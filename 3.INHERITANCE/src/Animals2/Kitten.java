package Animals2;

public class Kitten extends Cat {
    public Kitten(String name, int age, String gender) {
        super(name, age, gender);
    }

    @Override
    protected void setGender(String gender){
        super.setGender(gender);
    }

    @Override
    public String produceSound() {
        return "Miau";
    }
}
