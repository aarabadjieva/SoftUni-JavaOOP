package Override;

public class Rectangle extends Shape{
    private Double height;
    private Double width;

    public Rectangle(Double height, Double width) {
        this.height = height;
        this.width = width;
    }

    public Double getWidth() {
        return width;
    }

    public Double getHeight() {
        return height;
    }

    @Override
    double calculatePerimeter() {
        return (2*(this.width+this.height));
    }

    @Override
    double calculateArea() {
        return (this.width*this.height);
    }
}
