package BoatRaceSimulator.models.engines;

import BoatRaceSimulator.exceptions.ArgumentException;

public class JetEngine extends Engine {

    public JetEngine(String model, int horsepower, int displacement) throws ArgumentException {
        super(model, horsepower, displacement);
    }

    @Override
    int calculateOutput() {
        return (this.getHorsepower()*5)+this.getDisplacement();
    }
}
