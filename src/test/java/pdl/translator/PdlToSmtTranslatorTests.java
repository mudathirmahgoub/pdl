package pdl.translator;

import edu.uiowa.smt.Result;
import edu.uiowa.smt.TranslatorUtils;
import edu.uiowa.smt.smtAst.FunctionDefinition;
import org.junit.jupiter.api.Test;
import pdl.ast.KripkeFrame;

import java.util.Arrays;
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
        assertEquals(0, aRelation.size());
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
        assertEquals(1, pSet.size());
        assertEquals(1, aRelation.size());
        KripkeFrame frame = result.getResultFrame();
        assertEquals(
                "K = {0, 1}\n" +
                        "m(p) = {1}\n" +
                        "m(a) = {(1,0)}\n", frame.toString());
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
        String pdl = "<do p -> a | q -> b od> (not p and not q)";
        PdlResult result = PdlUtils.runCVC4(pdl);
        assertEquals("sat", result.satResult);

        KripkeFrame frame = result.getResultFrame();
        assertEquals(
                "K = {0}\n" +
                        "m(p) = {}\n" +
                        "m(q) = {}\n" +
                        "m(a) = {}\n" +
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
            "K = {0}\n" +
                    "m(p) = {}\n" +
                    "m(q) = {}\n" +
                    "m(r) = {0}\n" +
                    "m(a) = {}\n" +
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
                "K = {0}\n" +
                        "m(p) = {}\n" +
                        "m(q) = {}\n" +
                        "m(a) = {}\n" +
                        "m(b) = {}\n", frame.toString());
    }

    @Test
    public void whileProgram1() throws Exception
    {
        String pdl = "<while p do a> p";
        PdlResult result = PdlUtils.runCVC4(pdl);
        assertEquals("unsat", result.satResult);
    }

    @Test
    public void whileProgram2() throws Exception
    {
        String pdl = "<while p do a> not p";
        PdlResult result = PdlUtils.runCVC4(pdl);
        assertEquals("sat", result.satResult);

        KripkeFrame frame = result.getResultFrame();
        assertEquals(
                "K = {0}\n" +
                        "m(p) = {}\n" +
                        "m(a) = {}\n", frame.toString());
    }

    @Test
    public void repeatProgram() throws Exception
    {
        String pdl = "<repeat a until p> p";
        PdlResult result = PdlUtils.runCVC4(pdl);
        assertEquals("sat", result.satResult);

        KripkeFrame frame = result.getResultFrame();
        assertEquals(
                "K = {0}\n" +
                        "m(p) = {0}\n" +
                        "m(a) = {(0,0)}\n", frame.toString());
    }

    @Test
    public void hoarePartialCorrectness1() throws Exception
    {
        String pdl = "{p} a {q}";
        PdlResult result = PdlUtils.runCVC4(pdl);
        assertEquals("sat", result.satResult);

        KripkeFrame frame = result.getResultFrame();
        assertEquals(
                "K = {0}\n" +
                        "m(p) = {}\n" +
                        "m(q) = {0}\n" +
                        "m(a) = {}\n", frame.toString());
    }

    @Test
    public void hoarePartialCorrectness2() throws Exception
    {
        String pdl = "<a>p and {p} a {q}";
        PdlResult result = PdlUtils.runCVC4(pdl);
        assertEquals("sat", result.satResult);

        KripkeFrame frame = result.getResultFrame();
        assertEquals(
                "K = {0}\n" +
                        "m(p) = {0}\n" +
                        "m(q) = {0}\n" +
                        "m(a) = {(0,0)}\n", frame.toString());
    }

    @Test
    public void bookExample1WithFrameSat() throws Exception
    {
        String pdl =
                "K = {u, v, w}\n" +
                "m(p) = {u, v}\n" +
                "m(a) = {(u,v), (u,w), (v,w), (w,v)}\n" +
                "<a*>[(a;a)*] p and <a*> [(a;a)*] not p";
        PdlResult result = PdlUtils.runCVC4(pdl);
        assertEquals("sat", result.satResult);

        Set<String> uvw = new HashSet<>(Arrays.asList("u", "v", "w"));
        assertEquals(uvw, result.satisfyingStates);
    }

    @Test
    public void bookExample1WithFrameUnsat() throws Exception
    {
        String pdl =
                "K = {u, v, w}\n" +
                "m(p) = {u, v}\n" +
                "m(a) = {(u,v), (u,w), (v,w), (w,v)}\n" +
                "not (<a*>[(a;a)*] p and <a*> [(a;a)*] not p)";
        PdlResult result = PdlUtils.runCVC4(pdl);
        assertEquals("unsat", result.satResult);
    }

    @Test
    public void examQuestionA() throws Exception
    {
        String pdl =
                "K = {01,2,3,4,5}\n" +
                "m(p) = {01,2}\n" +
                "m(q) = {3,4}\n" +
                "m(r) = {4,5}\n" +
                "m(a) = {(2,3), (4,5), (5,01)}\n" +
                "m(b) = {(01,2), (3,4)}\n" +
                "m(c) = {(2,3), (3,2)}" +
                "<((b;a) union a)*> p";

        PdlResult result = PdlUtils.runCVC4(pdl);
        assertEquals("sat", result.satResult);

        Set<String> k = new HashSet<>(Arrays.asList("s01","s2","s3","s4","s5"));
        assertEquals(k, result.satisfyingStates);
    }

    @Test
    public void examQuestionB() throws Exception
    {
        String pdl =
                "K = {01,2,3,4,5}\n" +
                "m(p) = {01,2}\n" +
                "m(q) = {3,4}\n" +
                "m(r) = {4,5}\n" +
                "m(a) = {(2,3), (4,5), (5,01)}\n" +
                "m(b) = {(01,2), (3,4)}\n" +
                "m(c) = {(2,3), (3,2)}" +
                "<c>q -> <b>r";

        PdlResult result = PdlUtils.runCVC4(pdl);
        assertEquals("sat", result.satResult);

        Set<String> k = new HashSet<>(Arrays.asList("s01","s3","s4","s5"));
        assertEquals(k, result.satisfyingStates);
    }

    @Test
    public void examQuestionC() throws Exception
    {
        String pdl =
                "K = {01,2,3,4,5}\n" +
                "m(p) = {01,2}\n" +
                "m(q) = {3,4}\n" +
                "m(r) = {4,5}\n" +
                "m(a) = {(2,3), (4,5), (5,01)}\n" +
                "m(b) = {(01,2), (3,4)}\n" +
                "m(c) = {(2,3), (3,2)}" +
                "[b union c] <a> q";

        PdlResult result = PdlUtils.runCVC4(pdl);
        assertEquals("sat", result.satResult);

        Set<String> k = new HashSet<>(Arrays.asList("s01","s4","s5"));
        assertEquals(k, result.satisfyingStates);
    }

    @Test
    public void homeworkA() throws Exception
    {
        String pdl =
                "K = {01,2,3,4,5}\n" +
                        "m(p) = {01,2,4}\n" +
                        "m(q) = {01, 3}\n" +
                        "m(r) = {5}\n" +
                        "m(a) = {(01,2), (01,4), (2,4), (01,3)}\n" +
                        "m(b) = {(01,3), (3,3)}\n" +
                        "m(c) = {(5,5)}\n" +
                        "p -> [b] q";

        PdlResult result = PdlUtils.runCVC4(pdl);
        assertEquals("sat", result.satResult);

        Set<String> k = new HashSet<>(Arrays.asList("s01","s2", "s3", "s4","s5"));
        assertEquals(k, result.satisfyingStates);
    }

    @Test
    public void homeworkB() throws Exception
    {
        String pdl =
                "K = {01,2,3,4,5}\n" +
                        "m(p) = {01,2,4}\n" +
                        "m(q) = {01, 3}\n" +
                        "m(r) = {5}\n" +
                        "m(a) = {(01,2), (01,4), (2,4), (01,3)}\n" +
                        "m(b) = {(01,3), (3,3)}\n" +
                        "m(c) = {(5,5)}\n" +
                        "p -> (q -> [c]p)";

        PdlResult result = PdlUtils.runCVC4(pdl);
        assertEquals("sat", result.satResult);

        Set<String> k = new HashSet<>(Arrays.asList("s01","s2", "s3", "s4","s5"));
        assertEquals(k, result.satisfyingStates);
    }

    @Test
    public void homeworkC() throws Exception
    {
        String pdl =
                "K = {01,2,3,4,5}\n" +
                        "m(p) = {01,2,4}\n" +
                        "m(q) = {01, 3}\n" +
                        "m(r) = {5}\n" +
                        "m(a) = {(01,2), (01,4), (2,4), (01,3)}\n" +
                        "m(b) = {(01,3), (3,3)}\n" +
                        "m(c) = {(5,5)}\n" +
                        "p and <b>[b*] q";

        PdlResult result = PdlUtils.runCVC4(pdl);
        assertEquals("sat", result.satResult);

        Set<String> k = new HashSet<>(Arrays.asList("s01"));
        assertEquals(k, result.satisfyingStates);
    }

    @Test
    public void homeworkD() throws Exception
    {
        String pdl =
                "K = {01,2,3,4,5}\n" +
                        "m(p) = {01,2,4}\n" +
                        "m(q) = {01, 3}\n" +
                        "m(r) = {5}\n" +
                        "m(a) = {(01,2), (01,4), (2,4), (01,3)}\n" +
                        "m(b) = {(01,3), (3,3)}\n" +
                        "m(c) = {(5,5)}\n" +
                        "[c*] r";

        PdlResult result = PdlUtils.runCVC4(pdl);
        assertEquals("sat", result.satResult);

        Set<String> k = new HashSet<>(Arrays.asList("s5"));
        assertEquals(k, result.satisfyingStates);
    }

    @Test
    public void homeworkDPossibility() throws Exception
    {
        String pdl =
                "K = {01,2,3,4,5}\n" +
                        "m(p) = {01,2,4}\n" +
                        "m(q) = {01, 3}\n" +
                        "m(r) = {5}\n" +
                        "m(a) = {(01,2), (01,4), (2,4), (01,3)}\n" +
                        "m(b) = {(01,3), (3,3)}\n" +
                        "m(c) = {(5,5)}\n" +
                        "<c*> r";

        PdlResult result = PdlUtils.runCVC4(pdl);
        assertEquals("sat", result.satResult);

        Set<String> k = new HashSet<>(Arrays.asList("s5"));
        assertEquals(k, result.satisfyingStates);
    }

    @Test
    public void homeworkE() throws Exception
    {
        String pdl =
                "K = {01,2,3,4,5}\n" +
                        "m(p) = {01,2,4}\n" +
                        "m(q) = {01, 3}\n" +
                        "m(r) = {5}\n" +
                        "m(a) = {(01,2), (01,4), (2,4), (01,3)}\n" +
                        "m(b) = {(01,3), (3,3)}\n" +
                        "m(c) = {(5,5)}\n" +
                        "[a union b union c] (q and not p)";

        PdlResult result = PdlUtils.runCVC4(pdl);
        assertEquals("sat", result.satResult);

        Set<String> k = new HashSet<>(Arrays.asList("s3", "s4"));
        assertEquals(k, result.satisfyingStates);
    }

    @Test
    public void homework1Satisfies() throws Exception
    {
        String pdl =
                "<a><b> 1 and ([a]<b> 1 -> [b]<a> 1)";

        PdlResult result = PdlUtils.runCVC4(pdl);
        assertEquals("sat", result.satResult);

        KripkeFrame frame = result.getResultFrame();
        assertEquals(
                "K = {0}\n" +
                        "m(a) = {(0,0)}\n" +
                        "m(b) = {(0,0)}\n", frame.toString());
    }

    @Test
    public void homework1Falsifies() throws Exception
    {
        String pdl =
                "not (<a><b> 1 and ([a]<b> 1 -> [b]<a> 1))";

        PdlResult result = PdlUtils.runCVC4(pdl);
        assertEquals("sat", result.satResult);

        KripkeFrame frame = result.getResultFrame();
        assertEquals(
                "K = {0}\n" +
                        "m(a) = {}\n" +
                        "m(b) = {(0,0)}\n", frame.toString());
    }

    @Test
    public void homework2Satisfies() throws Exception
    {
        String pdl =
                "<a> 1 and ([a;a*] p -> <a> p)";

        PdlResult result = PdlUtils.runCVC4(pdl);
        assertEquals("sat", result.satResult);

        KripkeFrame frame = result.getResultFrame();
        assertEquals(
                "K = {0}\n" +
                        "m(p) = {}\n" +
                        "m(a) = {(0,0)}\n", frame.toString());
    }

    @Test
    public void homework2Falsifies() throws Exception
    {
        String pdl =
                "not (<a> 1 and ([a;a*] p -> <a> p))";

        PdlResult result = PdlUtils.runCVC4(pdl);
        assertEquals("sat", result.satResult);

        KripkeFrame frame = result.getResultFrame();
        assertEquals(
                "K = {0}\n" +
                        "m(p) = {0}\n" +
                        "m(a) = {}\n", frame.toString());
    }

    @Test
    public void homework3Satisfies() throws Exception
    {
        String pdl =
                "[a union b](p or q) -> ([a]p and [b] q)";

        PdlResult result = PdlUtils.runCVC4(pdl);
        assertEquals("sat", result.satResult);

        KripkeFrame frame = result.getResultFrame();
        assertEquals(
                "K = {0}\n" +
                        "m(p) = {}\n" +
                        "m(q) = {}\n" +
                        "m(a) = {(0,0)}\n" +
                        "m(b) = {(0,0)}\n", frame.toString());
    }

    @Test
    public void homework3Falsifies() throws Exception
    {
        String pdl =
                "not([a union b](p or q) -> ([a]p and [b] q))";

        PdlResult result = PdlUtils.runCVC4(pdl);
        assertEquals("sat", result.satResult);

        KripkeFrame frame = result.getResultFrame();
        assertEquals(
                "K = {0}\n" +
                        "m(p) = {}\n" +
                        "m(q) = {0}\n" +
                        "m(a) = {(0,0)}\n" +
                        "m(b) = {}\n", frame.toString());
    }

    @Test
    public void validity1() throws Exception
    {
        String pdl = "not (p or not p)";
        PdlResult result = PdlUtils.runCVC4(pdl);
        assertEquals("unsat", result.satResult);
    }

    @Test
    public void validity2() throws Exception
    {
        String pdl = "not ((p and (p -> q)) -> q)";
        PdlResult result = PdlUtils.runCVC4(pdl);
        assertEquals("unsat", result.satResult);
    }
}