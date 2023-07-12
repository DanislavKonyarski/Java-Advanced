package T2VehiclesExtension;

import java.text.DecimalFormat;

public class Car extends Venicles {

    private final double EXPENS_SUMMER = 0.9;

    public Car(double fuelQuantity, double litersPerKm, double tankCapacity) {
        super(fuelQuantity, litersPerKm, tankCapacity);
        setLitersPerKm(litersPerKm+EXPENS_SUMMER);
    }
}
