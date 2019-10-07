package io.github.therealmone.cpuemulator.memory;

public class Register {

    private int value = 0;

    public void setValue(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "Register{" +
                "value=" + value +
                '}';
    }
}
