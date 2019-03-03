package forer.FlightsAndMovies;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Singleton;
import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Singleton
public class FlightMovieView extends JFrame {

    List<Movie> movies = new ArrayList<>();
    List<JLabel> labels = new ArrayList<>(10);
    JLabel flight = new JLabel();
    public FlightMovieView(){
        setSize(400, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Movie by Flight Time");
        JPanel homePanel = new JPanel(new GridBagLayout());
        GridBagConstraints constraint = new GridBagConstraints();
        constraint.gridx = 0;
        constraint.gridy = 0;
        constraint.fill = GridBagConstraints.BOTH;
        constraint.insets = new Insets(3, 2, 3, 2);
        JPanel top = new JPanel();
        top.add(flight);
        for(int i = 0; i < 10; i++){
            JLabel label = new JLabel("");
            labels.add(label);
            constraint.gridy++;
            homePanel.add(label, constraint);
        }
        JPanel main = new JPanel(new BorderLayout());
        main.add(flight, BorderLayout.NORTH);
        main.add(homePanel);
        add(main);
    }

    public static void main(String [] args){
        Injector injector = Guice.createInjector(new MovieModule());
        FlightMovieView view = injector.getInstance(FlightMovieView.class);
        FlightMovieController controller = injector.getInstance(FlightMovieController.class);

        controller.getFlightInformation();
        System.out.println(view.movies.size());
        view.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                controller.stop();
            }
        });
        view.setVisible(true);
    }

    private void setUp() {
        for(int i = 0; i < movies.size(); i++){
                labels.get(i).setText(movies.get(i).getTitle());
        }
    }


    int i=0;
    public void addMovies(Movie movie) {
        movies.add(movie);
        System.out.println(movie.getTitle());
        if(i < 10) {
            labels.get(i).setText(movie.getTitle());
            i++;
        }
    }

    public void setTop(Flight randomFlight) {
        flight.setText("Flight Number: " + randomFlight.flightNumber);
    }
}
