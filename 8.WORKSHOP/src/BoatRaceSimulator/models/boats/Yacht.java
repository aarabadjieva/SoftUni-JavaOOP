package BoatRaceSimulator.models.boats;

import BoatRaceSimulator.models.engines.Engine;
import BoatRaceSimulator.exceptions.ArgumentException;

public class Yacht extends Boat{
    private Engine engine;
    private int cargoWeight;

    public Yacht(String model, int weight, Engine engine, int cargoWeight) throws ArgumentException {
        super(model, weight);
        this.engine = engine;
        this.setCargoWeight(cargoWeight);
    }

    public Engine getEngine() {
        return engine;
    }

    private void setEngine(Engine engine) {
        this.engine = engine;
    }

    public int getCargoWeight() {
        return cargoWeight;
    }

    private void setCargoWeight(int cargoWeight) throws ArgumentException {
        if (cargoWeight<=0){
            throw new ArgumentException("Cargo Weight must be a positive integer.");
        }
        this.cargoWeight = cargoWeight;
    }
}
