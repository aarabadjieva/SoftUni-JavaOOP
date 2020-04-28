package solidLab.p02_OpenClosedPrinciple.p02_DrawingShape;

import solidLab.p02_OpenClosedPrinciple.p02_DrawingShape.interfaces.DrawingManager;
import solidLab.p02_OpenClosedPrinciple.p02_DrawingShape.interfaces.Shape;

public class Rectangle implements Shape {

    @Override
    public void draw(DrawingManagerImpl drawingManager) {
        drawingManager.draw(this);
    }
}
