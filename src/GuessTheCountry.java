import java.util.*;

public class GuessTheCountry {
    public static void main(String[] args) {

        Map<Integer, String[]> countries = new HashMap<>();
        putContinents(countries);
        System.out.println("Guess the country");
        String playAgain = " ";
        gameContent(playAgain, countries);
    }

    public static void gameContent(String playAgain, Map<Integer, String[]> countries) {
        Scanner scanner = new Scanner(System.in);
        int continent = new Random().nextInt(7);
        while (!playAgain.equals("n")) {
            if (playAgain.equals("y")) { //play again
                playAgain = "";
                continent = new Random().nextInt(7);
            }
            String hint = getHint(continent);
            String randomCountry = getRandomCountry(countries.get(continent)); //country getter

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

            guessCounter = gameProgress(censoredCountry, guessCounter, randomCountry, guessedChars, hint); //game progress
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
    private static String getHint(int continent) {
        return switch (continent) {
            case 0 -> "The country is in Europe";
            case 1 -> "The country is in Africa";
            case 2 -> "The country is in South America";
            case 3 -> "The country is in Asia";
            case 4 -> "The country is in North America";
            case 5 -> "The country is in Oceania";
            case 6 -> "The country is in Osmor Islands";  // za mitaka
            default -> null;
        };
    }
    public static int gameProgress(StringBuilder censoredCountry, int guessCounter, String randomCountry, List<String> guessedChars, String hint) {
        Scanner scanner = new Scanner(System.in);
        int hintCounter = 0;
        String temporaryCountry = randomCountry;

        while (!censoredCountry.toString().equalsIgnoreCase(randomCountry) && (guessCounter != 5)) {
            System.out.print("Make a guess: ");
            String input = scanner.nextLine();


            if (input.equalsIgnoreCase(randomCountry)) {
                break;
            }

            if (input.equalsIgnoreCase("Hint")) {//hint - in which continent
                if (hintCounter == 0) {
                    System.out.println(hint);
                    System.out.println(censoredCountry);
                    hintCounter++;
                    continue;
                }
                else {
                    System.out.print("Are you sure you want to use 1 hint? The hint cost 1 guess: ");
                    input = scanner.nextLine();
                    if (hintCounter > 0 && input.equalsIgnoreCase("yes")) {//revealing random letter
                        int num = new Random().nextInt(temporaryCountry.length());
                        input = String.valueOf(temporaryCountry.charAt(num));
                        temporaryCountry = temporaryCountry.replaceAll(input, "");
                        guessCounter++;
                        System.out.printf("Guess %d/5%n", guessCounter);
                        hintCounter++;
                    }
                }

                if (input.equalsIgnoreCase("no")) {
                    continue;
                }
            }
            if (guessedChars.contains(input.toLowerCase())) { //guessed chars
                System.out.println("Already guessed it!");
            } else {
                if (randomCountry.toLowerCase().contains(input.toLowerCase()) && input.length() == 1) { //direct guess
                    for (int i = 0; i < randomCountry.length(); i++) { // replacing
                        if (randomCountry.toLowerCase().charAt(i) == input.toLowerCase().charAt(0)) {
                            if (i == 0) {
                                censoredCountry.replace(i, i + 1, input.toUpperCase());
                            } else {
                                censoredCountry.replace(i, i + 1, input.toLowerCase());
                            }
                        }
                    }

                    System.out.println(censoredCountry);
                } else {
                    if (input.length() == 1 && Character.isLetter(input.charAt(0))) {
                        guessCounter++;
                        System.out.printf("There is no '%s'%n", input);
                        System.out.printf("Guess %d/5%n", guessCounter);
                    } else if (input.length()>1){
                        guessCounter++;
                        System.out.println("Wrong country");
                        System.out.printf("Guess %d/5%n", guessCounter);
                    }else {
                        System.out.println("Wrong input");
                    }
                    if (guessCounter == 2) {
                        System.out.println("If you need help type - Hint");
                    }
                }
            }
            guessedChars.add(input); //adding guessed chars
        }
        return guessCounter;
    }
    public static String getRandomCountry(String[] countries) {
        int index = new Random().nextInt(countries.length);

        return countries[index];
    }

    private static void putContinents(Map<Integer, String[]> countries) {
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
                "Tunisia", "Uganda", "Zambia", "Zimbabwe"}); //Africa

        countries.put(2, new String[]{
                "Argentina", "Bolivia", "Brazil", "Chile", "Colombia", "Ecuador",
                "Guyana", "Paraguay", "Peru", "Suriname", "Uruguay", "Venezuela" //South America
        });

        countries.put(3, new String[]{
                "Afghanistan", "Armenia", "Azerbaijan", "Bahrain", "Bangladesh", "Bhutan",
                "Brunei", "Cambodia", "China", "Cyprus", "Georgia", "India", "Indonesia",
                "Iran", "Iraq", "Israel", "Japan", "Jordan", "Kazakhstan", "Kuwait", "Kyrgyzstan",
                "Laos", "Lebanon", "Malaysia", "Maldives", "Mongolia", "Myanmar", "Nepal", "North Korea",
                "Oman", "Pakistan", "Palestine", "Philippines", "Qatar", "Russia", "Saudi Arabia",
                "Singapore", "South Korea", "Sri Lanka", "Syria", "Taiwan", "Tajikistan", "Thailand",
                "Timor-Leste", "Turkey", "Turkmenistan", "United Arab Emirates", "Uzbekistan", "Vietnam",
                "Yemen" //Asia
        });

        countries.put(4, new String[]{
                "Antigua and Barbuda", "Bahamas", "Barbados", "Belize", "Canada", "Costa Rica",
                "Cuba", "Dominica", "Dominican Republic", "El Salvador", "Grenada", "Guatemala",
                "Haiti", "Honduras", "Jamaica", "Mexico", "Nicaragua", "Panama", "Saint Kitts and Nevis",
                "Saint Lucia", "Saint Vincent and the Grenadines", "Trinidad and Tobago", "United States" //North America
        });

        countries.put(5, new String[]{
                "Australia", "Fiji", "Kiribati", "Marshall Islands", "Micronesia",
                "Nauru", "New Zealand", "Palau", "Papua New Guinea", "Samoa",
                "Solomon Islands", "Tonga", "Tuvalu", "Vanuatu" //Australia
        });

        countries.put(6, new String[]{
                "Mitaka", "Sasho", "Preso", "Denkata", "Vikos", "Kobomir", "Ananas", "Cherniq" //Osmor Islands
        });
    }
}