package forer.paint.Shapes;

import forer.paint.Point;

import java.awt.*;

public interface Tool {
    void onDrag(Graphics g, Point thisPoint, Point nextPoint);
}
