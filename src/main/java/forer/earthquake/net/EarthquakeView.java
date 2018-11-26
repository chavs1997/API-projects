package forer.earthquake.net;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.*;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Singleton;

@SuppressWarnings("serial")
@Singleton
public class EarthquakeView extends JFrame {

<<<<<<< HEAD
    /*private JLabel enterMonthMag = new JLabel();
    private JLabel enterWeekMag = new JLabel();
    private JLabel enterDayMag = new JLabel();
    private JLabel enterHourMag = new JLabel();
    private JLabel enterMonthLoc = new JLabel();
    private JLabel enterWeekLoc = new JLabel();
    private JLabel enterDayLoc = new JLabel();
    private JLabel enterHourLoc = new JLabel();
*/
=======
>>>>>>> master
    private JLabel magOne = new JLabel();
    private JLabel locOne = new JLabel();
    private JLabel magTwo = new JLabel();
    private JLabel locTwo = new JLabel();
    private JLabel magThree = new JLabel();
    private JLabel locThree = new JLabel();
    private JLabel magFour = new JLabel();
    private JLabel locFour = new JLabel();
    private JLabel magFive = new JLabel();
    private JLabel locFive = new JLabel();

    public EarthquakeView() {
<<<<<<< HEAD
        setTitle("Top 5 Earthquakes of the Day");
=======
        setTitle("Past 5 Earthquakes in the Hour");
>>>>>>> master
        setSize(500, 350);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JPanel homePanel = new JPanel();
        homePanel.setLayout(new BoxLayout(homePanel, BoxLayout.Y_AXIS));
<<<<<<< HEAD
        homePanel.setBackground(Color.BLUE);
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridBagLayout());
        mainPanel.setBackground(Color.GREEN);
=======
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridBagLayout());
>>>>>>> master
        GridBagConstraints constraint = new GridBagConstraints();
        constraint.gridx = 0;
        constraint.gridy = 0;
        constraint.fill = GridBagConstraints.BOTH;
        constraint.insets = new Insets(3, 2, 3, 2);

        constraint.gridy = 1;
        mainPanel.add(new JLabel("First Earthquake: "), constraint);
        constraint.gridy = 2;
        mainPanel.add(new JLabel("Second Earthquake: "), constraint);
        constraint.gridy = 3;
        mainPanel.add(new JLabel("Third Earthquake: "), constraint);
        constraint.gridy = 4;
        mainPanel.add(new JLabel("Fourth Earthquake: "), constraint);
        constraint.gridy = 5;
        mainPanel.add(new JLabel("Fifth Earthquake: "), constraint);
        constraint.gridx = 1;
        constraint.gridy = 0;
        mainPanel.add(new JLabel("Magnitude   "), constraint);
        constraint.gridy = 1;
        mainPanel.add(magOne, constraint);
        constraint.gridy = 2;
        mainPanel.add(magTwo, constraint);
        constraint.gridy = 3;
        mainPanel.add(magThree, constraint);
        constraint.gridy = 4;
        mainPanel.add(magFour, constraint);
        constraint.gridy = 5;
        mainPanel.add(magFive, constraint);
        constraint.gridx = 2;
        constraint.gridy = 0;
        mainPanel.add(new JLabel("   Location   "), constraint);
        constraint.gridy = 1;
        mainPanel.add(locOne, constraint);
        constraint.gridy = 2;
        mainPanel.add(locTwo, constraint);
        constraint.gridy = 3;
        mainPanel.add(locThree, constraint);
        constraint.gridy = 4;
        mainPanel.add(locFour, constraint);
        constraint.gridy = 5;
        mainPanel.add(locFive, constraint);

<<<<<<< HEAD

=======
>>>>>>> master
        homePanel.add(mainPanel);
        add(homePanel);


    }

    public static void main(String[] args) {

        Injector injector = Guice.createInjector(new EarthquakeModule());
        EarthquakeView view = injector.getInstance(EarthquakeView.class);
        EarthquakeController controller = injector.getInstance(EarthquakeController.class);

<<<<<<< HEAD
        Timer timer = new Timer(30000, (event) -> controller.refreshData());
        timer.setInitialDelay(0);
        timer.start();


        view.setVisible(true);
    }

    public JLabel[] getDayMagLabel() {
=======
        controller.refreshData();
        view.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                controller.stop();
            }
        });
        view.setVisible(true);
    }

    public JLabel[] getHourMagLabel() {
>>>>>>> master
        JLabel[] magnitudes = new JLabel[]{magOne, magTwo, magThree, magFour, magFive};
        return magnitudes;
    }

<<<<<<< HEAD
    public JLabel[] getDayLocLabel() {
=======
    public JLabel[] getHourLocLabel() {
>>>>>>> master
        JLabel[] locations = new JLabel[]{locOne, locTwo, locThree, locFour, locFive};
        return locations;
    }


}
