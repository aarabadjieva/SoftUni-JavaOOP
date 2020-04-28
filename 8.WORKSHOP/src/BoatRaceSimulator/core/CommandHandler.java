package BoatRaceSimulator.core;

import BoatRaceSimulator.exceptions.*;

public class CommandHandler {
    private Controller controller;


    public CommandHandler(Controller controller) {
        this.controller = controller;
    }

   public String handle(String[] data) throws DuplicateModelException, ArgumentException, NonExistantModelException, RaceAlreadyExistException, NoSetRaceException, InsufficientContestantsException {
        String result = "";
        switch (data[0]) {
            case "CreateBoatEngine":
                String model = data[1];
                int horsepower = Integer.parseInt(data[2]);
                int displacement = Integer.parseInt(data[3]);
                String type = data[4];
                result = controller.createBoatEngine(model, horsepower, displacement, type);
                break;
            case "CreateRowBoat":
                model = data[1];
                int weight = Integer.parseInt(data[2]);
                int oars = Integer.parseInt(data[3]);
                result = controller.createRowBoat(model, weight, oars);
                break;
            case "CreateSailBoat":
                model = data[1];
                weight = Integer.parseInt(data[2]);
                int sailEfficiency = Integer.parseInt(data[3]);
                result = controller.createSailBoat(model, weight, sailEfficiency);
                break;
            case "CreatePowerBoat":
                model = data[1];
                weight = Integer.parseInt(data[2]);
                String engine = data[3];
                String engine2 = data[4];
                result = controller.createPowerBoat(model, weight, engine, engine2);
                break;
            case "CreateYacht":
                model = data[1];
                weight = Integer.parseInt(data[2]);
                engine = data[3];
                int cargo = Integer.parseInt(data[4]);
                result = controller.createYacht(model, weight, engine, cargo);
                break;
            case "OpenRace":
                int distance = Integer.parseInt(data[1]);
                int wind = Integer.parseInt(data[2]);
                int ocean = Integer.parseInt(data[3]);
                boolean allowed = Boolean.parseBoolean(data[4]);
                result = controller.openRace(distance, wind, ocean, allowed);
                break;
            case "SignUpBoat":
                model = data[1];
                result = controller.signUpBoat(model);
                break;
            case "StartRace":
                result = controller.startRace();
                break;
        }
        return result;
    }
}
