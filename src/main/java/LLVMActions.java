import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;

class Value {
    public String name;
    public String type;

    public Value(String name, String type) {
        this.name = name;
        this.type = type;
    }
}

class Array {
    public String type;
    public ArrayList<String> values; // zmienna String ma jednoelementową listę

    public Array(String type, ArrayList<String> values) {
        this.type = type;
        this.values = values;
    }
}

public class LLVMActions extends GrammarBaseListener {
    HashMap<String, String> variables = new HashMap<String, String>(); // wszystkie zmienne: ID -> typ zmiennej
    HashMap<String, Array> consts = new HashMap<String, Array>(); // wszystkie stałe: ID -> array
    Stack<Value> stack = new Stack<Value>();
    int undeclaredStrings = 0;

    public String generate() {
        return LLVMGenerator.generate(consts);
    }

    public void error(int line, String msg) {
        System.err.println("Error, line " + line + ", " + msg);
        System.exit(1);
    }

    @Override
    public void exitIf(GrammarParser.IfContext ctx) {
    }

    @Override
    public void enterBlockif(GrammarParser.BlockifContext ctx) {
        LLVMGenerator.ifstart();
    }

    @Override
    public void exitBlockif(GrammarParser.BlockifContext ctx) {
        LLVMGenerator.ifend();
    }

    @Override
    public void exitEqual(GrammarParser.EqualContext ctx) {
        String ID = ctx.ID().getText();
        String INT = ctx.INT().getText();
        if( variables.containsKey(ID) ) {
            LLVMGenerator.icmp( ID, INT );
        } else {
            ctx.getStart().getLine();
            System.err.println("Line "+ ctx.getStart().getLine()+", unknown variable: "+ID);
        }
    }

    @Override
    public void exitBlock(GrammarParser.BlockContext ctx) {
        if( ctx.getParent() instanceof GrammarParser.RepeatContext ){
            LLVMGenerator.repeatEnd();
        }
    }

    @Override
    public void exitRepetitions(GrammarParser.RepetitionsContext ctx) {
        String value = "";
        if(ctx.ID() != null) {
            String ID = ctx.ID().getText();
            if(variables.containsKey(ID)) {
                if(variables.get(ID).equals("int")) {
                    LLVMGenerator.load_i32(ID);
                    value = "%" + (LLVMGenerator.reg - 1);
                } else {
                    error(ctx.getStart().getLine(), "Mismatch type in loop");
                }
            } else {
                error(ctx.getStart().getLine(), "Unknown variable "+ID);
            }
        } else if (ctx.INT() != null) {
            value = ctx.INT().getText();
        }
        LLVMGenerator.repeatStart(value);
    }

    @Override
    public void exitRead(GrammarParser.ReadContext ctx) {
        String ID = ctx.ID().getText();
        if (variables.containsKey(ID)) {
            String type = variables.get(ID);
            if (type.equals("int")) {
                LLVMGenerator.scanf_i32(ID);
            } else if (type.equals("float")) {
                LLVMGenerator.scanf_double(ID);
            }
        } else {
            error(ctx.getStart().getLine(), "Assign type mismatch");
        }
    }

    @Override
    public void exitPrint(GrammarParser.PrintContext ctx) {
        String ID = ctx.ID().getText(); // pobierz nazwę zmiennej
        String type = variables.get(ID);
        if (type != null) {
            if (type.equals("int")) { // wypisz int
                LLVMGenerator.printf_i32(ID);
            } else if (type.equals("float")) { // wypisz float
                LLVMGenerator.printf_double(ID);
            } else if (type.equals("string")) { // wypisz string
                LLVMGenerator.printf_string(ID, consts.get(ID).values.get(0).length());
            }
        } else { // nie ma takiej zmiennej
            error(ctx.getStart().getLine(), "Unknown variable " + ID);
        }
    }

    @Override
    public void exitPrintString(GrammarParser.PrintStringContext ctx) {
        String string = ctx.STRING().getText(); // pobierz tekst do wypisania
        string = string.substring(1, string.length()-1);
        ArrayList values = new ArrayList();
        values.add(string);
        undeclaredStrings++;
        String ID = "un" + undeclaredStrings;
        consts.put(ID, new Array("string", values));
        LLVMGenerator.printf_unknown_string(ID, string.length());
    }

    @Override
    public void exitAssign(GrammarParser.AssignContext ctx) {
        String ID = ctx.id().children.get(ctx.id().children.size() - 1).toString(); // pobierz nazwę zmiennej
        Value value = stack.pop(); // pobierz wartość ze stosu
        if (variables.get(ID).equals(value.type)) {
            variables.put(ID, value.type); // dodaj zmienną i wartość do listy
            if (value.type.equals("int")) {
                LLVMGenerator.assign_i32(ID, value.name);
            } else if (value.type.equals("float")) {
                LLVMGenerator.assign_double(ID, value.name);
            }
        } else {
            error(ctx.getStart().getLine(), "Assign type mismatch");
        }
    }

    @Override
    public void exitToInt(GrammarParser.ToIntContext ctx) {
        Value value = stack.pop(); // pobierz wartość ze stosu
        LLVMGenerator.fptosi(value.name); // zrzutuj na float
        stack.push(new Value("%" + (LLVMGenerator.reg - 1), "int")); // połóż nową wartość na stos
    }

    @Override
    public void exitToFloat(GrammarParser.ToFloatContext ctx) {
        Value value = stack.pop(); // pobierz wartość ze stosu
        LLVMGenerator.sitofp(value.name); // zrzutuj na int
        stack.push(new Value("%" + (LLVMGenerator.reg - 1), "float")); // połóż nową wartość na stos
    }

    @Override
    public void exitValId(GrammarParser.ValIdContext ctx) {
        String ID = ctx.ID().getText(); // pobierz nazwę zmiennej
        String type = variables.get(ID); // pobierz typ zmiennej
        if (type != null) {
            if (type.equals("int")) {
                LLVMGenerator.load_i32(ID);
                stack.push(new Value("%" + (LLVMGenerator.reg - 1), "int"));
            } else if (type.equals("float")) {
                LLVMGenerator.load_double(ID);
                stack.push(new Value("%" + (LLVMGenerator.reg - 1), "float"));
            }
        } else {
            error(ctx.getStart().getLine(), "Unknown variable " + ID);
        }
    }

    @Override
    public void exitPlus(GrammarParser.PlusContext ctx) {
        Value v1 = stack.pop(); // zdejmij pierwszą wartość ze stosu
        Value v2 = stack.pop(); // zdejmij drugą wartość ze stosu
        if (v1.type == v2.type) { // jeśli zgadzają się typy
            if (v1.type.equals("int")) { // dla int
                LLVMGenerator.add_i32(v1.name, v2.name);
                stack.push(new Value("%" + (LLVMGenerator.reg - 1), "int"));
            }
            if (v1.type.equals("float")) { // dla float
                LLVMGenerator.add_double(v1.name, v2.name);
                stack.push(new Value("%" + (LLVMGenerator.reg - 1), "float"));
            }
        } else {
            error(ctx.getStart().getLine(), "Add type mismatch");
        }
    }

    @Override
    public void exitMinus(GrammarParser.MinusContext ctx) {
        Value v1 = stack.pop(); // zdejmij pierwszą wartość ze stosu
        Value v2 = stack.pop(); // zdejmij drugą wartość ze stosu
        if (v1.type == v2.type) { // jeśli zgadzają się typy
            if (v1.type.equals("int")) { // dla int
                LLVMGenerator.sub_i32(v1.name, v2.name);
                stack.push(new Value("%" + (LLVMGenerator.reg - 1), "int"));
            }
            if (v1.type.equals("float")) { // dla float
                LLVMGenerator.sub_double(v1.name, v2.name);
                stack.push(new Value("%" + (LLVMGenerator.reg - 1), "float"));
            }
        } else {
            error(ctx.getStart().getLine(), "Sub type mismatch");
        }
    }

    @Override
    public void exitMul(GrammarParser.MulContext ctx) {
        Value v1 = stack.pop(); // zdejmij pierwszą wartość ze stosu
        Value v2 = stack.pop(); // zdejmij drugą wartość ze stosu
        if (v1.type == v2.type) { // jeśli zgadzają się typy
            if (v1.type.equals("int")) { // dla int
                LLVMGenerator.mul_i32(v1.name, v2.name);
                stack.push(new Value("%" + (LLVMGenerator.reg - 1), "int"));
            }
            if (v1.type.equals("float")) { // dla float
                LLVMGenerator.mul_double(v1.name, v2.name);
                stack.push(new Value("%" + (LLVMGenerator.reg - 1), "float"));
            }
        } else {
            error(ctx.getStart().getLine(), "Mul type mismatch");
        }
    }

    @Override
    public void exitDiv(GrammarParser.DivContext ctx) {
        Value v1 = stack.pop(); // zdejmij pierwszą wartość ze stosu
        Value v2 = stack.pop(); // zdejmij drugą wartość ze stosu
        if (v1.type == v2.type) { // jeśli zgadzają się typy
            if (v1.type.equals("int")) { // dla int
                LLVMGenerator.div_i32(v1.name, v2.name);
                stack.push(new Value("%" + (LLVMGenerator.reg - 1), "int"));
            }
            if (v1.type.equals("float")) { // dla float
                LLVMGenerator.div_double(v1.name, v2.name);
                stack.push(new Value("%" + (LLVMGenerator.reg - 1), "float"));
            }
        } else {
            error(ctx.getStart().getLine(), "Div type mismatch");
        }
    }

    @Override
    public void exitInt(GrammarParser.IntContext ctx) {
        stack.push(new Value(ctx.INT().getText(), "int")); // połóż na stosie int
    }

    @Override
    public void exitFloat(GrammarParser.FloatContext ctx) {
        stack.push(new Value(ctx.FLOAT().getText(), "float")); // połóż na stosie float
    }

    @Override
    public void exitNewVar(GrammarParser.NewVarContext ctx) {
        String ID = ctx.ID().getText(); // pobierz nazwę zmiennej
        String type = ctx.type().getText(); // pobierz typ zmiennej
        if (!variables.containsKey(ID)) { // jeśli nie ma takiej zmiennej
            variables.put(ID, type); // dodaj ją do listy
            if (type.equals("int")) {
                LLVMGenerator.declare_i32(ID); // zadeklaruj int
            } else if (type.equals("float")) {
                LLVMGenerator.declare_double(ID); // zadeklaruj float
            }
        } else { // taka zmienna już istnieje
            error(ctx.getStart().getLine(), "Variable " + ID + " already declared");
        }
    }

    @Override
    public void exitVar(GrammarParser.VarContext ctx) {
        String ID = ctx.ID().getText(); // pobierz nazwę zmiennej
        if (!variables.containsKey(ID)) {
            error(ctx.getStart().getLine(), "Unknown variable " + ID);
        }
    }

    @Override
    public void exitNewArray(GrammarParser.NewArrayContext ctx) {
        String ID = ctx.ID().getText(); // nazwa zmiennej
        ArrayList<String> values = new ArrayList<>();
        String type = ctx.arrayType().getText();
        for (GrammarParser.NumberContext n: ctx.number()) {
            String number = n.getText();
            if ((number.contains(".") && type.equals("int[]")) || (!number.contains(".") && type.equals("float[]"))) {
                error(ctx.getStart().getLine(), "Array element type mismatch");
            }
            values.add(number);
        }
        if(!consts.containsKey(ID) && !variables.containsKey(ID)) {
            consts.put(ID, new Array(type, values));
            variables.put(ID, type);
            if(type.equals("int[]")) {
                LLVMGenerator.declare_i32_array(ID, values.size());
            } else if (type.equals("float[]")) {
                LLVMGenerator.declare_double_array(ID, values.size());
            }
        } else {
            error(ctx.getStart().getLine(), "Variable " + ID + " already declared");
        }
    }

    @Override
    public void exitArrElem(GrammarParser.ArrElemContext ctx) {
        String ID = ctx.ID().getText(); // nazwa array
        if(consts.containsKey(ID)) { // istnieje taki array
            String type = consts.get(ID).type;
            int size = consts.get(ID).values.size();
            int i = Integer.parseInt(ctx.INT().getText()); // indeks
            if(i < 0 || i >= size) {
                error(ctx.getStart().getLine(), "Index out of bounds");
            }
            if(type.equals("int[]")) {
                LLVMGenerator.getelementptr_i32(ID, size, i);
                Integer pom = LLVMGenerator.reg - 1;
                LLVMGenerator.load_i32(pom.toString());
                stack.push(new Value("%" + (LLVMGenerator.reg - 1), "int"));
            } else if (type.equals("float[]")) {
                LLVMGenerator.getelementptr_double(ID, size, i);
                Integer pom = LLVMGenerator.reg - 1;
                LLVMGenerator.load_double(pom.toString());
                stack.push(new Value("%" + (LLVMGenerator.reg - 1), "float"));
            }
        } else {
            error(ctx.getStart().getLine(), "Unknown array " + ID);
        }
    }

    @Override
    public void exitNewString(GrammarParser.NewStringContext ctx) {
        String ID = ctx.ID().getText();
        String value = ctx.STRING().getText();
        value = value.substring(1, value.length()-1);
        ArrayList values = new ArrayList();
        values.add(value); // String ma jednoelementową listę values
        if(!consts.containsKey(ID) && !variables.containsKey(ID)) {
            consts.put(ID, new Array("string", values));
            variables.put(ID, "string");
            LLVMGenerator.declare_string(ID, value.length());
        } else {
            error(ctx.getStart().getLine(), "Variable " + ID + " already declared");
        }
    }
}
