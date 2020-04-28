package Farm;

import java.text.DecimalFormat;

public class Chicken {
    private String name;
    private int age;

    public Chicken(String name, int age) {
        this.setName(name);
        this.setAge(age);
    }

    public int getAge() {
        return age;
    }

    private void setName(String name) {
        if (name==null||name.trim().equals("")){
            throw new IllegalArgumentException("Name must be at least one symbol long.");
        }
        this.name = name;
    }

    private void setAge(int age) {
        if (age<=0||age>15){
            throw new IllegalArgumentException("Age should be between 0 and 15.");
        }
        this.age = age;
    }

    public double productPerDay(){
        return this.calculateProductPerDay();
    }

    private double calculateProductPerDay(){
        double result;
        if (this.getAge()<6){
            result = 2;
        }else if (this.getAge()<12){
            result = 1;
        }else {
            result = 0.75;
        }
        return result;
    }

    @Override
    public String toString() {
        DecimalFormat decimalFormat = new DecimalFormat("#.##");
        return String.format("Farm.Chicken %s (age %d) can produce %s eggs per day.",this.name,this.getAge(), decimalFormat.format(this.productPerDay()));
    }
}
