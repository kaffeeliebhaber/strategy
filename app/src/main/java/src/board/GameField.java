package src.board;

import src.board.pieces.GamePiece;

public class GameField {

    private GamePiece gamePiece;

    private boolean isLocked;

    public GameField() {

    }

    public void setIsLocked(boolean isLocked) { this.isLocked = isLocked; }

    public boolean isLocked() { return isLocked; }

    public void setGamePiece(final GamePiece gamePiece) {
        this.gamePiece = gamePiece;
    }

    public boolean isEmpty() {
        return gamePiece == null;
    }
}
