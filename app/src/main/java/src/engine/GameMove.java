package src.engine;

import src.board.pieces.GamePiece;
import src.board.GameBoard;

public class GameMove {

    private GameBoard gameBoard;

    private int row;
    private int col;
    private GamePiece gamePiece;

    public GameMove(GameBoard gameBoard) {
        this.gameBoard = gameBoard;
    }

    public void setRow(final int row) { this.row = row; }
    public void setCol(final int col) { this.col = col; }
    public void setGamePiece(final GamePiece gamePiece) { this.gamePiece = gamePiece; }

    public boolean isValid() {

        boolean isValid = false;

        isValid = gameBoard.isGameFieldEmpty(row, col);
        isValid = isValid && !gameBoard.isGameFieldLocked(row, col);

        return isValid;

    }

    public int getRow() { return row; }
    public int getCol() { return col; }


    public void execute() {
        gameBoard.placeGamePiece(gamePiece, row, col);
    }
}
