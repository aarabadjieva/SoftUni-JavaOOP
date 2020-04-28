package MordorCrueltyPlan;

import java.util.HashMap;
import java.util.Map;

public class Gandalf {
    private int foodPoints;
    private static final Map<String, Food> FOODS_MAP = new HashMap<>() {{
        put("cram", new Cram(2));
        put("lembas", new Lembas(3));
        put("apple", new Apple(1));
        put("melon", new Melon(1));
        put("honeycake", new HoneyCake(5));
        put("mushrooms", new Mushrooms(-10));
    }};

    public Gandalf() {
        this.foodPoints = 0;
    }

    public void eatFood(String food) {
        try {
            int happinesPoints = Integer.parseInt(food);
            this.foodPoints += happinesPoints;
        } catch (Exception ex) {
            if (Gandalf.FOODS_MAP.containsKey(food.toLowerCase())) {
                this.foodPoints += Gandalf.FOODS_MAP.get(food.toLowerCase()).getHappinesPoints();
            } else {
                this.foodPoints += -1;
            }
        }
    }

    public int getFoodPoints() {
        return this.foodPoints;
    }

    public String getMood() {
        String mood = "";
        if (this.foodPoints < -5) {
            mood = "Angry";
        } else if (this.foodPoints < 0) {
            mood = "Sad";
        } else if (this.foodPoints < 15) {
            mood = "Happy";
        } else {
            mood = "JavaScript";
        }
        return mood;
    }
}
