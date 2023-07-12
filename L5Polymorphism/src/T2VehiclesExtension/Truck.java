package T2VehiclesExtension;


import java.text.DecimalFormat;

public class Truck extends Venicles {
    private final double EXPENS_SUMMER = 1.6;

    public Truck(double fuelQuantity, double litersPerKm, double tankCapacity) {
        super(fuelQuantity, litersPerKm, tankCapacity);
        setLitersPerKm(litersPerKm+EXPENS_SUMMER);
    }
}
