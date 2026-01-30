package org.irmalerrr.tictactoe;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameButtonActionListener implements ActionListener {
    private final GameLogic model;
    private final GameGUI view;

    public GameButtonActionListener(GameLogic model, GameGUI view) {
        super();
        this.model = model;
        this.view = view;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        GameButton clickedButton = (GameButton) e.getSource();
        if (clickedButton.getState() != ButtonState.EMPTY) return;

        int row = clickedButton.getRow();
        int column = clickedButton.getColumn();
        GameState state = model.getGameState();

        if (state == GameState.NOT_STARTED || state == GameState.CROSS_TURN) {
            clickedButton.setState(ButtonState.CROSS);
            model.updateBoard(row, column, ButtonState.CROSS.getCount());
        } else if (state == GameState.ZERO_TURN) {
            clickedButton.setState(ButtonState.ZERO);
            model.updateBoard(row, column, ButtonState.ZERO.getCount());
        }

        view.updateStateLabel(model.getGameState().getValue());
    }
}
