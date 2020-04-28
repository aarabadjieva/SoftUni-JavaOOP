package Vechicle;

import java.text.DecimalFormat;

public class Car extends Vechicle {


    public Car(double fuelQuantity, double fuelConsumption, int tankCapacity) {
        super(fuelQuantity, fuelConsumption, tankCapacity);
    }

    @Override
    String drive(double distance) {
        DecimalFormat df = new DecimalFormat("#.##");
        if (this.getFuelQuantity()/(this.getFuelConsumption()+0.9)>=distance){
            this.setFuelQuantity(this.getFuelQuantity()-(distance*(this.getFuelConsumption()+0.9)));
            return "Car travelled "+df.format(distance)+" km";
        }
        return "Car needs refueling";
    }

}
