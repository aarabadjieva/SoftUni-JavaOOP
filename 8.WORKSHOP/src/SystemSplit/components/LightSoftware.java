package SystemSplit.components;

public class LightSoftware extends Software {
    public LightSoftware(String name, int capacityConsumption, int memoryConsumption) {
        super(name, capacityConsumption, memoryConsumption);
    }

    @Override
    void setCapacityConsumption(int capacityConsumption) {
        this.capacityConsumption = capacityConsumption+capacityConsumption/2;
    }

    @Override
    void setMemoryConsumption(int memoryConsumption) {
        this.memoryConsumption = memoryConsumption/2;
    }
}
