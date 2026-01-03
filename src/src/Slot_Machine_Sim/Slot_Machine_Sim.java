package Slot_Machine_Sim;

import java.util.Scanner;
import java.util.Random;

public class Slot_Machine_Sim {

    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);
        int balance = 100;
        int bet;
        int payout;
        String[] row;
        String play_again;

        System.out.println("********************************");
        System.out.println("Welcome to our slot machine sim!");
        System.out.println("Symbols: ❤️ 🍉 💲 🔔 🍓");
        System.out.println("********************************");

        while(balance > 0){
            System.out.println("Current balance: " + balance + " US dollars");
            System.out.print("Place your bet amount: ");
            bet = scanner.nextInt();
            scanner.nextLine(); // Clearing the input buffer left after using nextInt()

            if (bet>balance){
                System.out.println("insufficient funds");
                continue;
            }
            else if(bet <= 0){
                System.out.println("Bet cannot be negative or equal to zero");
                continue;
            }
            else {
                balance -= bet;
            }

            System.out.println("Spinning...");
            row = spinRow();
            printRow(row);
            payout = getPayout(row, bet);

            if (payout>0){
                System.out.println("You won " + payout + " Dollars!");
                balance += payout;
            }
            else{
                System.out.println("You failed this round :(");
            }

            System.out.print("Would you like to play again? (Y/N): ");
            play_again = scanner.nextLine().toUpperCase();

            if (!play_again.equals("Y")){
                break;
            }
        }

    }
    static String[] spinRow(){
        String[] symbols = {"❤️", "🍉", "💲", "🔔", "🍓"};
        String[] row = new String[3];
        Random random = new Random();

        for (int i=0; i<3; i++){
            row[i] = symbols[random.nextInt(symbols.length)];
        }

        return row;
    }

    static void printRow(String[] row){
        System.out.println("********************************");
        System.out.println(" " + String.join(" | ", row));
        System.out.println("********************************");
    }

    static int getPayout(String[] row, int bet){
        if (row[0].equals(row[1]) && row[1].equals(row[2])){
            return switch(row[0]){
                case "🍓" -> bet*3;
                case "🍉" -> bet*4;
                case "🔔" -> bet*5;
                case "💲" -> bet*6;
                case "❤️" -> bet*10;
                default -> 0;
            };
        }

        else if (row[0].equals(row[1]) || row[1].equals(row[2]) || row[0].equals(row[2])){
            return bet*2;
            };

        return 0;
    }
}
