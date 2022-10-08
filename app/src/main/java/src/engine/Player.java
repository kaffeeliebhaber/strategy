package src.engine;

import java.util.List;
import src.board.pieces.GamePiece;
import src.board.GameBoard;

public abstract class Player {

    private final GameBoard gameBoard;
    protected final GameBoardPlayerPlacementArea placementArea;
    private List<GamePiece> gamePieces;

    public Player(final GameBoard gameBoard, final GameBoardPlayerPlacementArea placementArea) {

        this.gameBoard = gameBoard;
        this.placementArea = placementArea;
    }

    public void addGamePieces(final List<GamePiece> gamePieces) {
        this.gamePieces = gamePieces;
    }

    public void placeGamePieces() {

        boolean validMove = false;
        GameMove gameMove;

        do {

            gameMove = place();

            validMove = gameBoard.isGameFieldEmpty(gameMove.getRow(), gameMove.getCol());
            validMove = validMove && placementArea.validateGameMove(gameMove);

        } while (!validMove);

        gameMove.execute();
    }

    public GameMove moveGamePiece() {

        boolean validMove = false;

        GameMove gameMove;

        do {

            gameMove = move();

            boolean isFieldLocked = gameBoard.isGameFieldLocked(gameMove.getRow(), gameMove.getCol());
            boolean isFieldEmpty = gameBoard.isGameFieldEmpty(gameMove.getRow(), gameMove.getCol());
            boolean isFieldOccupiedByEnemy = true;

            //validMove = validM

            // ODER der GEGNER BEFINDET SICH AUF DEM FELD


        } while (!validMove);

        return gameMove;
    }

    protected abstract GameMove move();
    protected abstract GameMove place();

}
