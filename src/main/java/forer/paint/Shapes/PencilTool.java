package forer.paint.Shapes;

import forer.paint.Point;

import java.awt.*;

public class PencilTool implements Tool {
    @Override
    public void onDrag(Graphics g, Point currentPoint, Point nextPoint) {
        g.setColor(currentPoint.getColor());
        g.drawLine(currentPoint.getX(), currentPoint.getY(),
                nextPoint.getX(), nextPoint.getY());
    }

}
