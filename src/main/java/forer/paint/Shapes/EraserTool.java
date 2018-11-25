package forer.paint.Shapes;

import forer.paint.Point;

import java.awt.*;

public class EraserTool implements Tool{


    private int width = 15;
    private Color col = Color.WHITE;

    @Override
    public void onDrag(Graphics g, forer.paint.Point currentPoint, Point nextPoint) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setStroke(new BasicStroke(width));
        g2.setColor(col);
        g2.drawLine(currentPoint.getX(), currentPoint.getY(),
                nextPoint.getX(), nextPoint.getY());
    }
    public void setWidth(int width) {
        this.width = width;
    }
}
