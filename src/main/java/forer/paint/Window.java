package forer.paint;

import forer.paint.Shapes.Shape;

import javax.swing.*;
import java.awt.*;

public class Window extends JFrame {
    public Window() {
        setTitle("Paint");
        setSize(800, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Canvas paintCanvas = new Canvas();
        setLayout(new BorderLayout());
        add(paintCanvas, BorderLayout.CENTER);
        JPanel topPanel = new JPanel();
        JButton colorButton = new JButton("Choose Color!");
        colorButton.addActionListener(e -> paintCanvas.setColor(JColorChooser.showDialog(paintCanvas,
                "Choose a color", new Color(100, 1, 94))));
        topPanel.add(colorButton);
        JButton pencilButton = new JButton("Pencil");
        pencilButton.addActionListener(e -> paintCanvas.setCurrentType(Shape.Type.Line));
        topPanel.add(pencilButton);
        JButton recButton = new JButton("Rectangle");
        recButton.addActionListener(e -> paintCanvas.setCurrentType(Shape.Type.Rectangle));
        topPanel.add(recButton);
        add(topPanel, BorderLayout.NORTH);
    }

    public static void main(String[] args) {
        new Window().setVisible(true);
    }

}
