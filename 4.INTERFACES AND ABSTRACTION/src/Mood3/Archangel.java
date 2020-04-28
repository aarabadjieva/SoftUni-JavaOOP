package Mood3;

public class Archangel extends Character<String> {
    private static final String CHARACTER_TYPE = "Archangel";
    public Archangel(String username, int level, Integer specialPoints) {
        super(username, CHARACTER_TYPE, level, specialPoints);
    }


    @Override
    public String getHashedPassword() {
        StringBuilder name = new StringBuilder(this.getUsername()+"\"");
       return name
               .reverse().append("\"")
               .append((this.getUsername().length()+2)*21)
               .toString();
    }

    @Override
    public String toString() {
        return String.format("%s%n%d",super.toString(),
                (Integer)this.getSpecialPoints()*this.getLevel());
    }
}
