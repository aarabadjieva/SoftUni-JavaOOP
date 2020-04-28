package Pizza;

public class Dough {
    private String flourType;
    private String bakingTechnique;
    private double weight;

    public Dough(String flourType, String bakingTechnique, double weight) {
        this.setFlourType(flourType);
        this.setBakingTechnique(bakingTechnique);
        this.setWeight(weight);
    }

    private void setFlourType(String flourType) {
        this.validate(flourType);
        this.flourType = flourType;
    }

    private void setBakingTechnique(String bakingTechnique) {
        this.validate(bakingTechnique);
        this.bakingTechnique = bakingTechnique;
    }

    private void setWeight(double weight) {
        if (weight<1||weight>200){
            throw new IllegalArgumentException("Pizza.Dough weight should be in the range [1..200].");
        }
        this.weight = weight;
    }

    private void validate(String type){
        if (!DoughType.contains(type)){
            throw new IllegalArgumentException("Invalid type of dough.");
        }
    }

    public double calculateCalories(){
        return (2*this.weight)*DoughType.valueOf(this.flourType).getModifier()
                *DoughType.valueOf(this.bakingTechnique).getModifier();
    }
}
