package forer.paint;

import forer.paint.Shapes.Shape;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class Window extends JFrame {
    private Window() throws IOException {
        setTitle("Paint");
        setSize(800, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Canvas paintCanvas = new Canvas();
        ButtonMaker bMaker = new ButtonMaker();
        setLayout(new BorderLayout());
        add(paintCanvas, BorderLayout.CENTER);
        JPanel topPanel = new JPanel();

        JButton undoButton = bMaker.generateButton("Undo");
        undoButton.addActionListener(e -> paintCanvas.undo());
        topPanel.add(undoButton);

        JButton colorButton = bMaker.generateButton("Color");
        colorButton.addActionListener(e -> paintCanvas.setColor(JColorChooser.showDialog(paintCanvas,
                "Choose a color", new Color(100, 1, 94))));
        topPanel.add(colorButton);

        JButton pencilButton = bMaker.generateButton("Pencil");
        pencilButton.addActionListener(e -> paintCanvas.setCurrentType(Shape.Type.Line));
        topPanel.add(pencilButton);

        JButton recButton = bMaker.generateButton("Rectangle");
        recButton.addActionListener(e -> paintCanvas.setCurrentType(Shape.Type.Rectangle));
        topPanel.add(recButton);

        JButton fillRecButton = bMaker.generateButton("Filled Rectangle");
        fillRecButton.addActionListener(e -> paintCanvas.setCurrentType(Shape.Type.FilledRectangle));
        topPanel.add(fillRecButton);

        JButton heartButton = bMaker.generateButton("Heart");
        heartButton.addActionListener(e -> paintCanvas.setCurrentType(Shape.Type.Heart));
        topPanel.add(heartButton);

        JButton eraser = bMaker.generateButton("Eraser");
        eraser.addActionListener(e -> paintCanvas.setCurrentType(Shape.Type.Eraser));
        topPanel.add(eraser);

        add(topPanel, BorderLayout.NORTH);
    }

    public static void main(String[] args) throws IOException {
        new Window().setVisible(true);
    }

}
