package SystemSplit.interfaces;

import SystemSplit.components.Software;

public interface HardwareInterface {
    String getName();

    String getType();

    int getMaxCapacity();

    int getMaxMemory();

    void addSoftware(Software software);

    void releaseSoftware(String softwareName);
}
