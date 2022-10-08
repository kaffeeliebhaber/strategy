package src.engine;

import src.engine.GameMove;

public class GameBoardPlayerPlacementArea {

    private int minX, maxX;
    private int minY, maxY;

    public GameBoardPlayerPlacementArea(final int minX, final int maxX, final int minY, final int maxY) {
        this.minX = minX;
        this.maxX = maxX;
        this.minY = minY;
        this.maxY = maxY;
    }

    public boolean validateGameMove(final GameMove gameMove) {
        return validPlacement(gameMove.getRow(), gameMove.getCol());
    }

    private boolean validPlacement(final int row, final int col) {

        boolean valid = true;

        // Check for 'row'
        valid = row >= minY && row < maxY;

        // Check for 'col';
        valid = valid && (col >= minX && col < maxX);

        return valid;
    }
}
