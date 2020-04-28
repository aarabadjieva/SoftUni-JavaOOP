package SystemSplit.components;

public class HeavyHardware extends Hardware {
    public HeavyHardware(String name, int capacity, int memory) {
        super(name, capacity, memory);
    }

    @Override
    protected void setMaxCapacity(int capacity) {
        this.maxCapacity = capacity *2;
    }

    @Override
    void setMaxMemory(int memory) {
        this.maxMemory = memory-(memory/4);
    }
}
