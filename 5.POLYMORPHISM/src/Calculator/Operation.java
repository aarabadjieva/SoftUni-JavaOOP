package Calculator;

import java.util.Stack;

public interface Operation {
    static Stack<Integer> memory = new Stack<>();
    void addOperand(int operand);
    int getResult();
    boolean isCompleted();
}
