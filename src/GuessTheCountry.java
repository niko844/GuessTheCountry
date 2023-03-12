import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class GuessTheCountry {
    public static void main(String[] args) {

        System.out.println("Guess the country in Europe");
        Random random = new Random();
        int randomNum = random.nextInt(47);
        String randomCountry = " ";
        String playAgain = " ";

        gameContent(randomCountry, playAgain, randomNum);
    }
    public static void gameContent(String randomCountry, String playAgain, int randomNum) {
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);
        while (!playAgain.equals("n")) {
            if (playAgain.equals("y")) { //play again
                randomNum = random.nextInt(47);
                playAgain = "";
            }
            randomCountry = getEuropeanCountry(randomNum).toLowerCase(); //country getter

            StringBuilder censoredCountry = new StringBuilder();
            List<String> guessedChars = new ArrayList<>();
            int guessCounter = 0;

            for (int i = 0; i < randomCountry.length(); i++) { //censored country
                if (randomCountry.charAt(i) == ' ') {
                    censoredCountry.append(' ');
                } else {
                    censoredCountry.append("*");
                }
            }
            System.out.println(censoredCountry);

            guessCounter = gameProgress(censoredCountry, guessCounter, randomCountry, guessedChars); //game progress
            if (guessCounter == 5) { //win/lose
                System.out.printf("You lost! The country was: %s%n", randomCountry);
                System.out.print("Do you want to play again? y/n:");
            } else {
                System.out.println("You win!");
                System.out.print("Do you want to play again? y/n:");
            }
            playAgain = scanner.nextLine();
        }
        System.out.println("Bye");
    }
    public static int gameProgress(StringBuilder censoredCountry, int guessCounter, String randomCountry, List<String> guessedChars) {
        Scanner scanner = new Scanner(System.in);
        while (!censoredCountry.toString().equalsIgnoreCase(randomCountry) && (guessCounter != 5)) {
            System.out.print("Make a guess: ");
            String input = scanner.nextLine().toLowerCase();
            if (guessedChars.contains(input.toLowerCase())) {
                System.out.println("Already guessed it!");
            } else {
                if (randomCountry.contains(input)) {
                    if (input.equals(randomCountry)) {
                        break;
                    }
                    for (int i = 0; i < randomCountry.length(); i++) { // replacing
                        if (randomCountry.charAt(i) == input.charAt(0)) {
                            if (input.length() == 1) {
                                censoredCountry.replace(i, i + input.length(), input);
                            } else {
                                censoredCountry.replace(i, i + input.length(), input);
                                break;
                            }
                        }
                    }
                    guessedChars.add(input); //adding guessed chars
                    System.out.println(censoredCountry);
                } else {
                    guessCounter++;
                    System.out.println("Wrong input");
                    System.out.printf("Guess %d/5%n", guessCounter);
                }
            }
        }
        return guessCounter;
    }
    public static String getEuropeanCountry(int randomNum) {
        String[] countries = {"Germany", "Poland", "Czech Republic", "Slovakia", "Hungary", "Slovenia", "Switzerland", "Austria", "Liechtenstein",
                "Russia", "Estonia", "Latvia", "Lithuania", "Belarus", "Ukraine", "Moldova",
                "Iceland", "Norway", "Sweden", "Finland", "Denmark",
                "Croatia", "Bosnia and Herzegovina", "Montenegro", "Albania", "North Macedonia", "Kosovo", "Serbia", "Bulgaria", "Romania", "Turkey",
                "Italy", "San Marino", "Vatican City", "Malta", "Cyprus", "Greece",
                "Spain", "Portugal", "Andorra",
                "Ireland", "United Kingdom", "Netherlands", "Belgium", "Luxembourg", "France", "Monaco"};

        return countries[randomNum];
    }
}