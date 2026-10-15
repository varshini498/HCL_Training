
package model;

import java.util.Objects;

public class BankAccount {

    private String accountNumber;
    private String accountHolder;
    private double balance;

    private static int accountCount = 0;
    public BankAccount() {
        this("UNKNOWN", "Unknown", 0);
    }

    public BankAccount(String accountHolder) {
        this("UNKNOWN", accountHolder, 0);
    }

    public BankAccount(
            String accountNumber,
            String accountHolder,
            double balance) {

        if (accountNumber == null || accountNumber.isBlank()) {
            throw new IllegalArgumentException(
                    "Account number cannot be empty");
        }

        if (accountHolder == null || accountHolder.isBlank()) {
            throw new IllegalArgumentException(
                    "Account holder cannot be empty");
        }

        if (!Double.isFinite(balance) || balance < 0) {
            throw new IllegalArgumentException(
                    "Balance must be finite and non-negative");
        }

        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = balance;

        accountCount++;
    }

    
    public String getAccountNumber() {
        return accountNumber;
    }

    public String getAccountHolder() {
        return accountHolder;
    }

    public double getBalance() {
        return balance;
    }

    
    public static int getAccountCount() {
        return accountCount;
    }


    public void deposit(double amount) {
        if (!Double.isFinite(amount) || amount <= 0) {
            System.out.println(
                    "Deposit amount must be positive and finite.");
            return;
        }

        balance += amount;

        System.out.println(
                "Deposit successful. Balance: ₹" + balance);
    }

    public void withdraw(double amount) {
        if (!Double.isFinite(amount) || amount <= 0) {
            System.out.println(
                    "Withdrawal amount must be positive and finite.");
            return;
        }

        if (amount > balance) {
            System.out.println("Insufficient balance.");
            return;
        }


        balance += amount;

        System.out.println(
                "Withdrawal successful. Balance: ₹" + balance);
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof BankAccount)) {
            return false;
        }

        BankAccount other = (BankAccount) obj;

        return accountNumber.equals(other.accountNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountNumber);
    }
}
