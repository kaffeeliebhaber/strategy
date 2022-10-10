package src.gameState;

import java.awt.*;

import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

import src.gfx.Spritesheet;

import src.ui.UIBoard;

import src.engine.GameMove;
import src.engine.Player;
import src.actions.GamePlayState;
import src.board.GameBoard;

public class GameStatePlayState extends GameState {

    /*
    private GamePlayState gameState;
    private GameBoard gameBoard;
    private Player player1;
    private Player player2;

    private Player currentPlayer;

     */

    // DATA
    private final Spritesheet spritesheetBoard;
    private final Spritesheet spritesheetPieces;
    private final Spritesheet spritesheetGamePieces;

    // UI
    private UIBoard uiBoard;

    public GameStatePlayState(GameStateManager gameStateManager, GameStateID gameStateID) {
        super(gameStateManager, gameStateID);

        // UI Board setup.
        final String spritesheetBoardPath = "/raw/img/TX Tileset Grass.png";
        final int scale = 2; // Default: 2
        final int tileSize = 16;
        final int rows = 10;
        final int cols = 10;
        final int width = tileSize * scale;
        final int height = tileSize * scale;

        spritesheetBoard = new Spritesheet(spritesheetBoardPath, tileSize, scale, scale);
        spritesheetBoard.load();

        // UI Board piece setup.
        final String spritesheetBoardPiecePath = "/raw/img/TX Props.png";

        spritesheetPieces = new Spritesheet(spritesheetBoardPiecePath, tileSize * 2);
        spritesheetPieces.load();

        // NEW game field pieces
        final String spritesheetBoardFieldPiecesPath = "/raw/img/pyxel/gamePieces.png";

        spritesheetGamePieces = new Spritesheet(spritesheetBoardFieldPiecesPath, 2 * tileSize);
        spritesheetGamePieces.load();

        uiBoard = new UIBoard(cols, rows, width, height, spritesheetBoard, spritesheetGamePieces);
        uiBoard.init();
        uiBoard.setPosition(20, 0);

        //gameState = GamePlayState.INIT;
    }

    @Override public void mouseMoved(MouseEvent e) {
        //gameStateManager.mouseMoved(e);


        //System.out.println("x: " + e.getX() + ", y: " + e.getY());
        uiBoard.mouseMoved(e);
    }

    @Override public void mouseDragged(MouseEvent e) {
        uiBoard.mouseDragged(e);
    }


    @Override public void mouseReleased(MouseEvent e) {
        uiBoard.mouseReleased(e);
    }

    @Override public void mousePressed(MouseEvent e) {
        uiBoard.mousePressed(e);
    }

    /*
    public void setGameBoard(final GameBoard gameBoard) {
        this.gameBoard = gameBoard;
    }

    public void setPlayer1(final Player player1) {
        this.player1 = player1;
    }

    public void setPlayer2(final Player player2) {
        this.player2 = player2;
    }

    public void switchPlayer() {
        currentPlayer = currentPlayer == player1 ? player2 : player1;
    }


     */



    @Override
    public void keyPressed(final int keyCode) {

        if (keyCode == KeyEvent.VK_UP) {
            uiBoard.translateY(-5);
        }

        if (keyCode == KeyEvent.VK_DOWN) {
            uiBoard.translateY(5);
        }

        if (keyCode == KeyEvent.VK_LEFT) {
            uiBoard.translateX(-5);
        }

        if (keyCode == KeyEvent.VK_RIGHT) {
            uiBoard.translateX(5);
        }

    }


    @Override
    public void draw(Graphics2D g2D) {
        uiBoard.draw(g2D);
    }

    @Override
    public void update() {

        /*
        switch (gameState) {

            case INIT:
                place();
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

         */


        /*
        switch (gameState) {
            case INIT: place(); break;
            case PLAY: move(); break;
        }


         */

    }

    /*
    private void place() {

        // Erst wenn beide Spieler das "Okay" gesendet haben, dass sie ihre Spielsteine gesetz haben, wird der SpielState geändert
        // Beispiel: gameState = GamePlayState.PLAY_Player1;

        // NOTE: Eventuell macht es Sinn, hierfür eine definierte Zeit verstreichen zu lassen. Ggf. 5 Minuten.

        // TODO: Add check whether there are enough pieces to set.
        currentPlayer.place();
        switchPlayer();



    }

    private void move() {

        currentPlayer.move();

        // TODO: Check for win or lose.
        switchPlayer();

    }
    */
/*
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

 */


}
