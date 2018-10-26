package forer.paint;

import javafx.scene.shape.Circle;
import sun.java2d.loops.DrawRect;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;


public class Canvas extends JComponent{
    MouseEvent event;
    public Canvas(){

            setBackground(Color.WHITE);
            addMouseMotionListener(new MouseMotionListener() {
                @Override
                public void mouseDragged(MouseEvent e) {
                        event = e;
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
        g2.drawOval(event.getX(), event.getY(), 1, 1);

    }


}
