package com.example.szakdolgozat.Masks;

import com.example.szakdolgozat.Picture;

import java.awt.*;

public class FreiChen extends Masks {
    public FreiChen(int height, int width) {
        super(height, width);
    }

    public static void freiChenFilter() {
        int color;
        int min = 255;
        int max = 0;
        for (int i = 0; i < Picture.height; i++) {
            for (int j = 0; j < Picture.width; j++) {
                int x = -1 * getGray(i - 1, j - 1) + (int) (-1 * Math.sqrt(2) * getGray(i, j - 1)) + -1 * getGray(i + 1, j - 1) + getGray(i - 1, j) + getGray(i + 1, j) + (int) (Math.sqrt(2) * getGray(i, j + 1));
                int y = getGray(i - 1, j - 1) + -1 * getGray(i, j - 1) + (int) (-1 * Math.sqrt(2) * getGray(i + 1, j - 1) + -1 * getGray(i - 1, j) + (int) Math.sqrt(2) * getGray(i + 1, j) + getGray(i, j + 1));
                int z = (int) (Math.sqrt(2) * getGray(i - 1, j - 1) + getGray(i, j - 1) + -1 * getGray(i + 1, j - 1) + (int) (-1 * Math.sqrt(2)) * getGray(i - 1, j) + -1 * getGray(i + 1, j) + getGray(i, j + 1));
                color = (int) Math.sqrt((x * x) + (y * y) + (z * z));
                if (color < min) {
                    min = color;
                }
                if (color > max) {
                    max = color;
                }

                color = (int) scale(color, min, max, 0, 255);
                Picture.filterPixel[i][j] = new Color(color, color, color).getRGB();
            }
        }

        for (int i = 0; i < Picture.height; i++) {
            if (Picture.width >= 0) System.arraycopy(Picture.filterPixel[i], 0, Picture.pixel[i], 0, Picture.width);
        }
    }

}
