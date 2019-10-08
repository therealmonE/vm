package io.github.therealmone.cpuemulator.parser;

import io.github.tdf4j.core.model.ast.ASTNode;
import io.github.therealmone.cpuemulator.command.Type;
import io.github.therealmone.cpuemulator.utils.Utils;

import static io.github.therealmone.cpuemulator.Config.*;

public final class CommandConstructor {

    /**
     * add_command =
     *          ADD_KEYWORD
     *      ,   register
     *      ,   register
     *      ,   register
     *      ;
     */
    public static int toAddCommand(final ASTNode node) {
        final int destination = Utils.toInt(node.getChildren().get(1).asNode(), 2);
        final int op1 = Utils.toInt(node.getChildren().get(2).asNode(), 2);
        final int op2 = Utils.toInt(node.getChildren().get(3).asNode(), 2);
        return toCommand(Type.ADD, 0, destination, op1, op2);
    }

    /**
     * mov_command =
     *          MOV_KEYWORD
     *      ,   register
     *      ,   DIGIT
     *      ;
     */
    public static int toMovCommand(final ASTNode node) {
        final int reg = Utils.toInt(node.getChildren().get(1).asNode(), 2);
        final int literal = Utils.toInt(node, 2);
        return toCommand(Type.MOV, literal, reg, 0, 0);
    }

    /**
     * goto_command =
     *          GOTO_KEYWORD
     *      ,   DIGIT
     *      ;
     */
    public static int toGotoCommand(final ASTNode node) {
        final int literal = Utils.toInt(node, 1);
        return toCommand(Type.GOTO, literal, 0, 0, 0);
    }

    private static int toCommand(final Type type, final int literal, final int destination, final int op1, final int op2) {
        return (type.getHeader() << TYPE_SHIFT)
                | (literal << LITERAL_SHIFT)
                | (destination << DESTINATION_SHIFT)
                | (op1 << OP1_SHIFT)
                | (op2 << OP2_SHIFT);
    }

}
