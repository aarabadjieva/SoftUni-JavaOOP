package RhombusOfStars;

import java.util.Scanner;

public class Rhombus {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int width = Integer.parseInt(scanner.nextLine());
        for (int i = 1; i <= width; i++) {
            printRow(width, i);
        }
        for (int i = width-1; i >0 ; i--) {
            printRow(width, i);
        }
    }

    private static void printRow(int width, int row) {
        System.out.print(repeatString(" ", width - row));
        System.out.print(repeatString("* ", row));
        System.out.println();
    }

    private static String repeatString(String sequence, int times) {
        StringBuilder line = new StringBuilder();
        for (int i = 0; i < times; i++) {
            line.append(sequence);
        }
        return line.toString();
    }
}
