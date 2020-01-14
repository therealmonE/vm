package io.github.therealmone.cpuemulator.memory;

import io.github.therealmone.cpuemulator.command.Command;

import static io.github.therealmone.cpuemulator.Config.C_MEM_SIZE;

public class CommandMemory extends Memory<Command> {

    public CommandMemory() {
        super(new Command[C_MEM_SIZE]);
        for (int i = 0; i < data.length; i++) {
            data[i] = new Command(0x0);
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

    public void load(int[] bits) {
        if (bits.length > data.length) {
            throw new IllegalArgumentException();
        }
        for (int i = 0; i < bits.length; i++) {
            data[i] = new Command(bits[i]);
        }
    }

    private boolean invalidPC(final ProgramCounter pc) {
        return pc.getValue() < 0 || pc.getValue() >= data.length;
    }

}
