package T2VehiclesExtension;

import java.text.DecimalFormat;

public abstract class Venicles implements Transport {
    private double fuelQuantity;
    private double litersPerKm;
    private double tankCapacity;

    public Venicles(double fuelQuantity, double litersPerKm, double tankCapacity) {
        this.litersPerKm = litersPerKm ;
        setTanCapacity(tankCapacity);
        setFuelQuantity(fuelQuantity);
    }

    @Override
    public void refuel(double fuel) {
        if (fuel <= 0) {
            throw new IllegalArgumentException("Fuel must be a positive number");
        } else if (fuel + fuelQuantity <= tankCapacity) {
            this.fuelQuantity += fuel;
        } else {
            throw new IllegalArgumentException("Cannot fit fuel in tank");
        }
    }

    @Override
    public String drive(double distance) {
        if (distance * litersPerKm <= fuelQuantity) {
            fuelQuantity -= litersPerKm * distance;
            DecimalFormat df = new DecimalFormat("##.##");
            return String.format("%s travelled %s km", getClass().getSimpleName(), df.format(distance));
        }
        return String.format("%s needs refueling", getClass().getSimpleName());
    }

    @Override
    public double getFuelQuantity() {
        return fuelQuantity;
    }


    private void setTanCapacity(double tankCapacity) {
        if (tankCapacity < 0) {
            throw new IllegalArgumentException("Fuel must be a positive number");
        }
        this.tankCapacity = tankCapacity;
    }

    protected double getLitersPerKm() {
        return litersPerKm;
    }


    protected double getTankCapacity() {
        return tankCapacity;
    }

    protected void setFuelQuantity(double fuelQuantity) {
            this.fuelQuantity = fuelQuantity;
    }

    protected void setLitersPerKm(double litersPerKm) {
        this.litersPerKm = litersPerKm;
    }
}
