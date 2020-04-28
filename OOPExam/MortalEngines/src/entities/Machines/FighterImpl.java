package entities.Machines;

import entities.interfaces.Fighter;

public class FighterImpl extends BaseMachine implements Fighter {
    private static double INITIAL_HEALTH = 200;
    private static final double ATTACK_POINTS_MODIFIER = 50.00;
    private static final double DEFENSE_POINTS_MODIFIER = 25.00;

    private boolean aggressiveMode;

    public FighterImpl(String name, double attackPoints, double defensePoints) {
        super(name, attackPoints+ATTACK_POINTS_MODIFIER, defensePoints-DEFENSE_POINTS_MODIFIER,INITIAL_HEALTH);
        this.aggressiveMode = true;

    }


    private void setAggressiveMode(boolean aggressiveMode) {
        this.aggressiveMode = aggressiveMode;
    }


    @Override
    public boolean getAggressiveMode() {
        return this.aggressiveMode;
    }

    @Override
    public void toggleAggressiveMode() {
        if (this.getAggressiveMode()){
            this.setAggressiveMode(false);
            this.setAttackPoints(this.getAttackPoints()-ATTACK_POINTS_MODIFIER);
            this.setDefensePoints(this.getDefensePoints()+DEFENSE_POINTS_MODIFIER);
        }else {
            this.setAggressiveMode(true);
            this.setAttackPoints(this.getAttackPoints()+ATTACK_POINTS_MODIFIER);
            this.setDefensePoints(this.getDefensePoints()-DEFENSE_POINTS_MODIFIER);
        }
    }

    @Override
    public String toString() {
        String aggressive = "ON";
        if (!this.getAggressiveMode()){
            aggressive = "OFF";
        }
        return String.format("%s\n *Aggressive Mode(%s)",super.toString(),aggressive);
    }
}
