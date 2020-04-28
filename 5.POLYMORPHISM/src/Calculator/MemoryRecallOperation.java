package Calculator;

import java.util.Stack;

public class MemoryRecallOperation implements Operation {

    @Override
    public void addOperand(int operand) {
    }

    @Override
    public int getResult() {
        return this.memory.pop();
    }

    @Override
    public boolean isCompleted() {
        return true;
    }
}
