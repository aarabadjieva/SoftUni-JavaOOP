package ShapesDrawing;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int radius = Integer.parseInt(scanner.nextLine());
        Drawable circle = new Circle(radius);
        circle.draw();
        Drawable rectangle = new Ractangle(Integer.parseInt(scanner.nextLine()),
                Integer.parseInt(scanner.nextLine()));
        rectangle.draw();
    }
}
