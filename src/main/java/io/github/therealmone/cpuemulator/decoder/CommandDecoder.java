package io.github.therealmone.cpuemulator.decoder;

import io.github.therealmone.cpuemulator.command.*;
import io.github.therealmone.cpuemulator.decoder.impl.DestinationDecoder;
import io.github.therealmone.cpuemulator.decoder.impl.FirstOperandDecoder;
import io.github.therealmone.cpuemulator.decoder.impl.LiteralDecoder;
import io.github.therealmone.cpuemulator.decoder.impl.SecondOperandDecoder;
import io.github.therealmone.cpuemulator.decoder.impl.TypeDecoder;

public final class CommandDecoder {
    private static final TypeDecoder typeDecoder = new TypeDecoder();
    private static final LiteralDecoder literalDecoder = new LiteralDecoder();
    private static final DestinationDecoder destinationDecoder = new DestinationDecoder();
    private static final FirstOperandDecoder firstOperandDecoder = new FirstOperandDecoder();
    private static final SecondOperandDecoder secondOperandDecoder = new SecondOperandDecoder();

    public static CommandType decodeType(final Command command) {
        return typeDecoder.decode(command);
    }

    public static Literal decodeLiteral(final Command command) {
        return literalDecoder.decode(command);
    }

    public static Destination decodeDestination(final Command command) {
        return destinationDecoder.decode(command);
    }

    public static FirstOperand decodeFirstOperand(final Command command) {
        return firstOperandDecoder.decode(command);
    }

    public static SecondOperand decodeSecondOperand(final Command command) {
        return secondOperandDecoder.decode(command);
    }

}
