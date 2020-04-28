package BoatRaceSimulator.data;

import BoatRaceSimulator.exceptions.DuplicateModelException;
import BoatRaceSimulator.models.engines.Engine;

public class EngineRepository extends Repository<Engine> {
    public EngineRepository() {
        super();
    }

    @Override
   public void addModel(Engine engine) throws DuplicateModelException {
        if (this.getModels().containsKey(engine.getModel())){
            throw new DuplicateModelException();
        }
        this.getModels().put(engine.getModel(),engine);
    }
}
