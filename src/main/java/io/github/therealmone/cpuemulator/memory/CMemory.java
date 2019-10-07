package io.github.therealmone.cpuemulator.memory;

import io.github.therealmone.cpuemulator.command.Command;

import java.util.Arrays;

public class CMemory {

    private final Command[] data;

    public CMemory(final int size) {
        this.data = new Command[size];
    }

    public CMemory(final int[] data) {
        this.data = Arrays.stream(data)
                .mapToObj(Command::new)
                .toArray(Command[]::new);
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
