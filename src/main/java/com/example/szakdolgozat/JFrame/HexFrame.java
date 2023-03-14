package com.example.szakdolgozat.JFrame;

import com.example.szakdolgozat.Picture;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

public class HexFrame extends JFrame {
    HexaPanel hexaPanel;

    public HexFrame() {
        super("Hexagon");
        setLayout(new BorderLayout());
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setPreferredSize(new Dimension(Picture.width * 6 + 25, Picture.height * 8 + 55));
        Hexagon hexagon = new Hexagon(0, 0);
        hexaPanel = new HexaPanel(hexagon);
        add(BorderLayout.CENTER, hexaPanel);

        pack();
        setVisible(true);

        BufferedImage image = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_RGB);
        Graphics2D g2 = image.createGraphics();
        paint(g2);
        try {
            ImageIO.write(image, "jpg", new File(Picture.savepath));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


}
