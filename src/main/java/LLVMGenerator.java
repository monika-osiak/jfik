import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class LLVMGenerator {
    static String header_text = "";
    static String main_text = "";
    static int reg = 1;

    static void scanf_i32(String id) { // scanf int
        main_text += "%" + reg + " = call i32 (i8*, ...) @scanf(i8* getelementptr inbounds ([3 x i8], [3 x i8]* @strsi, i64 0, i64 0), i32* %" + id + ")\n";
        // %2 = call i32 (i8*, ...) @scanf(i8* getelementptr inbounds ([3 x i8], [3 x i8]* @.str, i64 0, i64 0), i32* %1)
        reg++;
    }

    static void scanf_double(String id) { // scanf int
        main_text += "%" + reg + " = call i32 (i8*, ...) @scanf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @strsd, i64 0, i64 0), double* %" + id + ")\n";
        // %3 = call i32 (i8*, ...) @scanf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @.str, i64 0, i64 0), double* %1)
        reg++;
    }

    static void printf_i32(String id) {
        main_text += "%" + reg + " = load i32, i32* %" + id + "\n";
        reg++;
        main_text += "%" + reg + " = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @strpi, i32 0, i32 0), i32 %" + (reg - 1) + ")\n";
        reg++;
    }

    static void printf_double(String id) {
        main_text += "%" + reg + " = load double, double* %" + id + "\n";
        reg++;
        // tu było zmieniane na 5 x18 TODO nie działa czasami wypisywanie tablicy double
        main_text += "%" + reg + " = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([5 x i8], [5 x i8]* @strpd, i64 0, i64 0), double %" + (reg - 1) + ")\n";
        reg++;
    }

    static void printf_string(String id, int size) {
        main_text += "%" + reg + " = getelementptr inbounds [" + (size + 1) + " x i8], [" + (size + 1) + " x i8]* %" + id + ", i64 0, i64 0\n";
        reg++;
        // %3 = getelementptr inbounds [9 x i8], [9 x i8]* %1, i64 0, i64 0
        main_text += "%" + reg + " = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @strps, i64 0, i64 0), i8* %" + (reg - 1) + ")\n";
        reg++;
        // %4 = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @.str, i64 0, i64 0), i8* %3)
    }

    static void printf_unknown_string(String id, int size) {
        main_text += "%" + reg + " = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([" + (size + 2) + " x i8], [" + (size + 2) + " x i8]* @" + id + ", i64 0, i64 0))\n";
        reg++;
        // %2 = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([8 x i8], [8 x i8]* @.str.1, i64 0, i64 0))
    }

    static void declare_i32(String id) {
        main_text += "%" + id + " = alloca i32\n";
    }

    static void declare_double(String id) {
        main_text += "%" + id + " = alloca double\n";
    }

    static void declare_i32_array(String id, int size) {
        main_text += "%" + id + " = alloca [" + size + " x i32], align 16\n";
        main_text += "%" + reg + " = bitcast [" + size + " x i32]* %" + id + " to i8*\n";
        reg++;
        main_text += "call void @llvm.memcpy.p0i8.p0i8.i64(i8* align 16 %" + (reg - 1) +
                ", i8* align 16 bitcast ([" + size + " x i32]* @" + id + " to i8*), i64 " + (size * 4) + ", i1 false)\n";
        // %1 = alloca [3 x i32], align 4
        // %3 = bitcast [3 x i32]* %1 to i8*
        // call void @llvm.memcpy.p0i8.p0i8.i64(i8* align 4 %3, i8* align 4 bitcast ([3 x i32]* @__const.main.hello to i8*), i64 12, i1 false)
    }

    static void declare_double_array(String id, int size) {
        main_text += "%" + id + " = alloca [" + size + " x double], align 16\n";
        main_text += "%" + reg + " = bitcast [" + size + " x double]* %" + id + " to i8*\n";
        reg++;
        main_text += "call void @llvm.memcpy.p0i8.p0i8.i64(i8* align 16 %" + (reg - 1) +
                ", i8* align 16 bitcast ([" + size + " x double]* @" + id + " to i8*), i64 " + (size * 8) + ", i1 false)\n";
        // %1 = alloca [3 x float], align 4
        // %3 = bitcast [3 x float]* %1 to i8*
        // call void @llvm.memcpy.p0i8.p0i8.i64(i8* align 4 %3, i8* align 4 bitcast ([3 x float]* @__const.main.hello to i8*), i64 12, i1 false)
    }

    static void declare_string(String id, int size) {
        main_text += "%" + id + " = alloca [" + (size + 1) + " x i8], align 1\n";
        main_text += "%" + reg + " = bitcast [" + (size + 1) + " x i8]* %" + id + " to i8*\n";
        reg++;
        main_text += "call void @llvm.memcpy.p0i8.p0i8.i64(i8* align 1 %" + (reg - 1) +
                ", i8* align 1 getelementptr inbounds ([" + (size + 1) + " x i8], [" + (size + 1) + " x i8]* @" + id + ", i32 0, i32 0), i64 " + (size + 1) + ", i1 false)\n";
        // %1 = alloca [9 x i8], align 1
        // %2 = bitcast [9 x i8]* %1 to i8*
        // call void @llvm.memcpy.p0i8.p0i8.i64(i8* align 1 %2, i8* align 1 getelementptr inbounds ([9 x i8], [9 x i8]* @__const.main.s, i32 0, i32 0), i64 9, i1 false)
    }

    static void assign_i32(String id, String value) {
        main_text += "store i32 " + value + ", i32* %" + id + "\n";
    }

    static void assign_double(String id, String value) {
        main_text += "store double " + value + ", double* %" + id + "\n";
    }

    static void load_i32(String id) {
        main_text += "%" + reg + " = load i32, i32* %" + id + "\n";
        reg++;
    }

    static void load_double(String id) {
        main_text += "%" + reg + " = load double, double* %" + id + "\n";
        reg++;
    }

    static void getelementptr_i32(String id, int size, int index) {
        main_text += "%" + reg + " = getelementptr inbounds [" + size + " x i32], [" + size + " x i32]* %" + id + ", i64 0, i64 " + index + "\n";
        reg++;
    }

    static void getelementptr_double(String id, int size, int index) {
        main_text += "%" + reg + " = getelementptr inbounds [" + size + " x double], [" + size + " x double]* %" + id + ", i64 0, i64 " + index + "\n";
        reg++;
    }

    static void add_i32(String val1, String val2) {
        main_text += "%" + reg + " = add i32 " + val1 + ", " + val2 + "\n";
        reg++;
    }

    static void add_double(String val1, String val2) {
        main_text += "%" + reg + " = fadd double " + val1 + ", " + val2 + "\n";
        reg++;
    }

    static void sub_i32(String val1, String val2) {
        main_text += "%" + reg + " = sub i32 " + val2 + ", " + val1 + "\n"; // kolejność odwrotna!!!
        reg++;
    }

    static void sub_double(String val1, String val2) {
        main_text += "%" + reg + " = fsub double " + val2 + ", " + val1 + "\n"; // kolejność odwrotna!!!
        reg++;
    }

    static void mul_i32(String val1, String val2) {
        main_text += "%" + reg + " = mul i32 " + val1 + ", " + val2 + "\n";
        reg++;
    }

    static void mul_double(String val1, String val2) {
        main_text += "%" + reg + " = fmul double " + val1 + ", " + val2 + "\n";
        reg++;
    }

    static void div_i32(String val1, String val2) {
        main_text += "%" + reg + " = udiv i32 " + val2 + ", " + val1 + "\n"; // kolejność odwrotna!!!
        reg++;
    }

    static void div_double(String val1, String val2) {
        main_text += "%" + reg + " = fdiv double " + val2 + ", " + val1 + "\n"; // kolejność odwrotna!!!
        reg++;
    }

    static void sitofp(String id) {
        main_text += "%" + reg + " = sitofp i32 " + id + " to double\n";
        reg++;
    }

    static void fptosi(String id) {
        main_text += "%" + reg + " = fptosi double " + id + " to i32\n";
        reg++;
    }

    static String getConsts(HashMap<String, Array> consts) {
        String text = "";
        for (Map.Entry<String, Array> entry : consts.entrySet()) {
            String ID = entry.getKey();
            Array array = entry.getValue();
            String type = array.type;
            if (array.type.equals("int[]")) {
                type = "i32";
            } else if (array.type.equals("float[]")) {
                type = "double";
            }

            if (type.equals("i32") || type.equals("double")) { // ARRAY
                // @__const.main.hello = private unnamed_addr constant [3 x i32]
                text += "@" + ID + " = private unnamed_addr constant [" + array.values.size() + " x " + type + "] [";
                // [i32 8, i32 9, i32 0], align 4
                for (String v : array.values) {
                    text += type + " " + v + ", ";
                }
                text = text.substring(0, text.length() - 2);
                text += "], align 16\n";

            } else if (type.equals("string")) { // STRING
                int size = array.values.get(0).length() + 1; // +1 do długości
                // @__const.main.s = private unnamed_addr constant [9 x i8]
                // c"Montreal\00", align 1
                if (ID.contains("un")) {
                    text += "@" + ID + " = private unnamed_addr constant [" + (size + 1) + " x i8] ";
                    text += "c\"" + array.values.get(0) + "\\0A\\00\", align 1\n";
                } else {
                    text += "@" + ID + " = private unnamed_addr constant [" + size + " x i8] ";
                    text += "c\"" + array.values.get(0) + "\\00\", align 1\n";
                }
            }

        }
        return text;
    }

    static String generate(HashMap<String, Array> consts) {
        String text = "";
        text += "declare i32 @printf(i8*, ...)\n";
        text += "declare i32 @__isoc99_scanf(i8*, ...)\n";

        text += "@strpi = constant [4 x i8] c\"%d\\0A\\00\"\n"; // formatowanie print int
        text += "@strpd = constant [5 x i8] c\"%lf\\0A\\00\"\n"; // formatowanie print float
        text += "@strps = private unnamed_addr constant [4 x i8] c\"%s\\0A\\00\"\n"; // formatowanie print string
        // @.str = private unnamed_addr constant [5 x i8] c"%lf\0A\00", align 1

        text += "@strsi = constant [3 x i8] c\"%i\\00\"\n"; // scanf int
        text += "@strsd = constant [4 x i8] c\"%lf\\00\"\n"; // scanf float

        text += getConsts(consts);

        text += header_text;
        text += "define i32 @main() nounwind{\n";
        text += main_text;
        text += "ret i32 0 }\n";
        text += "declare void @llvm.memcpy.p0i8.p0i8.i64(i8* noalias nocapture writeonly, i8* noalias nocapture readonly, i64, i1 immarg) #1\n";
        text += "declare i32 @scanf(i8*, ...) #1\n";
        text += "attributes #1 = { \"correctly-rounded-divide-sqrt-fp-math\"=\"false\" \"disable-tail-calls\"=\"false\" \"frame-pointer\"=\"all\" \"less-precise-fpmad\"=\"false\" \"no-infs-fp-math\"=\"false\" \"no-nans-fp-math\"=\"false\" \"no-signed-zeros-fp-math\"=\"false\" \"no-trapping-math\"=\"true\" \"stack-protector-buffer-size\"=\"8\" \"target-cpu\"=\"penryn\" \"target-features\"=\"+cx16,+cx8,+fxsr,+mmx,+sahf,+sse,+sse2,+sse3,+sse4.1,+ssse3,+x87\" \"unsafe-fp-math\"=\"false\" \"use-soft-float\"=\"false\" }\n";

        return text;
    }

}
