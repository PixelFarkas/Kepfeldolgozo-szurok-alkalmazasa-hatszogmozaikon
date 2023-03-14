package com.example.szakdolgozat;

import java.awt.*;

public class Picture {
    public static int height;
    public static int width;
    public static int radius;
    public static int[][] pixel;
    public static int[][] filterPixel;
    public static int[][] unsharpPixel;
    public static Color c;
    public static String savepath = "";
    public static String path = "";


    public Picture(int height, int width) {
        setHeight(height);
        setWidth(width);
        pixel = new int[height][width];

    }

    public static Color getColor(int i, int j) {
        return c = new Color(pixel[i][j]);
    }

    public static int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        Picture.height = height;
    }

    public static int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        Picture.width = width;
    }

}
