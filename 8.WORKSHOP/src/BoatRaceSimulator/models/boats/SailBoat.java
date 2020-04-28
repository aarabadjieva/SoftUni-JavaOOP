package BoatRaceSimulator.models.boats;

import BoatRaceSimulator.exceptions.ArgumentException;

public class SailBoat extends Boat {
    private int sailEfficiency;

    public SailBoat(String model, int weight, int sailEfficiency) throws ArgumentException {
        super(model, weight);
        this.setSailEfficiency(sailEfficiency);
    }

    public int getSailEfficiency() {
        return sailEfficiency;
    }

    private void setSailEfficiency(int sailEfficiency) throws ArgumentException {
        if (sailEfficiency<1||sailEfficiency>100){
            throw new ArgumentException("Sail Effectiveness must be between [1...100].");
        }
        this.sailEfficiency = sailEfficiency;
    }
}
