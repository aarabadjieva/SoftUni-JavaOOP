import core.MachineFactoryImpl;
import core.MachinesManagerImpl;

import core.PilotFactoryImpl;
import core.interfaces.MachineFactory;
import core.interfaces.PilotFactory;
import core.interfaces.MachinesManager;
import entities.interfaces.Machine;
import entities.interfaces.Pilot;


import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        PilotFactory pilotFactory = new PilotFactoryImpl();
        MachineFactory machineFactory = new MachineFactoryImpl();
        Map<String, Pilot> pilots = new LinkedHashMap<>();
        Map<String, Machine> machines = new LinkedHashMap<>();

        Scanner scanner = new Scanner(System.in);

        MachinesManager machinesManager = new MachinesManagerImpl(pilotFactory, machineFactory, pilots, machines);

        String input = scanner.nextLine();
        while (!input.equals("Over")) {
            String[] data = input.split("\\s");
            String cmd = data[0];
            String result = "";
            switch (cmd) {
                case "Hire":
                    String pilotName = data[1];
                    result = machinesManager.hirePilot(pilotName);
                    break;
                case "ManufactureTank":
                    String tankName = data[1];
                    double attackPoints = Double.parseDouble(data[2]);
                    double defensePoints = Double.parseDouble(data[3]);
                    result = machinesManager.manufactureTank(tankName, attackPoints, defensePoints);
                    break;
                case "ManufactureFighter":
                    String fighterName = data[1];
                    attackPoints = Double.parseDouble(data[2]);
                    defensePoints = Double.parseDouble(data[3]);
                    result = machinesManager.manufactureFighter(fighterName, attackPoints, defensePoints);
                    break;
                case "Engage":
                    pilotName = data[1];
                    String machineName = data[2];
                    result = machinesManager.engageMachine(pilotName, machineName);
                    break;
                case "Attack":
                    String attacker = data[1];
                    String defender = data[2];
                    result = machinesManager.attackMachines(attacker,defender);
                    break;
                case "AggressiveMode":
                    fighterName = data[1];
                    result = machinesManager.toggleFighterAggressiveMode(fighterName);
                    break;
                case "DefenseMode":
                    tankName = data[1];
                    result = machinesManager.toggleTankDefenseMode(tankName);
                    break;
                case "Report":
                    pilotName = data[1];
                    result = machinesManager.pilotReport(pilotName);
                    break;
            }
            System.out.println(result);
            input = scanner.nextLine();
        }

    }
}
