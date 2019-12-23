package io.github.therealmone.cpuemulator.decoder.impl;

import io.github.therealmone.cpuemulator.command.Command;
import io.github.therealmone.cpuemulator.command.SecondOperand;
import io.github.therealmone.cpuemulator.decoder.AbstractDecoder;
import io.github.therealmone.cpuemulator.decoder.Mask;
import io.github.therealmone.cpuemulator.decoder.Shift;

import static io.github.therealmone.cpuemulator.Config.OP2_MASK;
import static io.github.therealmone.cpuemulator.Config.OP2_SHIFT;

public class SecondOperandDecoder extends AbstractDecoder<SecondOperand> {

    public SecondOperandDecoder() {
        super(new Shift(OP2_SHIFT), new Mask(OP2_MASK));
    }

    @Override
    public SecondOperand decode(final Command command) {
        return new SecondOperand(applyShiftAndMask(command.getBits()));
    }

}
