package Override;

public class Main {
    public static void main(String[] args) {
        Shape rectangle = new Rectangle(2.00,4.00);
        Shape circle = new Circle(6.0);
        System.out.println(rectangle.calculateArea());
        System.out.println(rectangle.calculatePerimeter());
        System.out.println(circle.calculateArea());
        System.out.println(circle.calculatePerimeter());
    }
}
