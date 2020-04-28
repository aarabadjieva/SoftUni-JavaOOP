package Shopping;

import java.awt.dnd.InvalidDnDOperationException;
import java.util.ArrayList;
import java.util.List;

public class Person {
    private String name;
    private double money;
    private List<Product> products;

    public Person(String name, double money) {
        this.setName(name);
        this.setMoney(money);
        this.products = new ArrayList<>();
    }

    private void setName(String name){
        if (name.trim().isEmpty()){
            throw new IllegalArgumentException("Name cannot be empty");
        }
        this.name = name;
    }

    private void setMoney(double money){
        if (money<0){
            throw new IllegalArgumentException("Money cannot be negative");
        }
        this.money = money;
    }

    public void buyProduct(Product product){
        if (this.money>=product.getCost()){
            this.products.add(product);
            this.setMoney(this.money-product.getCost());
        }else{
            throw new InvalidDnDOperationException(String.format("%s can't afford %s",this.name,product.getName()));
        }
    }

    @Override
    public String toString() {
        String result = "Nothing bought";
        if (this.products.size()>0) {
            result = String.join(", ", this.products.toString()).replaceAll("[\\[\\]]+", "");
        }
        return String.format("%s - %s",this.name,result);
    }
}
