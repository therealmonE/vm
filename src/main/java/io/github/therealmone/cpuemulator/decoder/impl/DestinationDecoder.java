package io.github.therealmone.cpuemulator.decoder.impl;

import io.github.therealmone.cpuemulator.command.Command;
import io.github.therealmone.cpuemulator.command.Destination;
import io.github.therealmone.cpuemulator.decoder.AbstractDecoder;
import io.github.therealmone.cpuemulator.decoder.Mask;
import io.github.therealmone.cpuemulator.decoder.Shift;

import static io.github.therealmone.cpuemulator.Config.DESTINATION_MASK;
import static io.github.therealmone.cpuemulator.Config.DESTINATION_SHIFT;

public class DestinationDecoder extends AbstractDecoder<Destination> {

    public DestinationDecoder() {
        super(new Shift(DESTINATION_SHIFT), new Mask(DESTINATION_MASK));
    }

    @Override
    public Destination decode(final Command command) {
        return new Destination(applyShiftAndMask(command.getBits()));
    }

}
