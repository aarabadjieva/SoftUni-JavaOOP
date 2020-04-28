package BoatRaceSimulator.data;

public class Database {
    private BoatRepository boatRepository;
    private EngineRepository engineRepository;

    public Database() {
        this.boatRepository = new BoatRepository();
        this.engineRepository = new EngineRepository();
    }

    public BoatRepository getBoatRepository() {
        return boatRepository;
    }

    public EngineRepository getEngineRepository() {
        return engineRepository;
    }
}
