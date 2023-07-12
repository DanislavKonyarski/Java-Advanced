package T2VehiclesExtension;

import java.text.DecimalFormat;

public class Bus extends Venicles {

    private final double WHITH_PEOPLE = 1.4;

    public Bus(double fuelQuantity, double litersPerKm, double tankCapacity) {
        super(fuelQuantity, litersPerKm, tankCapacity);
        setLitersPerKm(litersPerKm+WHITH_PEOPLE);
    }


    public String DriveEmpty(double distance) {
        if (distance * (getLitersPerKm() - WHITH_PEOPLE) <= getFuelQuantity()) {
            setFuelQuantity((getLitersPerKm() - WHITH_PEOPLE) * distance);
            DecimalFormat df = new DecimalFormat("##.##");
            return String.format("%s travelled %s km", getClass().getSimpleName(), df.format(distance));
        }
        return String.format("%s needs refueling", getClass().getSimpleName());
    }
}
