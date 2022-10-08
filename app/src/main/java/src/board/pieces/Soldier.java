package src.board.pieces;

import java.awt.image.BufferedImage;

public class Soldier extends GamePiece {

    public Soldier() {
        super();

        /*

        this.value = 1;
        this.canMove = true;
        this.image = null;

         */
    }

    @Override
    protected int getValue() {
        return 1;
    }

    @Override
    public boolean canMove() {
        return true;
    }

    @Override
    public BufferedImage getImage() {
        return null;
    }

    @Override
    public boolean isFlag() {
        return false;
    }

    @Override public String getName() { return "SOLDIER"; }
}
