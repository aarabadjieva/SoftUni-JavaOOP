package pr0304Barracks.core.commands;

import pr0304Barracks.contracts.Inject;
import pr0304Barracks.contracts.Repository;
import pr0304Barracks.contracts.UnitFactory;

public class Retire extends Command {

    @Inject
    private Repository repository;

    public Retire(String[] data) {
        super(data);
    }

    @Override
    public String execute() {
        String unitType = this.getData()[1];
        String output = unitType;
        try {
            this.repository.removeUnit(unitType);
            output = unitType + " retired!";
        }catch (Exception ex){
            output = ex.getMessage();
        }
        return output;
    }
}
