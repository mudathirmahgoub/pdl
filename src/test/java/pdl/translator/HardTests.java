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

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class HardTests
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
}