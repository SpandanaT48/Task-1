import java.util.Random;
import java.util.Scanner;

public class NumberGame {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        
        int minRange = 1; // Minimum number for the range
        int maxRange = 100; // Maximum number for the range
        int attemptsLimit = 10; // Maximum number of attempts allowed
        int score = 0; // Score counter for rounds won
        
        boolean playAgain = true;
        
        while (playAgain) {
            int numberToGuess = random.nextInt(maxRange - minRange + 1) + minRange;
            System.out.println("Welcome to the Number Guessing Game!");
            System.out.println("Guess the number between " + minRange + " and " + maxRange + ".");
            
            int attempts = 0;
            boolean guessedCorrectly = false;
            
            while (!guessedCorrectly && attempts < attemptsLimit) {
                System.out.print("Attempt " + (attempts + 1) + "/" + attemptsLimit + ": Enter your guess: ");
                int userGuess = scanner.nextInt();
                attempts++;
                
                if (userGuess == numberToGuess) {
                    System.out.println("Congratulations! You guessed the correct number " + numberToGuess + " in " + attempts + " attempts.");
                    score++;
                    guessedCorrectly = true;
                } else if (userGuess < numberToGuess) {
                    System.out.println("Too low! Try guessing higher.");
                } else {
                    System.out.println("Too high! Try guessing lower.");
                }
            }
            
            if (!guessedCorrectly) {
                System.out.println("Oops! You've used all " + attemptsLimit + " attempts. The correct number was: " + numberToGuess);
            }
            
            System.out.print("Do you want to play again? (yes/no): ");
            String playChoice = scanner.next();
            
            if (!playChoice.equalsIgnoreCase("yes")) {
                playAgain = false;
            }
        }
        
        System.out.println("Game over. Your final score: " + score);
        scanner.close();
    }
}
