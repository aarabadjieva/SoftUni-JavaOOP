package cresla.entities.reactors;

public class CryoReactor extends ReactorImpl{
    private int cryoProductionindex;

   public CryoReactor(int id, int cryoProductionindex , int capacity ) {
        super(id, capacity);
        this.cryoProductionindex = cryoProductionindex;
    }

    @Override
    public long getTotalEnergyOutput() {
        return super.getTotalEnergyOutput()*this.cryoProductionindex;
    }

}
