package io.github.therealmone.cpuemulator.decoder;

import java.util.function.Function;

public class Mask implements Function<Integer, Integer> {

    private final int mask;

    public Mask(final int mask) {
        this.mask = mask;
    }

    @Override
    public Integer apply(final Integer cmd) {
        return cmd & mask;
    }

}
