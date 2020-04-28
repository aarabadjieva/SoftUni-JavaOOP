package Mood3;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] params = scanner.nextLine().split(" \\| ");
        String username = params[0];
        String type = params[1];
        Integer level = Integer.parseInt(params[3]);
        Character hero;
        if (type.toLowerCase().equals("demon")){
            hero = new Demon(username,level,Double.parseDouble(params[2]));
        }else {
            hero = new Archangel(username,level,Integer.parseInt(params[2]));
        }
        System.out.println(hero.toString());
    }
}
