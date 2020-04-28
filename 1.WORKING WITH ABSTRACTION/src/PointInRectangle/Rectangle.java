package PointInRectangle;

public class Rectangle {
    private Point topLeft;
    private Point bottomRight;

    public Rectangle(Point topLeft, Point bottomRight) {
        this.topLeft = topLeft;
        this.bottomRight = bottomRight;
    }

    public boolean Contains(Point point){
        return point.getX()>=this.topLeft.getX()&&point.getX()<=this.bottomRight.getX()
                &&point.getY()>=this.topLeft.getY()&&point.getY()<=this.bottomRight.getY();
    }
}
