package io.github.therealmone.cpuemulator;

import io.github.therealmone.cpuemulator.memory.CMemory;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        final CPU cpu = new CPU(getMemory());
        while (!cpu.isDone()) {
            cpu.processNextCommand();
        }
        System.out.println(Arrays.toString(cpu.getContext().getRegisters()));
    }

    private static CMemory getMemory() {
        return new CMemory(new int[] {
                0b0001_0000000000000001_0001_0000_0000, //reg[1] = 1
                0b0001_0000000000000001_0010_0000_0000, //reg[2] = 1
                0b0010_0000000000000000_0111_0001_0010, //reg[3] = reg[1] + reg[2]
        });
    }

}
