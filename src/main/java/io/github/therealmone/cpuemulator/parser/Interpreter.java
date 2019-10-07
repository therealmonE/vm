package io.github.therealmone.cpuemulator.parser;

import io.github.therealmone.cpuemulator.memory.CMemory;
import io.github.therealmone.tdf4j.generator.impl.LexerGenerator;
import io.github.therealmone.tdf4j.generator.impl.ParserGenerator;
import io.github.therealmone.tdf4j.lexer.Lexer;
import io.github.therealmone.tdf4j.tdfparser.TdfParser;
import io.github.therealmone.tdf4j.tdfparser.TdfParserGenerator;

import java.io.IOException;

public class Interpreter {

    private final ProgramParser parser;
    private final Lexer lexer;

    public Interpreter() throws IOException {
        @SuppressWarnings("ConstantConditions")
        final TdfParser tdf = new TdfParserGenerator(
                Thread.currentThread().getContextClassLoader().getResourceAsStream("grammar.tdf")
        ).generate();
        this.lexer = new LexerGenerator(tdf.getLexerModule()).generate();
        this.parser = new ParserGenerator(tdf.getParserModule()).generate(ProgramParser.class);
    }

    public CMemory load(final String prog) {
        this.parser.parse(lexer.stream(prog));
        return parser.getMemory();
    }

}
