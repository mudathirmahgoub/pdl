package pdl.printers;

import pdl.ast.*;

import java.util.List;

public class PdlPrinter implements PdlAstVisitor
{
    private StringBuilder stringBuilder = new StringBuilder();

    @Override
    public void visit(PdlProgram program)
    {
        stringBuilder.append(program.getFrame());
        stringBuilder.append("\n");
        visit(program.getFormula());
        stringBuilder.append("\n");
    }

    @Override
    public void visit(AtomicProgram atomicProgram)
    {
        stringBuilder.append(atomicProgram.getSymbol());
    }

    @Override
    public void visit(Test test)
    {
        visit(test.getFormula());
        stringBuilder.append("?");
    }

    @Override
    public void visit(KripkeFrame kripkeFrame)
    {
        stringBuilder.append(kripkeFrame + "\n");
    }

    @Override
    public void visit(UnaryFormula unaryFormula)
    {
        // for negation
        stringBuilder.append("¬");
        visit(unaryFormula.getFormula());
    }

    @Override
    public void visit(PartialCorrectnessFormula partialCorrectnessFormula)
    {
        stringBuilder.append("{");
        visit(partialCorrectnessFormula.getPrecondition());
        stringBuilder.append("}");
        visit(partialCorrectnessFormula.getProgram());
        stringBuilder.append("{");
        visit(partialCorrectnessFormula.getPostcondition());
        stringBuilder.append("}");
    }

    @Override
    public void visit(Program program)
    {
        if(program instanceof  AtomicProgram)
        {
            visit((AtomicProgram) program);
            return;
        }
        if(program instanceof  BinaryProgram)
        {
            visit((BinaryProgram) program);
            return;
        }
        if(program instanceof  Fail)
        {
            visit((Fail) program);
            return;
        }
        if(program instanceof  ITEProgram)
        {
            visit((ITEProgram) program);
            return;
        }
        if(program instanceof  Iteration)
        {
            visit((Iteration) program);
            return;
        }
        if(program instanceof  MultiGurardedCommand)
        {
            visit((MultiGurardedCommand) program);
            return;
        }
        if(program instanceof  Repeat)
        {
            visit((Repeat) program);
            return;
        }
        if(program instanceof  Skip)
        {
            visit((Skip) program);
            return;
        }
        if(program instanceof  Test)
        {
            visit((Test) program);
            return;
        }
        if(program instanceof  While)
        {
            visit((While) program);
            return;
        }
        if(program instanceof Converse)
        {
            visit((Converse) program);
            return;
        }
        throw new UnsupportedOperationException();
    }

    @Override
    public void visit(BinaryFormula binaryFormula)
    {
        stringBuilder.append("(");
        visit(binaryFormula.getLeft());
        switch (binaryFormula.getOp())
        {
            case Or:
            {
                stringBuilder.append(" ∨ ");
                break;
            }
            case And:
            {
                stringBuilder.append(" ∧ ");
                break;
            }
            case Implies:
            {
                stringBuilder.append(" → ");
                break;
            }
            case Equivalence:
            {
                stringBuilder.append(" ↔ ");
                break;
            }
            default:
                throw new UnsupportedOperationException();
        }

        visit(binaryFormula.getRight());
        stringBuilder.append(")");
    }

    @Override
    public void visit(While whileProgram)
    {
        stringBuilder.append("while ");
        visit(whileProgram.getFormula());
        stringBuilder.append(" do ");
        visit(whileProgram.getProgram());
    }

    @Override
    public void visit(Repeat repeat)
    {
        stringBuilder.append("repeat ");
        visit(repeat.getProgram());
        stringBuilder.append(" until ");
        visit(repeat.getFormula());
    }

    @Override
    public void visit(ConstantFormula constantFormula)
    {
        if(constantFormula.getValue())
        {
            stringBuilder.append("1");
        }
        else
        {
            stringBuilder.append("0");
        }
    }

    @Override
    public void visit(Skip skip)
    {
        stringBuilder.append("skip");
    }

    @Override
    public void visit(GuardedCommand guardedCommand)
    {
        visit(guardedCommand.getFormula());
        stringBuilder.append("→");
        visit(guardedCommand.getProgram());
    }

    @Override
    public void visit(Fail fail)
    {
        stringBuilder.append("fail");
    }

    @Override
    public void visit(AtomicFormula atomicFormula)
    {
        stringBuilder.append(atomicFormula.getSymbol());
    }

    @Override
    public void visit(Iteration iteration)
    {
        visit(iteration.getProgram());
        stringBuilder.append("*");
    }

    @Override
    public void visit(Converse converse)
    {
        visit(converse.getProgram());
        stringBuilder.append("‾");
    }

    @Override
    public void visit(ITEProgram iteProgram)
    {
        stringBuilder.append("if ");
        visit(iteProgram.getCondition());
        stringBuilder.append(" then ");
        visit(iteProgram.getThenProgram());
        stringBuilder.append(" else ");
        visit(iteProgram.getElseProgram());
        stringBuilder.append("fi");
    }

    @Override
    public void visit(BinaryProgram binaryProgram)
    {
        stringBuilder.append("(");
        visit(binaryProgram.getLeft());
        switch (binaryProgram.getOP())
        {
            case Choice:
            {
                stringBuilder.append("∪");
                break;
            }
            case Composition:
            {
                stringBuilder.append(";");
                break;
            }
            default:
                throw new UnsupportedOperationException();
        }
        visit(binaryProgram.getRight());
        stringBuilder.append(")");
    }

    @Override
    public void visit(ModalFormula modalFormula)
    {
        switch (modalFormula.getOP())
        {
            case Box:
            {
                stringBuilder.append("[");
                visit(modalFormula.getProgram());
                stringBuilder.append("]");
                visit(modalFormula.getFormula());
            }break;

            case Diamond:
            {
                stringBuilder.append("<");
                visit(modalFormula.getProgram());
                stringBuilder.append(">");
                visit(modalFormula.getFormula());
            }break;
            default:
                throw new UnsupportedOperationException();
        }
    }

    @Override
    public void visit(MultiGurardedCommand multiGurardedCommand)
    {
        if(multiGurardedCommand.getOp() == MultiGurardedCommand.Op.If)
        {
            stringBuilder.append("if ");
        }

        if(multiGurardedCommand.getOp() == MultiGurardedCommand.Op.Do)
        {
            stringBuilder.append("do ");
        }

        visit(multiGurardedCommand.getGuardedCommands());

        if(multiGurardedCommand.getOp() == MultiGurardedCommand.Op.If)
        {
            stringBuilder.append(" fi");
        }

        if(multiGurardedCommand.getOp() == MultiGurardedCommand.Op.Do)
        {
            stringBuilder.append(" od");
        }
    }

    private void visit(List<GuardedCommand> commands)
    {
        if(commands.size() == 0)
        {
            throw new UnsupportedOperationException();
        }
        else if(commands.size() == 1)
        {
            visit(commands.get(0));
        }
        else
        {
            for (int i = 0; i < commands.size() - 1 ; i++)
            {
                visit(commands.get(i));
                stringBuilder.append(" | ");
            }
            visit(commands.get(commands.size() - 1));
        }
    }

    @Override
    public void visit(Formula formula)
    {
        if(formula instanceof ConstantFormula)
        {
            visit((ConstantFormula) formula);
            return;
        }
        if(formula instanceof PartialCorrectnessFormula)
        {
            visit((PartialCorrectnessFormula) formula);
            return;
        }
        if(formula instanceof UnaryFormula)
        {
            visit((UnaryFormula) formula);
            return;
        }
        if(formula instanceof ModalFormula)
        {
            visit((ModalFormula) formula);
            return;
        }
        if(formula instanceof BinaryFormula)
        {
            visit((BinaryFormula) formula);
            return;
        }
        if(formula instanceof AtomicFormula)
        {
            visit((AtomicFormula) formula);
            return;
        }
        throw new UnsupportedOperationException();
    }

    public String print()
    {
        return stringBuilder.toString();
    }
}
