package rpg_lab;

import rpg_lab.interfaces.Target;
import rpg_lab.interfaces.Weapon;

import java.util.List;

public class Dummy implements Target {

    private int health;
    private int experience;
    private List<Weapon> posssibleLoot;

    public Dummy(int health, int experience) {
        this.health = health;
        this.experience = experience;
    }

    public Weapon getLoot(){
        return this.posssibleLoot.get(0);
    }

    public int getHealth() {
        return this.health;
    }

    public void takeAttack(int attackPoints) {
        if (this.isDead()) {
            throw new IllegalStateException("Dummy is dead.");
        }

        this.health -= attackPoints;
    }

    public int giveExperience() {
        if (!this.isDead()) {
            throw new IllegalStateException("Target is not dead.");
        }

        return this.experience;
    }

    public boolean isDead() {
        return this.health <= 0;
    }
}
