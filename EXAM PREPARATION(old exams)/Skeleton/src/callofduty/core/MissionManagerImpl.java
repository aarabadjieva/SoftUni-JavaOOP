package callofduty.core;

import callofduty.domain.agents.Novice;
import callofduty.interfaces.Agent;
import callofduty.interfaces.Mission;
import callofduty.interfaces.MissionManager;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class MissionManagerImpl implements MissionManager {
    private Map<String, Agent> agents;
    private MissionControlImpl missionControl;

    public MissionManagerImpl() {
        this.agents = new LinkedHashMap<>();
        this.missionControl = new MissionControlImpl();
    }

    @Override
    public String agent(List<String> arguments) {
        String id = arguments.get(0);
        String name = arguments.get(1);
        Agent agent = new Novice(id,name,0);
        this.agents.putIfAbsent(id,agent);
        return null;
    }

    @Override
    public String request(List<String> arguments) {
        String agentId = arguments.get(0);
        String missionId = arguments.get(1);
        Double missionRating = Double.parseDouble(arguments.get(2));
        Double missionBounty = Double.parseDouble(arguments.get(3));
        Mission mission = this.missionControl.generateMission(missionId,missionRating,missionBounty);
        this.agents.get(agentId).acceptMission(mission);
        return null;
    }

    @Override
    public String complete(List<String> arguments) {
        return null;
    }

    @Override
    public String status(List<String> arguments) {
        return null;
    }

    @Override
    public String over(List<String> arguments) {
        return null;
    }
}
