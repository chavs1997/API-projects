package forer.paint;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;


public class Canvas extends JComponent{
    public Canvas(){
            setBackground(Color.WHITE);
            addMouseMotionListener(new MouseMotionListener() {
                @Override
                public void mouseDragged(MouseEvent e) {
                    System.out.println(e.getX() + ", " + e.getY());
                }

                @Override
                public void mouseMoved(MouseEvent e) {

                }
            });

    }

}
