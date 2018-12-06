package forer.paint;

import forer.paint.Shapes.Shape;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Window extends JFrame {
    public Window() throws IOException {
        setTitle("Paint");
        setSize(800, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Canvas paintCanvas = new Canvas();
        setLayout(new BorderLayout());
        add(paintCanvas, BorderLayout.CENTER);

        JPanel topPanel = new JPanel();

        JButton undoButton = new JButton("Undo");
        undoButton.addActionListener(e -> paintCanvas.undo());
        topPanel.add(undoButton);

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

        JButton fillRecButton = new JButton("Filled Rectangle");
        fillRecButton.addActionListener(e -> paintCanvas.setCurrentType(Shape.Type.FilledRectangle));
        topPanel.add(fillRecButton);

        JButton heartButton = new JButton("Heart");
        heartButton.addActionListener(e -> paintCanvas.setCurrentType(Shape.Type.Heart));
        topPanel.add(heartButton);

        JButton eraser = new JButton();
        Image eraseIcon = ImageIO.read(new File("eraser.png")).getScaledInstance(20,20, Image.SCALE_DEFAULT);
        eraser.setIcon(new ImageIcon(eraseIcon));
        eraser.addActionListener(e -> paintCanvas.setCurrentType(Shape.Type.Eraser));
        topPanel.add(eraser);


        add(topPanel, BorderLayout.NORTH);
    }

    public static void main(String[] args) throws IOException {
        new Window().setVisible(true);
    }

}
