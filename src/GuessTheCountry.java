import java.util.*;

public class GuessTheCountry {
    public static void main(String[] args) {

        Map<Integer,String[]>countries = new HashMap<>();
        putContinents(countries);
        String playAgain = " ";

        gameContent(playAgain,countries);
    }
    private static void putContinents(Map<Integer,String[]> countries) {
        countries.put(0, new String[]{"Germany", "Poland", "Czech Republic", "Slovakia", "Hungary", "Slovenia", "Switzerland", "Austria", "Liechtenstein",
                "Russia", "Estonia", "Latvia", "Lithuania", "Belarus", "Ukraine", "Moldova",
                "Iceland", "Norway", "Sweden", "Finland", "Denmark",
                "Croatia", "Bosnia and Herzegovina", "Montenegro", "Albania", "North Macedonia", "Kosovo", "Serbia", "Bulgaria", "Romania", "Turkey",
                "Italy", "San Marino", "Vatican City", "Malta", "Cyprus", "Greece",
                "Spain", "Portugal", "Andorra",
                "Ireland", "United Kingdom", "Netherlands", "Belgium", "Luxembourg", "France", "Monaco"});
        countries.put(1, new String[]{
                "Algeria", "Angola", "Benin", "Botswana", "Burkina Faso", "Burundi",
                "Cabo Verde", "Cameroon", "Central African Republic", "Chad", "Comoros",
                "Democratic Republic of the Congo", "Republic of the Congo", "Ivory Coast",
                "Djibouti", "Egypt", "Equatorial Guinea", "Eritrea", "Eswatini", "Ethiopia",
                "Gabon", "Gambia", "Ghana", "Guinea", "Guinea-Bissau", "Kenya", "Lesotho",
                "Liberia", "Libya", "Madagascar", "Malawi", "Mali", "Mauritania",
                "Mauritius", "Morocco", "Mozambique", "Namibia", "Niger", "Nigeria",
                "Rwanda", "Sao Tome and Principe", "Senegal", "Seychelles", "Sierra Leone",
                "Somalia", "South Africa", "South Sudan", "Sudan", "Tanzania", "Togo",
                "Tunisia", "Uganda", "Zambia", "Zimbabwe"});
        countries.put(2, new String[]{
                "Argentina", "Bolivia", "Brazil", "Chile", "Colombia", "Ecuador",
                "Guyana", "Paraguay", "Peru", "Suriname", "Uruguay", "Venezuela"
        });
        countries.put(3,new String[]{
                "Afghanistan", "Armenia", "Azerbaijan", "Bahrain", "Bangladesh", "Bhutan",
                "Brunei", "Cambodia", "China", "Cyprus", "Georgia", "India", "Indonesia",
                "Iran", "Iraq", "Israel", "Japan", "Jordan", "Kazakhstan", "Kuwait", "Kyrgyzstan",
                "Laos", "Lebanon", "Malaysia", "Maldives", "Mongolia", "Myanmar", "Nepal", "North Korea",
                "Oman", "Pakistan", "Palestine", "Philippines", "Qatar", "Russia", "Saudi Arabia",
                "Singapore", "South Korea", "Sri Lanka", "Syria", "Taiwan", "Tajikistan", "Thailand",
                "Timor-Leste", "Turkey", "Turkmenistan", "United Arab Emirates", "Uzbekistan", "Vietnam",
                "Yemen"
        });
        countries.put(4,new String[]{
                "Argentina", "Bolivia", "Brazil", "Chile", "Colombia", "Ecuador",
                "Guyana", "Paraguay", "Peru", "Suriname", "Uruguay", "Venezuela"
        });
        countries.put(5,new String[]{
                "Australia", "Fiji", "Kiribati", "Marshall Islands", "Micronesia",
                "Nauru", "New Zealand", "Palau", "Papua New Guinea", "Samoa",
                "Solomon Islands", "Tonga", "Tuvalu", "Vanuatu"
        });
    }

    public static void gameContent(String playAgain, Map<Integer,String[]>countries) {
        Scanner scanner = new Scanner(System.in);
        int continent = new Random().nextInt(6);
        while (!playAgain.equals("n")) {
            if (playAgain.equals("y")) { //play again
                playAgain = "";
                continent = new Random().nextInt(6);
            }
            String randomCountry = getRandomCountry(countries.get(continent));//country getter
            switch (continent){
                case 0:
                    System.out.println("Guess the country in Europe");
                    break;
                case 1:
                    System.out.println("Guess the country in Africa");
                    break;
                case 2:
                    System.out.println("Guess the country in South America");
                    break;
                case 3:
                    System.out.println("Guess the country in Asia");
                    break;
                case 4:
                    System.out.println("Guess the country in North America");
                    break;
                case 5:
                    System.out.println("Guess the country in Australia");
                    break;
            }

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
                System.out.print("Do you want to play again? y/n: ");
            } else {
                System.out.println("You win!");
                System.out.print("Do you want to play again? y/n: ");
            }
            playAgain = scanner.nextLine();
        }
        System.out.println("Bye");
    }
    public static int gameProgress(StringBuilder censoredCountry, int guessCounter, String randomCountry, List<String> guessedChars) {
        Scanner scanner = new Scanner(System.in);
        while (!censoredCountry.toString().equalsIgnoreCase(randomCountry) && (guessCounter != 5)) {
            System.out.print("Make a guess: ");
            String input = scanner.nextLine();
            if (guessedChars.contains(input.toLowerCase())) {
                System.out.println("Already guessed it!");
            } else {
                if (randomCountry.toLowerCase().contains(input.toLowerCase())) {
                    if (input.equals(randomCountry)) {
                        break;
                    }
                    for (int i = 0; i < randomCountry.length(); i++) { // replacing
                        if (randomCountry.toLowerCase().charAt(i) == input.toLowerCase().charAt(0)) {
                            if (input.length() == 1) {
                                if (i == 0) {
                                    censoredCountry.replace(i, i + input.length(), input.toUpperCase());
                                } else {
                                    censoredCountry.replace(i, i + input.length(), input.toLowerCase());
                                }
                            } else {
                                censoredCountry.replace(i, i + input.length(), input.toLowerCase());
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

    public static String getRandomCountry(String[] countries) {
        int index = new Random().nextInt(countries.length);

        return countries[index];
    }
}