package io.github.therealmone.cpuemulator;

import io.github.therealmone.cpuemulator.command.Command;
import io.github.therealmone.cpuemulator.command.Type;
import io.github.therealmone.cpuemulator.memory.CMemory;
import io.github.therealmone.cpuemulator.memory.ProgramCounter;
import io.github.therealmone.cpuemulator.memory.Register;

import java.util.stream.Stream;

import static io.github.therealmone.cpuemulator.decoder.CommandDecoder.*;

public class CPU {

    private final Context context;

    CPU(final CMemory memory) {
        this.context = new Context(memory);
    }

    public Context getContext() {
        return context;
    }

    void processNextCommand() {
        final Command nextCommand = context.getMemory().get(context.getProgramCounter());
        final Type type = decodeType(nextCommand);
        type.apply(nextCommand, context);
    }

    boolean isDone() {
        try {
            return decodeType(context.getMemory().get(context.getProgramCounter())) == Type.FINISH;
        } catch (IndexOutOfBoundsException e) {
            return true;
        }
    }

    public static class Context {
        private final CMemory memory;
        private final ProgramCounter programCounter;
        private final Register[] registers;

        Context(final CMemory memory) {
            this.memory = memory;
            this.programCounter = new ProgramCounter();
            this.registers = new Register[16];
            for (int i = 0; i < 16; i++) {
                registers[i] = new Register();
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

}
