package io.github.therealmone.cpuemulator.parser;

import io.github.tdf4j.parser.Parser;
import io.github.therealmone.cpuemulator.memory.CMemory;

public interface ProgramParser extends Parser {

    CMemory getMemory();

}
