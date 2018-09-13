package forer.maze;

import javax.swing.*;
import java.awt.*;

public class MazeView extends JFrame {
    public MazeView(int length) {
        setTitle("Maze");
        setSize(800, 800);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        MazePanel maze = new MazePanel(length);
        add(maze);
    }

    public static void main(String[] args) {

        JDialog.setDefaultLookAndFeelDecorated(true);
        Object[] selectionValues = {"5 x 5", "10 x 10", "15 x 15", "20 x 20", "50 x 50"};
        String initialSelection = "5 x 5";
        Object selection = JOptionPane.showInputDialog(null, "Choose a maze size:",
                "Maze Display", JOptionPane.QUESTION_MESSAGE, null, selectionValues, initialSelection);
        String selected = selection.toString();
        int length;
        if (selected.equals("5 x 5")) {
            length = 5;
        } else if (selected.equals("10 x 10")) {
            length = 10;
        } else if (selected.equals("15 x 15")) {
            length = 15;
        } else if (selected.equals("20 x 20")) {
            length = 20;
        } else if (selected.equals("50 x 50")) {
            length = 50;
        } else {
            length = 10;
        }

        new MazeView(length).setVisible(true);
    }
}
