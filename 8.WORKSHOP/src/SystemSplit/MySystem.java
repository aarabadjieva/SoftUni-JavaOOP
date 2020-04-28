package SystemSplit;

import SystemSplit.components.*;

import java.util.LinkedHashMap;
import java.util.Map;

public class MySystem {
    Map<String, Hardware> hardware;
    Bin bin;
    int maxCapacity;
    int maxMemory;
    int usedCapacity;
    int usedMemory;

    public MySystem() {
        this.hardware = new LinkedHashMap<>();
        this.bin = new Bin();
        this.maxCapacity = 0;
        this.maxMemory = 0;
        this.usedCapacity = 0;
        this.usedMemory = 0;
    }

    public Map<String, Hardware> getHardware() {
        return hardware;
    }

    public int getMaxCapacity() {
        return maxCapacity;
    }

    public int getMaxMemory() {
        return maxMemory;
    }

    public int getUsedCapacity() {
        return usedCapacity;
    }

    public int getUsedMemory() {
        return usedMemory;
    }

    public Bin getBin() {
        return bin;
    }

    public void registerPowerHardware(String name, int capacity, int memory) {
        Hardware hardware = new PowerHardware(name, capacity, memory);
        this.hardware.put(name, hardware);
        this.maxCapacity += hardware.getMaxCapacity();
        this.maxMemory += hardware.getMaxMemory();
    }

    public void registerHeavyHardware(String name, int capacity, int memory) {
        Hardware hardware = new HeavyHardware(name, capacity, memory);
        this.hardware.put(name, hardware);
        this.maxCapacity += hardware.getMaxCapacity();
        this.maxMemory += hardware.getMaxMemory();
    }

    public void registerExpressSoftware(String hardwareName, String name, int capacity, int memory) {
        Software software = new ExpressSoftware(name, capacity, memory);
        if (this.hardware.containsKey(hardwareName)) {
            this.hardware.get(hardwareName).addSoftware(software);
        }
    }

    public void registerLightSoftware(String hardwareName, String name, int capacity, int memory) {
        Software software = new LightSoftware(name, capacity, memory);
        if (this.hardware.containsKey(hardwareName)) {
            this.hardware.get(hardwareName).addSoftware(software);
        }
    }

    public void releaseSoftwareComponent(String hardwareName, String softwareName) {
        if (this.hardware.containsKey(hardwareName)) {
            this.hardware.get(hardwareName).releaseSoftware(softwareName);
        }
    }

    private int getTotalSoftwareCount() {
        int softwareCount = 0;
        for (Hardware hardware : this.hardware.values()) {
            softwareCount += hardware.getSoftwareComponents().size();
        }
        return softwareCount;
    }

    private void setUsedMemoryAndCapacity() {
        this.usedCapacity = 0;
        this.usedMemory = 0;
        for (Hardware hardware : this.hardware.values()) {
            this.usedCapacity += hardware.getUsedCapacity();
            this.usedMemory += hardware.getUsedMemory();
        }
    }

    public String analyze() {
        this.setUsedMemoryAndCapacity();
        return String.format("System Analysis%n" +
                        "Hardware Components: %d%n" +
                        "Software Components: %d%n" +
                        "Total Operational Memory: %d / %d%n" +
                        "Total Capacity Taken: %d / %d",
                this.getHardware().size(), this.getTotalSoftwareCount(),
                this.getUsedMemory(), this.getMaxMemory(),
                this.getUsedCapacity(), this.getMaxCapacity());
    }

    public void dump(String hardwareName) {
        if (this.hardware.containsKey(hardwareName)) {
            Hardware hardware = this.hardware.get(hardwareName);
            this.hardware.remove(hardwareName);
            this.bin.getDumped().put(hardwareName, hardware);
            this.maxCapacity -= hardware.getMaxCapacity();
            this.maxMemory -= hardware.getMaxMemory();
        }
    }

    public void restore(String hardwareName){
        if (this.bin.getDumped().containsKey(hardwareName)){
            Hardware hardware = this.bin.getDumped().get(hardwareName);
            this.bin.getDumped().remove(hardwareName);
            this.hardware.put(hardwareName,hardware);
            this.maxMemory += hardware.getMaxMemory();
            this.maxCapacity += hardware.getMaxCapacity();
        }
    }

    public String systemSplit() {
        StringBuilder sb = new StringBuilder();
        for (Hardware hardware : this.hardware.values()
        ) {
            if (hardware.getType().equals("Power"))
                sb.append(hardware.toString()).append(System.lineSeparator());
        }
        for (Hardware hardware : this.hardware.values()
        ) {
            if (!hardware.getType().equals("Power"))
                sb.append(hardware.toString()).append(System.lineSeparator());
        }
        return sb.toString();
    }
}
