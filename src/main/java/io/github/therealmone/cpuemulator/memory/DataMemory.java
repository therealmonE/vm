package io.github.therealmone.cpuemulator.memory;

import static io.github.therealmone.cpuemulator.Config.D_MEM_SIZE;

public class DataMemory extends Memory<DataLine> {

    public DataMemory() {
        super(new DataLine[D_MEM_SIZE]);
        for (int i = 0; i < data.length; i++) {
            data[i] = new DataLine(0x0);
        }
    }

    public DataLine get(int address) {
        if (isInvalidAddress(address)) {
            throw new IndexOutOfBoundsException(address);
        }
        return data[address];
    }

    public void set(int address, int data) {
        if (isInvalidAddress(address)) {
            throw new IndexOutOfBoundsException(address);
        }
        this.data[address] = new DataLine(data);
    }

    private boolean isInvalidAddress(int address) {
        return address < 0 || address >= data.length;
    }

}
