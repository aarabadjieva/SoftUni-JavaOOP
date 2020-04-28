package OnlineRadio;

import java.util.List;

public class SongDatabase {
    private List<Song> songs;

    public SongDatabase(List<Song> songs) {
        this.songs = songs;
    }

    public void addSong(Song song){
        this.songs.add(song);
    }

    public int size(){
        return this.songs.size();
    }

    public String getTotalLengthOfSongs(){
        int mins = 0;
        int secs = 0;
        for (Song song:this.songs
             ) {
            int minsOfSong = Integer.parseInt(song.getLength().split(":")[0]);
            int secsOfSong = Integer.parseInt(song.getLength().split(":")[1]);
            mins+=minsOfSong;
            secs+=secsOfSong;
        }
        int temp = secs/60;
        secs = secs%60;
        mins+=temp;
        temp = mins/60;
        mins = mins%60;
        StringBuilder time = new StringBuilder();
        time.append("Playlist length: ")
        .append(temp).append("h ")
        .append(mins).append("m ")
        .append(secs).append("s");
        return time.toString();
    }
}
