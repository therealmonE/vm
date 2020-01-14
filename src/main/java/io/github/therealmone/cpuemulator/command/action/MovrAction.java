package io.github.therealmone.cpuemulator.command.action;

import io.github.therealmone.cpuemulator.CPU;
import io.github.therealmone.cpuemulator.command.Command;
import io.github.therealmone.cpuemulator.memory.Register;

import static io.github.therealmone.cpuemulator.decoder.CommandDecoder.decodeDestination;
import static io.github.therealmone.cpuemulator.decoder.CommandDecoder.decodeFirstOperand;

public class MovrAction implements Action {

    @Override
    public void accept(Command command, CPU cpu) {
        final int destination = decodeDestination(command).getBits();
        final int op1 = decodeFirstOperand(command).getBits();
        final Register[] reg = cpu.getRegisters();

        reg[destination].setValue(reg[op1].getValue());
        cpu.getProgramCounter().increment();
    }

}
