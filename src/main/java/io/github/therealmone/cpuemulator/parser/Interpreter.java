package io.github.therealmone.cpuemulator.parser;

import io.github.tdf4j.generator.Options;
import io.github.tdf4j.generator.impl.ParserGenerator;
import io.github.tdf4j.tdfparser.impl.TdfInterpreter;
import io.github.therealmone.cpuemulator.memory.CMemory;
import io.github.therealmone.cpuemulator.utils.Utils;

import java.io.IOException;

public class Interpreter {

    private final ProgramParser parser;

    public Interpreter() throws IOException {
        final io.github.tdf4j.tdfparser.Interpreter tdf = new TdfInterpreter();
        tdf.parse(Utils.read(Thread.currentThread().getContextClassLoader().getResourceAsStream("grammar.tdf"), "UTF-8"));
        this.parser = (ProgramParser) new ParserGenerator(new Options.Builder()
                .setClassName("ProgramParserImpl")
                .setPackage("io.github.therealmone.cpuemulator.parser")
                .setInterface(ProgramParser.class)
                .setLexerModule(tdf.getLexerModule())
                .setParserModule(tdf.getParserModule())
                .build()
        ).generate().compile();
    }

    public CMemory load(final String prog) {
        this.parser.parse(prog);
        return parser.getMemory();
    }

}
