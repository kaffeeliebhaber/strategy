package src.board.pieces;

import java.awt.image.BufferedImage;

public class Bomb extends GamePiece {

    public Bomb() {
        super();

        /*


        this.value = 0;
        this.canMove = false;
        this.image = null;


         */
    }

    @Override
    protected int getValue() {
        return 0;
    }

    @Override
    public boolean canMove() {
        return false;
    }

    @Override
    public BufferedImage getImage() {
        return null;
    }

    @Override
    public boolean isFlag() {
        return false;
    }

    @Override public String getName() { return "BOMB"; }

}
