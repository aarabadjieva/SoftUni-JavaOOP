package BoatRaceSimulator.models.engines;

import BoatRaceSimulator.exceptions.ArgumentException;

public abstract class Engine {
    private String model;
    private int horsepower;
    private int displacement;
    private int output;

    public Engine(String model, int horsepower, int displacement) throws ArgumentException {
        this.setModel(model);
        this.setHorsepower(horsepower);
        this.setDisplacement(displacement);
        this.output = this.calculateOutput();
    }

    abstract int calculateOutput();

    public String getModel() {
        return model;
    }

    private void setModel(String model) throws ArgumentException {
        if (model.length()<3){
            throw new ArgumentException("Model's name must be at least 3 symbols long.");
        }
        this.model = model;
    }

    public int getHorsepower() {
        return horsepower;
    }

    private void setHorsepower(int horsepower) throws ArgumentException {
        if (horsepower<=0){
            throw new ArgumentException("Horsepower must be a positive integer.");
        }
        this.horsepower = horsepower;
    }

    public int getDisplacement() {
        return displacement;
    }

    private void setDisplacement(int displacement) throws ArgumentException {
        if (displacement<=0){
            throw new ArgumentException("Displacement must be a positive integer.");
        }
        this.displacement = displacement;
    }

    public int getOutput() {
        return output;
    }

}
