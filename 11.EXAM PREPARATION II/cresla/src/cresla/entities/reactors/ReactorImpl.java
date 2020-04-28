package cresla.entities.reactors;

import cresla.entities.containers.ModuleContainer;
import cresla.interfaces.AbsorbingModule;
import cresla.interfaces.EnergyModule;
import cresla.interfaces.Reactor;

public abstract class ReactorImpl implements Reactor {
    private int id;
    private ModuleContainer moduleContainer;

     ReactorImpl(int id, int capacity) {
        this.id = id;
        this.moduleContainer = new ModuleContainer(capacity);
    }

    @Override
    public long getTotalEnergyOutput() {
        return this.moduleContainer.getTotalEnergyOutput();
    }

    @Override
    public long getTotalHeatAbsorbing() {
        return this.moduleContainer.getTotalHeatAbsorbing();
    }

    @Override
    public int getModuleCount() {
        return this.moduleContainer.getModuleByInputCount();
    }

    @Override
    public void addEnergyModule(EnergyModule energyModule) {
         this.moduleContainer.addEnergyModule(energyModule);
    }

    @Override
    public void addAbsorbingModule(AbsorbingModule absorbingModule) {
         this.moduleContainer.addAbsorbingModule(absorbingModule);
    }

    @Override
    public int getId() {
        return this.id;
    }

    @Override
    public String toString() {
        long totalEnergy = this.getTotalEnergyOutput();
        if (isOverheated()){
            totalEnergy = 0;
        }
        return  String.format("%s – %d%n" +
                        "Energy Output: %d%n" +
                        "Heat Absorbing: %d%n" +
                        "Modules: %d",this.getClass().getSimpleName(),
                this.getId(),totalEnergy,
                this.getTotalHeatAbsorbing(),
                this.getModuleCount());
    }

    private boolean isOverheated(){
        return this.getTotalEnergyOutput() > this.getTotalHeatAbsorbing();
    }
}
