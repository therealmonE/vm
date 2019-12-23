package io.github.therealmone.cpuemulator.command.action;

import io.github.therealmone.cpuemulator.CPU;
import io.github.therealmone.cpuemulator.command.Command;

import static io.github.therealmone.cpuemulator.decoder.CommandDecoder.decodeDestination;
import static io.github.therealmone.cpuemulator.decoder.CommandDecoder.decodeLiteral;

public class MovAction implements Action {

    @Override
    public void accept(Command command, CPU cpu) {
        final int literal = decodeLiteral(command).getBits();
        final int destination = decodeDestination(command).getBits();

        cpu.getRegisters()[destination].setValue(literal);
        cpu.getProgramCounter().increment();
    }

}
