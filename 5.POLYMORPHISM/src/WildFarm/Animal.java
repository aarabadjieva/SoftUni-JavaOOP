package WildFarm;

public abstract class Animal {
    private static final int STARTING_FOOD = 0;
    private String name;
    private String type;
    private double weight;
    private int foodEaten = STARTING_FOOD;

    public Animal(String name, String type, double weight) {
        this.name = name;
        this.type = type;
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public double getWeight() {
        return weight;
    }

    public int getFoodEaten() {
        return foodEaten;
    }

    protected void setFoodEaten(int foodEaten) {
        this.foodEaten = foodEaten;
    }

    public abstract String makeSound();

    public abstract void eatFood(Food food);

}
