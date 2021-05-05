// Generated from /Users/monika/MRG-SEM1/JFiK/P2.2/Grammar.g4 by ANTLR 4.9.1
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link GrammarParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface GrammarVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link GrammarParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(GrammarParser.ProgramContext ctx);
	/**
	 * Visit a parse tree produced by the {@code print}
	 * labeled alternative in {@link GrammarParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrint(GrammarParser.PrintContext ctx);
	/**
	 * Visit a parse tree produced by the {@code read}
	 * labeled alternative in {@link GrammarParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRead(GrammarParser.ReadContext ctx);
	/**
	 * Visit a parse tree produced by the {@code printString}
	 * labeled alternative in {@link GrammarParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrintString(GrammarParser.PrintStringContext ctx);
	/**
	 * Visit a parse tree produced by the {@code statId}
	 * labeled alternative in {@link GrammarParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatId(GrammarParser.StatIdContext ctx);
	/**
	 * Visit a parse tree produced by the {@code assign}
	 * labeled alternative in {@link GrammarParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssign(GrammarParser.AssignContext ctx);
	/**
	 * Visit a parse tree produced by the {@code newString}
	 * labeled alternative in {@link GrammarParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNewString(GrammarParser.NewStringContext ctx);
	/**
	 * Visit a parse tree produced by the {@code newArray}
	 * labeled alternative in {@link GrammarParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNewArray(GrammarParser.NewArrayContext ctx);
	/**
	 * Visit a parse tree produced by the {@code numb}
	 * labeled alternative in {@link GrammarParser#val}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumb(GrammarParser.NumbContext ctx);
	/**
	 * Visit a parse tree produced by the {@code arrElem}
	 * labeled alternative in {@link GrammarParser#val}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrElem(GrammarParser.ArrElemContext ctx);
	/**
	 * Visit a parse tree produced by the {@code toInt}
	 * labeled alternative in {@link GrammarParser#val}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitToInt(GrammarParser.ToIntContext ctx);
	/**
	 * Visit a parse tree produced by the {@code toFloat}
	 * labeled alternative in {@link GrammarParser#val}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitToFloat(GrammarParser.ToFloatContext ctx);
	/**
	 * Visit a parse tree produced by the {@code valId}
	 * labeled alternative in {@link GrammarParser#val}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValId(GrammarParser.ValIdContext ctx);
	/**
	 * Visit a parse tree produced by the {@code plus}
	 * labeled alternative in {@link GrammarParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPlus(GrammarParser.PlusContext ctx);
	/**
	 * Visit a parse tree produced by the {@code minus}
	 * labeled alternative in {@link GrammarParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMinus(GrammarParser.MinusContext ctx);
	/**
	 * Visit a parse tree produced by the {@code mul}
	 * labeled alternative in {@link GrammarParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMul(GrammarParser.MulContext ctx);
	/**
	 * Visit a parse tree produced by the {@code div}
	 * labeled alternative in {@link GrammarParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDiv(GrammarParser.DivContext ctx);
	/**
	 * Visit a parse tree produced by the {@code int}
	 * labeled alternative in {@link GrammarParser#number}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInt(GrammarParser.IntContext ctx);
	/**
	 * Visit a parse tree produced by the {@code float}
	 * labeled alternative in {@link GrammarParser#number}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFloat(GrammarParser.FloatContext ctx);
	/**
	 * Visit a parse tree produced by the {@code newVar}
	 * labeled alternative in {@link GrammarParser#id}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNewVar(GrammarParser.NewVarContext ctx);
	/**
	 * Visit a parse tree produced by the {@code var}
	 * labeled alternative in {@link GrammarParser#id}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVar(GrammarParser.VarContext ctx);
	/**
	 * Visit a parse tree produced by {@link GrammarParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitType(GrammarParser.TypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link GrammarParser#arrayType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayType(GrammarParser.ArrayTypeContext ctx);
}