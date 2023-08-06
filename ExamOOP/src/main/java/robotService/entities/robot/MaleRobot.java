package robotService.entities.robot;

public class MaleRobot extends BaseRobot{


    public MaleRobot(String name, String kind, double price) {
        super(name, kind, 9, price);
    }
    //Can only live in MainService!
    @Override
    public void eating() {
       int currentKilograms = getKilograms();
       setKilograms(currentKilograms+3);
    }
}
