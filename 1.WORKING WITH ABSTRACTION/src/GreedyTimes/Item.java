package GreedyTimes;

public class Item {
    private String name;
    private long value;

    public Item(String name, long value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }


    public long getValue() {
        return value;
    }

    public void setValue(long value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return String.format("##%s - %s%n",this.getName(),this.getValue());
    }
}
