package Main;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        Database db = new Database();

        System.out.println("Welcome to the Banking Application. Please log in.");

        System.out.print("Username: ");
        String username = input.nextLine();

        System.out.print("Password: ");
        String password = input.nextLine();

        User loggedUser = db.Login(username, password);

        if (loggedUser != null) {

            System.out.println("Login successful. Welcome, " + loggedUser.username);

            while (true) {

                System.out.println("\n=MENU=");
                System.out.println("1. Show Balance");
                System.out.println("2. Deposit Money");
                System.out.println("3. Withdraw Money");
                System.out.println("4. Exit");
                System.out.print("Your choice: ");

                int choice = input.nextInt();

                switch (choice) {

                    case 1:

                        System.out.println("Your balance: " + loggedUser.balance);
                        break;

                    case 2:

                        System.out.print("Enter the amount to deposit: ");

                        double depositedAmount = input.nextDouble();

                        if (depositedAmount <= 0) {

                            System.out.println("Please enter a valid amount.");
                            break;
                        }

                        loggedUser.balance += depositedAmount;

                        System.out.println(
                        "Deposit successful. Your new balance is: "
                        + loggedUser.balance);

                        break;

                    case 3:

                        System.out.print("Enter the amount to withdraw: ");

                        double withdrawnAmount = input.nextDouble();

                        if (withdrawnAmount <= 0) {

                            System.out.println("Please enter a valid amount.");
                            break;
                        }

                        if (withdrawnAmount <= loggedUser.balance) {

                            loggedUser.balance -= withdrawnAmount;

                            System.out.println(
                            "Withdrawal successful. Your new balance is: "
                            + loggedUser.balance);

                        } else {

                            System.out.println("Insufficient balance.");
                        }

                        break;

                    case 4:

                        System.out.println("Exiting...");
                        input.close();
                        return;

                    default:

                        System.out.println("Invalid choice. Please try again.");
                }
            }

        } else {

            System.out.println("Login failed. Please try again.");
        }
    }
}
