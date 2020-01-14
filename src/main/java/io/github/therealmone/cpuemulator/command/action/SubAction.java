package io.github.therealmone.cpuemulator.command.action;

import io.github.therealmone.cpuemulator.CPU;
import io.github.therealmone.cpuemulator.command.Command;
import io.github.therealmone.cpuemulator.memory.Register;

import static io.github.therealmone.cpuemulator.decoder.CommandDecoder.decodeDestination;
import static io.github.therealmone.cpuemulator.decoder.CommandDecoder.decodeFirstOperand;
import static io.github.therealmone.cpuemulator.decoder.CommandDecoder.decodeSecondOperand;

public class SubAction implements Action {

    @Override
    public void accept(Command command, CPU cpu) {
        final int destination = decodeDestination(command).getBits();
        final int firstOperand = decodeFirstOperand(command).getBits();
        final int secondOperand = decodeSecondOperand(command).getBits();
        final Register[] reg = cpu.getRegisters();

        reg[destination].setValue(
                reg[firstOperand].getValue() - reg[secondOperand].getValue());
        cpu.getProgramCounter().increment();
    }

}
