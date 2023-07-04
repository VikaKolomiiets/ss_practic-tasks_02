package question02;

import java.util.HashMap;
import java.util.Map;

public class Cappuccino extends Caffee {
//    public Cappuccino(String name) {
//        super(name);
//    }

    public Cappuccino(String name, int rating) {
        super(name, rating);
    }

    @Override
    public Map<String, Integer> makeDrink() {
        this.addComponent("Water", 100)
                .addComponent("Arabica", 20)
                .addComponent("Milk", 50);
        return this.getIngredients();
    }
}
