package Ferrari;

public class Ferrari implements Car {
    private String driverName;
    private String model;

    public Ferrari(String driverName) {
        this.driverName = driverName;
        this.model = "488-Spider";
    }


    @Override
    public String toString() {
        return String.format("488-Spider/Brakes!/Zadu6avam sA!/%s",this.driverName);
    }

    @Override
    public String brakes() {
        return "Brakes!";
    }

    @Override
    public String gas() {
        return "Zadu6avam sA!";
    }
}
