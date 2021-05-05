import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

public class Main {
    public static String getCode(String filename) {

        File file = new File(filename);
        String code = "";
        try {
            List<String> content = Files.readAllLines(file.toPath());
            for(String line : content) {
                code = code.concat(line).concat("\n");
            }
        } catch (IOException e) {
            // handle exception in i/o
        }
        return code;
    }

    public static void saveCode(String code) throws Exception {
        FileWriter writer = new FileWriter("code.ll");
        writer.write(code);
        writer.close();
    }

    // TODO: obsługa string
    // TODO: obsługa array
    // TODO: działania na zmiennych
    public static void main(String[] args) throws Exception {
        String filename = args.length > 0 ? args[0] : "code.mo";
        String code = getCode(filename);

        GrammarLexer lexer = new GrammarLexer(CharStreams.fromString(code));

        CommonTokenStream tokens = new CommonTokenStream(lexer);
        GrammarParser parser = new GrammarParser(tokens);

        ParseTree tree = parser.program();

        //System.out.println(tree.toStringTree(parser));

        ParseTreeWalker walker = new ParseTreeWalker();
        LLVMActions listener = new LLVMActions();
        walker.walk(listener, tree);
        String LLVM = listener.generate();
        saveCode(LLVM);
    }
}
