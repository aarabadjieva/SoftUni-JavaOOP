package Pizza;

public enum DoughType {
    White (1.5),
    Wholegrain (1.0),
    Crispy (0.9),
    Chewy (1.1),
    Homemade (1.0);

    private double modifier;

    DoughType(double modifier) {
        this.modifier = modifier;
    }

    public double getModifier() {
        return modifier;
    }

    public static boolean contains(String test) {
        for (DoughType type : DoughType.values()) {
            if (type.name().equals(test)) {
                return true;
            }
        }
        return false;
    }
}
