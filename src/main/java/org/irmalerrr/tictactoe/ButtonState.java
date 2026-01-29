package org.irmalerrr.tictactoe;

public enum ButtonState {
    EMPTY(" ", 0),
    CROSS("X", 1),
    ZERO("O", -1);

    private final String value;
    private final int count;

    ButtonState(String value, int count) {
        this.value = value;
        this.count = count;
    }
    public int getCount() {
        return count;
    }
    public String getValue() {
        return value;
    }
}
