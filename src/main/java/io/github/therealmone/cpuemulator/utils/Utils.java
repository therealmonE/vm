package io.github.therealmone.cpuemulator.utils;

import io.github.therealmone.tdf4j.model.ast.ASTNode;

import java.io.*;

public final class Utils {

    public static String read(final InputStream input, final String encoding) throws IOException {
        try (
                final Reader reader = new InputStreamReader(input, encoding);
                final Writer writer = new StringWriter()
        ) {
            int bt;
            while ((bt = reader.read()) != -1) {
                writer.write(bt);
            }
            return writer.toString();
        }
    }

    public static int toInt(final ASTNode node, final int child) {
        return Integer.parseInt(node.children().get(child).asLeaf().token().value());
    }

}
