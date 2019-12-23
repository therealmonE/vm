package io.github.therealmone.cpuemulator.command.action;

import io.github.therealmone.cpuemulator.CPU;
import io.github.therealmone.cpuemulator.command.Command;

import java.util.function.BiConsumer;

public interface Action extends BiConsumer<Command, CPU> {
}
