package zoo.entities.animals;

public class AquaticAnimal extends BaseAnimal{
    public AquaticAnimal(String name, String kind, double price) {
        super(name, kind, 2.50, price);
    }

//    Can only live in WaterArea!
    @Override
    public void eat() {
        double currentKg = getKg();
        setKg(currentKg+7.5);
    }
}
