package pdl.translator;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import pdl.ast.PdlProgram;
import pdl.parser.PdlProgramVisitor;
import pdl.parser.antlr.PdlLexer;
import pdl.parser.antlr.PdlParser;

public class PdlUtils
{
    public static PdlProgram parseProgram(String model)
    {
        CharStream charStream = CharStreams.fromString(model);

        PdlLexer lexer = new PdlLexer(charStream);
        CommonTokenStream tokenStream = new CommonTokenStream(lexer);
        PdlParser parser = new PdlParser(tokenStream);

        ParseTree tree = parser.pdl();
        PdlProgramVisitor visitor = new PdlProgramVisitor();
        PdlProgram program = (PdlProgram) visitor.visit(tree);
        return program;
    }
}
