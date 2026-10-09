import java.util.Scanner;

public class ATMSimulator {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        final int correctPin = 1234;

        int attempts = 0;
        boolean authenticated = false;

        // PIN validation
        while (attempts < 3) {

            System.out.print("Enter PIN: ");
            int pin = scanner.nextInt();

            if (pin == correctPin) {

                authenticated = true;
                break;

            } else {

                attempts++;
                System.out.println("Incorrect PIN.");
            }
        }

        // Account locked
        if (!authenticated) {

            System.out.println("Account locked.");
            scanner.close();
            return;
        }

        double balance = 10000;

        int choice;

        // ATM menu
        do {

            System.out.println();
            System.out.println("===== ATM MENU =====");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Mini Statement");
            System.out.println("5. Exit");

            System.out.print("Enter choice: ");

            choice = scanner.nextInt();

            switch (choice) {

                case 1:

                    System.out.println(
                        "Balance: ₹" + balance
                    );

                    break;

                case 2:

                    System.out.print(
                        "Enter deposit amount: "
                    );

                    double deposit = scanner.nextDouble();

                    if (deposit <= 0) {

                        System.out.println(
                            "Invalid amount."
                        );

                        continue;
                    }

                    balance = balance + deposit;

                    System.out.println(
                        "Deposit successful."
                    );

                    System.out.println(
                        "New Balance: ₹" + balance
                    );

                    break;

                case 3:

                    System.out.print(
                        "Enter withdrawal amount: "
                    );

                    double withdrawal =
                            scanner.nextDouble();

                    if (withdrawal <= 0) {

                        System.out.println(
                            "Invalid amount."
                        );

                        continue;
                    }

                    if (withdrawal > balance) {

                        System.out.println(
                            "Insufficient balance."
                        );

                        continue;
                    }

                    balance = balance - withdrawal;

                    System.out.println(
                        "Withdrawal successful."
                    );

                    System.out.println(
                        "Remaining Balance: ₹" + balance
                    );

                    break;

                case 4:

                    int[] transactions = {
                        1000,
                        -500,
                        2000,
                        -1000
                    };

                    System.out.println(
                        "===== MINI STATEMENT ====="
                    );

                    for (int transaction : transactions) {

                        if (transaction > 0) {

                            System.out.println(
                                "Deposit: ₹" + transaction
                            );

                        } else {

                            System.out.println(
                                "Withdrawal: ₹"
                                + (-transaction)
                            );
                        }
                    }

                    break;

                case 5:

                    System.out.println(
                        "Thank you for using ATM."
                    );

                    break;

                default:

                    System.out.println(
                        "Invalid choice."
                    );
            }

        } while (choice != 5);

        scanner.close();
    }
}