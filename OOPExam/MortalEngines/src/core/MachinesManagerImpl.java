package core;

import core.interfaces.MachineFactory;
import core.interfaces.PilotFactory;
import core.interfaces.MachinesManager;

import entities.Machines.FighterImpl;
import entities.Machines.TankImpl;
import entities.interfaces.Fighter;
import entities.interfaces.Machine;
import entities.interfaces.Pilot;

import java.util.Map;

public class MachinesManagerImpl implements MachinesManager {

    private PilotFactory pilotFactory;
    private MachineFactory machineFactory;
    private Map<String, Pilot> pilots;
    private Map<String, Machine> machines;

    public MachinesManagerImpl(PilotFactory pilotFactory, MachineFactory machineFactory, Map<String, Pilot> pilots, Map<String, Machine> machines) {
        this.pilotFactory = pilotFactory;
        this.machineFactory = machineFactory;
        this.pilots = pilots;
        this.machines = machines;
    }


    @Override
    public String hirePilot(String name) {
        if (this.pilots.containsKey(name)) {
            return String.format("Pilot %s is hired already", name);
        }

        this.pilots.put(name, this.pilotFactory.createPilot(name));
        return String.format("Pilot %s hired", name);
    }

    @Override
    public String manufactureTank(String name, double attackPoints, double defensePoints) {
        if (this.machines.containsKey(name)) {
            return String.format("Machine %s is manufactured already", name);
        }
        this.machines.put(name, this.machineFactory.createTank(name, attackPoints, defensePoints));
        return String.format("Tank %s manufactured - attack: %.2f; defense: %.2f", name, attackPoints, defensePoints);
    }

    @Override
    public String manufactureFighter(String name, double attackPoints, double defensePoints) {
        if (this.machines.containsKey(name)) {
            return String.format("Machine %s is manufactured already", name);
        }
        this.machines.put(name, this.machineFactory.createFighter(name, attackPoints, defensePoints));
        return String.format("Fighter %s manufactured - attack: %.2f; defense: %.2f", name, attackPoints, defensePoints);
    }

    @Override
    public String engageMachine(String selectedPilotName, String selectedMachineName) {
        if (!this.pilots.containsKey(selectedPilotName)) {
            return String.format("Pilot %s could not be found", selectedPilotName);
        }
        if (!this.machines.containsKey(selectedMachineName)) {
            return String.format("Machine %s could not be found", selectedMachineName);
        }

        Pilot pilot = this.pilots.get(selectedPilotName);
        Machine machine = this.machines.get(selectedMachineName);
        if (machine.getPilot() != null) {
            return String.format("Machine %s is already occupied", machine.getName());
        }
        machine.setPilot(pilot);
        pilot.addMachine(machine);
        return String.format("Pilot %s engaged machine %s", pilot.getName(), machine.getName());
    }

    @Override
    public String attackMachines(String attackingMachineName, String defendingMachineName) {
        if (!this.machines.containsKey(attackingMachineName)) {
            return String.format("Machine %s could not be found", attackingMachineName);
        }
        if (!this.machines.containsKey(defendingMachineName)) {
            return String.format("Machine %s could not be found", defendingMachineName);
        }
        Machine attackingMachine = this.machines.get(attackingMachineName);
        Machine defendingMachine = this.machines.get(defendingMachineName);
        attackingMachine.attack(defendingMachineName);
        if (attackingMachine.getAttackPoints() > defendingMachine.getDefensePoints()) {
            if (defendingMachine.getHealthPoints() - attackingMachine.getAttackPoints() <= 0) {
                defendingMachine.setHealthPoints(0);
            }
        }
        return String.format("Machine %s was attacked by machine %s - current health: %.2f", defendingMachineName,
                attackingMachineName, defendingMachine.getHealthPoints());
    }

    @Override
    public String pilotReport(String pilotName) {
        if (!this.pilots.containsKey(pilotName)) {
            return String.format("Pilot %s could not be found", pilotName);
        }
        Pilot pilot = this.pilots.get(pilotName);
        return pilot.report();
    }

    @Override
    public String toggleFighterAggressiveMode(String fighterName) {
        if (!this.machines.containsKey(fighterName)) {
            return String.format("Machine %s could not be found", fighterName);
        }
        Machine machine = this.machines.get(fighterName);
        if (!machine.getClass().getSimpleName().contains("Fighter")) {
            return String.format("Machine %s does not support this operation", fighterName);
        }
        ((FighterImpl) this.machines.get(fighterName)).toggleAggressiveMode();
        return String.format("Fighter %s toggled aggressive mode", fighterName);
    }

    @Override
    public String toggleTankDefenseMode(String tankName) {
        if (!this.machines.containsKey(tankName)) {
            return String.format("Machine %s could not be found", tankName);
        }
        Machine machine = this.machines.get(tankName);
        if (!machine.getClass().getSimpleName().contains("Tank")) {
            return String.format("Machine %s does not support this operation", tankName);
        }
        ((TankImpl) this.machines.get(tankName)).toggleDefenseMode();
        return String.format("Tank %s toggled defense mode", tankName);
    }
}
