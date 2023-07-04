package question02;

import java.util.HashMap;
import java.util.Map;

public class Espresso extends Caffee {
//    public Espresso(String name) {
//        super(name);
//    }

    public Espresso(String name, int rating) {
        super(name, rating);
    }

    @Override
    public Map<String, Integer> makeDrink() {
        this.addComponent("Water", 50)
        .addComponent("Arabica", 20);
        return this.getIngredients();
    }
}
