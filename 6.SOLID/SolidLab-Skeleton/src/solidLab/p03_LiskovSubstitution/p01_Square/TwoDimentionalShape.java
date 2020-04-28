package solidLab.p03_LiskovSubstitution.p01_Square;

public abstract class TwoDimentionalShape extends Shape {
    private double width;

    private double height;

    public double getWidth() {
        return this.width;
    }

    protected void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return this.height;
    }

    protected void setHeight(double height) {
        this.height = height;
    }
    public abstract double getArea();
}
