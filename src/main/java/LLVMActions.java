import java.util.*;

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

class Struct {
    public String name; // nazwa struktury
    public HashMap<String, String> data; // nazwa pola i typ; x -> int, y -> int etc
    public List kolejnosc;

    public Struct(String name, HashMap data, List k) {
        this.name = name;
        this.data = data;
        this.kolejnosc = k;
    }
}

public class LLVMActions extends GrammarBaseListener {
    HashMap<String, String> variables = new HashMap<String, String>(); // wszystkie zmienne: ID -> typ zmiennej
    HashMap<String, String> localVariables = new HashMap<String, String>(); // wszystkie zmienne: ID -> typ zmiennej
    // variables zawiera consts
    HashMap<String, Array> consts = new HashMap<String, Array>(); // wszystkie stałe: ID -> array

    HashMap<String, Struct> defStruct = new HashMap<>(); // wszystkie zdefiniowane do tej pory struktury
    HashMap<String, String> structures = new HashMap<>(); // nazwa zmiennej -> typ struktury

    Stack<Value> stack = new Stack<Value>();
    int undeclaredStrings = 0;

    // TODO: naprawić zmienne lokalne/globalne -> newVar, assign
    // generalnie napisać swoją wersję funkcji setVariable, która zwraca @ lub % i usunąć te znaki z LLVMGen
    HashSet<String> globalnames = new HashSet<String>();
    HashSet<String> functions = new HashSet<String>();
    HashSet<String> localnames = new HashSet<String>();
    String value, function;
    Boolean global;

    // METODY POMOCNICZE

    public String generate() {
        return LLVMGenerator.generate(consts);
    }

    public void error(int line, String msg) {
        System.err.println("Error, line " + line + ", " + msg);
        System.exit(1);
    }

    public String cutDot(String ID) {
        return ID.replace(".", "");
    }

    // STRUKTURY
    @Override
    public void exitDefStruct(GrammarParser.DefStructContext ctx) {
        String name = ctx.ID(0).getText();
        if(!variables.containsKey(name)) {
            HashMap<String, String> data = new HashMap<>();
            for (int i = 1; i < ctx.ID().size(); i++) {
                String type = ctx.type(i-1).getText();
                String ID = ctx.ID(i).getText();
                if(!data.containsKey(ID)) {
                    data.put(ID, type);
                } else {
                    error(ctx.getStart().getLine(), "Name " + ID + " already declared");
                }
            }
            List k = ctx.ID().subList(1,ctx.ID().size());
            Struct newStruct = new Struct(name, data, k);
            defStruct.put(name, newStruct);
            variables.put(name, "struct");
        } else {
            error(ctx.getStart().getLine(), "Name " + name + " already declared");
        }

    }

    @Override
    public void exitNewStruct(GrammarParser.NewStructContext ctx) {
        // Point p = Point(1 2)
        String type = ctx.ID(0).getText(); // Point
        String ID = ctx.ID(1).getText(); // p
        String struct = ctx.ID(2).getText(); // Point
        int args = ctx.val().size();

        if(!type.equals(struct)) {
            error(ctx.getStart().getLine(), "Mismatch structure type");
        }

        if(defStruct.containsKey(type)) { // jest taka struktura
            Struct s = defStruct.get(type);
            if(args != s.data.size()) {
                error(ctx.getStart().getLine(), "Expected " + s.data.size() + " arguments");
            }
            if(variables.containsKey(ID)) {
                error(ctx.getStart().getLine(), "Name " + ID + " already declared");
            }
            variables.put(ID, "struct");
            structures.put(ID, type);
            for (int i = 0; i < args; i++) {
                String var = s.kolejnosc.get(i).toString();
                String val = ctx.val(i).getText();
                String t = s.data.get(var);
                String name = "@" + ID + var;
                if (!variables.containsKey(name)) {
                    variables.put(name, t); // dodaj ją do listy
                    if (t.equals("int")) {
                        LLVMGenerator.declare_global_i32(name); // zadeklaruj int
                        LLVMGenerator.assign_i32(name, val);
                    } else if (t.equals("float")) {
                        LLVMGenerator.declare_global_double(name); // zadeklaruj float
                        LLVMGenerator.assign_double(name, val);
                    }
                } else { // taka zmienna już istnieje
                    error(ctx.getStart().getLine(), "Variable " + name + " already declared");
                }
            }
        } else {
            error(ctx.getStart().getLine(), "Unknown structure  " + type);
        }
    }

    // METODY OGÓLNE

    @Override
    public void enterProgram(GrammarParser.ProgramContext ctx) {
        global = true;
    }

    @Override
    public void exitProgram(GrammarParser.ProgramContext ctc) {
        LLVMGenerator.close_main();
    }

    // FUNCTION

    @Override
    public void exitName(GrammarParser.NameContext ctx) {
        String ID = ctx.ID().getText(); // weź nazwę
        // ID = global ? "@" + ID : "%" + ID;
        if (!variables.containsKey(ID)) { // jeśli nie ma takiej zmiennej
            variables.put(ID, "function"); // dodaj ją do listy
            functions.add(ID); // dodaj do nazw funkcji
            function = ID; // bieżąca funkcja
            LLVMGenerator.functionstart(ID);
        } else { // taka zmienna już istnieje
            error(ctx.getStart().getLine(), "Name " + ID + " already declared");
        }
    }

    @Override
    public void enterFblock(GrammarParser.FblockContext ctx) {
        global = false; // jesteśmy w funkcji, nie globalnie
    }

    @Override
    public void exitFblock(GrammarParser.FblockContext ctx) {
        String ID = "%" + function;
        if(!localVariables.containsKey(function) ){ // jeśli nie ma takiej zmiennej lokalnej
            localVariables.put(function, "function");
            LLVMGenerator.declare_i32(ID);
            LLVMGenerator.assign_i32(ID, "0"); // to ją zapisz
        }
        LLVMGenerator.load_i32( ID ); // załaduj
        LLVMGenerator.functionend(); // zakończ funkcję pod spodem
        localVariables = new HashMap<String, String>();
        // localnames = new HashSet<String>(); // wyczyść lokalne zmienne
        global = true; // wróć do globala
    }

    @Override
    public void exitCall(GrammarParser.CallContext ctx) {
        String ID = ctx.ID().getText();
        if(functions.contains(ID)) {
            LLVMGenerator.call(ID);
        } else {
            error(ctx.getStart().getLine(), ID + " is not a fuction");
        }
    }

    // IF

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
        ID = global ? "@" + ID : "%" + ID;
        String INT = ctx.INT().getText();
        if( variables.containsKey(ID) ) {
            LLVMGenerator.icmp( ID, INT );
        } else {
            ctx.getStart().getLine();
            System.err.println("Line "+ ctx.getStart().getLine()+", unknown variable: "+ID);
        }
    }

    // LOOP

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

    // IN/OUT

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
        // tak, wiem, kod tej metody to dramat :/ ale działa (chyba lmao)
        String ID = ctx.ID().getText(); // pobierz nazwę zmiennej
        String newID = "@"+ID;
        String type = variables.get(newID);
        if(type == null && !global) { // nie ma takiej zmiennej globalnej
            newID = "%"+ID;
            type = localVariables.get(newID); // pobierz zmienną lokalną
        }
        ID = newID;
        if (type == null) { // złap string, który nie ma w ID ani @ ani %
            ID = ctx.ID().getText();
            type = variables.get(ID);
        }
        if (type != null) {
            if (type.equals("int")) { // wypisz int
                LLVMGenerator.printf_i32(ID);
            } else if (type.equals("float")) { // wypisz float
                LLVMGenerator.printf_double(ID);
            } else if (type.equals("string")) { // wypisz string
                LLVMGenerator.printf_string(ID, consts.get(ID).values.get(0).length());
            } else if (type.equals("struct")) { // wypisz strukturę
                Struct s = defStruct.get(structures.get(ID));
                for (int i = 0; i < s.kolejnosc.size(); i++) {
                    String s_ID = s.kolejnosc.get(i).toString();
                    String s_type = s.data.get(s_ID);
                    String name = "@" + ID + s_ID;
                    if(s_type.equals("int")) {
                        LLVMGenerator.printf_i32(name);
                    } else if (s_type.equals("float")) {
                        LLVMGenerator.printf_double(name);
                    }
                }
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

    // DZIAŁANIA ARYTMETYCZNE

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
        ID = cutDot(ID);
        String newID = "@"+ID;
        String type = variables.get(newID);
        if(type == null && !global) { // nie ma takiej zmiennej globalnej
            newID = "%"+ID;
            type = localVariables.get(newID); // pobierz zmienną lokalną
        }
        ID = newID;
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

    // ZMIENNE

    @Override
    public void exitNewVar(GrammarParser.NewVarContext ctx) {
        String ID = ctx.ID().getText(); // pobierz nazwę zmiennej
        ID = global ? "@" + ID : "%" + ID;
        String type = ctx.type().getText(); // pobierz typ zmiennej

        if(global) { // jesteśmy globalnie
            if (!variables.containsKey(ID)) { // jeśli nie ma takiej zmiennej globalnie
                variables.put(ID, type); // dodaj ją do listy
                if (type.equals("int")) {
                    LLVMGenerator.declare_global_i32(ID); // zadeklaruj int
                } else if (type.equals("float")) {
                    LLVMGenerator.declare_global_double(ID); // zadeklaruj float
                }
            } else { // taka zmienna już istnieje
                error(ctx.getStart().getLine(), "Variable " + ID + " already declared");
            }
        } else {
            if (!variables.containsKey(ID) && !localVariables.containsKey(ID)) { // nazwa nie jest zajęta globalnie i lokalnie
                localVariables.put(ID, type);
                if (type.equals("int")) {
                    LLVMGenerator.declare_i32(ID); // zadeklaruj int
                } else if (type.equals("float")) {
                    LLVMGenerator.declare_double(ID); // zadeklaruj float
                }
            } else { // nazwa zajęta
                error(ctx.getStart().getLine(), "Variable " + ID + " already declared");
            }
        }


    }

    @Override
    public void exitVar(GrammarParser.VarContext ctx) {
        String ID = ctx.ID().getText(); // pobierz nazwę zmiennej
        ID = global ? "@" + ID : "%" + ID;
        ID = cutDot(ID);
        if (!variables.containsKey(ID)) { // nie ma takiej zmiennej globalnej
            if (!global && !localVariables.containsKey(ID)) { // nie ma takiej zmiennej lokalnej
                error(ctx.getStart().getLine(), "Unknown variable " + ID);
            }
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

    @Override
    public void exitAssign(GrammarParser.AssignContext ctx) {
        String ID = ctx.id().children.get(ctx.id().children.size() - 1).toString(); // pobierz nazwę zmiennej
        ID = global ? "@" + ID : "%" + ID;
        ID = cutDot(ID);
        Value value = stack.pop(); // pobierz wartość ze stosu
        // to czy zmienna istnieje jest sprawdzane w exitVar
        if(variables.containsKey(ID)) {
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
        } else if (!global) { // zmienna nie jest globalna, a my jesteśmy w funkcji
            if (localVariables.get(ID).equals(value.type)) {
                localVariables.put(ID, value.type); // dodaj zmienną i wartość do listy
                if (value.type.equals("int")) {
                    LLVMGenerator.assign_i32(ID, value.name);
                } else if (value.type.equals("float")) {
                    LLVMGenerator.assign_double(ID, value.name);
                }
            } else {
                error(ctx.getStart().getLine(), "Assign type mismatch");
            }
        } else { // tutaj chyba nigdy nie wejdziemy, bo localVariables są zawsze dla konkretnej funkcji?
            error(ctx.getStart().getLine(), "Unknown variable " + ID);
        }
    }
}
