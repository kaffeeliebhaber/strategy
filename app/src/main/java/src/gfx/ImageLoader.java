package src.gfx;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ImageLoader {

    public static BufferedImage loadImageFromResource(final String imagePath) {
        BufferedImage image = null;

        try {
            image = ImageIO.read(ImageLoader.class.getResource(imagePath));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return image;
    }

    /*
    TODO: Das Laden einer Datei funktioniert aktuell noch nicht. Daher eher die Methode 'loadImageFromResource' benutzen.
     */
    public static BufferedImage loadImageFromFolder(final String imagePath) {
        BufferedImage image = null;

        try {
            image = ImageIO.read(new File(imagePath));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return image;
    }
}