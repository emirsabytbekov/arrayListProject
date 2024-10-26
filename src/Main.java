import java.util.Random;
import java.util.Scanner;
import java.util.ArrayList;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();

        int arrayListSize = 3;
        ArrayList<Integer> arrayList = new ArrayList<Integer>(arrayListSize);

        int rightGuessesNumber = 0;
        int firstGuess;
        int secondGuess;
        int thirdGuess;

        printGreeting();

        for (int i = 0; i < arrayListSize; i++)
        {
            int element = 1 + rand.nextInt(7);

            if (i == 0) arrayList.add(element);
            else if (i > 0 && element == arrayList.get(i-1) ) i--;
            else if (i > 0 && element != arrayList.get(i-1) )
            {
                if (i == 2 && element == arrayList.get(i-2) ) i--;
                else arrayList.add(element);
            }
        }

        for (int numberOfAttempts = 5; numberOfAttempts > 0; numberOfAttempts--)
        {


            System.out.println("\nPlease, enter three numbers: ");

            firstGuess = sc.nextInt();
            secondGuess = sc.nextInt();
            thirdGuess = sc.nextInt();

            if (firstGuess == secondGuess || firstGuess == thirdGuess || secondGuess == thirdGuess)
            {
                System.out.println("You must not check the same spot two times in the same attempt, it attracts too much attention!");
                break;
            }

            rightGuessesNumber = rightGuessesNumber - rightGuessesNumber;

            for (int i = 0; i < arrayListSize; i++){
                if (firstGuess == arrayList.get(i)) rightGuessesNumber++;
            }
            for (int i = 0; i < arrayListSize; i++){
                if (secondGuess == arrayList.get(i)) rightGuessesNumber++;
            }
            for (int i = 0; i < arrayListSize; i++){
                if (thirdGuess == arrayList.get(i)) rightGuessesNumber++;
            }

            if (rightGuessesNumber == 1) System.out.println("You've found " + rightGuessesNumber + " box");
            else if (rightGuessesNumber == 3)
            {
                System.out.println("YAAAAAY! YOU HAVE SUCCESSFULLY FOUND ALL THE BOXES");
                break;
            }
            else System.out.println("You've found " + rightGuessesNumber + " boxes");
        }

        if (rightGuessesNumber != 3) System.out.println("\nALERT! YOU HAVE BEEN NOTICED!\nLegs have eyes...");

        System.out.println(arrayList);

    }
    public static void printGreeting() {
        System.out.println("There are 3 boxes that are hidden in this desert.");
        System.out.println("They may be in each kilometer from 1 to 7 (inclusive).");
        System.out.println("You have only 5 attempts to guess the place of each box,");
        System.out.println("Otherwise boxes will be replaced by moving tentacles.");
        System.out.println("Each attempt must include three numbers, divided by the space.");
        System.out.println("After each attempt program will display number of found boxes.");
        System.out.println("Get ready, program launches!");
    }

}