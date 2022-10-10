package src.ui;

import java.awt.image.BufferedImage;

public class UIBoardField {

    private static int createdBoardFields = 0;
    private final int ID;
    private BufferedImage image;
    private boolean selected;

    public UIBoardField(final BufferedImage image) {

        ID = ++createdBoardFields;
        this.image = image;
    }

    public void select() {
        this.selected = true;
    }

    public void deSelect() {
        this.selected = false;
    }

    public boolean isSelected() {
        return selected;
    }

    public BufferedImage getImage() {
        return image;
    }

    @Override
    public boolean equals(Object o) {

        if (!(o instanceof UIBoardField)) {
            return false;
        }

        UIBoardField boardField = (UIBoardField) o;

        if (this.ID != boardField.ID) {
            return false;
        }

        return true;
    }
}
