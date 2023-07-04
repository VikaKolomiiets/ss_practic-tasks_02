package question02;

import java.util.HashMap;
import java.util.Map;

public class Caffee implements DrinkReceipt, DrinkPreparation, Rating {
    private String name;
    private int rating;
    private Map<String, Integer> ingredients;

//    public Caffee(String name) {

    protected Map<String, Integer> getIngredients() {
        return ingredients;
    }
//        this(name, 0);
//    }

    public Caffee(String name, int rating) {
        this.setName(name);
        this.setRating(rating);
        this.ingredients = new HashMap<>();
    }

    public void setName(String name) {
        if (name == null || name.isEmpty()) {
            throw new RuntimeException("Name is absent, please check Name");
        }
        this.name = name;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getRating() {
        return this.rating;
    }

    @Override
    public Map<String, Integer> makeDrink() {
        this.addComponent("Water", 100)
                .addComponent("Arabica", 20);
        return this.ingredients;
    }

    @Override
    public DrinkReceipt addComponent(String componentName, int componentCount) {
        if (componentName == null || componentName.isEmpty()) {
            throw new RuntimeException("ComponentName is absent, please check name");
        }
        if (componentCount <= 0) {
            throw new RuntimeException("ComponentCount should be more than 0");
        }
        this.ingredients.put(componentName, componentCount);
        return this;
    }


}
