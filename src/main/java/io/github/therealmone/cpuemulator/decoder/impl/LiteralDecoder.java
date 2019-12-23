package io.github.therealmone.cpuemulator.decoder.impl;

import io.github.therealmone.cpuemulator.command.Command;
import io.github.therealmone.cpuemulator.command.Literal;
import io.github.therealmone.cpuemulator.decoder.AbstractDecoder;
import io.github.therealmone.cpuemulator.decoder.Mask;
import io.github.therealmone.cpuemulator.decoder.Shift;

import static io.github.therealmone.cpuemulator.Config.LITERAL_MASK;
import static io.github.therealmone.cpuemulator.Config.LITERAL_SHIFT;

public class LiteralDecoder extends AbstractDecoder<Literal> {

    public LiteralDecoder() {
        super(new Shift(LITERAL_SHIFT), new Mask(LITERAL_MASK));
    }

    @Override
    public Literal decode(final Command command) {
        return new Literal(applyShiftAndMask(command.getBits()));
    }

}
