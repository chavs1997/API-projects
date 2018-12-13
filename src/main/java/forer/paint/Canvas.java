package forer.paint;

import forer.paint.Shapes.Shape;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.ArrayList;

public class Canvas extends JComponent {
    private Shape.Type currentType = Shape.Type.Line;
    private int shapeCounter = 0;
    private Color mainColor;
    private ArrayList<Shape> shapes = new ArrayList();
    private File userFilePNG;
    private String userFileShapes;

    public Canvas() {
        setBackground(Color.WHITE);
        addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {
                Shape shape = new Shape(currentType, mainColor);
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

                shapes.get(shapeCounter).getPoints().add(new Point(e.getX(), e.getY()));
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
        drawBackground(g);
        for (Shape shape : shapes) {
            shape.paint(g);
        }
    }

    private void drawBackground(Graphics g) {
        g.setColor(new Color(255, 187, 139));
        g.fillRect(0, 0, getWidth(), getHeight());
    }


    public void setColor(Color color) {
        mainColor = color;
    }

    public void setCurrentType(Shape.Type currentType) {
        this.currentType = currentType;
    }

    public void undo() {
        if (shapes.size() > 0) {
            shapes.remove(shapes.size() - 1);
            shapeCounter--;
            repaint();
        }
    }

    public void saveAsPNG() throws IOException {
        BufferedImage bufferedImage = new BufferedImage(this.getWidth(), this.getHeight(), BufferedImage.TYPE_INT_RGB);
        Graphics2D g2d = bufferedImage.createGraphics();

        drawBackground(g2d);
        for (Shape shape : shapes) {
            g2d.setColor(shape.getColor());
            shape.paint(g2d);
        }

        File filePNG = new File(userFilePNG.getAbsolutePath() + ".png");
        ImageIO.write(bufferedImage, "png", filePNG);
    }

    public void setUserFilePNG(File userFilePNG) {
        this.userFilePNG = userFilePNG;
    }

    public void saveAsShapes() throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream(userFileShapes);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);

        objectOutputStream.writeObject(shapes);

        objectOutputStream.close();
    }

    public void openAsShapes() throws IOException, ClassNotFoundException {
        FileInputStream fileInputStream = new FileInputStream(userFileShapes);
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

        Object shape = objectInputStream.readObject();
        shapes.clear();
        shapes.addAll((ArrayList<Shape>) shape);
        objectInputStream.close();
        repaint();
    }

    public void setUserFileShapes(String userFileShapes) {
        this.userFileShapes = userFileShapes;
    }
}
