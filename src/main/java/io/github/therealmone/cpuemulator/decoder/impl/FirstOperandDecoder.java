package io.github.therealmone.cpuemulator.decoder.impl;

import io.github.therealmone.cpuemulator.command.Command;
import io.github.therealmone.cpuemulator.command.FirstOperand;
import io.github.therealmone.cpuemulator.decoder.AbstractDecoder;
import io.github.therealmone.cpuemulator.decoder.Mask;
import io.github.therealmone.cpuemulator.decoder.Shift;

import static io.github.therealmone.cpuemulator.Config.OP1_MASK;
import static io.github.therealmone.cpuemulator.Config.OP1_SHIFT;

public class FirstOperandDecoder extends AbstractDecoder<FirstOperand> {

    public FirstOperandDecoder() {
        super(new Shift(OP1_SHIFT), new Mask(OP1_MASK));
    }

    @Override
    public FirstOperand decode(final Command command) {
        return new FirstOperand(applyShiftAndMask(command.getBits()));
    }

}
