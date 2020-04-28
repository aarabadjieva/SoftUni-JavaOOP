
package GreedyTimes;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        long bagCapacity = Long.parseLong(scanner.nextLine());
        String[] safeContent = scanner.nextLine().split("\\s+");
        Bag bag = new Bag(bagCapacity);

        bag.fillBag(safeContent);

        System.out.println(bag.toString());
    }

}