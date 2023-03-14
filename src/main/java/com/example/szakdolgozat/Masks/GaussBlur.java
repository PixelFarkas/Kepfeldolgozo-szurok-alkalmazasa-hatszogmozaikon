package com.example.szakdolgozat.Masks;

import com.example.szakdolgozat.HexagonController;
import com.example.szakdolgozat.Picture;

import java.awt.image.BufferedImage;
import java.util.stream.IntStream;

public class GaussBlur extends Masks {

    public GaussBlur(int height, int width) {
        super(height, width);
    }


    public static void blur() {
        int height1 = pixel.length;
        int width1 = pixel[0].length;

        BufferedImage image = HexagonController.resizedImage;

        for (int y = 0; y < height1; y++) {
            for (int x = 0; x < width1; x++) {
                image.setRGB(x, y, pixel[y][x]);
            }
        }

        int[] filter = null;
        switch (Picture.radius) {
            case 1:
                filter = new int[]{1, 1, 1, 1, 2, 1, 0, 1, 0};
                radius = 3;
                break;
            case 2:
                filter = new int[]{0, 1, 1, 1, 0, 1, 2, 2, 2, 1, 1, 2, 4, 2, 1, 1, 1, 2, 1, 1, 0, 0, 1, 0, 0};
                radius = 5;
                break;
            case 3:
                filter = new int[]{0, 0, 1, 1, 1, 0, 0, 1, 1, 2, 2, 2, 1, 1, 1, 2, 4, 4, 4, 2, 1, 1, 2, 4, 8, 4, 2, 1, 1, 2, 2, 4, 2, 2, 1, 0, 1, 1, 2, 1, 1, 0, 0, 0, 1, 1, 1, 0, 0};
                radius = 7;
                break;
            default:
                break;
        }
        if (filter.length % radius != 0) {
            throw new IllegalArgumentException("filter contains a incomplete row");
        }

        final int width = image.getWidth();
        final int height = image.getHeight();
        final int sum = IntStream.of(filter).sum();

        int[] input = image.getRGB(0, 0, width, height, null, 0, width);

        int[] output = new int[input.length];

        final int pixelIndexOffset = width - radius;
        final int centerOffsetX = radius / 2;
        final int centerOffsetY = filter.length / radius / 2;

        // apply filter
        for (int h = height - filter.length / radius + 1, w = width - radius + 1, y = 0; y < h; y++) {
            for (int x = 0; x < w; x++) {
                int r = 0;
                int g = 0;
                int b = 0;
                for (int filterIndex = 0, pixelIndex = y * width + x;
                     filterIndex < filter.length;
                     pixelIndex += pixelIndexOffset) {
                    for (int fx = 0; fx < radius; fx++, pixelIndex++, filterIndex++) {
                        int col = input[pixelIndex];
                        int factor = filter[filterIndex];

                        r += ((col >>> 16) & 0xFF) * factor;
                        g += ((col >>> 8) & 0xFF) * factor;
                        b += (col & 0xFF) * factor;
                    }
                }
                r /= sum;
                g /= sum;
                b /= sum;
                output[x + centerOffsetX + (y + centerOffsetY) * width] = (r << 16) | (g << 8) | b | 0xFF000000;
            }
        }

        BufferedImage result = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        result.setRGB(0, 0, width, height, output, 0, width);
        for (int row = 0; row < image.getWidth(); row++) {
            for (int col = 0; col < image.getHeight(); col++) {
                Picture.pixel[col][row] = result.getRGB(row, col);
            }
        }

    }
}

