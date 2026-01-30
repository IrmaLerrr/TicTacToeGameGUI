package org.irmalerrr.tictactoe;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class GameGUI extends JFrame {
    private static final Font FONT = new Font("Courier", Font.BOLD, 45);
    private JLabel stateLabel;
    private JButton resetButton;
    private List<GameButton> gameButtonList;

    public GameGUI() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Tic Tac Toe");
        setSize(450, 450);
        setLocationRelativeTo(null);
        initComponents();
    }

    private void initComponents() {
        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JPanel gamePanel = new JPanel(new GridLayout(3, 3, 10, 10));
        mainPanel.add(gamePanel, BorderLayout.CENTER);

        gameButtonList = new ArrayList<>();
        for (int row = 0; row < 3; row++) {
            for (int column = 0; column < 3; column++) {
                GameButton btn = new GameButton(row, column);
                gameButtonList.add(btn);
                String name = Character.toString('A' + column) + (3 - row);
                btn.setName("Button" + name);
                btn.setFont(FONT);
                gamePanel.add(btn);
            }
        }
        JPanel bottomPanel = new JPanel(new BorderLayout());
        mainPanel.add(bottomPanel, BorderLayout.SOUTH);

        stateLabel = new JLabel("State");
        stateLabel.setText(GameState.NOT_STARTED.getValue());
        stateLabel.setName("LabelStatus");
        bottomPanel.add(stateLabel, BorderLayout.WEST);

        resetButton = new JButton();
        resetButton.setText("Reset");
        resetButton.setName("ButtonReset");
        bottomPanel.add(resetButton, BorderLayout.EAST);

        add(mainPanel);
    }

    public void updateStateLabel(String text){
        stateLabel.setText(text);
    }

    public JButton getResetButton() {
        return resetButton;
    }

    public List<GameButton> getGameButtonList() {
        return gameButtonList;
    }

    public void start() {
        setVisible(true);
    }

    public void reset() {
        for (GameButton gameButton : gameButtonList) {
            gameButton.setState(ButtonState.EMPTY);
        }
        stateLabel.setText(GameState.NOT_STARTED.getValue());
    }
}
