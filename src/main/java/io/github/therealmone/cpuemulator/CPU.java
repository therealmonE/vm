package io.github.therealmone.cpuemulator;

import io.github.therealmone.cpuemulator.command.Command;
import io.github.therealmone.cpuemulator.command.CommandType;
import io.github.therealmone.cpuemulator.memory.CMemory;
import io.github.therealmone.cpuemulator.memory.ProgramCounter;
import io.github.therealmone.cpuemulator.memory.Register;

import static io.github.therealmone.cpuemulator.Config.REG_COUNT;
import static io.github.therealmone.cpuemulator.decoder.CommandDecoder.*;

public class CPU {

    private final CMemory memory;
    private final ProgramCounter programCounter;
    private final Register[] registers;

    CPU(final CMemory memory) {
        this.memory = memory;
        this.programCounter = new ProgramCounter();
        this.registers = new Register[REG_COUNT];
        for (int i = 0; i < registers.length; i++) {
            registers[i] = new Register();
        }
    }

    void processNextCommand() {
        final Command nextCommand = memory.get(programCounter);
        final CommandType commandType = decodeType(nextCommand);
        commandType.accept(nextCommand, this);
    }

    boolean isDone() {
        try {
            return decodeType(memory.get(programCounter)) == CommandType.FINISH;
        } catch (IndexOutOfBoundsException e) {
            return true;
        }
    }

    public CMemory getMemory() {
        return memory;
    }

    public ProgramCounter getProgramCounter() {
        return programCounter;
    }

    public Register[] getRegisters() {
        return registers;
    }
}
