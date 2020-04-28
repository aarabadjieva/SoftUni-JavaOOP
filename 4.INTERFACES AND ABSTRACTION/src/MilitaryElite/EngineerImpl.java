package MilitaryElite;

import MilitaryElite.Interfaces.Engineer;

import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

public class EngineerImpl extends SpecialisedSoldierImpl implements Engineer {
    private Set<Repair> repairs;

    public EngineerImpl(int id, String firstName, String lastName, double salary, String corps) {
        super(id, firstName, lastName, salary, corps);
        this.repairs = new LinkedHashSet<>();
    }

    @Override
    public void addRepair(Repair repair) {
        this.repairs.add(repair);
    }

    @Override
    public String print() {
        StringBuilder engineerString = new StringBuilder(super.print());
        engineerString.append(System.lineSeparator()).append("Repairs:");
        for (Repair repair:this.repairs
        ) {
            engineerString.append(System.lineSeparator()).append("  "+repair.toString());
        }
        return engineerString.toString();
    }
}
