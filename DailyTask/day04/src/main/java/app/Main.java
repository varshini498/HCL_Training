package app;

import model.BankAccount;
import service.BankAccountService;

public class Main {

    public static void main(String[] args) {

        BankAccount account =
            new BankAccount("ACC101", "Subiksha", 10000);

        BankAccountService service =
            new BankAccountService();

        service.displayBalance(account);

        System.out.println("\n--- Deposit ---");
        service.depositMoney(account, 2000);

        System.out.println("\n--- Withdraw ---");
        service.withdrawMoney(account, 3000);

        System.out.println("\n--- Final Balance ---");
        service.displayBalance(account);
    }
}