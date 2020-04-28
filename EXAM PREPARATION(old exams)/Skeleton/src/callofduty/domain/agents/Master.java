package callofduty.domain.agents;

import callofduty.interfaces.Agent;
import callofduty.interfaces.BountyAgent;
import callofduty.interfaces.Mission;

import java.util.LinkedHashMap;
import java.util.Map;

public class Master extends Novice implements BountyAgent {

    private double bounty;

    public Master(String id, String name, double rating, double bounty) {
        super(id, name, rating);
        this.bounty = bounty;
    }


    @Override
    public void acceptMission(Mission mission) {

    }

    @Override
    public void completeMissions() {

    }

    @Override
    public Double getBounty() {
        return null;
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
