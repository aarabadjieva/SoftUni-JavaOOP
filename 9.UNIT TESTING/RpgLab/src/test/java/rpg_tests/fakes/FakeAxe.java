package rpg_tests.fakes;

import rpg_lab.Dummy;
import rpg_lab.interfaces.Target;
import rpg_lab.interfaces.Weapon;

import static rpg_tests.Constants.BASE_ATTACK;

public class FakeAxe implements Weapon {
    public void attack(Target target) {
    }

    public int getAttackPoints() {
        return BASE_ATTACK;
    }

    public int getDurabilityPoints() {
        return 0;
    }
}
