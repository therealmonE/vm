package io.github.therealmone.cpuemulator.memory;

import io.github.therealmone.cpuemulator.command.Command;

import static io.github.therealmone.cpuemulator.Config.MEM_SIZE;

public class CMemory {

    private final Command[] data;

    public CMemory() {
        this.data = new Command[MEM_SIZE];
        for (int i = 0; i < MEM_SIZE; i++) {
            data[i] = new Command(0);
        }
    }

    public Command get(final ProgramCounter pc) {
        if (invalidPC(pc)) {
            throw new IndexOutOfBoundsException(pc.getValue());
        }
        return data[pc.getValue()];
    }

    public void set(final ProgramCounter pc, final Command command) {
        if (invalidPC(pc)) {
            throw new IndexOutOfBoundsException(pc.getValue());
        }
        this.data[pc.getValue()] = command;
    }

    private boolean invalidPC(final ProgramCounter pc) {
        return pc.getValue() < 0 || pc.getValue() >= data.length;
    }

}
