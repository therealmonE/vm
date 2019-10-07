package io.github.therealmone.cpuemulator.decoder;

import io.github.therealmone.cpuemulator.command.*;

public final class CommandDecoder {
    private static final TypeDecoder typeDecoder = new TypeDecoder();
    private static final LiteralDecoder literalDecoder = new LiteralDecoder();
    private static final DestinationDecoder destinationDecoder = new DestinationDecoder();
    private static final FirstOperandDecoder firstOperandDecoder = new FirstOperandDecoder();
    private static final SecondOperandDecoder secondOperandDecoder = new SecondOperandDecoder();

    public static Type decodeType(final Command command) {
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
