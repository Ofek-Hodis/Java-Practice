import java.util.Random;
import java.util.Scanner;

public class Number_Guessing {
    public static void main(String[] args){

        Random random = new Random();
        Scanner scanner = new Scanner(System.in);

        int guess = 0;
        int attempts = 0;
        int min = 0;
        int max = 101;
        String chooseRange;
        System.out.print("Would you like to choose custom numbers for the guessing range? (yes/no): ");
        chooseRange = scanner.nextLine();
        if (chooseRange.equalsIgnoreCase("yes")){
            System.out.print("Enter the lower limit of your guessing range: ");
            min = scanner.nextInt();
            System.out.print("Enter the higher limit of your guessing range: ");
            max = scanner.nextInt();
            max++; // Maximum limit in random function is non-inclusive so we increase the input by 1
        }
        // Verifying user input is "yes" or "no"
        else if (!chooseRange.equalsIgnoreCase("no")){
            while (!(chooseRange.equalsIgnoreCase("yes")||chooseRange.equalsIgnoreCase("no"))){
                System.out.print("Unclear input, please respond using (yes/no): ");
                chooseRange = scanner.nextLine();
            }
        }

        int target = random.nextInt(min,max);  // First number inclusive, second not

        System.out.printf("Guess a number between %d and %d: ", min, (max-1));  // Formatting the limits
        do{
            guess = scanner.nextInt();
            if (guess < target){
                System.out.println("Higher!");
            }
            else if (guess > target){
                System.out.println("Lower!");
            }

            attempts++;
        }while(guess != target);

        System.out.println("Good job! The number was " + target);
        System.out.println("That took you " + attempts + " attempts!");
        scanner.close();


    }
}
