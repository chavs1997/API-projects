package forer.maze;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class MazePanel extends JComponent {

    private Maze maze;
    private int size;
    BufferedImage girlImage;
    private int height;
    private int squareHeight;
    private Girl girl = new Girl(1,1);

    public MazePanel(int length) {
        size = length;
        maze = new Maze(length);
        try {
            girlImage = ImageIO.read(new File("/forer-mco364-fall-2018/src/resources/running-girl.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void paintComponent(Graphics g) {

        Graphics2D g2 = (Graphics2D) g;
        BasicStroke stroke = new BasicStroke(15);
        g2.setStroke(stroke);
        g2.setColor(Color.BLUE);
        super.paintComponent(g);
        height = this.getHeight();
        squareHeight = height / size;

        for (int column = 0; column < size; column++) {
            for (int row = 0; row < size; row++) {
                Cell current = maze.getCell(column, row);
                if (current.isWWall()) {
                    g.drawLine((row + 1) * squareHeight, column * squareHeight, (row + 1) * squareHeight, column * squareHeight + squareHeight);
                }

                if (current.isNWall()) {
                    g.drawLine((row + 1) * squareHeight, column * squareHeight, (row + 1) * squareHeight + squareHeight, column * squareHeight);
                }

                if (current.isEWall()) {
                    g.drawLine((row + 1) * squareHeight + squareHeight, column * squareHeight, (row + 1) * squareHeight + squareHeight, column * squareHeight + squareHeight);
                }

                if (current.isSWall()) {
                    g.drawLine((row + 1) * squareHeight, column * squareHeight + squareHeight, (row + 1) * squareHeight + squareHeight, column * squareHeight + squareHeight);
                }

            }
        }

        paintGirl(g);
    }

    private void paintGirl(Graphics g) {
        g.drawImage(girlImage,girl.getColumn()*squareHeight + (squareHeight/2),
                girl.getRow()*squareHeight - (int)(squareHeight/1.5), null);
    }

    public void directionLeft() {
    }

    public void directionRight() {
    }

    public void directionUp() {
    }

    public void directionDown() {
    }
}
