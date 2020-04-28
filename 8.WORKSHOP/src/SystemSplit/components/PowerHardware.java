package SystemSplit.components;

public class PowerHardware extends Hardware {
    public PowerHardware(String name, int capacity, int memory) {
        super(name, capacity, memory);
    }

    @Override
    protected void setMaxCapacity(int capacity) {
        this.maxCapacity = capacity -((capacity *3)/4);
    }

    @Override
    protected void setMaxMemory(int memory) {
        this.maxMemory = memory+((memory*3)/4);
    }
}
