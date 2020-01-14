package io.github.therealmone.cpuemulator;

import io.github.therealmone.cpuemulator.memory.CommandMemory;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        final CPU cpu = new CPU(initMemory());
        while (!cpu.isDone()) {
            cpu.processNextCommand();
        }
        for (int i = 0; i < cpu.getRegisters().length; i++) {
            System.out.println(
                    String.format("reg[%d]: %s", i, cpu.getRegisters()[i].getValue()));
        }
    }

    private static CommandMemory initMemory() {
        final CommandMemory memory = new CommandMemory();
        memory.load(new int[] {
                0b0001_00000001_0001_0000_0000,
                0b0001_00000010_0010_0000_0000,
                0b0010_00000000_0011_0001_0010,
        });
        return memory;
    }

}
