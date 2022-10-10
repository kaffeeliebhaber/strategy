package src.ui;

import src.gfx.Spritesheet;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.util.Random;


public class UIBoard {

    // LOOK
    private final Spritesheet spritesheetBoard;
    private final Spritesheet spritesheetBoardPieces;

    // POSITION
    private int x;
    private int y;

    // DATA
    private final int cols;
    private final int rows;
    private final int width;
    private final int height;

    private UIBoardField[][] boardFields;
    private UIBoardField selectedBoardField;

    private Random r;

    public UIBoard(final int cols, final int rows, final int width, final int height, final Spritesheet spritesheetBoard, Spritesheet spritesheetBoardPieces) {
        this.rows = rows;
        this.cols = cols;
        this.width = width;
        this.height = height;
        this.spritesheetBoard = spritesheetBoard;
        this.spritesheetBoardPieces = spritesheetBoardPieces;

        boardFields = new UIBoardField[cols][rows];

        r = new Random();
    }

    /*
        Used, currenlty, for select the right board field.
     */
    public void mouseMoved(MouseEvent e) {

        if (containsPoint(e.getPoint())) {
            selectBoardField(convertPosXToTileX(e.getX()), convertPosYToTileY(e.getY()));
        } else {
            deSelectBoardTile();
        }
    }

    /*

        1. Set board field piece to visible 'no'

     */
    public void mousePressed(MouseEvent e) {

        if (containsPoint(e.getPoint())) {
            System.out.println("[UIBoard.mousePressed] Point: " + e.getPoint());
        }

    }

    /*
        Mouse selected board field piece and mouse with mouse cursor.
     */
    public void mouseDragged(MouseEvent e) {

        if (containsPoint(e.getPoint())) {
            System.out.println("[UIBoard.mouseDragged] ");
        }

    }

    /*
        Place, selected, board field piece to new postion.

     */
    public void mouseReleased(MouseEvent e) {

        if (containsPoint(e.getPoint())) {
            System.out.println("[UIBoard.mouseReleased] Point: " + e.getPoint());
        }


    }

    private boolean containsPoint(Point p) {
        return new Rectangle(x, y, cols * width, rows * height).contains(p);
    }

    private int convertPosXToTileX(int mouseX) {
        return (mouseX - x) / width;
    }

    private int convertPosYToTileY(int mouseY) {
        return (mouseY - y) / height;
    }

    public void selectBoardField(int tileX, int tileY) {

        UIBoardField currentSelectedBoardField = getBoardField(tileX, tileY);

        if (selectedBoardField == null) {
            selectedBoardField = currentSelectedBoardField;
            selectedBoardField.select();
        } else if (!selectedBoardField.equals(currentSelectedBoardField)) {

            selectedBoardField.deSelect();
            selectedBoardField = currentSelectedBoardField;

            if (selectedBoardField != null) {
                selectedBoardField.select();
            }
        }
    }

    private UIBoardField getBoardField(final int tileX, final int tileY) {

        UIBoardField boardField = null;

        if (tileX < 0 || tileX >= cols || tileY < 0 || tileY >= rows) {
            System.out.println("[getBoardField.error] TileX: " + tileX + ", TileY: " + tileY);
        } else {
            boardField = boardFields[tileX][tileY];
        }

        return boardField;
    }

    public void deSelectBoardTile() {
        if (selectedBoardField != null) {
            selectedBoardField.deSelect();
            selectedBoardField = null;
        }
    }

    public void init() {
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                boardFields[col][row] = new UIBoardField(spritesheetBoard.getImageAt(r.nextInt(8), r.nextInt(8)));
            }
        }
    }

    // TODO: Current work.
    public void setGameFieldPieces() {







    }

    public void setPosition(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void translateX(final int deltaX) {
        this.x += deltaX;
    }

    public void translateY(final int deltaY) {
        this.y += deltaY;
    }

    public void draw(Graphics2D g2D) {
        drawBoardFields(g2D);
        drawSelectedBoardFields(g2D);
        drawTest(g2D);
    }

    private void drawImageAt(Graphics2D g2D, final java.awt.image.BufferedImage image, final int row, final int col) {
        g2D.drawImage(
                image,
                x + col * width,
                y + row * height,
                null);
    }

    private void drawBoardFields(Graphics2D g2D) {
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                drawImageAt(g2D, getBoardField(col, row).getImage(), row, col);
            }
        }
    }

    private void drawSelectedBoardFields(Graphics2D g2D) {
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (getBoardField(col, row).isSelected()) {
                    g2D.setColor(Color.RED);
                    g2D.drawRect(x + col * width, y + row * height, width, height);
                }
            }
        }
    }

    private void drawTest(Graphics2D g2D) {

        drawImageAt(g2D, spritesheetBoardPieces.getImageAt(0, 0), 0, 7);

    }



}
