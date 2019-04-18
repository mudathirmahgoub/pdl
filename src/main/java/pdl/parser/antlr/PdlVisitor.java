// Generated from Pdl.g4 by ANTLR 4.7.2
package pdl.parser.antlr;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link PdlParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface PdlVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link PdlParser#pdl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPdl(PdlParser.PdlContext ctx);
	/**
	 * Visit a parse tree produced by {@link PdlParser#kripkeFrame}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitKripkeFrame(PdlParser.KripkeFrameContext ctx);
	/**
	 * Visit a parse tree produced by {@link PdlParser#states}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStates(PdlParser.StatesContext ctx);
	/**
	 * Visit a parse tree produced by {@link PdlParser#propositionMeaning}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPropositionMeaning(PdlParser.PropositionMeaningContext ctx);
	/**
	 * Visit a parse tree produced by {@link PdlParser#programMeaning}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgramMeaning(PdlParser.ProgramMeaningContext ctx);
	/**
	 * Visit a parse tree produced by {@link PdlParser#pair}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPair(PdlParser.PairContext ctx);
	/**
	 * Visit a parse tree produced by {@link PdlParser#formula}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFormula(PdlParser.FormulaContext ctx);
	/**
	 * Visit a parse tree produced by {@link PdlParser#hoarePartialCorrectness}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitHoarePartialCorrectness(PdlParser.HoarePartialCorrectnessContext ctx);
	/**
	 * Visit a parse tree produced by {@link PdlParser#falsity}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFalsity(PdlParser.FalsityContext ctx);
	/**
	 * Visit a parse tree produced by {@link PdlParser#truth}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTruth(PdlParser.TruthContext ctx);
	/**
	 * Visit a parse tree produced by {@link PdlParser#atomicFormula}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAtomicFormula(PdlParser.AtomicFormulaContext ctx);
	/**
	 * Visit a parse tree produced by {@link PdlParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(PdlParser.ProgramContext ctx);
	/**
	 * Visit a parse tree produced by {@link PdlParser#skip}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSkip(PdlParser.SkipContext ctx);
	/**
	 * Visit a parse tree produced by {@link PdlParser#fail}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFail(PdlParser.FailContext ctx);
	/**
	 * Visit a parse tree produced by {@link PdlParser#atomicProgram}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAtomicProgram(PdlParser.AtomicProgramContext ctx);
	/**
	 * Visit a parse tree produced by {@link PdlParser#alternativeGuardedCommand}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlternativeGuardedCommand(PdlParser.AlternativeGuardedCommandContext ctx);
	/**
	 * Visit a parse tree produced by {@link PdlParser#iterativeGuardedCommand}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIterativeGuardedCommand(PdlParser.IterativeGuardedCommandContext ctx);
	/**
	 * Visit a parse tree produced by {@link PdlParser#guardedCommand}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGuardedCommand(PdlParser.GuardedCommandContext ctx);
	/**
	 * Visit a parse tree produced by {@link PdlParser#iteProgram}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIteProgram(PdlParser.IteProgramContext ctx);
	/**
	 * Visit a parse tree produced by {@link PdlParser#whileProgram}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhileProgram(PdlParser.WhileProgramContext ctx);
	/**
	 * Visit a parse tree produced by {@link PdlParser#repeatProgram}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRepeatProgram(PdlParser.RepeatProgramContext ctx);
}