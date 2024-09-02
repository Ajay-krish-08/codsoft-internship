import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int lowerBound = 1;
        int upperBound = 100;
        int maxAttempts = 10;
        int totalScore = 0;
        int roundNumber = 0;
        char playAgain;

        do {
            roundNumber++;
            System.out.println("\n--- Round " + roundNumber + " ---");
            int randomNumber = random.nextInt(upperBound - lowerBound + 1) + lowerBound;
            int attempts = 0;
            int score = 0;

            System.out.println("Guess the number between " + lowerBound + " and " + upperBound + ". You have " + maxAttempts + " attempts.");

            while (attempts < maxAttempts) {
                System.out.print("Enter your guess: ");
                int guess = scanner.nextInt();
                attempts++;

                if (guess < randomNumber) {
                    System.out.println("Too low!");
                } else if (guess > randomNumber) {
                    System.out.println("Too high!");
                } else {
                    System.out.println("Congratulations! You guessed the correct number in " + attempts + " attempts.");
                    score = maxAttempts - attempts + 1; // Higher score for fewer attempts
                    break;
                }

                if (attempts == maxAttempts) {
                    System.out.println("Sorry, you've used all " + maxAttempts + " attempts. The correct number was " + randomNumber + ".");
                }
            }

            totalScore += score;

            System.out.print("Do you want to play again? (y/n): ");
            playAgain = scanner.next().charAt(0);

        } while (playAgain == 'y' || playAgain == 'Y');

        System.out.println("\nYour final score after " + roundNumber + " round(s) is: " + totalScore + " points.");
        System.out.println("Thank you for playing!");

        scanner.close();
    }
}

