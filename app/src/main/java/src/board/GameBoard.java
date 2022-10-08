package src.board;

import java.awt.image.BufferedImage;
import src.board.pieces.GamePiece;

public class GameBoard {

    private final int rows;
    private final int cols;

    private BufferedImage backgroundImage;

    private GameField[][] board;

    public GameBoard(final int rows, final int cols) {
        this(null, rows, cols);
    }

    public GameBoard(final BufferedImage backgroundImage, final int rows, final int cols) {
        this.backgroundImage = backgroundImage;
        this.rows = rows;
        this.cols = cols;

        board = new GameField[cols][rows];

        init();
    }

    private void init() {
        for (int y = 0; y < rows; y++) {
            for (int x = 0; x < cols; x++) {
                board[x][y] = new GameField();
            }
        }
    }

    // TODO: Restrict access for player
    // TODO: Add map or list, containing Fields, that have to be locked.
    private void setGameFieldAsLocked(final int row, final int col, boolean locked) {
        getGameField(row, col).setIsLocked(locked);
    }

    public boolean isGameFieldLocked(final int row, final int col) {
        return getGameField(row, col).isLocked();
    }

    public void placeGamePiece(final GamePiece gamePiece, final int row, final int col) {
        getGameField(row, col).setGamePiece(gamePiece);
    }

    public boolean isGameFieldEmpty(final int row, final int col) {
        return getGameField(row, col).isEmpty();
    }

    public GameField getGameField(final int row, final int col) {
        return board[row][col];
    }
}
