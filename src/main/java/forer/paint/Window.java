package forer.paint;

import javax.swing.*;

public class Window extends JFrame{
    public Window(){
        setTitle("Paint");
        setSize(800,600);
        Canvas paintCanvas = new Canvas();
        add(paintCanvas);
    }

    public static void main(String [] args){
        new Window().setVisible(true);
    }

}
