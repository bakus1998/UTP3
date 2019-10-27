/**
 *
 *  @author Baka Krzysztof S16696
 *
 */

package zad2;


/*<-- niezbędne importy */

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        // Lista destynacji: port_wylotu port_przylotu cena_EUR
        List<String> dest = Arrays.asList(
                "bleble bleble 2000",
                "WAW HAV 1200",
                "xxx yyy 789",
                "WAW DPS 2000",
                "WAW HKT 1000"
        );
        double ratePLNvsEUR = 4.30;

        List<String> result = dest.stream().filter( s -> s.startsWith("WAW")).map(s-> {
            String split[] = s.split(" ");
            int number =(int)(Integer.parseInt(split[2])*ratePLNvsEUR);
            double number_in_double = Double.parseDouble(split[2])*ratePLNvsEUR;
            return "to " + split[1] + " - price in PLN: " + number;
        }).collect(Collectors.toList());

        for (String r : result) System.out.println(r);
    }
}
