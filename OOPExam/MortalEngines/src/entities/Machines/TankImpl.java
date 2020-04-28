package entities.Machines;

import entities.interfaces.Tank;

public class TankImpl extends BaseMachine implements Tank {
    private static double INITIAL_HEALTH = 100;
    private static final double ATTACK_POINTS_MODIFIER = 40.00;
    private static final double DEFENSE_POINTS_MODIFIER = 30.00;

    private boolean defenseMode;


    public TankImpl(String name, double attackPoints, double defensePoints) {
        super(name, attackPoints-ATTACK_POINTS_MODIFIER, defensePoints+DEFENSE_POINTS_MODIFIER, INITIAL_HEALTH);
        this.defenseMode = true;
    }

    private void setDefenseMode(boolean defenseMode) {
        this.defenseMode = defenseMode;
    }

    @Override
    public boolean getDefenseMode() {
        return this.defenseMode;
    }

    @Override
    public void toggleDefenseMode() {
        if (this.getDefenseMode()){
            this.setDefenseMode(false);
            this.setAttackPoints(this.getAttackPoints()+ATTACK_POINTS_MODIFIER);
            this.setDefensePoints(this.getDefensePoints()-DEFENSE_POINTS_MODIFIER);
        }else {
            this.setDefenseMode(true);
            this.setAttackPoints(this.getAttackPoints()-ATTACK_POINTS_MODIFIER);
            this.setDefensePoints(this.getDefensePoints()+DEFENSE_POINTS_MODIFIER);
        }
    }

    @Override
    public String toString() {
        String defense = "ON";
        if (!this.getDefenseMode()){
            defense = "OFF";
        }
        return String.format("%s\n *Defense Mode(%s)",super.toString(),defense);
    }
}
