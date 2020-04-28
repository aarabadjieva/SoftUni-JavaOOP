package SystemSplit;

import SystemSplit.components.Hardware;
import SystemSplit.components.Software;

import java.util.LinkedHashMap;
import java.util.Map;

public class Bin {
    Map<String, Hardware> dumped;
    int powerHardwareCount;
    int heavyHardwareCount;
    int expressSoftwareCount;
    int lightSoftwareCount;
    int totalDumpedMemory;
    int totalDumpedCapacity;

    public Bin() {
        this.dumped = new LinkedHashMap<>();
        this.powerHardwareCount = 0;
        this.heavyHardwareCount = 0;
        this.expressSoftwareCount = 0;
        this.lightSoftwareCount = 0;
    }

    public void destroy(String hardwareName){
        if (this.dumped.containsKey(hardwareName)){
            this.dumped.remove(hardwareName);
        }
    }

    private void calculateCountOfComponents(){
        for (Hardware hardware:this.dumped.values()
             ) {
            if (hardware.getType().equals("Power")){
                this.powerHardwareCount++;
            }else {
                this.heavyHardwareCount++;
            }
            for (Software software:hardware.getSoftwareComponents().values()
                 ) {
                if (software.getType().equals("Express")){
                    this.expressSoftwareCount++;
                }else {
                    this.lightSoftwareCount++;
                }
            }
            this.totalDumpedMemory+=hardware.getUsedMemory();
            this.totalDumpedCapacity+=hardware.getUsedCapacity();
        }
    }

    public Map<String, Hardware> getDumped() {
        return dumped;
    }

    public int getPowerHardwareCount() {
        return powerHardwareCount;
    }

    public int getHeavyHardwareCount() {
        return heavyHardwareCount;
    }

    public int getExpressSoftwareCount() {
        return expressSoftwareCount;
    }

    public int getLightSoftwareCount() {
        return lightSoftwareCount;
    }

    public int getTotalDumpedMemory() {
        return totalDumpedMemory;
    }

    public int getTotalDumpedCapacity() {
        return totalDumpedCapacity;
    }

    public String analyze(){
        this.calculateCountOfComponents();
        return String.format("Dump Analysis%n" +
                "Power Hardware Components: %d%n" +
                "Heavy Hardware Components: %d%n" +
                "Express Software Components: %d%n" +
                "Light Software Components: %d%n" +
                "Total Dumped Memory: %d%n" +
                "Total Dumped Capacity: %d",this.getPowerHardwareCount(),
                this.getHeavyHardwareCount(),this.getExpressSoftwareCount(),
                this.getLightSoftwareCount(),this.getTotalDumpedMemory(),
                this.getTotalDumpedCapacity());
    }
}
