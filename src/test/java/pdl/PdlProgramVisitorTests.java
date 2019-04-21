/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package pdl;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pdl.ast.*;
import pdl.translator.PdlUtils;

import java.util.Arrays;
import java.util.HashSet;

public class PdlProgramVisitorTests
{
    @Test
    public void testKripkeFrame()
    {
        String pdl = "K = {u, v, w} m(p) = {u, v} m(q) = {w} m(a) = {(u,v)} \n" +
                "p";
        PdlProgram program = PdlUtils.parseProgram(pdl);
        Assertions.assertNotNull(program);
        Assertions.assertNotNull(program.getFrame());

        KripkeFrame frame = program.getFrame();
        Assertions.assertEquals(Arrays.asList("u", "v", "w"), frame.getStates());
        Assertions.assertEquals(new HashSet<>(Arrays.asList("p", "q")), frame.getPropositions().keySet());
        Assertions.assertEquals(Arrays.asList("u", "v"), frame.getPropositions().get("p"));
        Assertions.assertEquals(Arrays.asList("w"), frame.getPropositions().get("q"));
        Assertions.assertEquals(new HashSet<>(Arrays.asList("a")), frame.getPrograms().keySet());
        Assertions.assertEquals(Arrays.asList(new Transition("u", "v")), frame.getPrograms().get("a"));

        Assertions.assertEquals(new AtomicFormula("p"), program.getFormula());
    }

    @Test
    public void testBoxFormula()
    {
        String pdl = "[a]p";
        PdlProgram program = PdlUtils.parseProgram(pdl);
        Assertions.assertNotNull(program);
        Assertions.assertNotNull(program.getFrame());

        KripkeFrame frame = program.getFrame();

        Assertions.assertEquals(new HashSet<>(Arrays.asList("p")), frame.getPropositions().keySet());
        Assertions.assertEquals(0, frame.getPropositions().get("p").size());
        Assertions.assertEquals(new HashSet<>(Arrays.asList("a")), frame.getPrograms().keySet());
        Assertions.assertEquals(0, frame.getPrograms().get("a").size());
        ModalFormula modal = (ModalFormula) program.getFormula();
        Assertions.assertEquals(ModalFormula.Op.Box, modal.getOP());
        AtomicProgram atomicProgram = (AtomicProgram) modal.getProgram();
        AtomicFormula atomicFormula = (AtomicFormula) modal.getFormula();
        Assertions.assertEquals("a", atomicProgram.getSymbol());
        Assertions.assertEquals("p", atomicFormula.getSymbol());
    }

    @Test
    public void testDiamondFormula()
    {
        String pdl = "<a>p";
        PdlProgram program = PdlUtils.parseProgram(pdl);
        Assertions.assertNotNull(program);
        Assertions.assertNotNull(program.getFrame());

        KripkeFrame frame = program.getFrame();

        Assertions.assertEquals(new HashSet<>(Arrays.asList("p")), frame.getPropositions().keySet());
        Assertions.assertEquals(0, frame.getPropositions().get("p").size());
        Assertions.assertEquals(new HashSet<>(Arrays.asList("a")), frame.getPrograms().keySet());
        Assertions.assertEquals(0, frame.getPrograms().get("a").size());
        ModalFormula modal = (ModalFormula) program.getFormula();
        Assertions.assertEquals(ModalFormula.Op.Diamond, modal.getOP());
        AtomicProgram atomicProgram = (AtomicProgram) modal.getProgram();
        AtomicFormula atomicFormula = (AtomicFormula) modal.getFormula();
        Assertions.assertEquals("a", atomicProgram.getSymbol());
        Assertions.assertEquals("p", atomicFormula.getSymbol());
    }

    @Test
    public void alternativeGuardedCommand()
    {
        String pdl = "[if p -> a | q -> b fi] r";
        PdlProgram program = PdlUtils.parseProgram(pdl);
        Assertions.assertNotNull(program);
        Assertions.assertNotNull(program.getFrame());

        KripkeFrame frame = program.getFrame();

        Assertions.assertEquals(new HashSet<>(Arrays.asList("p", "q", "r")), frame.getPropositions().keySet());
        Assertions.assertEquals(new HashSet<>(Arrays.asList("a", "b")), frame.getPrograms().keySet());

        Formula actualFormula = program.getFormula();
        Formula p = new AtomicFormula("p");
        Formula q = new AtomicFormula("q");
        Formula r = new AtomicFormula("r");
        Program a = new AtomicProgram("a");
        Program b = new AtomicProgram("b");
        GuardedCommand pa = new GuardedCommand(p, a);
        GuardedCommand qb = new GuardedCommand(q, b);
        Program alternative = new MultiGurardedCommand(MultiGurardedCommand.Op.If, Arrays.asList(pa, qb));
        Formula expectedFormula = new ModalFormula(ModalFormula.Op.Box, alternative, r);

        Assertions.assertEquals(expectedFormula, actualFormula);
    }
}
