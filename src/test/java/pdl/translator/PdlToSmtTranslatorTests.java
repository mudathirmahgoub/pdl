package pdl.translator;

import edu.uiowa.smt.Result;
import edu.uiowa.smt.TranslatorUtils;
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
}