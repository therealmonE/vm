package io.github.therealmone.cpuemulator.decoder;

import io.github.therealmone.cpuemulator.command.Command;
import io.github.therealmone.cpuemulator.command.Type;

public class TypeDecoder extends AbstractDecoder<Type> {

    TypeDecoder() {
        super(new Shift(28), new Mask(0x0000000F));
    }

    @Override
    public Type decode(final Command command) {
        final int type = applyShiftAndMask(command.getBits());
        return Type.byBits(type);
    }

}
