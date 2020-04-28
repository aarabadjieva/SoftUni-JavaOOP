package Vechicle;

public abstract class Vechicle {
    private double fuelQuantity;
    private double fuelConsumption;
    private int tankCapacity;

    public Vechicle(double fuelQuantity, double fuelConsumption,int tankCapacity) {
        this.setFuelQuantity(fuelQuantity);
        this.fuelConsumption = fuelConsumption;
        this.tankCapacity = tankCapacity;
    }

    public double getFuelQuantity() {
        return fuelQuantity;
    }

    public double getFuelConsumption() {
        return fuelConsumption;
    }

    protected void setFuelQuantity(double fuelQuantity) {
        if (fuelQuantity<=0){
            throw new IllegalArgumentException("Fuel must be a positive number");
        }
        this.fuelQuantity = fuelQuantity;
    }

    public int getTankCapacity() {
        return tankCapacity;
    }

    abstract String drive(double distance);
    void refuel(double liters){
        if (this.getFuelQuantity()+liters>this.getTankCapacity()){
            throw new IllegalArgumentException("Cannot fit fuel in tank");
        }
        if (liters<=0){
            throw new IllegalArgumentException("Fuel must be a positive number");
        }
        this.setFuelQuantity(this.getFuelQuantity()+liters);
    }

    @Override
    public String toString() {
        return String.format("%s: %.2f",this.getClass().getSimpleName(),this.getFuelQuantity());
    }
}
