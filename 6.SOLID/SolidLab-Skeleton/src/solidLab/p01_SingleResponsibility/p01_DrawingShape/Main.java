package solidLab.p01_SingleResponsibility.p01_DrawingShape;

public class Main {
    public static void main(String[] args) {
        Rectangle rectangle = new Rectangle(5,7);
        RendererImpl renderer = new RendererImpl();
        rectangle.draw(renderer);
    }
}
