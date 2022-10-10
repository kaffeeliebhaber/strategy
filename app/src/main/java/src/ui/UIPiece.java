package src.ui;

import java.awt.image.BufferedImage;

public class UIPiece {

    private final BufferedImage image;
    private boolean visible;

    // TODO. Implementierung der Funktion, dass das Hover-Image zurückgeliefert wird, wenn der Cursor über dem Feld ist.
    private boolean hover;

    public UIPiece(final BufferedImage image) {
        this.image = image;
        setVisible(true);
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    public void toggleVisible() {
        this.visible = !this.visible;
    }

    public BufferedImage getImage() {
        return image;
    }
}
