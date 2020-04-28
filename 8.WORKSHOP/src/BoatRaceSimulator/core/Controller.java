package BoatRaceSimulator.core;

import BoatRaceSimulator.data.Database;
import BoatRaceSimulator.exceptions.*;
import BoatRaceSimulator.models.boats.*;
import BoatRaceSimulator.models.engines.Engine;
import BoatRaceSimulator.models.engines.JetEngine;
import BoatRaceSimulator.models.engines.SterndriveEngine;
import BoatRaceSimulator.models.races.Race;

import java.text.DecimalFormat;
import java.util.*;
import java.util.stream.Collectors;

public class Controller {
    private Database database;
    private Race currentRace;

    public Controller(Database database) {
        this.database = database;
        this.currentRace = null;
    }

    public String createBoatEngine(String model, int horsepower, int displacement, String type) throws DuplicateModelException, ArgumentException {
        Engine engine = null;
        if (type.equals("Jet")){
            engine = new JetEngine(model,horsepower,displacement);
        }else {
            engine = new SterndriveEngine(model, horsepower, displacement);
        }
         this.database.getEngineRepository().addModel(engine);
        return String.format("EngineRun model %s with %d HP and displacement %d cm3 created successfully."
                ,engine.getModel(),engine.getHorsepower(),engine.getDisplacement());
    }

    public String createRowBoat(String model, int weight, int oars) throws ArgumentException, DuplicateModelException {
        Boat boat = new RowBoat(model, weight, oars);
         this.database.getBoatRepository().addModel(boat);
        return String.format("Row boat with model %s registered successfully.",boat.getModel());
    }

    public String createSailBoat(String model, int weight, int sailEfficiency) throws ArgumentException, DuplicateModelException {
        Boat boat = new SailBoat(model, weight, sailEfficiency);
         this.database.getBoatRepository().addModel(boat);
        return String.format("Sail boat with model %s registered successfully.",boat.getModel());
    }

    public String createPowerBoat(String model, int weight, String engineFirst, String engineSecond) throws NonExistantModelException, ArgumentException, DuplicateModelException {
        Engine engine1 = this.database.getEngineRepository().getModel(engineFirst);
        Engine engine2 = this.database.getEngineRepository().getModel(engineSecond);
        Boat boat = new PowerBoat(model,weight,engine1,engine2);
        this.database.getBoatRepository().addModel(boat);
        return String.format("Power boat with model %s registered successfully.",boat.getModel());
    }

    public String createYacht(String model, int weigth, String engine, int cargo) throws NonExistantModelException, ArgumentException, DuplicateModelException {
        Engine engine1 = this.database.getEngineRepository().getModel(engine);
        Boat boat = new Yacht(model,weigth,engine1,cargo);
         this.database.getBoatRepository().addModel(boat);
        return String.format("Yacht with model %s registered successfully.",boat.getModel());
    }

    public String openRace(int distance, int windSpeed, int oceanSpeed, boolean allowMotorboats) throws RaceAlreadyExistException, ArgumentException {
        if (this.currentRace!=null){
            throw new RaceAlreadyExistException("The current race has already been set.");
        }
        this.currentRace = new Race(distance,windSpeed,oceanSpeed,allowMotorboats);
        return String.format("A new race with distance %d meters, wind speed %d m/s and ocean current speed %d m/s has been set.",
        this.currentRace.getDistance(),this.currentRace.getWindSpeed(),
        this.currentRace.getOceanSpeed());
    }

    public String signUpBoat(String model) throws NoSetRaceException, NonExistantModelException, DuplicateModelException, ArgumentException {
        if (this.currentRace==null){
            throw new NoSetRaceException("There is currently no race set.");
        }
        Boat boat = this.database.getBoatRepository().getModel(model);
         this.currentRace.addParticipant(boat);
        return String.format("Boat with model %s has signed up for the current Race.",boat.getModel());
    }

    public String startRace() throws NoSetRaceException, InsufficientContestantsException {
        if (this.currentRace==null){
            throw new NoSetRaceException("There is currently no race set.");
        }
        if (this.currentRace.getParticipants().size()<3){
            throw new InsufficientContestantsException("Not enough contestants for the race.");
        }

        List<Boat> winners = new ArrayList<>();
        for (Boat boat:this.currentRace.getParticipants().values()
             ) {
            double boatTime = 0;
            if (boat instanceof RowBoat){
                boatTime = (((RowBoat) boat).getOars()*1.00*100.00)-boat.getWeight()+this.currentRace.getOceanSpeed();
            }else if (boat instanceof SailBoat){
                boatTime = (this.currentRace.getWindSpeed()*1.00*(((SailBoat) boat).getSailEfficiency()/100.00))-boat.getWeight()
                        +(this.currentRace.getOceanSpeed()*1.00/2.00);
            }else if (boat instanceof PowerBoat){
                boatTime = (((PowerBoat) boat).getEngine1().getOutput()+((PowerBoat) boat).getEngine2().getOutput())-
                        boat.getWeight()+(this.currentRace.getOceanSpeed()*1.00/5.00);
            }else if (boat instanceof Yacht){
                boatTime = ((Yacht) boat).getEngine().getOutput()-(boat.getWeight()+((Yacht) boat).getCargoWeight())+
                        (this.currentRace.getOceanSpeed()*1.00/2.00);
            }
            if (boatTime<=0){
                boat.setRaceTime(Double.POSITIVE_INFINITY);
            }else {
                boat.setRaceTime(this.currentRace.getDistance()/boatTime);
            }


            winners.add(boat);
        }
        DecimalFormat df = new DecimalFormat("0.00");
       winners = winners.stream().sorted(Comparator.comparingDouble(Boat::getRaceTime)).collect(Collectors.toList());
        StringBuilder sb = new StringBuilder();
        //First place: [typeOfBoat] Model: [model] Time: [boatsRaceTime]
        //Second place: [typeOfBoat] Model: [model] Time: [boatsRaceTime]
        //Third place: [typeOfBoat] Model: [model] Time: [boatsRaceTime]
        String first = "";
        String second = "";
        String third = "";
        if (winners.get(0).getRaceTime()!=Double.POSITIVE_INFINITY){
            first = df.format(winners.get(0).getRaceTime())+" sec";
        }else {
            first = "Did not finish!";
        }
        if (winners.get(1).getRaceTime()!=Double.POSITIVE_INFINITY){
            second = df.format(winners.get(1).getRaceTime())+" sec";
        }else {
            second = "Did not finish!";
        }
        if (winners.get(2).getRaceTime()!=Double.POSITIVE_INFINITY){
            third = df.format(winners.get(2).getRaceTime())+" sec";
        }else {
            third = "Did not finish!";
        }
        sb.append(String.format("First place: %s Model: %s Time: %s",winners.get(0).getClass().getSimpleName(),
                winners.get(0).getModel(),first)).append(System.lineSeparator()).append(String.format("Second place: %s Model: %s Time: %s",
                winners.get(1).getClass().getSimpleName(), winners.get(1).getModel(),second)).append(System.lineSeparator())
                .append(String.format("Third place: %s Model: %s Time: %s",winners.get(2).getClass().getSimpleName(),
                        winners.get(2).getModel(),third));
        this.currentRace = null;
        return sb.toString();
    }
}
