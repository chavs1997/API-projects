package forer.maze;

import javax.swing.*;
import java.awt.*;

public class MazePanel extends JComponent {

    private Maze maze;
    private int size;

    public MazePanel(int length) {
        size = length;
        maze = new Maze(length);
    }

    public void paintComponent(Graphics g) {

        Graphics2D g2 = (Graphics2D) g;
        BasicStroke stroke = new BasicStroke(15);
        g2.setStroke(stroke);
        g2.setColor(Color.BLUE);
        super.paintComponent(g);
        int height = this.getHeight() / size;

        for (int column = 0; column < size; column++) {
            for (int row = 0; row < size; row++) {
                Cell current = maze.getCell(column, row);
                if (current.isWWall()) {
                    g.drawLine((row + 1) * height, column * height, (row + 1) * height, column * height + height);
                }

                if (current.isNWall()) {
                    g.drawLine((row + 1) * height, column * height, (row + 1) * height + height, column * height);
                }

                if (current.isEWall()) {
                    g.drawLine((row + 1) * height + height, column * height, (row + 1) * height + height, column * height + height);
                }

                if (current.isSWall()) {
                    g.drawLine((row + 1) * height, column * height + height, (row + 1) * height + height, column * height + height);
                }

            }
        }
    }
}
