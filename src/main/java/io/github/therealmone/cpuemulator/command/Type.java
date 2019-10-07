package io.github.therealmone.cpuemulator.command;

import io.github.therealmone.cpuemulator.CPU;

import java.util.function.BiConsumer;

import static io.github.therealmone.cpuemulator.decoder.CommandDecoder.*;

public enum Type {
    FINISH(0x00000000, (command, context) -> {}),

    ASSIGN(0x00000001, ((command, context) -> {
        final Literal literal = decodeLiteral(command);
        final Destination destination = decodeDestination(command);
        context.getRegisters()[destination.getBits()]
                .setValue(literal.getBits());
        context.getProgramCounter().increment();
    })),

    SUM(0x00000002, ((command, context) -> {
        final Destination destination = decodeDestination(command);
        final FirstOperand firstOperand = decodeFirstOperand(command);
        final SecondOperand secondOperand = decodeSecondOperand(command);
        context.getRegisters()[destination.getBits()].setValue(
                context.getRegisters()[firstOperand.getBits()].getValue() +
                        context.getRegisters()[secondOperand.getBits()].getValue()
        );
        context.getProgramCounter().increment();
    }));

    private final int bits;
    private final BiConsumer<Command, CPU.Context> action;

    Type(final int bits, final BiConsumer<Command, CPU.Context> action) {
        this.bits = bits;
        this.action = action;
    }

    public static Type byBits(final int bits) {
        for (final Type type : Type.values()) {
            if (type.bits == bits) {
                return type;
            }
        }
        throw new IllegalArgumentException("No such command: "
                + Integer.toBinaryString(bits));
    }

    public void apply(final Command command, final CPU.Context context) {
        this.action.accept(command, context);
    }

}
