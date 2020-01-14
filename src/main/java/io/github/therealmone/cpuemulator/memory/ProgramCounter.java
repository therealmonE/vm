package io.github.therealmone.cpuemulator.memory;

public class ProgramCounter {

    private int value;

    public int increment() {
        return value++;
    }

    public int incrementBy(int value) {
        return this.value += value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}

