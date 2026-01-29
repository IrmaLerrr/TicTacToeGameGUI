package org.irmalerrr.tictactoe;

import javax.swing.*;
import java.awt.*;

public class GameButton extends JButton {
    private ButtonState state = ButtonState.EMPTY;
    private final GameLogic GAME;
    private final int row;
    private final int column;

    public GameButton(GameLogic GAME, int row, int column) {
        super();
        this.GAME = GAME;
        this.row = row;
        this.column = column;
        this.setBackground(Color.ORANGE);
        this.setState(ButtonState.EMPTY);
        this.setText(getState().getValue());
        this.setFocusPainted(false);
    }

    public ButtonState getState() {
        return state;
    }

    public void setState(ButtonState state) {
        this.state = state;
        this.setText(state.getValue());
        GAME.updateBoard(row, column, state.getCount());
    }

    public GameState getGameState() {
        return GAME.getGameState();
    }

    public void setGameState(GameState state) {
        GAME.setGameState(state);
    }
}
