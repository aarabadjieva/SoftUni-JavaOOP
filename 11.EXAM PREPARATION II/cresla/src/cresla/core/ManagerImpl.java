package cresla.core;

import cresla.entities.modules.CooldownSystem;
import cresla.entities.modules.CryogenRod;
import cresla.entities.modules.HeatProcessor;
import cresla.entities.reactors.CryoReactor;
import cresla.entities.reactors.HeatReactor;
import cresla.interfaces.AbsorbingModule;
import cresla.interfaces.EnergyModule;
import cresla.interfaces.Manager;
import cresla.interfaces.Module;
import cresla.interfaces.Reactor;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class ManagerImpl implements Manager {

    private int id;
    private Map<Integer, Reactor> reactors;
    private Map<Integer, Module> modules;
    private int cryoReactorsCount;
    private int heatReactorsCount;
    private int energyModulesCount;
    private int absorbingModulesCount;


    public ManagerImpl() {
        this.id = 1;
        this.reactors = new LinkedHashMap<>();
        this.modules = new LinkedHashMap<>();
        this.cryoReactorsCount = 0;
        this.heatReactorsCount = 0;
        this.absorbingModulesCount =0;
        this.energyModulesCount = 0;
    }

    @Override
    public String reactorCommand(List<String> arguments) {
        String type = arguments.get(0);
        int additionalParam = Integer.parseInt(arguments.get(1));
        int capacity = Integer.parseInt(arguments.get(2));
        Reactor reactor = null;
        if (type.equalsIgnoreCase("Cryo")) {
            reactor = new CryoReactor(this.id, additionalParam, capacity);
            this.cryoReactorsCount++;
        } else if (type.equalsIgnoreCase("Heat")){
            reactor = new HeatReactor(this.id, additionalParam, capacity);
            this.heatReactorsCount++;
        }
        this.reactors.putIfAbsent(this.id, reactor);

        return String.format("Created %s Reactor - %d", type, this.id++);
    }

    @Override
    public String moduleCommand(List<String> arguments) {
        int reactorID = Integer.parseInt(arguments.get(0));
        String type = arguments.get(1);
        int additionalParam = Integer.parseInt(arguments.get(2));
        Module module = null;
        switch (type) {
            case "CryogenRod":
                module = new CryogenRod(this.id, additionalParam);
                this.reactors.get(reactorID).addEnergyModule((EnergyModule) module);
                this.energyModulesCount++;
                break;
            case "HeatProcessor":
                module = new HeatProcessor(this.id, additionalParam);
                this.reactors.get(reactorID).addAbsorbingModule((AbsorbingModule) module);
                this.absorbingModulesCount++;
                break;
            case "CooldownSystem":
                module = new CooldownSystem(this.id, additionalParam);
                this.reactors.get(reactorID).addAbsorbingModule((AbsorbingModule) module);
                this.absorbingModulesCount++;
                break;
        }
        this.modules.putIfAbsent(this.id, module);
        return String.format("Added %s - %d to Reactor - %d", type, this.id++, reactorID);
    }

    @Override
    public String reportCommand(List<String> arguments) {
       // int neededID = Integer.parseInt(arguments.get(0));
       // String result = "";
      //  if (this.reactors.containsKey(neededID)) {
      //      result = this.reactors.get(neededID).toString();
      //  } else {
      //      result = this.modules.get(neededID).toString();
      //  }
        return null;//result;
    }


    @Override
    public String exitCommand(List<String> arguments) {
        return null;//this.toString();
    }

    @Override
    public String toString() {
     //  long totalEnergyOutput = 0;
     //  long totalHeatAbsorbing = 0;
     //  for (Reactor reactor : this.reactors.values()
     //  ) {
     //      totalEnergyOutput += reactor.getTotalEnergyOutput();
     //      totalHeatAbsorbing += reactor.getTotalHeatAbsorbing();
     //  }
     //  return String.format("Cryo Reactors: %d%n" +
     //                  "Heat Reactors: %d%n" +
     //                  "Energy Modules: %d%n" +
     //                  "Absorbing Modules: %d%n" +
     //                  "Total Energy Output: %d%n" +
     //                  "Total Heat Absorbing: %d%n", this.cryoReactorsCount,
     //          this.heatReactorsCount, this.energyModulesCount,
     //          this.absorbingModulesCount, totalEnergyOutput,
     //          totalHeatAbsorbing);
        return null;
    }
}
