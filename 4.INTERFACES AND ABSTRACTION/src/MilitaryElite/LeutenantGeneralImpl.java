package MilitaryElite;

import MilitaryElite.Interfaces.LeutenantGenerall;
import MilitaryElite.Interfaces.Private;

import java.util.Comparator;
import java.util.LinkedHashSet;
import java.util.Set;

public class LeutenantGeneralImpl extends PrivateImpl implements LeutenantGenerall {
    private Set<PrivateImpl> privates;

    public LeutenantGeneralImpl(int id, String firstName, String lastName, double salary) {
        super(id, firstName, lastName, salary);
        this.privates = new LinkedHashSet<>();
    }

    @Override
    public void addPrivate(PrivateImpl privateSoldier) {
        this.privates.add(privateSoldier);
    }

    @Override
    public String print() {
        StringBuilder leutenantString = new StringBuilder(super.print());
        leutenantString.append(System.lineSeparator()).append("Privates:");
        this.privates.stream().sorted(Comparator.comparing(SoldierImpl::getId).reversed()).forEach(p->leutenantString.append(System.lineSeparator()).append("  "+p.print()));
        return leutenantString.toString();
    }
}
