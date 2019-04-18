// Generated from pdl.g4 by ANTLR 4.7.2
package pdl.parser.antlr;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link pdlParser}.
 */
public interface pdlListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link pdlParser#pdl}.
	 * @param ctx the parse tree
	 */
	void enterPdl(pdlParser.PdlContext ctx);
	/**
	 * Exit a parse tree produced by {@link pdlParser#pdl}.
	 * @param ctx the parse tree
	 */
	void exitPdl(pdlParser.PdlContext ctx);
	/**
	 * Enter a parse tree produced by {@link pdlParser#formula}.
	 * @param ctx the parse tree
	 */
	void enterFormula(pdlParser.FormulaContext ctx);
	/**
	 * Exit a parse tree produced by {@link pdlParser#formula}.
	 * @param ctx the parse tree
	 */
	void exitFormula(pdlParser.FormulaContext ctx);
	/**
	 * Enter a parse tree produced by {@link pdlParser#hoarePartialCorrectness}.
	 * @param ctx the parse tree
	 */
	void enterHoarePartialCorrectness(pdlParser.HoarePartialCorrectnessContext ctx);
	/**
	 * Exit a parse tree produced by {@link pdlParser#hoarePartialCorrectness}.
	 * @param ctx the parse tree
	 */
	void exitHoarePartialCorrectness(pdlParser.HoarePartialCorrectnessContext ctx);
	/**
	 * Enter a parse tree produced by {@link pdlParser#falsity}.
	 * @param ctx the parse tree
	 */
	void enterFalsity(pdlParser.FalsityContext ctx);
	/**
	 * Exit a parse tree produced by {@link pdlParser#falsity}.
	 * @param ctx the parse tree
	 */
	void exitFalsity(pdlParser.FalsityContext ctx);
	/**
	 * Enter a parse tree produced by {@link pdlParser#truth}.
	 * @param ctx the parse tree
	 */
	void enterTruth(pdlParser.TruthContext ctx);
	/**
	 * Exit a parse tree produced by {@link pdlParser#truth}.
	 * @param ctx the parse tree
	 */
	void exitTruth(pdlParser.TruthContext ctx);
	/**
	 * Enter a parse tree produced by {@link pdlParser#atomicFormula}.
	 * @param ctx the parse tree
	 */
	void enterAtomicFormula(pdlParser.AtomicFormulaContext ctx);
	/**
	 * Exit a parse tree produced by {@link pdlParser#atomicFormula}.
	 * @param ctx the parse tree
	 */
	void exitAtomicFormula(pdlParser.AtomicFormulaContext ctx);
	/**
	 * Enter a parse tree produced by {@link pdlParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(pdlParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link pdlParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(pdlParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link pdlParser#skip}.
	 * @param ctx the parse tree
	 */
	void enterSkip(pdlParser.SkipContext ctx);
	/**
	 * Exit a parse tree produced by {@link pdlParser#skip}.
	 * @param ctx the parse tree
	 */
	void exitSkip(pdlParser.SkipContext ctx);
	/**
	 * Enter a parse tree produced by {@link pdlParser#fail}.
	 * @param ctx the parse tree
	 */
	void enterFail(pdlParser.FailContext ctx);
	/**
	 * Exit a parse tree produced by {@link pdlParser#fail}.
	 * @param ctx the parse tree
	 */
	void exitFail(pdlParser.FailContext ctx);
	/**
	 * Enter a parse tree produced by {@link pdlParser#atomicProgram}.
	 * @param ctx the parse tree
	 */
	void enterAtomicProgram(pdlParser.AtomicProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link pdlParser#atomicProgram}.
	 * @param ctx the parse tree
	 */
	void exitAtomicProgram(pdlParser.AtomicProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link pdlParser#alternativeGuardedCommand}.
	 * @param ctx the parse tree
	 */
	void enterAlternativeGuardedCommand(pdlParser.AlternativeGuardedCommandContext ctx);
	/**
	 * Exit a parse tree produced by {@link pdlParser#alternativeGuardedCommand}.
	 * @param ctx the parse tree
	 */
	void exitAlternativeGuardedCommand(pdlParser.AlternativeGuardedCommandContext ctx);
	/**
	 * Enter a parse tree produced by {@link pdlParser#iterativeGuardedCommand}.
	 * @param ctx the parse tree
	 */
	void enterIterativeGuardedCommand(pdlParser.IterativeGuardedCommandContext ctx);
	/**
	 * Exit a parse tree produced by {@link pdlParser#iterativeGuardedCommand}.
	 * @param ctx the parse tree
	 */
	void exitIterativeGuardedCommand(pdlParser.IterativeGuardedCommandContext ctx);
	/**
	 * Enter a parse tree produced by {@link pdlParser#guardedCommand}.
	 * @param ctx the parse tree
	 */
	void enterGuardedCommand(pdlParser.GuardedCommandContext ctx);
	/**
	 * Exit a parse tree produced by {@link pdlParser#guardedCommand}.
	 * @param ctx the parse tree
	 */
	void exitGuardedCommand(pdlParser.GuardedCommandContext ctx);
}