package forer.paint.Shapes;

import forer.paint.Point;

import java.awt.*;


public class RectangleTool implements Tool{
    @Override
    public void onDrag(Graphics g, Point point, Point nextPoint) {
        g.setColor(point.getColor());
        int px = Math.min(point.getX(),nextPoint.getX());
        int py = Math.min(point.getY(),nextPoint.getY());
        int pw=Math.abs(point.getX()-nextPoint.getX());
        int ph=Math.abs(point.getY()-nextPoint.getY());
        g.drawRect(px, py, pw, ph);
      }
}
