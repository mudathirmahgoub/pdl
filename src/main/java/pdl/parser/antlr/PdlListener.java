// Generated from Pdl.g4 by ANTLR 4.7.2
package pdl.parser.antlr;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link PdlParser}.
 */
public interface PdlListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link PdlParser#pdl}.
	 * @param ctx the parse tree
	 */
	void enterPdl(PdlParser.PdlContext ctx);
	/**
	 * Exit a parse tree produced by {@link PdlParser#pdl}.
	 * @param ctx the parse tree
	 */
	void exitPdl(PdlParser.PdlContext ctx);
	/**
	 * Enter a parse tree produced by {@link PdlParser#formula}.
	 * @param ctx the parse tree
	 */
	void enterFormula(PdlParser.FormulaContext ctx);
	/**
	 * Exit a parse tree produced by {@link PdlParser#formula}.
	 * @param ctx the parse tree
	 */
	void exitFormula(PdlParser.FormulaContext ctx);
	/**
	 * Enter a parse tree produced by {@link PdlParser#hoarePartialCorrectness}.
	 * @param ctx the parse tree
	 */
	void enterHoarePartialCorrectness(PdlParser.HoarePartialCorrectnessContext ctx);
	/**
	 * Exit a parse tree produced by {@link PdlParser#hoarePartialCorrectness}.
	 * @param ctx the parse tree
	 */
	void exitHoarePartialCorrectness(PdlParser.HoarePartialCorrectnessContext ctx);
	/**
	 * Enter a parse tree produced by {@link PdlParser#falsity}.
	 * @param ctx the parse tree
	 */
	void enterFalsity(PdlParser.FalsityContext ctx);
	/**
	 * Exit a parse tree produced by {@link PdlParser#falsity}.
	 * @param ctx the parse tree
	 */
	void exitFalsity(PdlParser.FalsityContext ctx);
	/**
	 * Enter a parse tree produced by {@link PdlParser#truth}.
	 * @param ctx the parse tree
	 */
	void enterTruth(PdlParser.TruthContext ctx);
	/**
	 * Exit a parse tree produced by {@link PdlParser#truth}.
	 * @param ctx the parse tree
	 */
	void exitTruth(PdlParser.TruthContext ctx);
	/**
	 * Enter a parse tree produced by {@link PdlParser#atomicFormula}.
	 * @param ctx the parse tree
	 */
	void enterAtomicFormula(PdlParser.AtomicFormulaContext ctx);
	/**
	 * Exit a parse tree produced by {@link PdlParser#atomicFormula}.
	 * @param ctx the parse tree
	 */
	void exitAtomicFormula(PdlParser.AtomicFormulaContext ctx);
	/**
	 * Enter a parse tree produced by {@link PdlParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(PdlParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link PdlParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(PdlParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link PdlParser#skip}.
	 * @param ctx the parse tree
	 */
	void enterSkip(PdlParser.SkipContext ctx);
	/**
	 * Exit a parse tree produced by {@link PdlParser#skip}.
	 * @param ctx the parse tree
	 */
	void exitSkip(PdlParser.SkipContext ctx);
	/**
	 * Enter a parse tree produced by {@link PdlParser#fail}.
	 * @param ctx the parse tree
	 */
	void enterFail(PdlParser.FailContext ctx);
	/**
	 * Exit a parse tree produced by {@link PdlParser#fail}.
	 * @param ctx the parse tree
	 */
	void exitFail(PdlParser.FailContext ctx);
	/**
	 * Enter a parse tree produced by {@link PdlParser#atomicProgram}.
	 * @param ctx the parse tree
	 */
	void enterAtomicProgram(PdlParser.AtomicProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link PdlParser#atomicProgram}.
	 * @param ctx the parse tree
	 */
	void exitAtomicProgram(PdlParser.AtomicProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link PdlParser#alternativeGuardedCommand}.
	 * @param ctx the parse tree
	 */
	void enterAlternativeGuardedCommand(PdlParser.AlternativeGuardedCommandContext ctx);
	/**
	 * Exit a parse tree produced by {@link PdlParser#alternativeGuardedCommand}.
	 * @param ctx the parse tree
	 */
	void exitAlternativeGuardedCommand(PdlParser.AlternativeGuardedCommandContext ctx);
	/**
	 * Enter a parse tree produced by {@link PdlParser#iterativeGuardedCommand}.
	 * @param ctx the parse tree
	 */
	void enterIterativeGuardedCommand(PdlParser.IterativeGuardedCommandContext ctx);
	/**
	 * Exit a parse tree produced by {@link PdlParser#iterativeGuardedCommand}.
	 * @param ctx the parse tree
	 */
	void exitIterativeGuardedCommand(PdlParser.IterativeGuardedCommandContext ctx);
	/**
	 * Enter a parse tree produced by {@link PdlParser#guardedCommand}.
	 * @param ctx the parse tree
	 */
	void enterGuardedCommand(PdlParser.GuardedCommandContext ctx);
	/**
	 * Exit a parse tree produced by {@link PdlParser#guardedCommand}.
	 * @param ctx the parse tree
	 */
	void exitGuardedCommand(PdlParser.GuardedCommandContext ctx);
}