package forer.paint.Shapes;

import forer.paint.Point;

import java.awt.*;
import java.util.ArrayList;

public class Shape {
    private ArrayList<Point> points = new ArrayList();

    public void paint(Graphics g) {
        if(type == Type.Line) {
            PencilTool tool = new PencilTool();
            for (int j = 0; j < this.getPoints().size() - 1; j++) {
                tool.onDrag(g, this.getPoints().get(j), this.getPoints().get(j + 1));

            }
        }
        if(type == Type.Rectangle){
            RectangleTool tool = new RectangleTool();
            tool.onDrag(g,this.getPoints().get(0), this.getPoints().get(this.getPoints().size() - 1));

        }

        if(type == Type.Heart){
            HeartTool tool = new HeartTool();
            tool.onDrag(g, this.getPoints().get(0), this.getPoints().get(this.getPoints().size()-1));

        }
    }

    public enum Type {
        Rectangle, Heart, Line
    }

    private Type type;

    public Shape(Type type) {
        this.type = type;
    }

    public ArrayList<Point> getPoints() {
        return points;
    }
}
