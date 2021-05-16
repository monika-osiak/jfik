// Generated from /Users/monika/MGR-SEM1/JFiK/project-repo/Grammar.g4 by ANTLR 4.9.1
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link GrammarParser}.
 */
public interface GrammarListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link GrammarParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(GrammarParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(GrammarParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#block}.
	 * @param ctx the parse tree
	 */
	void enterBlock(GrammarParser.BlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#block}.
	 * @param ctx the parse tree
	 */
	void exitBlock(GrammarParser.BlockContext ctx);
	/**
	 * Enter a parse tree produced by the {@code print}
	 * labeled alternative in {@link GrammarParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterPrint(GrammarParser.PrintContext ctx);
	/**
	 * Exit a parse tree produced by the {@code print}
	 * labeled alternative in {@link GrammarParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitPrint(GrammarParser.PrintContext ctx);
	/**
	 * Enter a parse tree produced by the {@code read}
	 * labeled alternative in {@link GrammarParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterRead(GrammarParser.ReadContext ctx);
	/**
	 * Exit a parse tree produced by the {@code read}
	 * labeled alternative in {@link GrammarParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitRead(GrammarParser.ReadContext ctx);
	/**
	 * Enter a parse tree produced by the {@code printString}
	 * labeled alternative in {@link GrammarParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterPrintString(GrammarParser.PrintStringContext ctx);
	/**
	 * Exit a parse tree produced by the {@code printString}
	 * labeled alternative in {@link GrammarParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitPrintString(GrammarParser.PrintStringContext ctx);
	/**
	 * Enter a parse tree produced by the {@code repeat}
	 * labeled alternative in {@link GrammarParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterRepeat(GrammarParser.RepeatContext ctx);
	/**
	 * Exit a parse tree produced by the {@code repeat}
	 * labeled alternative in {@link GrammarParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitRepeat(GrammarParser.RepeatContext ctx);
	/**
	 * Enter a parse tree produced by the {@code statId}
	 * labeled alternative in {@link GrammarParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterStatId(GrammarParser.StatIdContext ctx);
	/**
	 * Exit a parse tree produced by the {@code statId}
	 * labeled alternative in {@link GrammarParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitStatId(GrammarParser.StatIdContext ctx);
	/**
	 * Enter a parse tree produced by the {@code assign}
	 * labeled alternative in {@link GrammarParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterAssign(GrammarParser.AssignContext ctx);
	/**
	 * Exit a parse tree produced by the {@code assign}
	 * labeled alternative in {@link GrammarParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitAssign(GrammarParser.AssignContext ctx);
	/**
	 * Enter a parse tree produced by the {@code newString}
	 * labeled alternative in {@link GrammarParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterNewString(GrammarParser.NewStringContext ctx);
	/**
	 * Exit a parse tree produced by the {@code newString}
	 * labeled alternative in {@link GrammarParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitNewString(GrammarParser.NewStringContext ctx);
	/**
	 * Enter a parse tree produced by the {@code newArray}
	 * labeled alternative in {@link GrammarParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterNewArray(GrammarParser.NewArrayContext ctx);
	/**
	 * Exit a parse tree produced by the {@code newArray}
	 * labeled alternative in {@link GrammarParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitNewArray(GrammarParser.NewArrayContext ctx);
	/**
	 * Enter a parse tree produced by the {@code numb}
	 * labeled alternative in {@link GrammarParser#val}.
	 * @param ctx the parse tree
	 */
	void enterNumb(GrammarParser.NumbContext ctx);
	/**
	 * Exit a parse tree produced by the {@code numb}
	 * labeled alternative in {@link GrammarParser#val}.
	 * @param ctx the parse tree
	 */
	void exitNumb(GrammarParser.NumbContext ctx);
	/**
	 * Enter a parse tree produced by the {@code arrElem}
	 * labeled alternative in {@link GrammarParser#val}.
	 * @param ctx the parse tree
	 */
	void enterArrElem(GrammarParser.ArrElemContext ctx);
	/**
	 * Exit a parse tree produced by the {@code arrElem}
	 * labeled alternative in {@link GrammarParser#val}.
	 * @param ctx the parse tree
	 */
	void exitArrElem(GrammarParser.ArrElemContext ctx);
	/**
	 * Enter a parse tree produced by the {@code toInt}
	 * labeled alternative in {@link GrammarParser#val}.
	 * @param ctx the parse tree
	 */
	void enterToInt(GrammarParser.ToIntContext ctx);
	/**
	 * Exit a parse tree produced by the {@code toInt}
	 * labeled alternative in {@link GrammarParser#val}.
	 * @param ctx the parse tree
	 */
	void exitToInt(GrammarParser.ToIntContext ctx);
	/**
	 * Enter a parse tree produced by the {@code toFloat}
	 * labeled alternative in {@link GrammarParser#val}.
	 * @param ctx the parse tree
	 */
	void enterToFloat(GrammarParser.ToFloatContext ctx);
	/**
	 * Exit a parse tree produced by the {@code toFloat}
	 * labeled alternative in {@link GrammarParser#val}.
	 * @param ctx the parse tree
	 */
	void exitToFloat(GrammarParser.ToFloatContext ctx);
	/**
	 * Enter a parse tree produced by the {@code valId}
	 * labeled alternative in {@link GrammarParser#val}.
	 * @param ctx the parse tree
	 */
	void enterValId(GrammarParser.ValIdContext ctx);
	/**
	 * Exit a parse tree produced by the {@code valId}
	 * labeled alternative in {@link GrammarParser#val}.
	 * @param ctx the parse tree
	 */
	void exitValId(GrammarParser.ValIdContext ctx);
	/**
	 * Enter a parse tree produced by the {@code plus}
	 * labeled alternative in {@link GrammarParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterPlus(GrammarParser.PlusContext ctx);
	/**
	 * Exit a parse tree produced by the {@code plus}
	 * labeled alternative in {@link GrammarParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitPlus(GrammarParser.PlusContext ctx);
	/**
	 * Enter a parse tree produced by the {@code minus}
	 * labeled alternative in {@link GrammarParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterMinus(GrammarParser.MinusContext ctx);
	/**
	 * Exit a parse tree produced by the {@code minus}
	 * labeled alternative in {@link GrammarParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitMinus(GrammarParser.MinusContext ctx);
	/**
	 * Enter a parse tree produced by the {@code mul}
	 * labeled alternative in {@link GrammarParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterMul(GrammarParser.MulContext ctx);
	/**
	 * Exit a parse tree produced by the {@code mul}
	 * labeled alternative in {@link GrammarParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitMul(GrammarParser.MulContext ctx);
	/**
	 * Enter a parse tree produced by the {@code div}
	 * labeled alternative in {@link GrammarParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterDiv(GrammarParser.DivContext ctx);
	/**
	 * Exit a parse tree produced by the {@code div}
	 * labeled alternative in {@link GrammarParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitDiv(GrammarParser.DivContext ctx);
	/**
	 * Enter a parse tree produced by the {@code int}
	 * labeled alternative in {@link GrammarParser#number}.
	 * @param ctx the parse tree
	 */
	void enterInt(GrammarParser.IntContext ctx);
	/**
	 * Exit a parse tree produced by the {@code int}
	 * labeled alternative in {@link GrammarParser#number}.
	 * @param ctx the parse tree
	 */
	void exitInt(GrammarParser.IntContext ctx);
	/**
	 * Enter a parse tree produced by the {@code float}
	 * labeled alternative in {@link GrammarParser#number}.
	 * @param ctx the parse tree
	 */
	void enterFloat(GrammarParser.FloatContext ctx);
	/**
	 * Exit a parse tree produced by the {@code float}
	 * labeled alternative in {@link GrammarParser#number}.
	 * @param ctx the parse tree
	 */
	void exitFloat(GrammarParser.FloatContext ctx);
	/**
	 * Enter a parse tree produced by the {@code newVar}
	 * labeled alternative in {@link GrammarParser#id}.
	 * @param ctx the parse tree
	 */
	void enterNewVar(GrammarParser.NewVarContext ctx);
	/**
	 * Exit a parse tree produced by the {@code newVar}
	 * labeled alternative in {@link GrammarParser#id}.
	 * @param ctx the parse tree
	 */
	void exitNewVar(GrammarParser.NewVarContext ctx);
	/**
	 * Enter a parse tree produced by the {@code var}
	 * labeled alternative in {@link GrammarParser#id}.
	 * @param ctx the parse tree
	 */
	void enterVar(GrammarParser.VarContext ctx);
	/**
	 * Exit a parse tree produced by the {@code var}
	 * labeled alternative in {@link GrammarParser#id}.
	 * @param ctx the parse tree
	 */
	void exitVar(GrammarParser.VarContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#type}.
	 * @param ctx the parse tree
	 */
	void enterType(GrammarParser.TypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#type}.
	 * @param ctx the parse tree
	 */
	void exitType(GrammarParser.TypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#arrayType}.
	 * @param ctx the parse tree
	 */
	void enterArrayType(GrammarParser.ArrayTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#arrayType}.
	 * @param ctx the parse tree
	 */
	void exitArrayType(GrammarParser.ArrayTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#repetitions}.
	 * @param ctx the parse tree
	 */
	void enterRepetitions(GrammarParser.RepetitionsContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#repetitions}.
	 * @param ctx the parse tree
	 */
	void exitRepetitions(GrammarParser.RepetitionsContext ctx);
}