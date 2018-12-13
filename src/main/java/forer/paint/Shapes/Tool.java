package forer.paint.Shapes;

import java.awt.*;

public interface Tool {
    void onDrag(Graphics g, Point thisPoint, Point nextPoint);
}
