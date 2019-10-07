package io.github.therealmone.cpuemulator.memory;

public class ProgramCounter {

    private int value;

    public int increment() {
        return value++;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}

