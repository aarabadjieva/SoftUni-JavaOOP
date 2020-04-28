package SystemSplit.components;

public abstract class Software {
    String name;
    String type;
    int capacityConsumption;
    int memoryConsumption;

    protected Software(String name, int capacityConsumption, int memoryConsumption) {
        this.name = name;
        this.setType();
        this.setCapacityConsumption(capacityConsumption);
        this.setMemoryConsumption(memoryConsumption);
    }

    protected void setType(){
        this.type = this.getClass().getSimpleName().replaceAll("Software","");
    }

    abstract void setCapacityConsumption(int capacityConsumption);
    abstract void setMemoryConsumption(int memoryConsumption);

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public int getCapacityConsumption() {
        return this.capacityConsumption;
    }

    public int getMemoryConsumption() {
        return this.memoryConsumption;
    }
}
