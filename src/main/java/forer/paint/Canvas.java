package forer.paint;

import forer.paint.Shapes.Shape;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

public class Canvas extends JComponent {
    private boolean shape = false;
    private int shapeCounter = 0;
    private Color mainColor;
    private ArrayList<ArrayList<Shape>> shapePoints = new ArrayList();

    public Canvas() {
        shapePoints.add(new ArrayList<>());
        setBackground(Color.WHITE);
        addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {
                shapePoints.add(new ArrayList<>());
                shapeCounter++;
            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
        addMouseMotionListener(new MouseMotionListener() {

            @Override
            public void mouseDragged(MouseEvent e) {
                if (!shape) {
                    if (mainColor == null) {
                        mainColor = new Color(100, 1, 94);
                    }
                    Shape shape = new Shape(new Point(e.getX(), e.getY(), mainColor), Shape.Type.Line);
                    shapePoints.get(shapeCounter).add(shape);
                    repaint();
                }

            }

            @Override
            public void mouseMoved(MouseEvent e) {

            }

        });

    }


    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        BasicStroke stroke = new BasicStroke(2);
        g2.setStroke(stroke);

        g2.setColor(new Color(255, 187, 139));
        g2.fillRect(0, 0, getWidth(), getHeight());

        for (int i = 0; i < shapePoints.size(); i++) {
            for (int j = 0; j < shapePoints.get(i).size() - 1; j++) {
                Point currentPoint = shapePoints.get(i).get(j).getStartPoint();
                g2.setColor(currentPoint.getColor());
                Point nextPoint = shapePoints.get(i).get(j + 1).getStartPoint();
                g2.drawLine(currentPoint.getX(), currentPoint.getY(),
                        nextPoint.getX(), nextPoint.getY());
            }

        }
    }


    public void setColor(Color color) {
        mainColor = color;
    }

    public void setShape(boolean shape) {
        this.shape = shape;
    }
}
