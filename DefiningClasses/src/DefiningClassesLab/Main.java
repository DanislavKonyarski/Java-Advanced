package DefiningClassesLab;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        List<BankAccount> bankAccounts = new ArrayList<>();
        while (!input.equals("End")){
            String[] commands = input.split(" ");
            if (commands[0].equals("Create")){
                bankAccounts.add(new BankAccount());
                System.out.println("Account ID"+ bankAccounts.get(bankAccounts.size()-1).getId()+" created");
            } else if (commands[0].equals("Deposit")) {
                if (Integer.parseInt(commands[1])<=bankAccounts.size()){
                    bankAccounts.get(Integer.parseInt(commands[1])-1).deposit(Double.parseDouble(commands[2]));
                    System.out.printf("Deposited %s to ID%s%n",commands[2],commands[1]);
                }else {
                    System.out.println("Account does not exist");
                }
            } else if (commands[0].equals("SetInterest")) {
                BankAccount.setInterestRate(Double.parseDouble(commands[1]));
            } else if (commands[0].equals("GetInterest")) {
                if (Integer.parseInt(commands[1])<=bankAccounts.size()){
                    double balance = bankAccounts.get(Integer.parseInt(commands[1])-1).getInterestRate(Integer.parseInt(commands[2]));
                    System.out.printf("%.2f%n",balance);
                }else {
                    System.out.println("Account does not exist");
                }
            }


            input = scanner.nextLine();
        }
    }
}