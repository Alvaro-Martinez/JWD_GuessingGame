import java.util.Scanner;
import java.io.*;

public class Prompter {
    private Jar jar;

    public Prompter() {}

    public static void startGame() {

        try {

            Scanner scanner = new Scanner(System.in);

            System.out.println("ADMINISTRATOR SETUP");
            System.out.println("=======================");
            System.out.print("What type of item? ");
            String nameOfItems = scanner.nextLine();

            while (nameOfItems.length() == 0) {
                System.out.print("Please, enter the name of the Item: ");
                nameOfItems = scanner.nextLine();
            }

            System.out.printf("What is the maximum amount of %s? ", nameOfItems);
            String guessInput = scanner.nextLine();
            while (guessInput.length() == 0 || !isNumeric(guessInput) || (Integer.parseInt(guessInput)) == 0) {
                System.out.print("Please, enter a number greater than 0: ");

                guessInput = scanner.nextLine();
            }

            int numberOfItems = Integer.parseInt(guessInput);

            System.out.println("\nPLAYER");
            System.out.println("=======================");

            System.out.printf("Your goal is to guess how many %s are in the Jar. \n" +
                    "Your guess should be between 1 and %d \n\n", nameOfItems, numberOfItems);


            Jar jar = new Jar(nameOfItems, numberOfItems);

            jar.startGuessing(numberOfItems, nameOfItems);// DRY?

        } catch (Exception ex){
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