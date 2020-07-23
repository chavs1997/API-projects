import javax.swing.*;
import java.awt.*;

public class InfoPanel extends JPanel {
    public String[] movies;
    public String[] summs;
    public float[] times;
    public int index;

    protected void paintComponent(Graphics g) {
        super.paintComponent(g); // do your superclass's painting routine first, and then paint on top of it.
        g.setColor(Color.DARK_GRAY);
        g.fillRect(25, 25, 50, 75);
        g.drawString("Name: " + movies[this.index], 100, 40);
        g.drawString("Summary: " + summs[this.index], 100, 60);
        g.drawString("Length: " + times[this.index] + " hours", 100, 80);
        g.setColor(Color.blue);
        g.drawString("Play Trailer         Play Movie", 100, 100);
    }

    public void importMovies(String[] movies, String[] summs, float[] times) {
        this.movies = movies;
        this.summs = summs;
        this.times = times;
    }

    public void setIndex(int a) {
        this.index = a;
    }


}
