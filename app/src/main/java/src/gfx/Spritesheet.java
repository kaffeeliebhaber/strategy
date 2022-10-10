package src.gfx;

import java.awt.image.BufferedImage;

public class Spritesheet {

    private int tilesize;

    private int scaleFactorX;
    private int scaleFactorY;

    private BufferedImage spritesheet;

    private BufferedImage[][] subImages;

    private int rows;
    private int cols;

    public Spritesheet(final String path, int tilesize, int scaleFactorX, int scaleFactorY) {
        this(ImageLoader.loadImageFromResource(path), tilesize, scaleFactorX, scaleFactorY);
    }

    public Spritesheet(final String path, int tilesize)  {
        this(path, tilesize, 1, 1);
    }

    public Spritesheet(final BufferedImage spritesheet, int tilesize, int scaleFactorX, int scaleFactorY) {
        this.spritesheet = spritesheet;
        this.tilesize = tilesize;

        this.scaleFactorX = scaleFactorX;
        this.scaleFactorY = scaleFactorY;

        this.rows = spritesheet.getHeight() / tilesize;
        this.cols = spritesheet.getWidth() / tilesize;

        subImages = new BufferedImage[rows][cols];

    }

    public void load() {
        if (spritesheet == null) {
            return;
        }

        for (int y = 0; y < rows; y++) {
            for (int x = 0; x < cols; x++) {
                //subImages[y][x] = spritesheet.getSubimage(x * tileWidth, y * tileHeight, tileWidth, tileHeight);
                final BufferedImage subImage = spritesheet.getSubimage(x * tilesize, y * tilesize, tilesize, tilesize);
                final BufferedImage scaledBufferedImage = BufferedImageUtil.scale(subImage, scaleFactorX, scaleFactorY);
                subImages[y][x] = scaledBufferedImage;
                //subImages[y][x] = subImage;
            }
        }
    }

    public BufferedImage getImageByIndex(int index) {
        return getImageAt(index / cols, index % cols);
    }

    public BufferedImage getImageAt(int row, int col) {

        try {
            return subImages[row][col];
        } catch (ArrayIndexOutOfBoundsException e) {
            //System.out.println("row: " + row + ", col: " + col);
        }
        return null;
    }

    public BufferedImage[] getImages(int row) {
        return subImages[row];
    }

    public BufferedImage getSpritesheet() {
        return spritesheet;
    }

    public int getTilesize() {
        return tilesize;
    }
}