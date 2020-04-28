package MilitaryElite;

import MilitaryElite.Interfaces.SpecialisedSoldier;

public abstract class SpecialisedSoldierImpl extends PrivateImpl implements SpecialisedSoldier {
    private String corps;

    public SpecialisedSoldierImpl(int id, String firstName, String lastName, double salary, String corps) {
        super(id, firstName, lastName, salary);
        this.setCorps(corps);
    }

    @Override
    public void setCorps(String corps) {
        if (!corps.equals("Airforces")&&!corps.equals("Marines")){
            throw new IllegalArgumentException();
        }
        this.corps = corps;
    }

    @Override
    public String getCorps() {
        return this.corps;
    }

    @Override
    public String print() {
        return String.format("%s%nCorps: %s",super.print(),this.getCorps());
    }
}
