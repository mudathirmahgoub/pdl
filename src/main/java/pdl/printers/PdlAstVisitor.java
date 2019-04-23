package pdl.printers;

import pdl.ast.*;

public interface PdlAstVisitor
{
    void visit(PdlProgram program);

    void visit(AtomicProgram atomicProgram);

    void visit(Test test);

    void visit(KripkeFrame kripkeFrame);

    void visit(UnaryFormula unaryFormula);

    void visit(PartialCorrectnessFormula partialCorrectnessFormula);

    void visit(Program program);

    void visit(BinaryFormula binaryFormula);

    void visit(While aWhile);

    void visit(Repeat repeat);

    void visit(ConstantFormula constantFormula);

    void visit(Skip skip);

    void visit(GuardedCommand guardedCommand);

    void visit(Fail fail);

    void visit(AtomicFormula atomicFormula);

    void visit(Iteration iteration);

    void visit(ITEProgram iteProgram);

    void visit(BinaryProgram binaryProgram);

    void visit(ModalFormula modalFormula);

    void visit(MultiGurardedCommand multiGurardedCommand);

    void visit(Formula formula);
}
