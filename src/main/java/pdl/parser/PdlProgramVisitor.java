package pdl.parser;

import org.antlr.v4.runtime.tree.ParseTree;
import pdl.ast.*;
import pdl.parser.antlr.PdlBaseVisitor;
import pdl.parser.antlr.PdlParser;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class PdlProgramVisitor extends PdlBaseVisitor<PdlAst>
{
    @Override
    public PdlAst visitPdl(PdlParser.PdlContext ctx)
    {
        KripkeFrame frame = null;
        if(ctx.kripkeFrame() != null)
        {
            frame = (KripkeFrame) this.visitKripkeFrame(ctx.kripkeFrame());
        }
        Formula formula = (Formula) this.visitFormula(ctx.formula());

        return new PdlProgram(frame, formula);
    }

    @Override
    public PdlAst visitKripkeFrame(PdlParser.KripkeFrameContext ctx)
    {
        List<String> states = ctx.states().Identifier()
                .stream().map(n -> n.getText())
                .collect(Collectors.toList());
        Map<String, List<String>> propositions = new HashMap<>();

        if(ctx.propositionMeaning().size() > 0)
        {
            propositions = ctx.propositionMeaning()
                    .stream()
                    .collect(Collectors.toMap(c -> c.Identifier(0).getText(),
                            c -> getPropositionStates(c)));
        }

        Map<String, List<Transition>> programs = new HashMap<>();

        if(ctx.programMeaning().size() > 0)
        {
            programs = ctx.programMeaning()
                    .stream()
                    .collect(Collectors.toMap(c -> c.Identifier().getText(),
                            c -> getProgramStates(c)));
        }
        return new KripkeFrame(states, propositions, programs);
    }

    private List<Transition> getProgramStates(PdlParser.ProgramMeaningContext c)
    {
        List<Transition> transitions = c.pair().stream()
                .map(p -> new Transition(p.Identifier(0).getText(), p.Identifier(1).getText()))
                .collect(Collectors.toList());

        return transitions;
    }

    private List<String> getPropositionStates(PdlParser.PropositionMeaningContext c)
    {
        List<String> list = c.Identifier().stream().map(ParseTree::getText).collect(Collectors.toList());
        list = list.subList(1, list.size());
        return list;
    }
}
