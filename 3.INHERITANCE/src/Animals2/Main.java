package Animals2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        while (!input.equals("Beast!")){
            String[] info = scanner.nextLine().split("\\s");
            try {
                switch (input) {
                    case "Dog":
                        Dog dog = new Dog(info[0], Integer.parseInt(info[1]), info[2]);
                        System.out.println(dog.toString());
                        System.out.println(dog.produceSound());
                        break;
                    case "Cat":
                        Cat cat = new Cat(info[0], Integer.parseInt(info[1]), info[2]);
                        System.out.println(cat.toString());
                        System.out.println(cat.produceSound());
                        break;
                    case "Frog":
                        Frog frog = new Frog(info[0], Integer.parseInt(info[1]), info[2]);
                        System.out.println(frog.toString());
                        System.out.println(frog.produceSound());
                        break;
                    case "Kitten":
                        Kitten kitten = new Kitten(info[0], Integer.parseInt(info[1]), info[2]);
                        System.out.println(kitten.toString());
                        System.out.println(kitten.produceSound());
                        break;
                    case "Tomcat":
                        Tomcat tomcat = new Tomcat(info[0], Integer.parseInt(info[1]), info[2]);
                        System.out.println(tomcat.toString());
                        System.out.println(tomcat.produceSound());
                        break;
                }
            }catch (IllegalArgumentException ex){
                System.out.println(ex.getMessage());
            }
            input = scanner.nextLine();
        }
    }
}
