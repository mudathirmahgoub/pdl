package pdl.parser;

import org.antlr.v4.runtime.tree.ParseTree;
import pdl.ast.*;
import pdl.parser.antlr.PdlBaseVisitor;
import pdl.parser.antlr.PdlParser;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class PdlProgramVisitor extends PdlBaseVisitor<PdlAst>
{
    private KripkeFrame frame;
    private boolean isFrameProvided;

    @Override
    public PdlAst visitPdl(PdlParser.PdlContext ctx)
    {
        if (ctx.kripkeFrame() != null)
        {
            frame = (KripkeFrame) this.visitKripkeFrame(ctx.kripkeFrame());
            isFrameProvided = true;
        }
        else
        {
            List<String> states = new ArrayList<>();
            Map<String, List<String>> propositions = new HashMap<>();
            Map<String, List<Transition>> programs = new HashMap<>();
            frame = new KripkeFrame(states, propositions, programs);
            isFrameProvided = false;
        }
        Formula formula = (Formula) this.visitFormula(ctx.formula());
        return new PdlProgram(frame, formula, isFrameProvided);
    }

    @Override
    public PdlAst visitKripkeFrame(PdlParser.KripkeFrameContext ctx)
    {
        List<String> states = ctx.states().Identifier()
                                 .stream()
                                 .map(n -> n.getText())
                                 .map(s -> handleNumbers(s))
                                 .collect(Collectors.toList());
        Map<String, List<String>> propositions = new HashMap<>();

        if (ctx.propositionMeaning().size() > 0)
        {
            propositions = ctx.propositionMeaning()
                              .stream()
                              .collect(Collectors.toMap(c -> c.Identifier(0).getText(),
                                      c -> getPropositionStates(c)));
        }

        Map<String, List<Transition>> programs = new HashMap<>();

        if (ctx.programMeaning().size() > 0)
        {
            programs = ctx.programMeaning()
                          .stream()
                          .collect(Collectors.toMap(c -> c.Identifier().getText(),
                                  c -> getProgramStates(c)));
        }
        return new KripkeFrame(states, propositions, programs);
    }

    private String handleNumbers(String state)
    {
        try
        {
            Integer.parseInt(state);
            // if state label is a number, convert it to cvc4 identifier
            return "s" + state;
        }
        catch (NumberFormatException exception)
        {
            return state;
        }
    }

    private List<Transition> getProgramStates(PdlParser.ProgramMeaningContext c)
    {
        List<Transition> transitions = c.pair().stream()
                                        .map(p -> new Transition(handleNumbers(p.Identifier(0).getText()),
                                                handleNumbers(p.Identifier(1).getText())))
                                        .collect(Collectors.toList());

        return transitions;
    }

    private List<String> getPropositionStates(PdlParser.PropositionMeaningContext c)
    {
        List<String> list = c.Identifier().stream()
                             .map(ParseTree::getText).collect(Collectors.toList());
        list = list.subList(1, list.size());
        list = list.stream().map(s -> handleNumbers(s)).collect(Collectors.toList());
        return list;
    }

    @Override
    public PdlAst visitFormula(PdlParser.FormulaContext ctx)
    {
        if (ctx.falsity() != null)
        {
            return new ConstantFormula(false);
        }
        if (ctx.truth() != null)
        {
            return new ConstantFormula(true);
        }
        if (ctx.atomicFormula() != null)
        {
            String proposition = ctx.atomicFormula().getText();
            if (!frame.getPropositions().containsKey(proposition))
            {
                if (isFrameProvided)
                {
                    throw new RuntimeException(String.format("Proposition '%s' is not defined in the kripke frame", proposition));
                }
                else
                {
                    frame.addProposition(proposition);
                }
            }
            return new AtomicFormula(proposition);
        }
        if (ctx.LeftParenthesis() != null)
        {
            return this.visitFormula(ctx.formula(0));
        }
        if (ctx.Not() != null)
        {
            Formula formula = (Formula) this.visitFormula(ctx.formula(0));
            return new UnaryFormula(UnaryFormula.Op.Not, formula);
        }
        if (ctx.LeftSquareBracket() != null)
        {
            Program program = (Program) this.visitProgram(ctx.program());
            Formula formula = (Formula) this.visitFormula(ctx.formula(0));
            return new ModalFormula(ModalFormula.Op.Box, program, formula);
        }
        if (ctx.LeftAngle() != null)
        {
            Program program = (Program) this.visitProgram(ctx.program());
            Formula formula = (Formula) this.visitFormula(ctx.formula(0));
            return new ModalFormula(ModalFormula.Op.Diamond, program, formula);
        }
        if (ctx.And() != null)
        {
            Formula left = (Formula) this.visitFormula(ctx.formula(0));
            Formula right = (Formula) this.visitFormula(ctx.formula(1));
            return new BinaryFormula(BinaryFormula.Op.And, left, right);
        }
        if (ctx.Or() != null)
        {
            Formula left = (Formula) this.visitFormula(ctx.formula(0));
            Formula right = (Formula) this.visitFormula(ctx.formula(1));
            return new BinaryFormula(BinaryFormula.Op.Or, left, right);
        }
        if (ctx.RightArrow() != null)
        {
            Formula left = (Formula) this.visitFormula(ctx.formula(0));
            Formula right = (Formula) this.visitFormula(ctx.formula(1));
            return new BinaryFormula(BinaryFormula.Op.Implies, left, right);
        }
        if (ctx.LeftRightArrow() != null)
        {
            Formula left = (Formula) this.visitFormula(ctx.formula(0));
            Formula right = (Formula) this.visitFormula(ctx.formula(1));
            return new BinaryFormula(BinaryFormula.Op.Equivalence, left, right);
        }
        if (ctx.hoarePartialCorrectness() != null)
        {
            return this.visitHoarePartialCorrectness(ctx.hoarePartialCorrectness());
        }
        throw new UnsupportedOperationException();
    }

    @Override
    public PdlAst visitHoarePartialCorrectness(PdlParser.HoarePartialCorrectnessContext ctx)
    {
        Formula precondition = (Formula) visitFormula(ctx.formula(0));
        Program program = (Program) visitProgram(ctx.program());
        Formula postcondition = (Formula) visitFormula(ctx.formula(1));
        Formula partialCorrectness = new PartialCorrectnessFormula(precondition, program, postcondition);
        return partialCorrectness;
    }

    @Override
    public PdlAst visitProgram(PdlParser.ProgramContext ctx)
    {
        if (ctx.skip() != null)
        {
            return Skip.getInstance();
        }
        if (ctx.fail() != null)
        {
            return Fail.getInstance();
        }
        if (ctx.LeftParenthesis() != null)
        {
            return visitProgram(ctx.program(0));
        }
        if (ctx.atomicProgram() != null)
        {
            String program = ctx.atomicProgram().getText();
            if (!frame.getPrograms().keySet().contains(program))
            {
                if (isFrameProvided)
                {
                    throw new RuntimeException(String.format("Atomic program '%s' is not defined in the kripke frame", program));
                }
                else
                {
                    frame.addProgram(program);
                }
            }
            return new AtomicProgram(program);
        }
        if (ctx.alternativeGuardedCommand() != null)
        {
            return visitAlternativeGuardedCommand(ctx.alternativeGuardedCommand());
        }
        if (ctx.iterativeGuardedCommand() != null)
        {
            return visitIterativeGuardedCommand(ctx.iterativeGuardedCommand());
        }
        if (ctx.iteProgram() != null)
        {
            return visitIteProgram(ctx.iteProgram());
        }
        if (ctx.whileProgram() != null)
        {
            return visitWhileProgram(ctx.whileProgram());
        }
        if (ctx.repeatProgram() != null)
        {
            return visitRepeatProgram(ctx.repeatProgram());
        }
        if (ctx.Star() != null)
        {
            Program program = (Program) visitProgram(ctx.program(0));
            return new Iteration(program);
        }
        if (ctx.Semicolon() != null)
        {
            Program left = (Program) visitProgram(ctx.program(0));
            Program right = (Program) visitProgram(ctx.program(1));
            return new BinaryProgram(BinaryProgram.Op.Composition, left, right);
        }
        if (ctx.Union() != null)
        {
            Program left = (Program) visitProgram(ctx.program(0));
            Program right = (Program) visitProgram(ctx.program(1));
            return new BinaryProgram(BinaryProgram.Op.Choice, left, right);
        }
        if (ctx.QuestionMark() != null)
        {
            Formula formula = (Formula) visitFormula(ctx.formula());
            return new Test(formula);
        }
        throw new UnsupportedOperationException();
    }

    @Override
    public PdlAst visitAlternativeGuardedCommand(PdlParser.AlternativeGuardedCommandContext ctx)
    {
        List<GuardedCommand> commands = ctx.guardedCommand()
                                           .stream().map(c -> (GuardedCommand) visitGuardedCommand(c)).collect(Collectors.toList());
        return new MultiGurardedCommand(MultiGurardedCommand.Op.If, commands);
    }

    @Override
    public PdlAst visitIterativeGuardedCommand(PdlParser.IterativeGuardedCommandContext ctx)
    {
        List<GuardedCommand> commands = ctx.guardedCommand()
                                           .stream().map(c -> (GuardedCommand) visitGuardedCommand(c)).collect(Collectors.toList());
        return new MultiGurardedCommand(MultiGurardedCommand.Op.Do, commands);
    }

    @Override
    public PdlAst visitGuardedCommand(PdlParser.GuardedCommandContext ctx)
    {
        Formula formula = (Formula) this.visitFormula(ctx.formula());
        Program program = (Program) this.visitProgram(ctx.program());
        return new GuardedCommand(formula, program);
    }

    @Override
    public PdlAst visitIteProgram(PdlParser.IteProgramContext ctx)
    {
        Formula condition = (Formula) this.visitFormula(ctx.formula());
        Program thenProgram = (Program) this.visitProgram(ctx.program(0));
        Program elseProgram = (Program) this.visitProgram(ctx.program(1));
        return new ITEProgram(condition, thenProgram, elseProgram);
    }

    @Override
    public PdlAst visitWhileProgram(PdlParser.WhileProgramContext ctx)
    {
        Formula formula = (Formula) this.visitFormula(ctx.formula());
        Program program = (Program) this.visitProgram(ctx.program());
        return new While(formula, program);
    }

    @Override
    public PdlAst visitRepeatProgram(PdlParser.RepeatProgramContext ctx)
    {
        Formula formula = (Formula) this.visitFormula(ctx.formula());
        Program program = (Program) this.visitProgram(ctx.program());
        return new Repeat(program, formula);
    }
}
