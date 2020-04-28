package rpg_lab.interfaces;

import rpg_lab.Dummy;

public interface Weapon {
    public void attack(Target target);
    int getAttackPoints();
    int getDurabilityPoints();
}
