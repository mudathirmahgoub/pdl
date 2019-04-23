package pdl.translator;

import edu.uiowa.smt.Result;
import edu.uiowa.smt.TranslatorUtils;
import edu.uiowa.smt.smtAst.FunctionDefinition;
import org.junit.jupiter.api.Test;
import pdl.ast.KripkeFrame;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class PdlToSmtTranslatorTests
{
    @Test
    public void truth() throws Exception
    {
        String pdl = "1";
        Result result = PdlUtils.runCVC4(pdl);
        assertEquals("sat", result.satResult);
    }

    @Test
    public void falsity() throws Exception
    {
        String pdl = "0";
        Result result = PdlUtils.runCVC4(pdl);
        assertEquals("unsat", result.satResult);
    }

    @Test
    public void proposition() throws Exception
    {
        String pdl = "p";
        Result result = PdlUtils.runCVC4(pdl);
        assertEquals("sat", result.satResult);
        FunctionDefinition p = TranslatorUtils.getFunctionDefinition(result.smtModel, "p");
        assertNotEquals(0, TranslatorUtils.getAtomSet(p).size());
    }

    @Test
    public void and() throws Exception
    {
        String pdl = "p and q";
        Result result = PdlUtils.runCVC4(pdl);
        assertEquals("sat", result.satResult);
        FunctionDefinition p = TranslatorUtils.getFunctionDefinition(result.smtModel, "p");
        FunctionDefinition q = TranslatorUtils.getFunctionDefinition(result.smtModel, "q");

        Set<String> pSet = TranslatorUtils.getAtomSet(p);
        Set<String> qSet = TranslatorUtils.getAtomSet(q);
        Set<String> pq = new HashSet<>(pSet);
        pq.retainAll(qSet);
        assertNotEquals(0, pq.size());
    }

    @Test
    public void or() throws Exception
    {
        String pdl = "p or q";
        Result result = PdlUtils.runCVC4(pdl);
        assertEquals("sat", result.satResult);
        FunctionDefinition p = TranslatorUtils.getFunctionDefinition(result.smtModel, "p");
        FunctionDefinition q = TranslatorUtils.getFunctionDefinition(result.smtModel, "q");

        Set<String> pSet = TranslatorUtils.getAtomSet(p);
        Set<String> qSet = TranslatorUtils.getAtomSet(q);
        Set<String> pq = new HashSet<>(pSet);
        pq.addAll(qSet);
        assertNotEquals(0, pq.size());
    }

    @Test
    public void not() throws Exception
    {
        String pdl = "not p and q";
        Result result = PdlUtils.runCVC4(pdl);
        assertEquals("sat", result.satResult);
        FunctionDefinition p = TranslatorUtils.getFunctionDefinition(result.smtModel, "p");
        FunctionDefinition q = TranslatorUtils.getFunctionDefinition(result.smtModel, "q");

        Set<String> pSet = TranslatorUtils.getAtomSet(p);
        Set<String> qSet = TranslatorUtils.getAtomSet(q);
        assertEquals(0, pSet.size());
        assertNotEquals(0, qSet.size());
    }

    @Test
    public void implication1() throws Exception
    {
        String pdl = "not p and (p -> q)";
        Result result = PdlUtils.runCVC4(pdl);
        assertEquals("sat", result.satResult);
        FunctionDefinition p = TranslatorUtils.getFunctionDefinition(result.smtModel, "p");
        FunctionDefinition q = TranslatorUtils.getFunctionDefinition(result.smtModel, "q");

        Set<String> pSet = TranslatorUtils.getAtomSet(p);
        assertEquals(0, pSet.size());
    }

    @Test
    public void implication2() throws Exception
    {
        String pdl = "p and (p -> q)";
        Result result = PdlUtils.runCVC4(pdl);
        assertEquals("sat", result.satResult);
        FunctionDefinition p = TranslatorUtils.getFunctionDefinition(result.smtModel, "p");
        FunctionDefinition q = TranslatorUtils.getFunctionDefinition(result.smtModel, "q");

        Set<String> pSet = TranslatorUtils.getAtomSet(p);
        Set<String> qSet = TranslatorUtils.getAtomSet(q);
        assertNotEquals(0, pSet.size());
        assertNotEquals(0, qSet.size());
    }

    @Test
    public void equivalence1() throws Exception
    {
        String pdl = "not p and (p <-> q)";
        Result result = PdlUtils.runCVC4(pdl);
        assertEquals("sat", result.satResult);
        FunctionDefinition p = TranslatorUtils.getFunctionDefinition(result.smtModel, "p");
        FunctionDefinition q = TranslatorUtils.getFunctionDefinition(result.smtModel, "q");

        Set<String> pSet = TranslatorUtils.getAtomSet(p);
        Set<String> qSet = TranslatorUtils.getAtomSet(q);
        assertEquals(0, pSet.size());
        assertEquals(0, qSet.size());
    }

    @Test
    public void equivalence2() throws Exception
    {
        String pdl = "p and (p <-> q)";
        Result result = PdlUtils.runCVC4(pdl);
        assertEquals("sat", result.satResult);
        FunctionDefinition p = TranslatorUtils.getFunctionDefinition(result.smtModel, "p");
        FunctionDefinition q = TranslatorUtils.getFunctionDefinition(result.smtModel, "q");

        Set<String> pSet = TranslatorUtils.getAtomSet(p);
        Set<String> qSet = TranslatorUtils.getAtomSet(q);
        assertEquals(1, pSet.size());
        assertEquals(1, qSet.size());
    }

    @Test
    public void necessity() throws Exception
    {
        String pdl = "[a] p";
        Result result = PdlUtils.runCVC4(pdl);
        assertEquals("sat", result.satResult);

        FunctionDefinition a = TranslatorUtils.getFunctionDefinition(result.smtModel, "a");

        FunctionDefinition p = TranslatorUtils.getFunctionDefinition(result.smtModel, "p");

        Set<List<String>> aRelation = TranslatorUtils.getAtomRelation(a);
        Set<String> pSet = TranslatorUtils.getAtomSet(p);
        assertEquals(1, pSet.size());
        assertEquals(0, aRelation.size());
    }

    @Test
    public void possibility() throws Exception
    {
        String pdl = "<a> p";
        Result result = PdlUtils.runCVC4(pdl);
        assertEquals("sat", result.satResult);

        FunctionDefinition a = TranslatorUtils.getFunctionDefinition(result.smtModel, "a");

        FunctionDefinition p = TranslatorUtils.getFunctionDefinition(result.smtModel, "p");

        Set<List<String>> aRelation = TranslatorUtils.getAtomRelation(a);
        Set<String> pSet = TranslatorUtils.getAtomSet(p);
        assertEquals(1, pSet.size());
        assertEquals(1, aRelation.size());
    }

    @Test
    public void iteration() throws Exception
    {
        String pdl = "<a*> p";
        Result result = PdlUtils.runCVC4(pdl);
        assertEquals("sat", result.satResult);

        FunctionDefinition a = TranslatorUtils.getFunctionDefinition(result.smtModel, "a");

        FunctionDefinition p = TranslatorUtils.getFunctionDefinition(result.smtModel, "p");

        Set<List<String>> aRelation = TranslatorUtils.getAtomRelation(a);
        Set<String> pSet = TranslatorUtils.getAtomSet(p);
        assertEquals(1, pSet.size());
        assertEquals(1, aRelation.size());
    }

    @Test
    public void composition() throws Exception
    {
        String pdl = "<a;b> p";
        Result result = PdlUtils.runCVC4(pdl);
        assertEquals("sat", result.satResult);

        FunctionDefinition a = TranslatorUtils.getFunctionDefinition(result.smtModel, "a");

        FunctionDefinition b = TranslatorUtils.getFunctionDefinition(result.smtModel, "b");

        FunctionDefinition p = TranslatorUtils.getFunctionDefinition(result.smtModel, "p");

        Set<List<String>> aRelation = TranslatorUtils.getAtomRelation(a);
        Set<List<String>> bRelation = TranslatorUtils.getAtomRelation(b);
        Set<String> pSet = TranslatorUtils.getAtomSet(p);
        assertEquals(1, pSet.size());
        assertEquals(1, aRelation.size());
        assertEquals(1, bRelation.size());
    }

    @Test
    public void choice() throws Exception
    {
        String pdl = "<a union b> p";
        Result result = PdlUtils.runCVC4(pdl);
        assertEquals("sat", result.satResult);

        FunctionDefinition a = TranslatorUtils.getFunctionDefinition(result.smtModel, "a");

        FunctionDefinition b = TranslatorUtils.getFunctionDefinition(result.smtModel, "b");

        FunctionDefinition p = TranslatorUtils.getFunctionDefinition(result.smtModel, "p");

        Set<List<String>> aRelation = TranslatorUtils.getAtomRelation(a);
        Set<List<String>> bRelation = TranslatorUtils.getAtomRelation(b);
        Set<String> pSet = TranslatorUtils.getAtomSet(p);
        assertEquals(1, pSet.size());
        assertNotEquals(0, aRelation.size() + bRelation.size());
    }


    @Test
    public void bookExample1() throws Exception
    {
        String pdl = "<a*>[(a;a)*] p and <a*> [(a;a)*] not p";
        PdlResult result = PdlUtils.runCVC4(pdl);
        assertEquals("sat", result.satResult);

        FunctionDefinition a = TranslatorUtils.getFunctionDefinition(result.smtModel, "a");

        FunctionDefinition p = TranslatorUtils.getFunctionDefinition(result.smtModel, "p");

        Set<List<String>> aRelation = TranslatorUtils.getAtomRelation(a);
        Set<String> pSet = TranslatorUtils.getAtomSet(p);
        assertEquals(0, pSet.size());
        assertEquals(2, aRelation.size());
        KripkeFrame frame = result.getResultFrame();
        assertEquals(
                "K = {0, 1}\n" +
                "m(p) = {}\n" +
                "m(a) = {(0,1), (0,0)}\n", frame.toString());
    }

    @Test
    public void alternativeGuardedCommand() throws Exception
    {
        String pdl = "p and <if p -> a | q -> b fi> p and q";
        PdlResult result = PdlUtils.runCVC4(pdl);
        assertEquals("sat", result.satResult);

        KripkeFrame frame = result.getResultFrame();
        assertEquals(
                "K = {0}\n" +
                        "m(p) = {0}\n" +
                        "m(q) = {0}\n" +
                        "m(a) = {(0,0)}\n" +
                        "m(b) = {}\n", frame.toString());
    }

    @Test
    public void iterativeGuardedCommand1() throws Exception
    {
        String pdl = "<do p -> a | q -> b od> (not p or not q)";
        PdlResult result = PdlUtils.runCVC4(pdl);
        assertEquals("sat", result.satResult);

        KripkeFrame frame = result.getResultFrame();
        assertEquals(
                "K = {0, 1}\n" +
                        "m(p) = {1}\n" +
                        "m(q) = {1}\n" +
                        "m(a) = {(1,1), (1,0)}\n" +
                        "m(b) = {}\n", frame.toString());
    }

    @Test
    public void iterativeGuardedCommand2() throws Exception
    {
        String pdl = "<do p -> a | q -> b od> r";
        PdlResult result = PdlUtils.runCVC4(pdl);
        assertEquals("sat", result.satResult);
        KripkeFrame frame = result.getResultFrame();
        assertEquals(
            "K = {0, 1}\n" +
                    "m(p) = {1}\n" +
                    "m(q) = {1}\n" +
                    "m(r) = {0}\n" +
                    "m(a) = {(1,1), (1,0)}\n" +
                    "m(b) = {}\n", frame.toString());
    }

    @Test
    public void iterativeGuardedCommand3() throws Exception
    {
        String pdl = "<do p -> a | q -> b od> (not p)";
        PdlResult result = PdlUtils.runCVC4(pdl);
        assertEquals("sat", result.satResult);
        KripkeFrame frame = result.getResultFrame();
        assertEquals(
                "K = {0, 1}\n" +
                        "m(p) = {1}\n" +
                        "m(q) = {1}\n" +
                        "m(a) = {(1,1), (1,0)}\n" +
                        "m(b) = {}\n", frame.toString());
    }
}