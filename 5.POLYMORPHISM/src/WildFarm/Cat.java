package WildFarm;

import java.text.DecimalFormat;

public class Cat extends Felime {
    private String breed;

    public Cat(String name, String type, double weight, String livingRegion, String breed) {
        super(name, type, weight, livingRegion);
        this.breed = breed;
    }

    private String getBreed() {
        return breed;
    }

    @Override
    public String makeSound() {
        return "Meowwww";
    }

    @Override
    public void eatFood(Food food) {
        this.setFoodEaten(this.getFoodEaten() + food.getQuantity());
    }

    @Override
    public String toString() {
        DecimalFormat df = new DecimalFormat("#.##");
        return String.format("%s[%s, %s, %s, %s, %d]", this.getClass().getSimpleName(),
                this.getName(), this.getBreed(), df.format(this.getWeight()), this.getLivingRegion(), this.getFoodEaten());
    }
}
