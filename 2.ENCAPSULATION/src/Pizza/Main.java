package Pizza;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] input = reader.readLine().split("\\s");
        try {
            String name = input[1];
            int capacity = Integer.parseInt(input[2]);
            Pizza pizza = new Pizza(name,capacity);
            input = reader.readLine().split("\\s");
            String flourType = input[1];
            String bakingTechnique = input[2];
            double weight = Double.parseDouble(input[3]);
            Dough dough = new Dough(flourType,bakingTechnique,weight);
            pizza.setDough(dough);
            input = reader.readLine().split("\\s");
            while (!input[0].equals("END")){
                String toppingName = input[1];
                double toppingWeight = Double.parseDouble(input[2]);
                Topping topping = new Topping(toppingName,toppingWeight);
                pizza.addTopping(topping);
                input = reader.readLine().split("\\s");
            }
            System.out.printf("%s - %.2f%n",pizza.getName(),pizza.getOverallCalories());
        }catch (IllegalArgumentException ex){
            System.out.println(ex.getMessage());
        }

    }
}
