package Animals;

public abstract class Animal {
    private String name;
    private String favoriteFood;

    public Animal(String name, String favouriteFood) {
        this.name = name;
        this.favoriteFood = favouriteFood;
    }

     String explainSelf() {
        return String.format("I am %s and my fovourite food is %s"
                ,this.name,this.favoriteFood);
    }
}
