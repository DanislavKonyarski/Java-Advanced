package T1Vehicles;

import java.text.DecimalFormat;

public class Truck implements Vehicles {

    private double fuelQuantity;
    private double litersPerKm;
    private final double EXPENS_SUMMER = 1.6;

    public Truck(double fuelQuantity, double litersPerKm) {
        this.fuelQuantity = fuelQuantity;
        this.litersPerKm = litersPerKm + EXPENS_SUMMER;
    }

    @Override
    public void refuel(double fuel) {
        this.fuelQuantity += fuel * 0.95;
    }

    @Override
    public String drive(double distance) {
        if (distance * litersPerKm <= fuelQuantity) {
            fuelQuantity -= litersPerKm * distance;
            DecimalFormat df = new DecimalFormat("##.##");
            return String.format("Truck travelled %s km", df.format(distance));
        }
        return "Truck needs refueling";
    }

    @Override
    public double getFuelQuantity() {
        return fuelQuantity;
    }
}
