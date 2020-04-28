package Mood3;

public class Demon extends Character<Integer> {
    private static final String CHARACTER_TYPE = "Demon";
    public Demon(String username, int level, Double specialPoints) {
        super(username, CHARACTER_TYPE, level, specialPoints);
    }

    @Override
    public Integer getHashedPassword() {
        return (this.getUsername().length()+2)*217;
    }

    @Override
    public String toString() {
        return String.format("%s%n%.1f",super.toString(),
                (Double)this.getSpecialPoints()*this.getLevel());
    }
}
