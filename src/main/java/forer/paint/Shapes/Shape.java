package forer.paint.Shapes;

import java.awt.*;
import java.io.Serializable;
import java.util.ArrayList;

public class Shape implements Serializable {
    private ArrayList<Point> points = new ArrayList();

    private Color col;

    public Shape(Type type, Color col) {
        this.col = col;
        this.type = type;
    }

    public Color getColor() {
        return col;
    }

    public void paint(Graphics g) {
        if (type == Type.Line) {
            PencilTool tool = new PencilTool(col);
            for (int j = 0; j < points.size() - 1; j++) {
                tool.onDrag(g, points.get(j), points.get(j + 1));

            }
        }
        if (type == Type.Rectangle) {
            RectangleTool tool = new RectangleTool(col, false);
            tool.onDrag(g, points.get(0), points.get(points.size() - 1));

        }

        if (type == Type.FilledRectangle) {
            RectangleTool tool = new RectangleTool(col, true);
            tool.onDrag(g, points.get(0), points.get(points.size() - 1));
        }

        if (type == Type.Heart) {
            HeartTool tool = new HeartTool();
            tool.onDrag(g, points.get(0), points.get(points.size() - 1));

        }

        if (type == Type.Eraser) {
            EraserTool tool = new EraserTool();
            for (int j = 0; j < points.size() - 1; j++) {
                tool.onDrag(g, points.get(j), points.get(j + 1));

            }

        }
    }

    public ArrayList<Point> getPoints() {
        return points;
    }

    public enum Type {
        Rectangle, Heart, Line, Eraser, FilledRectangle
    }

    private Type type;


}
