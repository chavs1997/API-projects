package forer.maze;

import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class MazeView extends JFrame {

    MazePanel maze;
    public MazeView(int length) {
        setTitle("Maze");
        setSize(1000, 1000);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        maze = new MazePanel(length);
        add(maze);
        addKeyListener(new MyKeyAdapter());
    }

    private class MyKeyAdapter extends KeyAdapter {

        @Override
        public void keyPressed(KeyEvent keyEvent) {

            if (keyEvent.getKeyCode() == KeyEvent.VK_LEFT) {
                maze.directionLeft();
            } else if (keyEvent.getKeyCode() == KeyEvent.VK_RIGHT) {
                maze.directionRight();
            } else if (keyEvent.getKeyCode() == KeyEvent.VK_UP) {
                maze.directionUp();
            } else if (keyEvent.getKeyCode() == KeyEvent.VK_DOWN) {
                maze.directionDown();
            }
        }
    }


            public static void main(String[] args) {

        JDialog.setDefaultLookAndFeelDecorated(true);
        Object[] selectionValues = {"5 x 5", "10 x 10", "15 x 15", "20 x 20"};
        String initialSelection = "5 x 5";
        Object selection = JOptionPane.showInputDialog(null, "Choose a mazeGrid size:",
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
        } else {
            length = 10;
        }
        new MazeView(length).setVisible(true);

    }
}
