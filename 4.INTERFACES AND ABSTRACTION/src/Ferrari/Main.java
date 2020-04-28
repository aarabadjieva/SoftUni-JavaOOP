package Ferrari;

import java.lang.instrument.IllegalClassFormatException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IllegalClassFormatException {
        Scanner scanner = new Scanner(System.in);
        String driver = scanner.nextLine();
        Ferrari ferrari = new Ferrari(driver);
        System.out.println(ferrari.brakes());

    }
}
