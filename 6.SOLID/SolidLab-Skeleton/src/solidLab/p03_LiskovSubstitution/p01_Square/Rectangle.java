package solidLab.p03_LiskovSubstitution.p01_Square;

public class Rectangle extends TwoDimentionalShape {

    @Override
    public double getArea() {
       return this.getWidth()*this.getHeight();
    }
}
