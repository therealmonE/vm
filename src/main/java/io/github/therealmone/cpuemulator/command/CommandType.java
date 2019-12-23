package io.github.therealmone.cpuemulator.command;

import io.github.therealmone.cpuemulator.CPU;
import io.github.therealmone.cpuemulator.command.action.Action;
import io.github.therealmone.cpuemulator.command.action.AddAction;
import io.github.therealmone.cpuemulator.command.action.FinishAction;
import io.github.therealmone.cpuemulator.command.action.GoToAction;
import io.github.therealmone.cpuemulator.command.action.MovAction;

public enum CommandType {
    FINISH(0x00000000, new FinishAction()),

    MOV(0x00000001, new MovAction()),

    ADD(0x00000002, new AddAction()),

    GOTO(0x00000003, new GoToAction());

    private final int header;
    private final Action action;

    CommandType(final int header, final Action action) {
        this.header = header;
        this.action = action;
    }

    public static CommandType byBits(final int bits) {
        for (final CommandType commandType : CommandType.values()) {
            if (commandType.header == bits) {
                return commandType;
            }
        }
        throw new IllegalArgumentException("No such command: "
                + Integer.toBinaryString(bits));
    }

    public void accept(final Command command, final CPU cpu) {
        this.action.accept(command, cpu);
    }
}
