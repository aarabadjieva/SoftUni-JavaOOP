package MilitaryElite;

import MilitaryElite.Interfaces.Commando;

import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

public class CommandoImpl extends SpecialisedSoldierImpl implements Commando {
    private Set<Mission> missions;

    public CommandoImpl(int id, String firstName, String lastName, double salary, String corps) {
        super(id, firstName, lastName, salary, corps);
        this.missions = new LinkedHashSet<>();
    }

    @Override
    public void completeMission(Mission mission) {
      mission.setState("Complete");
    }

    @Override
    public void addMission(Mission mission) {
        this.missions.add(mission);
    }

    @Override
    public String print() {
        StringBuilder commandoString = new StringBuilder(super.print());
        commandoString.append(System.lineSeparator()).append("Missions:");
        for (Mission mission:this.missions
        ) {
            commandoString.append(System.lineSeparator()).append("  "+mission.toString());
        }
        return commandoString.toString();
    }
}
