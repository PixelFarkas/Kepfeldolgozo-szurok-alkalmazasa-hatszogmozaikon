package com.example.szakdolgozat.Masks;


import com.example.szakdolgozat.Picture;

public class Masks extends Picture {

    public Masks(int height, int width) {
        super(height, width);
        filterPixel = new int[height][width];
        unsharpPixel = new int[height][width];
    }

    public static int getRed(int i, int j) {
        if (i < 0 || i >= height || j < 0 || j >= width) {
            return -1;
        }
        return (pixel[i][j] >> 16) & 0xFF;
    }

    public static int getBlue(int i, int j) {
        if (i < 0 || i >= height || j < 0 || j >= width) {
            return -1;
        }
        return (pixel[i][j]) & 0xFF;
    }

    public static int getGreen(int i, int j) {

        if (i < 0 || i >= height || j < 0 || j >= width) {
            return -1;
        }
        return (pixel[i][j] >> 8) & 0xFF;
    }

    public static int getRedFilter(int i, int j) {
        if (i < 0 || i >= height || j < 0 || j >= width) {
            return -1;
        }
        return (unsharpPixel[i][j] >> 16) & 0xFF;
    }

    public static int getBlueFilter(int i, int j) {
        if (i < 0 || i >= height || j < 0 || j >= width) {
            return -1;
        }
        return (unsharpPixel[i][j]) & 0xFF;
    }

    public static int getGreenFilter(int i, int j) {
        if (i < 0 || i >= height || j < 0 || j >= width) {
            return -1;
        }
        return (unsharpPixel[i][j] >> 8) & 0xFF;
    }

    public static int controll(float num) {
        if (num >= 0) {
            if (num > 255) {
                return 255;
            } else {
                return (int) num;
            }
        } else {
            if (num < -255) {
                return 255;
            } else {
                return (int) -num;
            }
        }
    }

    public static int getGray(int i, int j) {
        if (i < 0 || i >= height || j < 0 || j >= width) {
            return -1;
        }
        return (getRed(i, j) + getGreen(i, j) + getBlue(i, j)) / 3;
    }

    public static double scale(final double valueIn, final double baseMin, final double baseMax, final double limitMin, final double limitMax) {
        return ((limitMax - limitMin) * (valueIn - baseMin) / (baseMax - baseMin)) + limitMin;
    }
}
