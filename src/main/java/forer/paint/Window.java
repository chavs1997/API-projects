package forer.paint;

import javax.swing.*;
import java.awt.*;

public class Window extends JFrame{
    public Window(){
        setTitle("Paint");
        setSize(800,600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Canvas paintCanvas = new Canvas();
        setLayout(new BorderLayout());
        add(paintCanvas, BorderLayout.CENTER);
    }

    public static void main(String [] args){
        new Window().setVisible(true);
    }

}
