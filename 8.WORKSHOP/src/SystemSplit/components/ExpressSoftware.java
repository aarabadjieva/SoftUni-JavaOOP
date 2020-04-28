package SystemSplit.components;

public class ExpressSoftware extends Software {
    public ExpressSoftware(String name, int capacityConsumption, int memoryConsumption) {
        super(name, capacityConsumption, memoryConsumption);
    }

    @Override
    void setCapacityConsumption(int capacityConsumption) {
        this.capacityConsumption = capacityConsumption;
    }

    @Override
    void setMemoryConsumption(int memoryConsumption) {
        this.memoryConsumption = memoryConsumption*2;
    }
}
