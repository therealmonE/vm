package io.github.therealmone.cpuemulator.decoder;

import io.github.therealmone.cpuemulator.command.Command;
import io.github.therealmone.cpuemulator.command.Destination;

public class DestinationDecoder extends AbstractDecoder<Destination> {

    DestinationDecoder() {
        super(new Shift(8), new Mask(0x0000000F));
    }

    @Override
    public Destination decode(final Command command) {
        return new Destination(applyShiftAndMask(command.getBits()));
    }

}
