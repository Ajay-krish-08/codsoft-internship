import java.util.Scanner;

public class ATMSystem {

    private double balance;
    private Scanner scanner;

    public ATMSystem(double initialBalance) {
        if (initialBalance >= 0) {
            this.balance = initialBalance;
        } else {
            this.balance = 0;
            System.out.println("Initial balance invalid. Setting balance to 0.");
        }
        this.scanner = new Scanner(System.in);
    }

    public static void main(String[] args) {
        ATMSystem atm = new ATMSystem(1000.00);
        atm.start();
    }

    public void start() {
        while (true) {
            System.out.println("\n--- ATM Menu ---");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    checkBalance();
                    break;
                case 2:
                    deposit();
                    break;
                case 3:
                    withdraw();
                    break;
                case 4:
                    System.out.println("Thank you for using the ATM. Goodbye!");
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    public void checkBalance() {
        System.out.println("Your current balance is: " + balance);
    }

    public void deposit() {
        System.out.print("Enter the amount to deposit: ");
        double amount = scanner.nextDouble();
        if (amount > 0) {
            balance += amount;
            System.out.println("Successfully deposited " + amount);
        } else {
            System.out.println("Invalid amount. Please enter a positive value.");
        }
    }

    public void withdraw() {
        System.out.print("Enter the amount to withdraw: ");
        double amount = scanner.nextDouble();
        if (amount > 0) {
            if (amount <= balance) {
                balance -= amount;
                System.out.println("Successfully withdrew " + amount);
            } else {
                System.out.println("Insufficient balance.");
            }
        } else {
            System.out.println("Invalid amount. Please enter a positive value.");
        }
    }
}
