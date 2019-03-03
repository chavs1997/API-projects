import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.lang.*;


public class Movies extends JFrame{

    public Movies (){

        setTitle("Movies!!!");
        setSize(500, 350);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // Home panel
        //JPanel homePanel = new JPanel();

        // Flight info panel
        JPanel infoPanel = new JPanel();
        float flightLength = (float) 2.5;
        infoPanel.add(new JLabel("Flight length: " + flightLength + " hours"));
        add(infoPanel, BorderLayout.NORTH);


        // Movies panel
        JPanel moviesPanel = new JPanel();
        //moviesPanel.setSize(new Dimension(500, 300));
        //moviesPanel.setLayout(new BoxLayout(moviesPanel, BoxLayout.X_AXIS));
        //moviesPanel.setBounds(100, 200, 100, 300);
        //moviesPanel.add(new JLabel("Movie list"));
        moviesPanel.setBackground(Color.BLUE);
        //moviesPanel.setPreferredSize(new Dimension(400, 200));
        //add(moviesPanel, BorderLayout.CENTER);

        // Movies scroll panel
        JScrollPane scroll = new JScrollPane(moviesPanel);
        add(scroll, BorderLayout.CENTER);


        // Fake movie array
        String[] movieArray = {"movie1", "movie2", "movie3", "movie4", "movie5", "movie6", "movie7", "movie8", "movie9", "movie10"};
        String[] summaryArray = {"summary1", "summary2", "summary3", "summary4", "summary5", "summary6", "summary7", "summary8", "summary9", "summary10"};
        float[] timesArray = new float[movieArray.length];
        Random gen = new Random();
        for (int i = 0; i < timesArray.length; i++) {
            timesArray[i] = Math.round(gen.nextFloat()*20)/(float)5;
            System.out.println(timesArray[i]);
        }

        // Movies info panel
        InfoPanel movieInfoPanel = new InfoPanel();
        movieInfoPanel.setBackground(Color.lightGray);
        movieInfoPanel.setPreferredSize(new Dimension(500, 150));
        movieInfoPanel.importMovies(movieArray, summaryArray, timesArray);
        add(movieInfoPanel, BorderLayout.SOUTH);
        movieInfoPanel.setVisible(false);

        //add(homePanel);
        JButton[] buttons = new JButton[movieArray.length];

        ActionListener displayMovie = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                movieInfoPanel.setVisible(false);
                for (int i = 0; i < movieArray.length; i++){
                    if (buttons[i] == e.getSource()) {
                        movieInfoPanel.setIndex(i);
                    }
                }
                movieInfoPanel.setVisible(true);
            }
        };

        int x = 100;

        for(int b = 0; b < buttons.length; b++){
            if (timesArray[b] <= flightLength) {
                buttons[b] = new JButton(movieArray[b]);
                buttons[b].addActionListener(displayMovie);
                buttons[b].setPreferredSize(new Dimension(75, 100));
                //moviesPanel.add(Box.createRigidArea(new Dimension(5,0)));
                moviesPanel.add(buttons[b]);
                x += 150;
            }
        }

    }
    public static void main(String[] args){
        Movies view = new Movies();
        view.setVisible(true);
    }


}

