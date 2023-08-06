package bank.entities.client;

public class Adult extends BaseClient{
    public Adult(String name, String ID, double income) {
        super(name, ID, 4, income);
    }

//    Can only live in CentralBank!
    @Override
    public void increase() {
        int currentInterest = getInterest();
        setInterest(currentInterest+2);
    }
}
