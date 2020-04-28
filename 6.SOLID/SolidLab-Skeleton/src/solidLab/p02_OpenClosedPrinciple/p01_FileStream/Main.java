package solidLab.p02_OpenClosedPrinciple.p01_FileStream;

public class Main {
    public static void main(String[] args) {
        Music music = new Music();
        Progress progress = new Progress(music);
        progress.getCurrentPercent();
    }
}

