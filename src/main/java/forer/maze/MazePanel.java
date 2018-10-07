package forer.maze;

import javax.swing.*;
import java.awt.*;

public class MazePanel extends JComponent {

    private Maze maze;
    private int size = 5;

    public MazePanel() {
        maze = new Maze(size);
    }

    public void paintComponent(Graphics g) {

        Graphics2D g2 = (Graphics2D) g;
        BasicStroke stroke = new BasicStroke(500);
        g2.setStroke(stroke);
        g2.setColor(Color.BLUE);

        for (int i = 0; i < maze.size; i++) {
            for (int j = 0; j < maze.size; j++) {
                if (maze.getCell(i, j).isEWall()) {
                    g2.drawLine(i, j + 1, i + 1, j + 1);
                }
                if (maze.getCell(i, j).isNWall()) {
                    g2.drawLine(i, j, i, j + 1);
                }
                if (maze.getCell(i, j).isSWall()) {
                    g2.drawLine(i + 1, j, i + 1, j + 1);
                }
                if (maze.getCell(i, j).isWWall()) {
                    g2.drawLine(i, j, i + 1, j);
                }
            }
        }
    }
}
