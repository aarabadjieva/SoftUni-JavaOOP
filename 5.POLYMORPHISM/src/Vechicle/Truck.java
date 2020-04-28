package Vechicle;

import java.text.DecimalFormat;

public class Truck extends Vechicle{
    public Truck(double fuelQuantity, double fuelConsumption, int tankCapacity) {
        super(fuelQuantity, fuelConsumption,tankCapacity);
    }

    @Override
    String drive(double distance) {
        DecimalFormat df = new DecimalFormat("#.##");
        if (this.getFuelQuantity()/(this.getFuelConsumption()+1.6)>=distance){
            this.setFuelQuantity(this.getFuelQuantity()-(distance*(this.getFuelConsumption()+1.6)));
            return "Truck travelled "+df.format(distance)+" km";
        }
        return "Truck needs refueling";
    }

    @Override
    void refuel(double liters) {
        liters = liters*0.95;
        super.refuel(liters);
    }
}
