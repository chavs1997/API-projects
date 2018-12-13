package forer.paint.Shapes;

import java.awt.*;

public class PencilTool implements Tool {


    private int width = 5;
    private Color col;

    public PencilTool(Color col) {
        this.col = col;
    }


    @Override
    public void onDrag(Graphics g, Point currentPoint, Point nextPoint) {
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
