package com.example.szakdolgozat.JFrame;

import com.example.szakdolgozat.Picture;

import javax.swing.*;
import java.awt.*;

public class HexaPanel extends JPanel {

    private Hexagon hexagon2;

    public HexaPanel(Hexagon hexagon) {
        this.hexagon2 = hexagon;


    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        int row = 0;
        int col;
        double hm;
        double hl = 0;
        for (int i = 0; i < Picture.getWidth(); i++) {
            hl += hexagon2.getHeight() * 1.5;
            col = 0;
            if (row % 2 != 1) {
                hm = hexagon2.getRadius();
                for (int j = 0; j < Picture.getHeight(); j++) {
                    hm = hm + hexagon2.getHeight() * 2;
                    hexagon2 = new Hexagon((int) hl, hm);
                    g.setColor(Picture.getColor(col, row));
                    g.fillPolygon(hexagon2.getHexagon());

                    col++;
                }
            } else {
                hm = hexagon2.getRadius() * 1.48;
                for (int j = 0; j < Picture.getHeight(); j++) {
                    hm += hexagon2.getHeight() * 2;
                    hexagon2 = new Hexagon(hl, hm);
                    g.setColor(Picture.getColor(col, row));
                    g.fillPolygon(hexagon2.getHexagon());

                    col++;

                }
            }
            row++;
        }

    }
}
