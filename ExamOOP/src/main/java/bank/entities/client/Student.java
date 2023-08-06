package bank.entities.client;

public class Student extends BaseClient{
    public Student(String name, String ID, double income) {
        super(name, ID, 2, income);
    }

//    Can only live in BranchBank!
    @Override
    public void increase() {
        int currentInterest = getInterest();
        setInterest(currentInterest+1);
    }
}
