package pdl.translator;

import edu.uiowa.smt.Result;
import edu.uiowa.smt.TranslatorUtils;
import edu.uiowa.smt.smtAst.FunctionDefinition;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
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
        assertNotEquals(0, pq);
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
        assertNotEquals(0, pq);
    }
}