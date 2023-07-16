package T2VehiclesExtension;


import java.text.DecimalFormat;

public class Truck extends Venicles {
    private final double EXPENS_SUMMER = 1.6;

    public Truck(double fuelQuantity, double litersPerKm, double tankCapacity) {
        super(fuelQuantity, litersPerKm, tankCapacity);
        setLitersPerKm(litersPerKm+EXPENS_SUMMER);
    }
    @Override
    public void refuel(double fuel) {
        if (fuel <= 0) {
            throw new IllegalArgumentException("Fuel must be a positive number");
        } else if (fuel + super.getFuelQuantity() <= super.getTankCapacity()) {
            super.setFuelQuantity(super.getFuelQuantity()+(fuel*0.95));
        } else {
            throw new IllegalArgumentException("Cannot fit fuel in tank");
        }
    }
}
