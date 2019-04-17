// Generated from pdl.g4 by ANTLR 4.7.2
package pdl;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link pdlParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface pdlVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link pdlParser#pdl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPdl(pdlParser.PdlContext ctx);
	/**
	 * Visit a parse tree produced by {@link pdlParser#formula}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFormula(pdlParser.FormulaContext ctx);
	/**
	 * Visit a parse tree produced by {@link pdlParser#hoarePartialCorrectness}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitHoarePartialCorrectness(pdlParser.HoarePartialCorrectnessContext ctx);
	/**
	 * Visit a parse tree produced by {@link pdlParser#falsity}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFalsity(pdlParser.FalsityContext ctx);
	/**
	 * Visit a parse tree produced by {@link pdlParser#truth}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTruth(pdlParser.TruthContext ctx);
	/**
	 * Visit a parse tree produced by {@link pdlParser#atomicFormula}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAtomicFormula(pdlParser.AtomicFormulaContext ctx);
	/**
	 * Visit a parse tree produced by {@link pdlParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(pdlParser.ProgramContext ctx);
	/**
	 * Visit a parse tree produced by {@link pdlParser#skip}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSkip(pdlParser.SkipContext ctx);
	/**
	 * Visit a parse tree produced by {@link pdlParser#fail}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFail(pdlParser.FailContext ctx);
	/**
	 * Visit a parse tree produced by {@link pdlParser#atomicProgram}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAtomicProgram(pdlParser.AtomicProgramContext ctx);
	/**
	 * Visit a parse tree produced by {@link pdlParser#alternativeGuardedCommand}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlternativeGuardedCommand(pdlParser.AlternativeGuardedCommandContext ctx);
	/**
	 * Visit a parse tree produced by {@link pdlParser#iterativeGuardedCommand}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIterativeGuardedCommand(pdlParser.IterativeGuardedCommandContext ctx);
	/**
	 * Visit a parse tree produced by {@link pdlParser#guardedCommand}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGuardedCommand(pdlParser.GuardedCommandContext ctx);
}