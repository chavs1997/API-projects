package forer.paint;

import forer.paint.Shapes.Shape;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

public class Canvas extends JComponent {
    private Shape.Type currentType = Shape.Type.Line;
    private int shapeCounter = 0;
    private Color mainColor;
    private ArrayList<Shape> shapes = new ArrayList();

    public Canvas() {
        setBackground(Color.WHITE);
        addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {
                Shape shape = new Shape(currentType);
                shapes.add(shape);
            }

            @Override
            public void mouseReleased(MouseEvent e) {
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
                if (mainColor == null) {
                    mainColor = new Color(100, 1, 94);
                }

                shapes.get(shapeCounter).getPoints().add(new Point(e.getX(), e.getY(), mainColor));
                repaint();
            }


            @Override
            public void mouseMoved(MouseEvent e) {

            }

        });

    }


    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(new Color(255, 187, 139));
        g.fillRect(0, 0, getWidth(), getHeight());

        for (Shape shape : shapes) {
            shape.paint(g);
        }
    }


    public void setColor(Color color) {
        mainColor = color;
    }

    public void setCurrentType(Shape.Type currentType) {
        this.currentType = currentType;
    }
}
