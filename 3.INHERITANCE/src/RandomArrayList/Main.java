package RandomArrayList;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        RandomArrayList<Integer> list = new RandomArrayList<>();

        list.addAll(Arrays.asList(1,2,3,4,5,6,7));
        System.out.println(list.getRandomElement());
    }
}
