package T1Vehicles;

import java.text.DecimalFormat;

public class Car implements Vehicles {

    private double fuelQuantity;
    private double litersPerKm;
    private final double EXPENS_SUMMER = 0.9;

    public Car(double fuelQuantity, double litersPerKm) {
        this.fuelQuantity = fuelQuantity;
        this.litersPerKm = litersPerKm + EXPENS_SUMMER;
    }

    @Override
    public void refuel(double fuel) {
        this.fuelQuantity += fuel;
    }

    @Override
    public String drive(double distance) {
        if (distance * litersPerKm <= fuelQuantity) {
            fuelQuantity -= litersPerKm * distance;
            DecimalFormat df = new DecimalFormat("##.##");
            return String.format("Car travelled %s km", df.format(distance));
        }
        return "Car needs refueling";
    }

    @Override
    public double getFuelQuantity() {
        return fuelQuantity;
    }
}
