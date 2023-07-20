package goldDigger.models.discoverer;

import goldDigger.models.museum.BaseMuseum;
import goldDigger.models.museum.Museum;

import static goldDigger.common.ExceptionMessages.DISCOVERER_ENERGY_LESS_THAN_ZERO;
import static goldDigger.common.ExceptionMessages.DISCOVERER_NAME_NULL_OR_EMPTY;

public abstract class  BaseDiscoverer implements Discoverer {

    private String name;
    private double energy;
    private Museum museum;

    public BaseDiscoverer(String name, double energy) {
        setName(name);
        setEnergy(energy);
        this.museum = new BaseMuseum();

    }

    protected void setEnergy(double energy) {
        if (energy<0){
            throw new IllegalArgumentException(DISCOVERER_ENERGY_LESS_THAN_ZERO);
        }
        this.energy = energy;
    }

    protected void setName(String name) {
        if (name==null||name.trim().isEmpty()){
            throw new NullPointerException(DISCOVERER_NAME_NULL_OR_EMPTY);
        }
        this.name = name;
    }
    @Override
    public void dig(){
        Math.max(0, energy-15);
    }
    @Override
    public boolean canDig(){
        if (energy>0){
            return true;
        }
        return false;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double getEnergy() {
        return energy;
    }

    @Override
    public Museum getMuseum() {
        return museum;
    }

    protected void setMuseum(Museum museum) {
        this.museum = museum;
    }
}
