package forer.maze;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class MazePanel extends JComponent {

    private Maze maze;
    private int length;
    Image girlImage;
    private int height;
    private int squareHeight;
    private Girl girl = new Girl(0,0);
    private BufferedImage read;

    public MazePanel(int length) {
        this.length = length;
        maze = new Maze(length);
        try {
            read = ImageIO.read(new File("running-girl.jpg"));

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public int getLength() {
        return length;
    }

    public Girl getGirl() {
        return girl;
    }

    public void paintComponent(Graphics g) {

        Graphics2D g2 = (Graphics2D) g;
        BasicStroke stroke = new BasicStroke(15);
        g2.setStroke(stroke);
        g2.setColor(Color.BLUE);
        height = this.getHeight();
        squareHeight = height / length;
        super.paintComponent(g);
        for (int row = 0; row < length; row++) {
            for (int column = 0; column < length; column++) {
                Cell current = maze.getCell(row, column);
                if (current.isWWall()) {
                    g.drawLine(column  * squareHeight, row * squareHeight, column * squareHeight, (row + 1) * squareHeight);
                }

                if (current.isNWall()) {
                    g.drawLine(column * squareHeight, row * squareHeight, (column+1)  * squareHeight, row  * squareHeight);
                }

                if (current.isEWall()) {
                    g.drawLine((column + 1) * squareHeight, row * squareHeight, (column + 1) * squareHeight, (row + 1) * squareHeight);
                }

                if (current.isSWall()) {
                    g.drawLine(column * squareHeight, (row + 1) * squareHeight, (column + 1) * squareHeight, (row + 1) * squareHeight);
                }

            }
        }

        paintGirl(g);
    }

    private void paintGirl(Graphics g) {
        girlImage = read.getScaledInstance(squareHeight-20, squareHeight-20, Image.SCALE_DEFAULT);
        g.drawImage(girlImage,(girl.getColumn()*squareHeight) + 10,
                (girl.getRow()*squareHeight) + 10 , null);
    }

    public void directionLeft() {
        if(girl.getColumn() != 0 && !maze.getCell(girl.getRow(), girl.getColumn()).isWWall()){
            girl.setColumn(girl.getColumn() - 1);
        }
    }

    public void directionRight() {
        if(girl.getColumn() != length && !maze.getCell(girl.getRow(), girl.getColumn()).isEWall()){
            girl.setColumn(girl.getColumn() + 1);
        }
    }

    public void directionUp() {
        if(girl.getRow() != 0 && !maze.getCell(girl.getRow(), girl.getColumn()).isNWall()){
            girl.setRow(girl.getRow() - 1);
        }
    }

    public void directionDown() {
        if(girl.getRow() != length && !maze.getCell(girl.getRow(), girl.getColumn()).isSWall()){
            girl.setRow(girl.getRow() + 1);
        }
    }
}