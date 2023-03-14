package com.example.szakdolgozat.JFrame;

import java.awt.*;
import java.awt.geom.Point2D;

public class Hexagon {
    private final int radius = 5;
    private final Polygon hexagon;
    private final double height = 4;
    private final Point2D.Double center;

    public Hexagon(double x, double y) {
        this.center = new Point2D.Double(x, y);
        this.hexagon = createHexagon();
    }


    private Polygon createHexagon() {
        Polygon polygon = new Polygon();
        for (int i = 0; i < 6; i++) {
            int xval = (int) (center.x + radius
                    * Math.cos(i * 2 * Math.PI / 6));
            int yval = (int) (center.y + radius
                    * Math.sin(i * 2 * Math.PI / 6));
            polygon.addPoint(xval, yval);
        }
        return polygon;
    }


    public int getRadius() {
        return radius;
    }

    public double getHeight() {
        return height;
    }

    public Polygon getHexagon() {
        createHexagon();
        return hexagon;
    }

}