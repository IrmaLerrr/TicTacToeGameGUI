package org.irmalerrr.tictactoe;

public class GameLogic {
    private GameState gameState = GameState.NOT_STARTED;
//    private final int[][] board = new int[][]{{0, 0, 0}, {0, 0, 0}, {0, 0, 0}};
    private final int[] rowsSum = new int[]{0, 0, 0};
    private final int[] columnSum = new int[]{0, 0, 0};
    private int diag1 = 0;
    private int diag2 = 0;
    private int emptyCells = 9;

    public GameLogic() {
    }

    public void updateBoard(int i, int j, int count) {
//        board[i][j] = count;
        rowsSum[i] += count;
        columnSum[j] += count;
        if (rowsSum[i] == 3) gameState = GameState.CROSS_WIN;
        if (rowsSum[i] == -3) gameState = GameState.ZERO_WIN;
        if (columnSum[j] == 3) gameState = GameState.CROSS_WIN;
        if (columnSum[j] == -3) gameState = GameState.ZERO_WIN;
        if (i == j) {
            diag1 += count;
            if (diag1 == 3) gameState = GameState.CROSS_WIN;
            if (diag1 == -3) gameState = GameState.ZERO_WIN;
        }
        if (i + j == 2) {
            diag2 += count;
            if (diag2 == 3) gameState = GameState.CROSS_WIN;
            if (diag2 == -3) gameState = GameState.ZERO_WIN;
        }
        emptyCells--;
        if (emptyCells == 0) gameState = GameState.DRAW;
    }

    public void setGameState(GameState gameState) {
        this.gameState = gameState;
    }

    public GameState getGameState() {
        return gameState;
    }
}
