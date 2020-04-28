package BoatRaceSimulator.models.boats;

import BoatRaceSimulator.exceptions.ArgumentException;

public class Boat {
    private String model;
    private int weight;
    private double raceTime;

    public double getRaceTime() {
        return raceTime;
    }

    public void setRaceTime(double raceTime) {
        this.raceTime = raceTime;
    }

    public Boat(String model, int weight) throws ArgumentException {
        this.setModel(model);
        this.setWeight(weight);
    }

    public String getModel() {
        return model;
    }

    private void setModel(String model) throws ArgumentException {
        if (model.length()<5){
            throw new ArgumentException("Model's name must be at least 5 symbols long.");
        }
        this.model = model;
    }

    public int getWeight() {
        return weight;
    }

    private void setWeight(int weight) throws ArgumentException {
        if (weight<=0){
            throw new ArgumentException("Weight must be a positive integer.");
        }
        this.weight = weight;
    }
}
