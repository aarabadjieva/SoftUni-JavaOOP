package MilitaryElite;

public class Repair {
    private String part;
    private int hours;

    public Repair(String part, int hours) {
        this.part = part;
        this.hours = hours;
    }

    public String getPart() {
        return part;
    }

    public int getHours() {
        return hours;
    }

    @Override
    public String toString() {
        return String.format("Part Name: %s Hours Worked: %d",this.getPart(),this.getHours());
    }
}
