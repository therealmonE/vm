package io.github.therealmone.cpuemulator.decoder;

import java.util.function.Function;

public class Shift implements Function<Integer, Integer> {

    private final int shift;

    Shift(final int shift) {
        this.shift = shift;
    }

    @Override
    public Integer apply(final Integer cmd) {
        return cmd >> shift;
    }

}
