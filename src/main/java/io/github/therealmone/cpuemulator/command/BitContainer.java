package io.github.therealmone.cpuemulator.command;

public abstract class BitContainer {

    private final int bits;

    BitContainer(final int bits) {
        this.bits = bits;
    }

    public int getBits() {
        return bits;
    }

}
