package solidLab.p02_OpenClosedPrinciple.p01_FileStream;

public class Music extends Entity{

    private String Artist;

    private String Album;

    public String getArtist() {
        return this.Artist;
    }

    protected void setArtist(String artist) {
        Artist = artist;
    }

    public String getAlbum() {
        return this.Album;
    }

    protected void setAlbum(String album) {
        Album = album;
    }
}
