package forer.paint;


import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;


public class Canvas extends JComponent {
    int counter = 0;
    ArrayList<ArrayList<Point>> points = new ArrayList();

    public Canvas() {
        points.add(new ArrayList<>());
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
                points.add(new ArrayList<>());
                counter++;
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
                points.get(counter).add(new Point(e.getX(), e.getY()));
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
        Graphics2D g2 = (Graphics2D) g;
        BasicStroke stroke = new BasicStroke(2);
        g2.setStroke(stroke);
        g2.setColor(Color.BLUE);
        g2.fillRect(0, 0, getWidth(), getHeight());
        g2.setColor(Color.WHITE);
        for (int i = 0; i < points.size(); i++) {
            for (int j = 0; j < points.get(i).size() - 1; j++) {
                g.drawLine(points.get(i).get(j).getX(), points.get(i).get(j).getY(),
                        points.get(i).get(j + 1).getX(), points.get(i).get(j + 1).getY());
            }
        }
    }


}
