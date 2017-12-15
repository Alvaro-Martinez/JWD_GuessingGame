import java.util.Random;
import java.util.Scanner;

public class Jar {
    private String itemName;
    private int numberOfItems;

    public Jar(String itemName, int maximumItemNumber) {
        this.itemName = itemName;
        this.numberOfItems = maximumItemNumber;
    }

    public static void startGuessing(int maxItemsAllowed, String nameOfItems) {

        try {

        Random random = new Random();
        int someNumber = random.nextInt(maxItemsAllowed+1);
        if (someNumber == 0) {
            someNumber = 1;
        }

        Scanner scanner = new Scanner(System.in);
        int counter = 0;
        boolean guessed = false;

        do {
            System.out.print("Guess: ");
            String guessInput = scanner.nextLine();

            while (!isNumeric(guessInput) || (Integer.parseInt(guessInput) == 0)) {
                System.out.println("Please, enter a number greater than 0 ");
                guessInput = scanner.nextLine();
            }
            int guessedNumber = Integer.parseInt(guessInput);

            while (guessedNumber > maxItemsAllowed && !isNumeric(guessInput) || (Integer.parseInt(guessInput) == 0)) {
                System.out.printf("Your guess must be less than %s, please try again: ", maxItemsAllowed);
                guessInput = scanner.nextLine();
            }
            counter++;

            if (guessedNumber == someNumber) {
                guessed = true;
            }

            if (guessedNumber > someNumber) {
                System.out.println("Your guess is too high");
            } else if (guessedNumber < someNumber) {
                System.out.println("Your guess is too low");
            }

        } while (!guessed);

        System.out.printf("Congratulations! you guessed that there are %d %s in the Jar! It took you %d Guess(es) to get it right.\n", someNumber, nameOfItems, counter);

        }catch (Exception ex) {
            System.out.println("An exception has occurred");
        }
    }

    private static boolean isNumeric(String cadena){
        try {
            Integer.parseInt(cadena);
            return true;
        } catch (NumberFormatException nfe){
            return false;
        }
    }
}