package forer.paint.Shapes;

import forer.paint.Point;

import java.awt.*;


public class RectangleTool implements Tool{


    private int width = 5;
    private Color col;
    public RectangleTool(Color col) {
        this.col = col;
    }

    @Override
    public void onDrag(Graphics g, Point point, Point nextPoint) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(col);
        g2.setStroke(new BasicStroke(width));

        int px = Math.min(point.getX(),nextPoint.getX());
        int py = Math.min(point.getY(),nextPoint.getY());
        int pw=Math.abs(point.getX()-nextPoint.getX());
        int ph=Math.abs(point.getY()-nextPoint.getY());
        g2.drawRect(px, py, pw, ph);

      }
    public void setWidth(int width) {
        this.width = width;
    }
}
