package io.github.therealmone.cpuemulator;

import io.github.therealmone.cpuemulator.command.Command;
import io.github.therealmone.cpuemulator.command.CommandType;
import io.github.therealmone.cpuemulator.memory.CommandMemory;
import io.github.therealmone.cpuemulator.memory.DataMemory;
import io.github.therealmone.cpuemulator.memory.ProgramCounter;
import io.github.therealmone.cpuemulator.memory.Register;

import static io.github.therealmone.cpuemulator.Config.REG_COUNT;
import static io.github.therealmone.cpuemulator.decoder.CommandDecoder.*;

public class CPU {

    private final CommandMemory cmem;
    private final DataMemory dmem;
    private final ProgramCounter programCounter;
    private final Register[] registers;

    public CPU(final CommandMemory cmem) {
        this.cmem = cmem;
        this.dmem = new DataMemory();
        this.programCounter = new ProgramCounter();
        this.registers = new Register[REG_COUNT];
        for (int i = 0; i < registers.length; i++) {
            registers[i] = new Register();
        }
    }

    public void processNextCommand() {
        final Command nextCommand = cmem.get(programCounter);
        final CommandType commandType = decodeType(nextCommand);
        commandType.accept(nextCommand, this);
    }

    public boolean isDone() {
        try {
            return decodeType(cmem.get(programCounter)) == CommandType.FINISH;
        } catch (IndexOutOfBoundsException e) {
            return true;
        }
    }

    public CommandMemory getCommandMemory() {
        return cmem;
    }

    public DataMemory getDataMemory() {
        return dmem;
    }

    public ProgramCounter getProgramCounter() {
        return programCounter;
    }

    public Register[] getRegisters() {
        return registers;
    }
}
