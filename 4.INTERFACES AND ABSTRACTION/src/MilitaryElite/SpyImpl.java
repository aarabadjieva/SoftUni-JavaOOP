package MilitaryElite;

import MilitaryElite.Interfaces.Soldier;
import MilitaryElite.Interfaces.Spy;

public class SpyImpl extends SoldierImpl implements Spy {
    private String codeNumber;

    public SpyImpl(int id, String firstName, String lastName, String codeNumber) {
        super(id, firstName, lastName);
        this.codeNumber = codeNumber;
    }

    @Override
    public String print() {
        return String.format("%s%nCode Number: %s",super.print(),this.getCodeNumber());
    }

    @Override
    public String getCodeNumber() {
        return this.codeNumber;
    }
}
