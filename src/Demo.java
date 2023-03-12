import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class Demo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<Integer, String[]> countries = new HashMap<>();

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
                "Democratic Republic of the Congo", "Republic of the Congo", "Cote d'Ivoire",
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


        System.out.println(getRandomCountry(countries.get(new Random().nextInt(6))));
    }

    public static String getRandomCountry(String[] countries) {
        int index = new Random().nextInt(countries.length);

        return countries[index];
    }
}
