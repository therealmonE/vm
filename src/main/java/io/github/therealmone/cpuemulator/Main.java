package io.github.therealmone.cpuemulator;

import io.github.therealmone.cpuemulator.memory.CMemory;
import io.github.therealmone.cpuemulator.parser.Interpreter;
import io.github.therealmone.cpuemulator.utils.Utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        final CPU cpu = new CPU(loadProgramInMemory(new File(args[0])));
        while (!cpu.isDone()) {
            cpu.processNextCommand();
        }
        for (int i = 0; i < cpu.getContext().getRegisters().length; i++) {
            System.out.println(String.format("reg[%d]: %s", i, cpu.getContext().getRegisters()[i].getValue()));
        }
    }

    private static CMemory loadProgramInMemory(final File file) throws IOException {
        final Interpreter interpreter = new Interpreter();
        return interpreter.load(Utils.read(new FileInputStream(file), "UTF-8"));
    }

}
