package Banking_Simulator;
import java.util.Scanner;


public class Banking_Simulator {
    static Scanner scanner = new Scanner(System.in);
    public static void main (String[] args){

        double balance = 0;
        boolean isRunning = true;
        int choice;

        while (isRunning){
            System.out.println("Welcome to your banking simulation!");
            System.out.println("1. Show balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Exit\n");
            System.out.print("Please enter your choice: ");
            choice = scanner.nextInt();

            switch(choice){
                case 1 -> showBalance(balance);
                case 2 -> balance += deposit();
                case 3 -> balance -= withdraw(balance);
                case 4 -> isRunning = false;
                default -> System.out.println("Invalid choice");
            }

        }
        scanner.close();
        System.out.println("Thank you for using our simulation!");
    }

    static void showBalance(double balance){
        System.out.printf("Your current balance is $%f\n", balance);
    }

    static double deposit(){
        double amount;
        System.out.print("Please enter the amount you would like to deposit: ");
        amount = scanner.nextDouble();
        if (amount<0){
            System.out.println("You cannot deposit a negative amount");
            return 0;
        }
        else{
            return amount;
        }
    }

    static double withdraw(double balance){
        double amount;
        System.out.print("Please enter the amount you would like to withdraw: ");
        amount = scanner.nextDouble();
        if (amount>balance){
            System.out.println("Insufficient funds");
            return 0;
        }
        else if (amount<0){
            System.out.println("You cannot withdraw a negative amount");
            return 0;
        }
        else{
            return amount;
        }
    }
}
