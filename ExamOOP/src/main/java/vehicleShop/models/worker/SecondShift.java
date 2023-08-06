package vehicleShop.models.worker;

public class SecondShift extends BaseWorker{
    public SecondShift(String name) {
        super(name, 70);
    }
    @Override
    public void working() {
        int currentStrength = getStrength();
        currentStrength = getStrength()-5;
        if (currentStrength<0){
            setStrength(0);
        }else {
            setStrength(currentStrength);
        }
    }

}
