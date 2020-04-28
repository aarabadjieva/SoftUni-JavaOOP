import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] input = reader.readLine().split(";");
        Map<String, Team> teams = new LinkedHashMap<>();
        while (!input[0].equals("END")) {
            String teamName = input[1];
            try {
                switch (input[0]) {
                    case "Team":
                        Team team = new Team(teamName);
                        teams.put(teamName, team);
                        break;
                    case "Add":
                        if (!teams.containsKey(teamName)) {
                            throw new IllegalArgumentException("Team " + teamName + " does not exist.");
                        }
                        Player player = new Player(input[2], Integer.parseInt(input[3]),
                                Integer.parseInt(input[4]), Integer.parseInt(input[5]),
                                Integer.parseInt(input[6]), Integer.parseInt(input[7]));
                        teams.get(teamName).addPlayer(player);
                        break;
                    case "Remove":
                        String playerName = input[2];
                        teams.get(teamName).removePlayer(playerName);
                        break;
                    case "Rating":
                        if (!teams.containsKey(teamName)) {
                            throw new IllegalArgumentException("Team " + teamName + " does not exist.");
                        }
                        System.out.println(teamName +" - " + (int)teams.get(teamName).getRating());
                        break;
                }
            }catch (Exception ex){
                System.out.println(ex.getMessage());
            }

            input = reader.readLine().split(";");
        }
    }
}
