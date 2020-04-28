package SystemSplit.components;

import SystemSplit.interfaces.HardwareInterface;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public abstract class Hardware implements HardwareInterface {
    String name;
    String type;
    int maxCapacity;
    int maxMemory;
    Map<String, Software> softwareComponents;
    int usedCapacity;
    int usedMemory;
    int expressCount;
    int lightCount;

    protected Hardware(String name, int capacity, int memory) {
        this.name = name;
        this.setMaxCapacity(capacity);
        this.setMaxMemory(memory);
        this.setType();
        this.softwareComponents = new LinkedHashMap<>();
        this.usedCapacity = 0;
        this.usedMemory = 0;
        this.expressCount = 0;
        this.lightCount = 0;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getMaxCapacity() {
        return this.maxCapacity;
    }

    @Override
    public int getMaxMemory() {
        return this.maxMemory;
    }

    @Override
    public String getType() {
        return this.type;
    }

    public Map<String, Software> getSoftwareComponents() {
        return softwareComponents;
    }


    public int getUsedCapacity() {
        return usedCapacity;
    }

    public int getUsedMemory() {
        return usedMemory;
    }

    public int getExpressCount() {
        return expressCount;
    }

    public int getLightCount() {
        return lightCount;
    }

    void setType() {
        this.type = this.getClass().getSimpleName().replaceAll("Hardware", "");
    }

    abstract void setMaxCapacity(int maxCapacity);

    abstract void setMaxMemory(int memory);

    @Override
    public void addSoftware(Software software) {
        if (this.usedMemory + software.getMemoryConsumption() <= this.maxMemory &&
                this.usedCapacity + software.getCapacityConsumption() <= this.maxCapacity) {
            this.softwareComponents.put(software.getName(), software);
            this.usedCapacity += software.getCapacityConsumption();
            this.usedMemory += software.getMemoryConsumption();
            if (software.getType().equals("Express")) {
                this.expressCount++;
            } else {
                this.lightCount++;
            }
        }
    }

    @Override
    public void releaseSoftware(String softwareName) {
        if (this.softwareComponents.containsKey(softwareName)) {
            int memoryToRelease = this.softwareComponents.get(softwareName).getMemoryConsumption();
            int capacityToRelease = this.softwareComponents.get(softwareName).getCapacityConsumption();
            if (this.softwareComponents.get(softwareName).getType().equals("Express")){
                this.expressCount--;
            }else {
                this.lightCount--;
            }
            this.usedCapacity -= capacityToRelease;
            this.usedMemory -= memoryToRelease;
            this.softwareComponents.remove(softwareName);
        }
    }

    private String getSoftwareToString() {
        List<String> names = new ArrayList<>(softwareComponents.keySet());
        if (names.size()==0){
            return "None";
        }
        return names.toString().replaceAll("[\\[\\]]", "");
    }

    @Override
    public String toString() {
        return String.format("Hardware Component - %s%n" +
                        "Express Software Components - %d%n" +
                        "Light Software Components - %d%n" +
                        "Memory Usage: %d / %d%n" +
                        "Capacity Usage: %d / %d%n" +
                        "Type: %s%n" +
                        "Software Components: %s", this.getName(),
                this.getExpressCount(), this.getLightCount(),
                this.getUsedMemory(), this.getMaxMemory(),
                this.getUsedCapacity(), this.getMaxCapacity(),
                this.getType(), this.getSoftwareToString());
    }
}
