package Calculator;

public class MemorySaveOperation implements Operation{


    @Override
    public void addOperand(int operand) {
        memory.push(operand);
    }

    @Override
    public int getResult() {
        return 0;
    }

    @Override
    public boolean isCompleted() {
        return false;
    }
}
