package bank.core;

import bank.entities.bank.Bank;
import bank.entities.bank.BranchBank;
import bank.entities.bank.CentralBank;
import bank.entities.client.Client;
import bank.entities.client.Student;
import bank.entities.loan.Loan;
import bank.entities.loan.MortgageLoan;
import bank.entities.loan.StudentLoan;
import bank.repositories.LoanRepository;

import java.util.ArrayList;
import java.util.Collection;

import static bank.common.ConstantMessages.*;
import static bank.common.ExceptionMessages.*;

public class ControllerImpl implements Controller {

    private LoanRepository loans;
    private Collection<Bank> banks;

    public ControllerImpl() {
        this.loans = new LoanRepository();
        this.banks = new ArrayList<>();
    }

    @Override
    public String addBank(String type, String name) {
        Bank bank = null;
        if (type.equals("CentralBank")) {
            bank = new CentralBank(name);
        } else if (type.equals("BranchBank")) {
            bank = new BranchBank(name);
        } else {
            throw new IllegalArgumentException(INVALID_BANK_TYPE);
        }
        banks.add(bank);
        return String.format(SUCCESSFULLY_ADDED_BANK_OR_LOAN_TYPE, type);
    }

    @Override
    public String addLoan(String type) {
        if ("StudentLoan".equals(type)) {
            loans.addLoan(new StudentLoan());
            return String.format(SUCCESSFULLY_ADDED_BANK_OR_LOAN_TYPE, type);
        } else if ("MortgageLoan".equals(type)) {
            loans.addLoan(new MortgageLoan());
            return String.format(SUCCESSFULLY_ADDED_BANK_OR_LOAN_TYPE, type);
        } else {
            throw new IllegalArgumentException(INVALID_LOAN_TYPE);
        }
    }

    @Override
    public String returnedLoan(String bankName, String loanType) {
        Loan loan = loans.findFirst(loanType);
        if (loan == null) {
            throw new IllegalArgumentException(String.format(NO_LOAN_FOUND, loanType));
        } else {
            for (Bank bank : banks) {
                if (bank.getName().equals(bankName)) {
                    bank.addLoan(loan);
                    break;
                }
            }
            loans.removeLoan(loan);
            return String.format(SUCCESSFULLY_ADDED_CLIENT_OR_LOAN_TO_BANK, loanType, bankName);
        }
    }

    @Override
    public String addClient(String bankName, String clientType, String clientName, String clientID, double income) {
        if ("Student".equals(clientType)) {
            for (Bank bank : banks) {
                if (bank.getName().equals(bankName)) {
                    if (bank.getClass().getSimpleName().equals("BranchBank")) {
                        bank.addClient(new Student(clientName, clientID, income));
                        return String.format(SUCCESSFULLY_ADDED_CLIENT_OR_LOAN_TO_BANK, clientType, bankName);
                    } else {
                        return UNSUITABLE_BANK;
                    }
                }
            }
        } else if ("Adult".equals(clientType)) {
                for (Bank bank : banks) {
                    if (bank.getName().equals(bankName)) {
                        if (bank.getClass().getSimpleName().equals("CentralBank")) {
                            bank.addClient(new Student(clientName, clientID, income));
                            return String.format(SUCCESSFULLY_ADDED_CLIENT_OR_LOAN_TO_BANK, clientType, bankName);
                        } else {
                            return UNSUITABLE_BANK;
                        }
                    }
                }
        } else {
            throw new IllegalArgumentException(INVALID_CLIENT_TYPE);
        }
        return null;
    }

    @Override
    public String finalCalculation(String bankName) {
        double incomeSum = 0;
        double loansSum = 0;
        for (Bank bank : banks) {
            if (bank.getName().equals(bankName)) {
                incomeSum = bank.getClients().stream().mapToDouble(Client::getIncome).sum();
                loansSum = bank.getLoans().stream().mapToDouble(Loan::getAmount).sum();
            }
        }
        return String.format(FUNDS_BANK,bankName,incomeSum+loansSum);
    }

    @Override
    public String getStatistics() {
        StringBuilder stringBuilder = new StringBuilder();
        banks.forEach(b-> stringBuilder.append(b.getStatistics()).append(System.lineSeparator()));
        return String.valueOf(stringBuilder).trim();
    }
}
