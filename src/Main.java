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

        hideTheBoxes(arrayListSize, rand, arrayList);

        for (int numberOfAttempts = 5; numberOfAttempts > 0; numberOfAttempts--)
        {
            System.out.println("\nPlease, enter three numbers: ");

            firstGuess = sc.nextInt();
            secondGuess = sc.nextInt();
            thirdGuess = sc.nextInt();

            if (firstGuess == secondGuess || firstGuess == thirdGuess || secondGuess == thirdGuess)
            {
                System.out.println("You must not check the same spot two times in the same attempt, it attracts too much attention!");
                wait(1000);
                break;
            }

            rightGuessesNumber = resetRightGuessesNumber();
            rightGuessesNumber = countRightGuesses(arrayListSize, firstGuess, secondGuess, thirdGuess, arrayList, rightGuessesNumber);

            if (rightGuessesNumber == 1) System.out.println("You've found " + rightGuessesNumber + " box");
            else if (rightGuessesNumber == 3)
            {
                System.out.println("HURRAAAAAY! YOU HAVE SUCCESSFULLY FOUND ALL THE BOXES");
                break;
            }
            else System.out.println("You've found " + rightGuessesNumber + " boxes");
        }

        if (rightGuessesNumber != 3) System.out.println("\nALERT! YOU HAVE BEEN NOTICED!\nLegs have eyes...");

        //added next line just for fun
        System.out.println("Their places were: " + arrayList);

    }


    public static void printGreeting() {
        wait(1000);
        System.out.println("There are 3 boxes that are hidden in this desert.");
        wait(2500);
        System.out.println("They may be in each kilometer from 1 to 7 (inclusive).");
        wait(2500);
        System.out.println("You have only 5 attempts to guess the place of each box,");
        wait(2500);
        System.out.println("Otherwise boxes will be replaced by moving tentacles.");
        wait(2500);
        System.out.println("Each attempt must include three numbers, divided by the space.");
        wait(2500);
        System.out.println("After each attempt program will display number of found boxes.");
        wait(2500);
        System.out.println("Get ready, program launches!");
        wait(4500);

        clearScreen();
    }

    public static void wait (int ms)
    {
        try {
            Thread.sleep(ms);
        }
        catch(InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }

    public static void clearScreen()
    {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static void hideTheBoxes (int arrayListSize, Random rand, ArrayList<Integer> arrayList)
    {
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
    }

    public static int countRightGuesses(int arrayListSize, int firstGuess, int secondGuess, int thirdGuess, ArrayList<Integer> arrayList, int rightGuessesNumber)
    {
        for (int i = 0; i < arrayListSize; i++){
            if (firstGuess == arrayList.get(i)) rightGuessesNumber++;
        }
        for (int i = 0; i < arrayListSize; i++){
            if (secondGuess == arrayList.get(i)) rightGuessesNumber++;
        }
        for (int i = 0; i < arrayListSize; i++){
            if (thirdGuess == arrayList.get(i)) rightGuessesNumber++;
        }
        return rightGuessesNumber;
    }

    public static int resetRightGuessesNumber()
    {
        return 0;
    }

}