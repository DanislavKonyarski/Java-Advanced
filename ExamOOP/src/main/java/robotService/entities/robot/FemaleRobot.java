package robotService.entities.robot;

public class FemaleRobot extends BaseRobot{

    public FemaleRobot(String name, String kind, double price) {
        super(name, kind, 7, price);
    }
//    Can only live in SecondaryService!
    @Override
    public void eating() {
        int currentKilograms = getKilograms();
        setKilograms(currentKilograms+1);
    }
}
