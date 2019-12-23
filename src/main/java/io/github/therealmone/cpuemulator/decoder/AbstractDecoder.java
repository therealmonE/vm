package io.github.therealmone.cpuemulator.decoder;

public abstract class AbstractDecoder<T> implements Decoder<T> {

    private final Shift shift;
    private final Mask mask;

    protected AbstractDecoder(final Shift shift, final Mask mask) {
        this.shift = shift;
        this.mask = mask;
    }

    protected int applyShiftAndMask(final int cmd) {
        return mask.apply(shift.apply(cmd));
    }

}
