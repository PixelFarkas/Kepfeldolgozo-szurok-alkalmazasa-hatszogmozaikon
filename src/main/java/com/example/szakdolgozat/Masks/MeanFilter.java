package com.example.szakdolgozat.Masks;

import com.example.szakdolgozat.Picture;

import java.awt.*;

public class MeanFilter extends Masks {
    public MeanFilter(int height, int width) {
        super(height, width);
    }

    public static void meanFilter() {
        Color mean;
        for (int i = 0; i < Picture.height; i++) {
            for (int j = 0; j < Picture.width; j++) {


                if (Picture.radius == 1) {
                    mean = new Color((getRed(i, j) + getRed(i - 1, j) + getRed(i + 1, j) + getRed(i, j + 1) + getRed(i, j - 1) + getRed(i - 1, j - 1) + getRed(i + 1, j - 1)) / 7,
                            (getGreen(i, j) + getGreen(i - 1, j) + getGreen(i + 1, j) + getGreen(i, j + 1) + getGreen(i, j - 1) + getGreen(i - 1, j - 1) + getGreen(i + 1, j - 1)) / 7,
                            (getBlue(i, j) + getBlue(i - 1, j) + getBlue(i + 1, j) + getBlue(i, j + 1) + getBlue(i, j - 1) + getBlue(i - 1, j - 1) + getBlue(i + 1, j - 1)) / 7);
                } else if (Picture.radius == 2) {
                    mean = new Color((getRed(i, j) + getRed(i - 1, j) + getRed(i + 1, j) + getRed(i, j + 1) + getRed(i, j - 1) + getRed(i - 1, j - 1) + getRed(i + 1, j - 1) + getRed(i - 2, j) + getRed(i + 2, j) + getRed(i, j + 2) + getRed(i, j - 2) + getRed(i - 1, j + 1) + getRed(i - 2, j - 1) + getRed(i + 2, j - 1) + getRed(i + 1, j + 1) + getRed(i + 2, j + 1) + getRed(i + 1, j - 2) + getRed(i - 2, j + 1) + getRed(i - 1, j - 2)) / 19,
                            (getGreen(i, j) + getGreen(i - 1, j) + getGreen(i + 1, j) + getGreen(i, j + 1) + getGreen(i, j - 1) + getGreen(i - 1, j - 1) + getGreen(i + 1, j - 1) + getGreen(i - 2, j) + getGreen(i + 2, j) + getGreen(i, j + 2) + getGreen(i, j - 2) + getGreen(i - 1, j + 1) + getGreen(i - 2, j - 1) + getGreen(i + 2, j - 1) + getGreen(i + 1, j + 1) + getGreen(i + 2, j + 1) + getGreen(i + 1, j - 2) + getGreen(i - 2, j + 1) + getGreen(i - 1, j - 2)) / 19,
                            (getBlue(i, j) + getBlue(i - 1, j) + getBlue(i + 1, j) + getBlue(i, j + 1) + getBlue(i, j - 1) + getBlue(i - 1, j - 1) + getBlue(i + 1, j - 1) + getBlue(i - 2, j) + getBlue(i + 2, j) + getBlue(i, j + 2) + getBlue(i, j - 2) + getBlue(i - 1, j + 1) + getBlue(i - 2, j - 1) + getBlue(i + 2, j - 1) + getBlue(i + 1, j + 1) + getBlue(i + 2, j + 1) + getBlue(i + 1, j - 2) + getBlue(i - 2, j + 1) + getBlue(i - 1, j - 2)) / 19);

                } else if (Picture.radius == 3) {
                    mean = new Color((getRed(i, j) + getRed(i - 1, j) + getRed(i + 1, j) + getRed(i, j + 1) + getRed(i, j - 1) + getRed(i - 1, j - 1) + getRed(i + 1, j - 1) + getRed(i - 2, j) + getRed(i + 2, j) + getRed(i, j + 2) + getRed(i, j - 2) + getRed(i - 1, j + 1) + getRed(i - 2, j - 1) + getRed(i + 2, j - 1) + getRed(i + 1, j + 1) + getRed(i + 2, j + 1) + getRed(i + 1, j - 2) + getRed(i - 2, j + 1) + getRed(i - 1, j - 2) + getRed(i, j - 3) + getRed(i - 1, j - 3) + getRed(i + 1, j - 3) + getRed(i - 2, j - 2) + getRed(i + 2, j - 2) + getRed(i - 3, j - 1) + getRed(i + 3, j - 1) + getRed(i + 3, j - 2) + getRed(i - 3, j - 2) + getRed(i - 3, j) + getRed(i + 3, j) + getRed(i + 3, j + 1) + getRed(i + 3, j + 1) + getRed(i - 2, j + 2) + getRed(i + 2, j + 2) + getRed(i - 1, j + 2) + getRed(i + 1, j + 2) + getRed(i, j + 3)) / 37,
                            (getGreen(i, j) + getGreen(i - 1, j) + getGreen(i + 1, j) + getGreen(i, j + 1) + getGreen(i, j - 1) + getGreen(i - 1, j - 1) + getGreen(i + 1, j - 1) + getGreen(i - 2, j) + getGreen(i + 2, j) + getGreen(i, j + 2) + getGreen(i, j - 2) + getGreen(i - 1, j + 1) + getGreen(i - 2, j - 1) + getGreen(i + 2, j - 1) + getGreen(i + 1, j + 1) + getGreen(i + 2, j + 1) + getGreen(i + 1, j - 2) + getGreen(i - 2, j + 1) + getGreen(i - 1, j - 2) + getGreen(i, j - 3) + getGreen(i - 1, j - 3) + getGreen(i + 1, j - 3) + getGreen(i - 2, j - 2) + getGreen(i + 2, j - 2) + getGreen(i - 3, j - 1) + getGreen(i + 3, j - 1) + getGreen(i + 3, j - 2) + getGreen(i - 3, j - 2) + getGreen(i - 3, j) + getGreen(i + 3, j) + getGreen(i + 3, j + 1) + getGreen(i + 3, j + 1) + getGreen(i - 2, j + 2) + getGreen(i + 2, j + 2) + getGreen(i - 1, j + 2) + getGreen(i + 1, j + 2) + getGreen(i, j + 3)) / 37,
                            (getBlue(i, j) + getBlue(i - 1, j) + getBlue(i + 1, j) + getBlue(i, j + 1) + getBlue(i, j - 1) + getBlue(i - 1, j - 1) + getBlue(i + 1, j - 1) + getBlue(i - 2, j) + getBlue(i + 2, j) + getBlue(i, j + 2) + getBlue(i, j - 2) + getBlue(i - 1, j + 1) + getBlue(i - 2, j - 1) + getBlue(i + 2, j - 1) + getBlue(i + 1, j + 1) + getBlue(i + 2, j + 1) + getBlue(i + 1, j - 2) + getBlue(i - 2, j + 1) + getBlue(i - 1, j - 2) + getBlue(i, j - 3) + getBlue(i - 1, j - 3) + getBlue(i + 1, j - 3) + getBlue(i - 2, j - 2) + getBlue(i + 2, j - 2) + getBlue(i - 3, j - 1) + getBlue(i + 3, j - 1) + getBlue(i + 3, j - 2) + getBlue(i - 3, j - 2) + getBlue(i - 3, j) + getBlue(i + 3, j) + getBlue(i + 3, j + 1) + getBlue(i + 3, j + 1) + getBlue(i - 2, j + 2) + getBlue(i + 2, j + 2) + getBlue(i - 1, j + 2) + getBlue(i + 1, j + 2) + getBlue(i, j + 3)) / 37);
                } else {
                    throw new IllegalStateException("Unexpected value: radius: " + Picture.radius);
                }
                Picture.filterPixel[i][j] = mean.getRGB();
            }
        }

        for (
                int i = 0;
                i < Picture.height; i++) {
            if (Picture.width >= 0) System.arraycopy(Picture.filterPixel[i], 0, Picture.pixel[i], 0, Picture.width);
        }
    }
}
