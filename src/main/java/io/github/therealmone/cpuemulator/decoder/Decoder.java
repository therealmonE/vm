package io.github.therealmone.cpuemulator.decoder;

import io.github.therealmone.cpuemulator.command.Command;

public interface Decoder<T> {

    T decode(final Command command);

}
