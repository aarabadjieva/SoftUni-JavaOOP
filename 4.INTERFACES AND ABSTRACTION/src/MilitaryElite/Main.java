package MilitaryElite;

import MilitaryElite.Interfaces.Private;
import MilitaryElite.Interfaces.Soldier;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Soldier> soldiers = new ArrayList<>();
        String line = scanner.nextLine();
        while (!line.equals("End")) {
            String[] info = line.split("\\s");
            int id = Integer.parseInt(info[1]);
            String firstName = info[2];
            String lastName = info[3];
            switch (info[0]) {
                case "Private":
                    double salary = Double.parseDouble(info[4]);
                    PrivateImpl privateSoldier = new PrivateImpl(id, firstName, lastName, salary);
                    soldiers.add(privateSoldier);
                    break;
                case "LeutenantGeneral":
                    salary = Double.parseDouble(info[4]);
                    LeutenantGeneralImpl leutenantGeneral = new LeutenantGeneralImpl(id, firstName, lastName, salary);
                    for (int i = 5; i < info.length; i++) {
                        for (Soldier soldier : soldiers
                        ) {
                            if (soldier.getId() == Integer.parseInt(info[i])) {
                                leutenantGeneral.addPrivate((PrivateImpl) soldier);
                            }
                        }
                    }
                    soldiers.add(leutenantGeneral);
                    break;
                case "Engineer":
                    salary = Double.parseDouble(info[4]);
                    try {
                        EngineerImpl engineer = new EngineerImpl(id, firstName, lastName, salary, info[5]);
                        for (int i = 6; i < info.length; i += 2) {
                            Repair repair = new Repair(info[i], Integer.parseInt(info[i + 1]));
                            engineer.addRepair(repair);
                        }
                        soldiers.add(engineer);
                    } catch (IllegalArgumentException ex) {
                    }
                    break;
                case "Commando":
                    salary = Double.parseDouble(info[4]);
                    try {
                        CommandoImpl commando = new CommandoImpl(id, firstName, lastName, salary, info[5]);
                        for (int i = 6; i < info.length; i += 2) {
                            try {
                                Mission mission = new Mission(info[i], info[i + 1]);
                                commando.addMission(mission);
                            } catch (IllegalArgumentException ex) {

                            }
                        }
                        soldiers.add(commando);
                    } catch (IllegalArgumentException ex) {
                    }
                    break;
                case "Spy":
                    SpyImpl spy = new SpyImpl(id, firstName, lastName, info[4]);
                    soldiers.add(spy);
            }
            line = scanner.nextLine();
        }

        for (Soldier soldier:soldiers
             ) {
            System.out.println(soldier.print());
        }
    }
}
