package PointInRectangle;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] coordinates = getCoordinates(scanner);
        Point topLeft = new Point(coordinates[0],coordinates[1]);
        Point bottomRight = new Point(coordinates[2],coordinates[3]);
        Rectangle rectangle = new Rectangle(topLeft,bottomRight);
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            coordinates = getCoordinates(scanner);
            Point toCheck = new Point(coordinates[0],coordinates[1]);
            System.out.println(rectangle.Contains(toCheck));
        }
    }

    private static int[] getCoordinates(Scanner scanner) {
        return Arrays.stream(scanner.nextLine().split("\\s"))
                .mapToInt(Integer::parseInt).toArray();
    }
}
