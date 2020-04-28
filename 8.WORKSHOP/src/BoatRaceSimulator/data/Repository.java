package BoatRaceSimulator.data;
import BoatRaceSimulator.exceptions.DuplicateModelException;
import BoatRaceSimulator.exceptions.NonExistantModelException;

import java.util.LinkedHashMap;
import java.util.Map;

public abstract class Repository <T> {
    private Map<String, T> models;

    public Repository() {
        this.models = new LinkedHashMap<>();
    }

    public Map<String, T> getModels() {
        return models;
    }

    abstract void addModel(T t) throws DuplicateModelException, DuplicateModelException;
    public T getModel(String model) throws NonExistantModelException {
        if (!this.getModels().containsKey(model)){
            throw new NonExistantModelException();
        }
        return this.getModels().get(model);
    }
}
