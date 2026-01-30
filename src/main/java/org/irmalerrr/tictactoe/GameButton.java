package org.irmalerrr.tictactoe;

import javax.swing.*;
import java.awt.*;

public class GameButton extends JButton {
    private ButtonState state = ButtonState.EMPTY;
    private final int row;
    private final int column;

    public GameButton(int row, int column) {
        super();
        this.row = row;
        this.column = column;
        this.setBackground(Color.ORANGE);
        this.setText(getState().getValue());
        this.setFocusPainted(false);
    }

    public ButtonState getState() {
        return state;
    }

    public void setState(ButtonState state) {
        this.state = state;
        this.setText(state.getValue());
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }
}
