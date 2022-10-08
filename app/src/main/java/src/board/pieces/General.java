package src.board.pieces;

import java.awt.image.BufferedImage;

public class General extends GamePiece {

    public General() {
        super();
/*


        this.value = 3;
        this.canMove = true;
        this.image = null;



 */
    }

    @Override
    protected int getValue() {
        return 3;
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

    @Override public String getName() { return "GENERAL"; }
}
