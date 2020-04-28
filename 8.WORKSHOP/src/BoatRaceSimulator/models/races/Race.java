package BoatRaceSimulator.models.races;

import BoatRaceSimulator.exceptions.ArgumentException;
import BoatRaceSimulator.exceptions.DuplicateModelException;
import BoatRaceSimulator.models.boats.Boat;

import java.util.LinkedHashMap;
import java.util.Map;

public class Race {
    private int distance;
    private int windSpeed;
    private int oceanSpeed;
    private Map<String, Boat> participants;
    private boolean allowMotorboats;

    public Race(int distance, int windSpeed, int oceanSpeed, boolean allowMotorboats) throws ArgumentException {
        this.setDistance(distance);
        this.windSpeed = windSpeed;
        this.oceanSpeed = oceanSpeed;
        this.participants = new LinkedHashMap<>();
        this.allowMotorboats = allowMotorboats;
    }

    public int getDistance() {
        return distance;
    }

    private void setDistance(int distance) throws ArgumentException {
        if (distance <= 0) {
            throw new ArgumentException("Distance must be a positive integer.");
        }
        this.distance = distance;
    }

    public int getWindSpeed() {
        return windSpeed;
    }

    private void setWindSpeed(int windSpeed) {
        this.windSpeed = windSpeed;
    }

    public int getOceanSpeed() {
        return oceanSpeed;
    }

    private void setOceanSpeed(int oceanSpeed) {
        this.oceanSpeed = oceanSpeed;
    }

    public Map<String, Boat> getParticipants() {
        return participants;
    }

    public boolean isAllowMotorboats() {
        return allowMotorboats;
    }

    private void setAllowMotorboats(boolean allowMotorboats) {
        this.allowMotorboats = allowMotorboats;
    }

    public void addParticipant(Boat boat) throws DuplicateModelException, ArgumentException {
        if (!this.allowMotorboats && isMotorboat(boat)) {
            throw new ArgumentException("The specified boat does not meet the race constraints.");
        }

        if (this.participants.containsKey(boat.getModel())) {
            throw new DuplicateModelException();
        }


        this.participants.put(boat.getModel(),boat);
    }

    private boolean isMotorboat(Boat boat) {
        if (boat.getClass().getSimpleName().equals("PowerBoat") || boat.getClass().getSimpleName().equals("Yacht")) {
            return true;
        }
        return false;
    }
}
