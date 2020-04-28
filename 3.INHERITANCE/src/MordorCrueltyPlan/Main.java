package MordorCrueltyPlan;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Gandalf gandalf = new Gandalf();
        String[] inputFoods = scanner.nextLine().split("\\s");
        for (String food:inputFoods
             ) {
            gandalf.eatFood(food);
        }

        System.out.println(gandalf.getFoodPoints());
        System.out.println(gandalf.getMood());
    }
}
