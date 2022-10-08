package src.gameState;

import java.awt.*;

import java.awt.event.KeyEvent;

import src.engine.GameMove;
import src.engine.Player;
import src.actions.GamePlayState;
import src.board.GameBoard;

public class GameStatePlayState extends GameState {

    private GamePlayState gameState;
    private GameBoard gameBoard;
    private Player player1;
    private Player player2;

    public GameStatePlayState(GameStateManager gameStateManager, GameStateID gameStateID) {
        super(gameStateManager, gameStateID);

        gameState = GamePlayState.INIT;
    }

    public void setGameBoard(final GameBoard gameBoard) {
        this.gameBoard = gameBoard;
    }

    public void setPlayer1(final Player player1) {
        this.player1 = player1;
    }

    public void setPlayer2(final Player player2) {
        this.player2 = player2;
    }

    @Override
    public void keyPressed(final int keyCode) {

        if (keyCode == KeyEvent.VK_A) {

            //general.vs(soldier);

        }

    }

    @Override
    public void update() {

        switch (gameState) {

            case INIT:
                updateInit();
                break;

            case PLAY_PLAYER1:
                playerMakeMove(player1);
                gameState = GamePlayState.PLAY_PLAYER2;
                break;

            case PLAY_PLAYER2:
                playerMakeMove(player2);
                gameState = GamePlayState.PLAY_PLAYER1;
                break;
        }

    }

    private void updateInit() {

        // Erst wenn beide Spieler das "Okay" gesendet haben, dass sie ihre Spielsteine gesetz haben, wird der SpielState geändert
        // Beispiel: gameState = GamePlayState.PLAY_Player1;

        // NOTE: Eventuell macht es Sinn, hierfür eine definierte Zeit verstreichen zu lassen. Ggf. 5 Minuten.

    }

    private void playerMakeMove(final Player player) {
        GameMove playerMove;

        do {

            // TODO: Könnte eine unendliche Schleife generieren.
            playerMove = player.moveGamePiece();

            // TODO: Prüfen, ob der Spieler den Spielstein auch an dem für ihn "richtigen" Platz gesetzt hat.
            // ( ) Richtig := Auf seiner "Grundreihe" und nicht auf "gesperrten" Flächen.
            // (x) Gesperrt := Felder, auf denen KEINE Spielsteine platziert werden dürfen. Beispiel: Wasser oder Felsen.

        } while (!playerMove.isValid());

        playerMove.execute();
    }

    @Override
    public void draw(Graphics2D g2D) {

    }
}
