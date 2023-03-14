package com.example.szakdolgozat.Masks;

import java.awt.*;

public class UnsharpFilter extends Masks {
    public UnsharpFilter(int height, int width) {
        super(height, width);
    }

    public static int unsharpFilter(int i, int j, String color) {
        switch (color) {
            case "red":
                return controll((float) getRedFilter(i, j) + (((float) getRedFilter(i, j) - (float) getRed(i, j)) * 7) / 7);
            case "green":
                return controll((float) getGreenFilter(i, j) + (((float) getGreenFilter(i, j) - (float) getGreen(i, j)) * 7) / 7);
            case "blue":
                return controll((float) getBlueFilter(i, j) + (((float) getBlueFilter(i, j) - (float) getBlue(i, j)) * 7) / 7);
            default:
                return 0;
        }
    }


    public static void unsharp() {
        for (int i = 0; i < height; i++) {
            if (width >= 0) System.arraycopy(pixel[i], 0, unsharpPixel[i], 0, width);
        }
        MeanFilter.meanFilter();
        Color mean;
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {

                mean = new Color(unsharpFilter(i, j, "red"), unsharpFilter(i, j, "green"), unsharpFilter(i, j, "blue"));
                filterPixel[i][j] = mean.getRGB();

            }
        }
        for (int i = 0; i < height; i++) {
            if (width >= 0) System.arraycopy(filterPixel[i], 0, pixel[i], 0, width);
        }
    }
}
