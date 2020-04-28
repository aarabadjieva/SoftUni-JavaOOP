package WildFarm;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split("\\s");
        List<Animal> animals = new ArrayList<>();
        while (!input[0].equals("End")){
            Animal animal = null;
            switch (input[0]){
                case "Cat":
                    animal = new Cat(input[1],input[0],Double.parseDouble(input[2]),input[3],input[4]);
                    break;
                case "Tiger":
                    animal = new Tiger(input[1],input[0],Double.parseDouble(input[2]),input[3]);
                    break;
                case "Zebra":
                    animal = new Zebra(input[1],input[0],Double.parseDouble(input[2]),input[3]);
                    break;
                case "Mouse":
                    animal = new Mouse(input[1],input[0],Double.parseDouble(input[2]),input[3]);
                    break;
            }
            System.out.println(animal.makeSound());
            input = scanner.nextLine().split("\\s");
            Food food = null;
            switch (input[0]){
                case "Vegetable":
                    food = new Vegetable(Integer.parseInt(input[1]));
                    break;
                case "Meat":
                    food = new Meat(Integer.parseInt(input[1]));
                    break;
            }
            try{
                animal.eatFood(food);
            }catch (IllegalArgumentException ex){
                System.out.println(ex.getMessage());
            }
            animals.add(animal);
            input = scanner.nextLine().split("\\s");
        }
        for (Animal animal:animals
             ) {
            System.out.println(animal.toString());
        }
    }
}
