package question02;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CaffeeMyUtils {


    public Map<String, Double> averageRating(List<Caffee> caffees) {
        Map<String, ArrayList<Integer>> allRates = new HashMap<>();
        for (Caffee drink : caffees) {
            if (!allRates.containsKey(drink.getName())) {
                allRates.put(drink.getName(), new ArrayList<>());
            }
            allRates.get(drink.getName()).add(drink.getRating());
        }

        Map<String, Double> rates = new HashMap<>();
        allRates.forEach((k, v) -> {
            int sum = 0;
            for (Integer r : v) {
                sum += r;
            }
            rates.put(k, (double) sum / v.size());
        });
        return rates;
    }

}
