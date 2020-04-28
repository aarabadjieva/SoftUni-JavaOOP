import java.awt.dnd.InvalidDnDOperationException;
import java.util.ArrayList;
import java.util.List;

public class Team {
    private String name;
    private List<Player> players;

    public Team(String name) {
        this.setName(name);
        this.players = new ArrayList<>();
    }

    private void setName(String name) {
        if (name.trim().isEmpty()) {
            throw new IllegalArgumentException("A name should not be empty.");
        }
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void addPlayer(Player player) {
        this.players.add(player);
    }

    public void removePlayer(String player) {
        int index = -1;
        for (Player p:this.players
             ) {
            if (p.getName().equals(player)){
                index = this.players.indexOf(p);
            }
        }
        if (index == -1) {
            throw new InvalidDnDOperationException("Player " + player +
                    " is not in " + this.name + " team.");
        }
        this.players.remove(index);
    }

    public double getRating(){
        double rating = 0;
        for (Player player: this.players
             ) {
            rating+=player.overallSkillLevel();
        }
        rating = rating/(1.00*this.players.size());
        return Math.round(rating);
    }
}
