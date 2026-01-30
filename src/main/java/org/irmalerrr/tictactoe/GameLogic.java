package org.irmalerrr.tictactoe;

import java.util.Arrays;

public class GameLogic {
    private GameState gameState = GameState.NOT_STARTED;
    private int[] sums = new int[]{0, 0, 0, 0, 0, 0, 0, 0}; //row1, row2, row3, column1, column2, column3, diagonal1, diagonal2
    private int emptyCells = 9;

    public GameLogic() {
    }

    public void updateBoard(int row, int column, int count) {
        sums[row] += count;
        sums[3 + column] += count;
        if (row == column) sums[6] += count;
        if (row + column == 2) sums[7] += count;
        emptyCells--;
        updateGameState();
    }

    private void updateGameState() {
        if (Arrays.stream(sums).anyMatch(n -> n == 3)) gameState = GameState.CROSS_WIN;
        else if (Arrays.stream(sums).anyMatch(n -> n == -3)) gameState = GameState.ZERO_WIN;
        else if (emptyCells == 0) gameState = GameState.DRAW;
        else if (gameState == GameState.ZERO_TURN) gameState = GameState.CROSS_TURN;
        else gameState = GameState.ZERO_TURN;
    }

    public void reset() {
        gameState = GameState.NOT_STARTED;
        sums = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
        emptyCells = 9;
    }

    public GameState getGameState() {
        return gameState;
    }
}
