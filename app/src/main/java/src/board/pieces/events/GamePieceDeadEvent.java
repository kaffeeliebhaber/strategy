package src.board.pieces.events;

import src.board.pieces.GamePiece;

public class GamePieceDeadEvent {

    private final GamePiece gamePiece;

    public GamePieceDeadEvent(final GamePiece gamePiece) { this.gamePiece = gamePiece; }

    public GamePiece getGamePiece() {
        return gamePiece;
    }
}
