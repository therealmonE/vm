package io.github.therealmone.cpuemulator.decoder;

import io.github.therealmone.cpuemulator.command.Command;
import io.github.therealmone.cpuemulator.command.Literal;

public class LiteralDecoder extends AbstractDecoder<Literal> {

    LiteralDecoder() {
        super(new Shift(12), new Mask(0x000000FF));
    }

    @Override
    public Literal decode(final Command command) {
        return new Literal(applyShiftAndMask(command.getBits()));
    }

}
