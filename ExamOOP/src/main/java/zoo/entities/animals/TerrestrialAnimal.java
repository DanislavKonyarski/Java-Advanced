package zoo.entities.animals;

public class TerrestrialAnimal extends BaseAnimal{
    public TerrestrialAnimal(String name, String kind, double price) {
        super(name, kind, 5.5, price);
    }

    @Override
    public void eat() {
        double currentKg = getKg();
        setKg(currentKg + 5.7);
    }
}
