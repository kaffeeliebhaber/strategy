package src.board.pieces;

// Capturing this gamepiece wins the game for the attacking player.
// TODO: So, how to implement this feature?

import java.awt.image.BufferedImage;

public class Flag extends GamePiece {
    public Flag() {
        super();

        /*

        this.value = 0; // TODO: Which value should be assigned??
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
        return true;
    }

    @Override public String getName() { return "FLAG"; }
}
