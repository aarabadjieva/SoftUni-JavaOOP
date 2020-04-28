package StudentSystem;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StudentSystem studentSystem = new StudentSystem(new StudentsRepository());
        String[] input = scanner.nextLine().split("\\s");
        while (!input[0].equals("Exit")) {
            studentSystem.ExecuteCommand(input);
            input = scanner.nextLine().split("\\s");
        }
    }
}
