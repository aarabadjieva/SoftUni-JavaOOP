package BoatRaceSimulator.models.boats;

import BoatRaceSimulator.models.engines.Engine;
import BoatRaceSimulator.exceptions.ArgumentException;

public class PowerBoat extends Boat {
    private Engine engine1;
    private Engine engine2;

    public PowerBoat(String model, int weight, Engine engine1, Engine engine2) throws ArgumentException {
        super(model, weight);
        this.engine1 = engine1;
        this.engine2 = engine2;
    }

    public Engine getEngine1() {
        return engine1;
    }

    private void setEngine1(Engine engine1) {
        this.engine1 = engine1;
    }

    public Engine getEngine2() {
        return engine2;
    }

    private void setEngine2(Engine engine2) {
        this.engine2 = engine2;
    }
}
