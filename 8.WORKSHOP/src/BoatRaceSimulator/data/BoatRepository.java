package BoatRaceSimulator.data;

import BoatRaceSimulator.models.boats.Boat;
import BoatRaceSimulator.exceptions.DuplicateModelException;

public class BoatRepository extends Repository<Boat> {
    public BoatRepository() {
        super();
    }

    @Override
    public void addModel(Boat boat) throws DuplicateModelException {
        if (this.getModels().containsKey(boat.getModel())){
            throw new DuplicateModelException();
        }
        this.getModels().put(boat.getModel(),boat);

    }

}
