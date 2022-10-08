package src.board.pieces;

import java.util.List;
import java.util.LinkedList;
import java.awt.image.BufferedImage;

import src.board.pieces.events.GamePieceDeadListener;
import src.board.pieces.events.GamePieceDeadEvent;

public abstract class GamePiece {

    // Indicates whether the piece is dead.
    private boolean isDead;

    private boolean isFlag;

    // Listener
    private final List<GamePieceDeadListener> gamePieceDeadListeners;

    public GamePiece() {

        gamePieceDeadListeners = new LinkedList<GamePieceDeadListener>();
    }

    public void vs(final GamePiece attackingPiece) {

        if (this.getValue() < attackingPiece.getValue()) {

            this.die();

        } else if (this.getValue() > attackingPiece.getValue()) {

            attackingPiece.die();

        } else {

            this.die();
            attackingPiece.die();

        }
    }

    // GENERAL
    public void die() {
        this.setIsDead(true);
        this.notifyGamePieceListeners();
    }

    // LISTENER
    public void addGamePieceDeadListener(final GamePieceDeadListener l) { gamePieceDeadListeners.add(l); }
    public void removeGamePieceDeadListener(final GamePieceDeadListener l) { gamePieceDeadListeners.remove(l); }

    private void notifyGamePieceListeners() {
        for (final GamePieceDeadListener l : gamePieceDeadListeners) {
            l.isDead(new GamePieceDeadEvent(this));
        }
    }

    // Setter
    private void setIsDead(final boolean isDead) { this.isDead = isDead; }

    // Getter
    protected abstract int getValue();
    protected abstract boolean isFlag();
    protected abstract BufferedImage getImage();
    protected abstract String getName();

    public abstract boolean canMove();

}
