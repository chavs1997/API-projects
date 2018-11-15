package forer.paint.Shapes;

import forer.paint.Point;

public class Shape {
     private Point startPoint;
     private Point endPoint;
     public enum Type{
         Rectangle, Circle, Line
     }

     private Type type;

    public Shape(Point startPoint, Type type) {
        this.startPoint = startPoint;
        this.type = type;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public Point getStartPoint() {
        return startPoint;
    }

    public void setStartPoint(Point startPoint) {
        this.startPoint = startPoint;
    }

    public Point getEndPoint() {
        return endPoint;
    }

    public void setEndPoint(Point endPoint) {
        this.endPoint = endPoint;
    }
}
