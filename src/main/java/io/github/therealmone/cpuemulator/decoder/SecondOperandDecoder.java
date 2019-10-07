package io.github.therealmone.cpuemulator.decoder;

import io.github.therealmone.cpuemulator.command.Command;
import io.github.therealmone.cpuemulator.command.SecondOperand;

public class SecondOperandDecoder extends AbstractDecoder<SecondOperand> {

    SecondOperandDecoder() {
        super(new Shift(0), new Mask(0x0000000F));
    }

    @Override
    public SecondOperand decode(final Command command) {
        return new SecondOperand(applyShiftAndMask(command.getBits()));
    }

}
