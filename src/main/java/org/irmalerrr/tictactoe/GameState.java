package org.irmalerrr.tictactoe;

public enum GameState {
    NOT_STARTED("Game is not started"),
    CROSS_TURN("Game in progress"),
    ZERO_TURN("Game in progress"),
    CROSS_WIN("X wins"),
    ZERO_WIN("O wins"),
    DRAW("Draw");

    private final String value;

    GameState(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
