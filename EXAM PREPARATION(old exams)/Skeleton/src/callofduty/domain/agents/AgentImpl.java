package callofduty.domain.agents;

import callofduty.interfaces.Mission;

import java.util.LinkedHashMap;
import java.util.Map;

public abstract class AgentImpl implements callofduty.interfaces.Agent {

    private String id;
    private String name;
    private double rating;
    private Map<String, Mission> missions;

    protected AgentImpl(String id, String name, double rating) {
        this.id = id;
        this.name = name;
        this.rating = rating;
        this.missions = new LinkedHashMap<>();
    }

    @Override
    public void acceptMission(Mission mission) {
        this.missions.putIfAbsent(mission.getId(),mission);
    }

    @Override
    public void completeMissions() {

    }

    @Override
    public String getId() {
        return null;
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public Double getRating() {
        return null;
    }
}
