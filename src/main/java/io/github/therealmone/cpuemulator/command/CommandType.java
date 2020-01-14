package io.github.therealmone.cpuemulator.command;

import io.github.therealmone.cpuemulator.CPU;
import io.github.therealmone.cpuemulator.command.action.Action;
import io.github.therealmone.cpuemulator.command.action.AddAction;
import io.github.therealmone.cpuemulator.command.action.EqAction;
import io.github.therealmone.cpuemulator.command.action.FinishAction;
import io.github.therealmone.cpuemulator.command.action.GoToAction;
import io.github.therealmone.cpuemulator.command.action.MovAction;
import io.github.therealmone.cpuemulator.command.action.MovrAction;
import io.github.therealmone.cpuemulator.command.action.SubAction;
import io.github.therealmone.cpuemulator.command.action.WrtAction;

public enum CommandType {
    FINISH(0x00000000, new FinishAction()),

    MOV(0x00000001, new MovAction()),

    ADD(0x00000002, new AddAction()),

    GOTO(0x00000003, new GoToAction()),

    SUB(0x00000004, new SubAction()),

    EQ(0x00000005, new EqAction()),

    WRT(0x00000006, new WrtAction()),

    MOVR(0x00000007, new MovrAction());

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
