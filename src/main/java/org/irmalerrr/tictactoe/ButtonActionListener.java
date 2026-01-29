package org.irmalerrr.tictactoe;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonActionListener implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        GameButton clickedButton = (GameButton) e.getSource();
        GameState gameState = clickedButton.getGameState();
        if (clickedButton.getState() == ButtonState.EMPTY) {
            if (gameState == GameState.NOT_STARTED || gameState == GameState.CROSS_TURN) {
                clickedButton.setState(ButtonState.CROSS);
                clickedButton.setGameState(GameState.ZERO_TURN);

            } else if (gameState == GameState.ZERO_TURN) {
                clickedButton.setState(ButtonState.ZERO);
                clickedButton.setGameState(GameState.CROSS_TURN);
            }
        }

    }
}
