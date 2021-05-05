llvm-as -f code.ll
llc code.bc
llvm-gcc -o code code.s
./code