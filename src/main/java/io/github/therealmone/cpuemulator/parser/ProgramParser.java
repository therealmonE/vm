package io.github.therealmone.cpuemulator.parser;

import io.github.therealmone.cpuemulator.memory.CMemory;
import io.github.therealmone.tdf4j.parser.Parser;

public interface ProgramParser extends Parser {

    CMemory getMemory();

}
