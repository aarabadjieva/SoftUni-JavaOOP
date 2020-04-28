package Calculator;

public class InputInterpreter {
    private CalculationEngine engine;

    public InputInterpreter(CalculationEngine engine){
        this.engine = engine;
    }

    public boolean interpret(String input) {
        try {
            engine.pushNumber(Integer.parseInt(input));
        }catch (Exception ex){
            engine.pushOperation(this.getOperation(input));
        }
        return true;
    }
    MemoryRecallOperation memoryRecall = new MemoryRecallOperation();
    public Operation getOperation(String operation) {
        MemoryRecallOperation memoryRecall = new MemoryRecallOperation();
        MemorySaveOperation memorySave = new MemorySaveOperation();
        if (operation.equals("*")) {
            return new MultiplicationOperation();
        }
        if (operation.equals("/")){
            return new DivisionOperation();
        }
        if (operation.equals("ms")){
            return memorySave;
        }
        if (operation.equals("mr")){
        memoryRecall.addOperand(memorySave.getResult());
            return memoryRecall;
        }

        return null;
    }
}
