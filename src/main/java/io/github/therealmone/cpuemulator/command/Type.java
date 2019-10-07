package io.github.therealmone.cpuemulator.command;

import io.github.therealmone.cpuemulator.CPU;

import java.util.function.BiConsumer;

import static io.github.therealmone.cpuemulator.decoder.CommandDecoder.*;

public enum Type {
    FINISH(0x00000000, (command, context) -> {}),

    MOV(0x00000001, (command, context) -> {
        final Literal literal = decodeLiteral(command);
        final Destination destination = decodeDestination(command);
        context.getRegisters()[destination.getBits()]
                .setValue(literal.getBits());
        context.getProgramCounter().increment();
    }),

    ADD(0x00000002, (command, context) -> {
        final Destination destination = decodeDestination(command);
        final FirstOperand firstOperand = decodeFirstOperand(command);
        final SecondOperand secondOperand = decodeSecondOperand(command);
        context.getRegisters()[destination.getBits()].setValue(
                context.getRegisters()[firstOperand.getBits()].getValue() +
                        context.getRegisters()[secondOperand.getBits()].getValue()
        );
        context.getProgramCounter().increment();
    }),

    GOTO(0x00000003, (command, context) -> {
        final Literal literal = decodeLiteral(command);
        context.getProgramCounter().setValue(literal.getBits());
    });

    private final int header;
    private final BiConsumer<Command, CPU.Context> action;

    Type(final int header, final BiConsumer<Command, CPU.Context> action) {
        this.header = header;
        this.action = action;
    }

    public static Type byBits(final int bits) {
        for (final Type type : Type.values()) {
            if (type.header == bits) {
                return type;
            }
        }
        throw new IllegalArgumentException("No such command: "
                + Integer.toBinaryString(bits));
    }

    public void apply(final Command command, final CPU.Context context) {
        this.action.accept(command, context);
    }

    public int getHeader() {
        return header;
    }
}
