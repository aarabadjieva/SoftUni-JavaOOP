package BoatRaceSimulator.models.boats;

import BoatRaceSimulator.exceptions.ArgumentException;

public class RowBoat extends Boat {
    private int oars;

    public RowBoat(String model, int weight, int oars) throws ArgumentException {
        super(model, weight);
        this.setOars(oars);
    }

    public int getOars() {
        return oars;
    }

    private void setOars(int oars) throws ArgumentException {
        if (oars<=0){
            throw new ArgumentException("Oars must be a positive integer.");
        }
        this.oars = oars;
    }
}
