package forer.paint.Shapes;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class HeartTool implements Tool {

    @Override
    public void onDrag(Graphics g, Point point, Point nextPoint) {
        int px = Math.min(point.getX(), nextPoint.getX());
        int py = Math.min(point.getY(), nextPoint.getY());
        int pw = Math.abs(point.getX() - nextPoint.getX());
        int ph = Math.abs(point.getY() - nextPoint.getY());

        try {
            BufferedImage heart = ImageIO.read(new File("src/resources/heartIcon.png"));
            g.drawImage(heart, px, py, pw, ph, new Color(255, 187, 139), null);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
