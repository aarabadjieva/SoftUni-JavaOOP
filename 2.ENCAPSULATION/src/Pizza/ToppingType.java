package Pizza;

public enum ToppingType {
    Meat(1.2),
    Veggies(0.8),
    Cheese(1.1),
    Sauce(0.9);

    private double modifier;

    ToppingType(double modifier){
        this.modifier = modifier;
    }

    public double getModifier(){
        return this.modifier;
    }

    public static boolean contains(String test) {
        for (ToppingType type : ToppingType.values()) {
            if (type.name().equals(test)) {
                return true;
            }
        }
        return false;
    }
}
