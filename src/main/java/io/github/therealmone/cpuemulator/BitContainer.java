package io.github.therealmone.cpuemulator;

public abstract class BitContainer {

    private final int bits;

    public BitContainer(final int bits) {
        this.bits = bits;
    }

    public int getBits() {
        return bits;
    }

}
