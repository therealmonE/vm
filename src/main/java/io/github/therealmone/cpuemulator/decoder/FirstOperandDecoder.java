package io.github.therealmone.cpuemulator.decoder;

import io.github.therealmone.cpuemulator.command.Command;
import io.github.therealmone.cpuemulator.command.FirstOperand;

public class FirstOperandDecoder extends AbstractDecoder<FirstOperand> {

    FirstOperandDecoder() {
        super(new Shift(4), new Mask(0x0000000F));
    }

    @Override
    public FirstOperand decode(final Command command) {
        return new FirstOperand(applyShiftAndMask(command.getBits()));
    }

}
