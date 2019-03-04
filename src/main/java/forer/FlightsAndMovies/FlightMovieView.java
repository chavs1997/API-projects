package forer.FlightsAndMovies;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Singleton;
import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;

@Singleton
public class FlightMovieView extends JFrame {

    List<Movie> movies = new ArrayList<>();
    List<JLabel> labels = new ArrayList<>(10);
    List<JLabel> time_labels = new ArrayList<>(10);
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
            homePanel.add(label, constraint);
            constraint.gridy++;
        }
        constraint.gridx +=1;
        constraint.gridy = 0;
        for(int i = 0; i <10;i++){
            JLabel time_label = new JLabel("");
            time_labels.add(time_label);
            homePanel.add(time_label, constraint);
            constraint.gridy++;
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
        view.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                controller.stop();
            }
        });
        view.setVisible(true);
    }

    int i=0;
    public void addMovies(Movie movie) {
        if(movie.getRuntime() >= duration - 35 ) {
            movies.add(movie);
        }
        System.out.println(movie.getTitle());
        if(i < 10) {
            labels.get(i).setText(movie.getTitle());
            time_labels.get(i).setText(Integer.toString(movie.getRuntime()) + " min");
            i++;
        }
    }
    public int duration;
    public void setTop(Flight randomFlight) {
        duration = randomFlight.getFlightDuration();
        flight.setText("Flight Number: " + randomFlight.flightNumber + "          Flight Duration: " + randomFlight.getFlightDuration());
    }
}
