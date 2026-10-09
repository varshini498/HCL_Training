package service;

import model.BankAccount;

public class BankAccountService {

    public void depositMoney(BankAccount account, double amount) {
        account.deposit(amount);
    }

    public void withdrawMoney(BankAccount account, double amount) {
        account.withdraw(amount);
    }

    public void displayBalance(BankAccount account) {
        System.out.println(
            "Account holder: " + account.getAccountHolder()
        );

        System.out.println(
            "Account number: " + account.getAccountNumber()
        );

        System.out.println(
            "Current balance: ₹" + account.getBalance()
        );
    }
}