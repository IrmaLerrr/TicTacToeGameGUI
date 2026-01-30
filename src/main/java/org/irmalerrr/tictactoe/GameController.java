package org.irmalerrr.tictactoe;

import javax.swing.*;
import java.util.List;

public class GameController {
    private final GameLogic game;
    private final GameGUI view;

    public GameController(GameLogic game, GameGUI view) {
        this.game = game;
        this.view = view;

        setupListeners();
    }

    private void setupListeners() {
        List<GameButton> gameButtons = view.getGameButtonList();
        for (GameButton button : gameButtons) {
            button.addActionListener(new GameButtonActionListener(game, view));
        }
        JButton resetButton = view.getResetButton();
        resetButton.addActionListener(e -> {
            game.reset();
            view.reset();
        });
    }

    public void start() {
        view.start();
    }
}
