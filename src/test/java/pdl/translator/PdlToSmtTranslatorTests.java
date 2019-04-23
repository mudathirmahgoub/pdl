package pdl.translator;

import edu.uiowa.smt.Result;
import edu.uiowa.smt.TranslatorUtils;
import edu.uiowa.smt.smtAst.FunctionDefinition;
import org.junit.jupiter.api.Test;

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
        assertEquals(1, TranslatorUtils.getAtomSet(p).size());
    }
}