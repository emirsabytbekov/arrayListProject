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

        for (int numberOfAttempts = 5; numberOfAttempts > 0; numberOfAttempts--)
        {
            for (int i = 0; i < arrayListSize; i++)
            {
                int element = 1 + rand.nextInt(7);
                arrayList.add(element);
            }

            firstGuess = sc.nextInt();
            secondGuess = sc.nextInt();
            thirdGuess = sc.nextInt();

            rightGuessesNumber = rightGuessesNumber - rightGuessesNumber;

            if (firstGuess == arrayList.get(0)) rightGuessesNumber++;
            if (secondGuess == arrayList.get(1)) rightGuessesNumber++;
            if (thirdGuess == arrayList.get(2)) rightGuessesNumber++;

            if (rightGuessesNumber == 1) System.out.println("You've found " + rightGuessesNumber + " box");
            else if (rightGuessesNumber == 3)
            {
                System.out.println("YAAAAAY! YOU HAVE SUCCESSFULLY FOUND ALL THE BOXES");
                break;
            }
            else System.out.println("You've found " + rightGuessesNumber + " boxes");
        }

        if (rightGuessesNumber != 3) System.out.println("\nALERT! YOU HAVE BEEN NOTICED!\nLegs have eyes...");


    }
}