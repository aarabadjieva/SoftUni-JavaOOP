package WildFarm;

public class Tiger extends Felime {
    public Tiger(String name, String type, double weight, String livingRegion) {
        super(name, type, weight, livingRegion);
    }

    @Override
    public String makeSound() {
        return "ROAAR!!!";
    }

    @Override
    public void eatFood(Food food) {
        if (!food.getClass().getSimpleName().equals("Meat")){
            throw new IllegalArgumentException("Tigers are not eating that type of food!");
        }
        this.setFoodEaten(this.getFoodEaten()+food.getQuantity());
    }
}
