package Mankind;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split("\\s");
        while (!input[0].equals("end")) {
            try {
                switch (input.length) {
                    case 3:
                        Human student = new Student(input[0], input[1], input[2]);
                        System.out.println(student.toString());
                        break;
                    case 4:
                        Human worker = new Worker(input[0], input[1], Double.parseDouble(input[2]), Double.parseDouble(input[3]));
                        System.out.println(worker.toString());
                }
            } catch (IllegalArgumentException ex) {
                System.out.println(ex.getMessage());
            }
            input = scanner.nextLine().split("\\s");
        }
    }
}
