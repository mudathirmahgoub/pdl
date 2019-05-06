package pdl.translator;

import edu.uiowa.smt.Result;
import edu.uiowa.smt.TranslatorUtils;
import edu.uiowa.smt.smtAst.FunctionDefinition;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import pdl.ast.KripkeFrame;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class ValidFormulas
{
    @Test
    public void bookFormula1() throws Exception
    {
        String pdl = "not([a](p and q)<-> [a] p and [a]q)";
        PdlResult result = PdlUtils.runCVC4(pdl);
        assertEquals("unsat", result.satResult);
    }

    @Test
    public void bookFormula2() throws Exception
    {
        String pdl = "not([a;b]p <-> [a][b]p)";
        PdlResult result = PdlUtils.runCVC4(pdl);
        assertEquals("unsat", result.satResult);
    }

    @Test
    public void bookFormula3() throws Exception
    {
        String pdl = "not([if p then a else b]p <-> [if not p then b else a]p)";
        PdlResult result = PdlUtils.runCVC4(pdl);
        assertEquals("unsat", result.satResult);
    }

    @Test void deductiveSystem2() throws Exception
    {
        String pdl = "not([a](p -> q) -> ([a]p -> [a]q))";
        PdlResult result = PdlUtils.runCVC4(pdl);
        assertEquals("unsat", result.satResult);
    }
    @Test void deductiveSystem3() throws Exception
    {
        String pdl = "not([a](p and q) -> ([a]p and [a]q))";
        PdlResult result = PdlUtils.runCVC4(pdl);
        assertEquals("unsat", result.satResult);
    }
    @Test void deductiveSystem4() throws Exception
    {
        String pdl = "not([a union b]p <-> [a]p and [b]p)";
        PdlResult result = PdlUtils.runCVC4(pdl);
        assertEquals("unsat", result.satResult);
    }
    @Test void deductiveSystem5() throws Exception
    {
        String pdl = "not([a;b]p <-> [a][b]p)";
        PdlResult result = PdlUtils.runCVC4(pdl);
        assertEquals("unsat", result.satResult);
    }
    @Test void deductiveSystem6() throws Exception
    {
        String pdl = "not([q?]p <-> (q -> p))";
        PdlResult result = PdlUtils.runCVC4(pdl);
        assertEquals("unsat", result.satResult);
    }
    @Test void deductiveSystem7() throws Exception
    {
        String pdl = "not(p and [a][a*] p <-> [a*]p)";
        PdlResult result = PdlUtils.runCVC4(pdl);
        assertEquals("unsat", result.satResult);
    }
    @Test void deductiveSystem8() throws Exception
    {
        String pdl = "not(p and [a*](p -> [a]p) -> [a*]p)";
        PdlResult result = PdlUtils.runCVC4(pdl);
        assertEquals("unsat", result.satResult);
    }
    @Test void deductiveSystem9MP() throws Exception
    {
        String pdl = "not((p and (p -> q)) -> q)";
        PdlResult result = PdlUtils.runCVC4(pdl);
        assertEquals("unsat", result.satResult);
    }

    @Test void theoream6_1() throws Exception
    {
        String pdl = "not(<a>(p or q) <-> <a>p or <a>q)";
        PdlResult result = PdlUtils.runCVC4(pdl);
        assertEquals("unsat", result.satResult);
    }

    @Test void theoream6_2() throws Exception
    {
        String pdl = "not([a](p and q) <-> [a]p and [a]q)";
        PdlResult result = PdlUtils.runCVC4(pdl);
        assertEquals("unsat", result.satResult);
    }

    @Test void theoream6_3() throws Exception
    {
        String pdl = "not(<a>p and [a] q -> <a>(p and q))";
        PdlResult result = PdlUtils.runCVC4(pdl);
        assertEquals("unsat", result.satResult);
    }

    @Test void theoream6_4() throws Exception
    {
        String pdl = "not([a](p -> q) -> ([a]p -> [a] q))";
        PdlResult result = PdlUtils.runCVC4(pdl);
        assertEquals("unsat", result.satResult);
    }

    @Test void theoream6_5() throws Exception
    {
        String pdl = "not(<a>(p and q) -> <a> p and <a> q)";
        PdlResult result = PdlUtils.runCVC4(pdl);
        assertEquals("unsat", result.satResult);
    }

    @Test void theoream6_6() throws Exception
    {
        String pdl = "not([a]p or [a] q -> [a] (p or q))";
        PdlResult result = PdlUtils.runCVC4(pdl);
        assertEquals("unsat", result.satResult);
    }

    @Test void theoream6_7() throws Exception
    {
        String pdl = "not(<a> 0 <-> 0)";
        PdlResult result = PdlUtils.runCVC4(pdl);
        assertEquals("unsat", result.satResult);
    }

    @Test void theoream6_8() throws Exception
    {
        String pdl = "not([a]p <-> not <a> not p)";
        PdlResult result = PdlUtils.runCVC4(pdl);
        assertEquals("unsat", result.satResult);
    }

    @Test void theoream8_1() throws Exception
    {
        String pdl = "not(<a union b> p <-> <a> p or <b> p)";
        PdlResult result = PdlUtils.runCVC4(pdl);
        assertEquals("unsat", result.satResult);
    }

    @Test void theoream8_2() throws Exception
    {
        String pdl = "not([a union b] p <-> [a] p and [b] p)";
        PdlResult result = PdlUtils.runCVC4(pdl);
        assertEquals("unsat", result.satResult);
    }

    @Test void theoream10_1() throws Exception
    {
        String pdl = "not(<a ; b> p <-> <a><b> p)";
        PdlResult result = PdlUtils.runCVC4(pdl);
        assertEquals("unsat", result.satResult);
    }

    @Test void theoream10_2() throws Exception
    {
        String pdl = "not([a ; b] p <-> [a][b] p)";
        PdlResult result = PdlUtils.runCVC4(pdl);
        assertEquals("unsat", result.satResult);
    }

    @Test void theoream11_1() throws Exception
    {
        String pdl = "not(<p?> q <-> p and q)";
        PdlResult result = PdlUtils.runCVC4(pdl);
        assertEquals("unsat", result.satResult);
    }

    @Test void theoream11_2() throws Exception
    {
        String pdl = "not([p?] q <-> (p -> q))";
        PdlResult result = PdlUtils.runCVC4(pdl);
        assertEquals("unsat", result.satResult);
    }

    @Test void theoream12_1() throws Exception
    {
        String pdl = "not([p?] q <-> (p -> q))";
        PdlResult result = PdlUtils.runCVC4(pdl);
        assertEquals("unsat", result.satResult);
    }

    @Test void theoream15_1() throws Exception
    {
        String pdl = "not([a*]p -> p)";
        PdlResult result = PdlUtils.runCVC4(pdl);
        assertEquals("unsat", result.satResult);
    }

    @Test void theoream15_2() throws Exception
    {
        String pdl = "not(p -> <a*> p)";
        PdlResult result = PdlUtils.runCVC4(pdl);
        assertEquals("unsat", result.satResult);
    }

    @Test void theoream15_3() throws Exception
    {
        String pdl = "not([a*]p -> [a]p)";
        PdlResult result = PdlUtils.runCVC4(pdl);
        assertEquals("unsat", result.satResult);
    }

    @Test void theoream15_4() throws Exception
    {
        String pdl = "not(<a>p -> <a*>p)";
        PdlResult result = PdlUtils.runCVC4(pdl);
        assertEquals("unsat", result.satResult);
    }

    @Test void theoream15_5() throws Exception
    {
        String pdl = "not([a*]p <-> [a*;a*]p)";
        PdlResult result = PdlUtils.runCVC4(pdl);
        assertEquals("unsat", result.satResult);
    }

    @Test void theoream15_6() throws Exception
    {
        String pdl = "not(<a*>p <-> <a*;a*>p)";
        PdlResult result = PdlUtils.runCVC4(pdl);
        assertEquals("unsat", result.satResult);
    }

    @Test void theoream15_7() throws Exception
    {
        String pdl = "not([a*]p <-> [a**]p)";
        PdlResult result = PdlUtils.runCVC4(pdl);
        assertEquals("unsat", result.satResult);
    }

    @Test void theoream15_8() throws Exception
    {
        String pdl = "not(<a*>p <-> <a**>p)";
        PdlResult result = PdlUtils.runCVC4(pdl);
        assertEquals("unsat", result.satResult);
    }

    @Test void theoream15_9() throws Exception
    {
        String pdl = "not([a*]p <-> p and [a][a*]p)";
        PdlResult result = PdlUtils.runCVC4(pdl);
        assertEquals("unsat", result.satResult);
    }

    @Test void theoream15_10() throws Exception
    {
        String pdl = "not(<a*>p <-> p or <a><a*>p)";
        PdlResult result = PdlUtils.runCVC4(pdl);
        assertEquals("unsat", result.satResult);
    }

    @Test void theoream15_11() throws Exception
    {
        String pdl = "not([a*]p <-> p and [a*](p -> [a]p))";
        PdlResult result = PdlUtils.runCVC4(pdl);
        assertEquals("unsat", result.satResult);
    }

    @Test void theoream15_12() throws Exception
    {
        String pdl = "not(<a*>p <-> p or <a*>(not p and <a>p))";
        PdlResult result = PdlUtils.runCVC4(pdl);
        assertEquals("unsat", result.satResult);
    }
}