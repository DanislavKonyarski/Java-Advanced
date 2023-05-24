package DefiningClassesLab;

public class BankAccount {

    private static final double defaultInterestRate = 0.02;
    private static double interestRate = defaultInterestRate;
    private static int countId = 1;
    private int id;
    private double balance;

    public BankAccount() {
        this.id = countId++;
    }

    static void setInterestRate(Double interestRate) {
        BankAccount.interestRate = interestRate;
    }

    void deposit(double amount) {
        this.balance += amount;
    }
    public int getId (){
        return this.id;
    }
    public void setBalance (double balance){
        this.balance = balance;
    }
    double getInterestRate(int year){
        return BankAccount.interestRate*year*this.balance;
    }

//    public BankAccount(int id, double balance,double interestRate){
//        this.id = id;
//        this.balance = balance;
//        this.interestRate = interestRate;
//    }


}

