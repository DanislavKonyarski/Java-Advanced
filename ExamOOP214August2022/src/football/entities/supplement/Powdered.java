package football.entities.supplement;

public class Powdered extends BaseSupplement{
//    It has 120 energy, and its price is 15.
    private static int ENERGY = 120;
    private static double PRICE = 15;
    public Powdered() {
        super(ENERGY, PRICE);
    }
}
