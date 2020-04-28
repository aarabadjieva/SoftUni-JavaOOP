package rpg_tests.fakes;

import rpg_lab.interfaces.Target;
import rpg_lab.interfaces.Weapon;

import static rpg_tests.Constants.BASE_XP;

public class FakeTarget implements Target {
    public void takeAttack(int attackPoints) {

    }

    public int getHealth() {
        return 0;
    }

    public int giveExperience() {
        return BASE_XP;
    }

    public boolean isDead() {
        return true;
    }

    public Weapon getLoot() {
        return null;
    }
}
