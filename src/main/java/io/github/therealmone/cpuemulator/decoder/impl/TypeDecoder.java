package io.github.therealmone.cpuemulator.decoder.impl;

import io.github.therealmone.cpuemulator.command.Command;
import io.github.therealmone.cpuemulator.command.CommandType;
import io.github.therealmone.cpuemulator.decoder.AbstractDecoder;
import io.github.therealmone.cpuemulator.decoder.Mask;
import io.github.therealmone.cpuemulator.decoder.Shift;

import static io.github.therealmone.cpuemulator.Config.TYPE_MASK;
import static io.github.therealmone.cpuemulator.Config.TYPE_SHIFT;

public class TypeDecoder extends AbstractDecoder<CommandType> {

    public TypeDecoder() {
        super(new Shift(TYPE_SHIFT), new Mask(TYPE_MASK));
    }

    @Override
    public CommandType decode(final Command command) {
        final int type = applyShiftAndMask(command.getBits());
        return CommandType.byBits(type);
    }

}
