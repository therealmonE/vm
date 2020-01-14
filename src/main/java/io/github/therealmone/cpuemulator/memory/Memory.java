package io.github.therealmone.cpuemulator.memory;

import io.github.therealmone.cpuemulator.BitContainer;

public abstract class Memory<T extends BitContainer> {

    protected final T[] data;

    public Memory(T[] data) {
        this.data = data;
    }

    public int size() {
        return data.length;
    }

}
