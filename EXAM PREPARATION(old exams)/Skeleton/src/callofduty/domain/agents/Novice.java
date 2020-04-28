package callofduty.domain.agents;

import callofduty.interfaces.Agent;
import callofduty.interfaces.Mission;

import java.util.LinkedHashMap;
import java.util.Map;

public class Novice extends AgentImpl {

    private String id;
    private String name;
    private double rating;
    private Map<String, Mission> missions;


    public Novice(String id, String name, double rating) {
        super(id, name, rating);
    }
}
