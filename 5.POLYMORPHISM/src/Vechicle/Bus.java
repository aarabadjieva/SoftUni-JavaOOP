package Vechicle;

import java.text.DecimalFormat;

public class Bus extends Vechicle {
    public Bus(double fuelQuantity, double fuelConsumption, int tankCapacity) {
        super(fuelQuantity, fuelConsumption, tankCapacity);
    }

    @Override
    String drive(double distance) {
        DecimalFormat df = new DecimalFormat("#.##");
        if (this.getFuelQuantity()/(this.getFuelConsumption()+1.4)>=distance){
            this.setFuelQuantity(this.getFuelQuantity()-(distance*(this.getFuelConsumption()+1.4)));
            return "Bus travelled "+df.format(distance)+" km";
        }
        return "Bus needs refueling";
    }

    String driveEmpty(double distance){
        DecimalFormat df = new DecimalFormat("#.##");
        if (this.getFuelQuantity()/this.getFuelConsumption()>=distance){
            this.setFuelQuantity(this.getFuelQuantity()-distance*(this.getFuelConsumption()));
            return "Bus travelled "+df.format(distance)+" km";
        }
        return "Bus needs refueling";
    }
}
