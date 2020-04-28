package OnlineRadio;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n =Integer.parseInt(scanner.nextLine());
        SongDatabase database = new SongDatabase(new ArrayList<>());
        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split(";");
            try {
                Song song = new Song(input[0],input[1],input[2]);
                database.addSong(song);
                System.out.println("Song added.");
            }catch (InvalidSongException ex){
                System.out.println(ex.getMessage());
            }
        }
        System.out.printf("Songs added: %d\n" +
                "Playlist length: %s\n",database.size(),database.getTotalLengthOfSongs());
    }
}
