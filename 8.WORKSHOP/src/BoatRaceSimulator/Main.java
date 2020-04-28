package BoatRaceSimulator;

import BoatRaceSimulator.core.CommandHandler;
import BoatRaceSimulator.core.Controller;
import BoatRaceSimulator.data.Database;

public class Main {
    public static void main(String[] args) {
        Database database = new Database();
        Controller controller = new Controller(database);
        CommandHandler commandHandler = new CommandHandler(controller);
        EngineRun engine = new EngineRun(commandHandler);
        engine.run();
    }
}
