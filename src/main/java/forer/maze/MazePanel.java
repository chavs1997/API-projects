package forer.maze;

import javax.swing.*;
import java.awt.*;
public class MazePanel extends JComponent {

    private int length;
    private Maze maze;

    public MazePanel(int length){
        this.length = length;
        maze = new Maze(length);

    }

    public void paintComponent(Graphics g){

        Graphics2D g2 = (Graphics2D) g;
        BasicStroke stroke = new BasicStroke(200);
        g2.setStroke(stroke);
        g2.setColor(Color.BLUE);
        int j = 0;

        for (int i = 0; i < length * length; i++) {
            g2.drawLine(maze.getStart(i, j)* (500/length),
                    maze.getStart(i,j+1) * (500/length),
                    maze.getEnd(i, j) * (500/length),
                    maze.getEnd(i, j+1) * (500/length));
        }
    }
}
