package callofduty.domain.missions;

import callofduty.interfaces.Mission;

public abstract class MissionImpl implements Mission {

    private String id;
    private double rating;
    private double bounty;

    protected MissionImpl(String id, double rating, double bounty) {
        this.id = id;
        this.rating = rating;
        this.bounty = bounty;
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
    public Double getRating() {
        return null;
    }
}
