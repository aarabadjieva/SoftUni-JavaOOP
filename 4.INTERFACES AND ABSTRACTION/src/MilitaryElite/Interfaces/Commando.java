package MilitaryElite.Interfaces;

import MilitaryElite.Mission;

public interface Commando extends SpecialisedSoldier {
    void completeMission(Mission mission);
    void addMission(Mission mission);
}
