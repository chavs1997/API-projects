package forer.paint;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

class ButtonMaker{
    private String type;
    private JButton typeButton;

    JButton generateButton(String type) throws IOException {
        this.type = type;
        typeButton = new JButton();
        setButtonIcon();
        return typeButton;
    }

    private void setButtonIcon() throws IOException {
        switch (type) {
            case "Undo":
                Image undoIcon = ImageIO.read(new File("undo icon.png")).getScaledInstance(20, 20, Image.SCALE_DEFAULT);
                typeButton.setIcon(new ImageIcon(undoIcon));
                break;
            case "Color":
                Image colorIcon = ImageIO.read(new File("color-icon.png")).getScaledInstance(20, 20, Image.SCALE_DEFAULT);
                typeButton.setIcon(new ImageIcon(colorIcon));
                break;
            case "Eraser":
                Image eraseIcon = ImageIO.read(new File("eraser.png")).getScaledInstance(20, 20, Image.SCALE_DEFAULT);
                typeButton.setIcon(new ImageIcon(eraseIcon));
                break;
            case "Heart":
                Image heartIcon = ImageIO.read(new File("heartIcon.png")).getScaledInstance(20, 20, Image.SCALE_DEFAULT);
                typeButton.setIcon(new ImageIcon(heartIcon));
                break;
            case "Pencil":
                Image pencilIcon = ImageIO.read(new File("pencil.png")).getScaledInstance(20, 20, Image.SCALE_DEFAULT);
                typeButton.setIcon(new ImageIcon(pencilIcon));
                break;
            case "Rectangle":
                Image recIcon = ImageIO.read(new File("rectangle.png")).getScaledInstance(20, 20, Image.SCALE_DEFAULT);
                typeButton.setIcon(new ImageIcon(recIcon));
                break;
            case "Filled Rectangle":
                Image fillRecIcon = ImageIO.read(new File("filled rectangle.png")).getScaledInstance(20, 20, Image.SCALE_DEFAULT);
                typeButton.setIcon(new ImageIcon(fillRecIcon));
                break;
        }


    }

}
