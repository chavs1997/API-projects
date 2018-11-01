package forer.paint;


import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;


public class Canvas extends JComponent {

    ArrayList<Integer> x =  new ArrayList();
    ArrayList<Integer> y =  new ArrayList();

    public Canvas() {

        setBackground(Color.WHITE);
        addMouseMotionListener(new MouseMotionListener() {
            @Override
            public void mouseDragged(MouseEvent e) {
                x.add(e.getX());
                y.add(e.getY());
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
        BasicStroke stroke = new BasicStroke(5);
        g2.setStroke(stroke);
        g2.setColor(Color.BLUE);
        g2.fillRect(0, 0, getWidth(), getHeight());
        g2.setColor(Color.WHITE);
        for(int i = 0; i < x.size() - 1; i++){
            g.drawLine(x.get(i), y.get(i), x.get(i+1), y.get(i+1));
        }
    }


}
