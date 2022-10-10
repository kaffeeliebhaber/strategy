package src.gfx;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;

public class BufferedImageUtil {

    public static BufferedImage scale(final BufferedImage bufferedImage, int scaleFactorX, int scaleFactorY) {

        int actualWidth = bufferedImage.getWidth();
        int actualHeight = bufferedImage.getHeight();

        int newWidth = actualWidth * scaleFactorX;
        int newHeight = actualHeight * scaleFactorY;

        Image newImage = bufferedImage.getScaledInstance(newWidth, newHeight, Image.SCALE_FAST);

        BufferedImage newBufferedImage = new BufferedImage(newImage.getWidth(null), newImage.getHeight(null), BufferedImage.TYPE_INT_ARGB);

        Graphics g = newBufferedImage.createGraphics();
        g.drawImage(newImage, 0, 0, null);
        g.dispose();

        return newBufferedImage;
    }

}
