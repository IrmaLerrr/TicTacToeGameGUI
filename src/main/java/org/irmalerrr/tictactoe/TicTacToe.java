package org.irmalerrr.tictactoe;

import javax.swing.*;
import java.awt.*;

public class TicTacToe extends JFrame {
    private static final Font FONT = new Font("Courier", Font.BOLD, 45);
    private final GameLogic gameLogic;

    public TicTacToe() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Tic Tac Toe");
        setSize(450, 450);
        setLocationRelativeTo(null);
        gameLogic = new GameLogic();
        initComponents();
        setVisible(true);
    }

    private void initComponents() {
        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JPanel gamePanel = new JPanel(new GridLayout(3, 3, 10, 10));
        mainPanel.add(gamePanel, BorderLayout.CENTER);

        GameButton[][] arr = new GameButton[3][3];
        for (int y = 0; y < arr.length; y++) {
            for (int x = 0; x < arr[y].length; x++) {
                arr[y][x] = new GameButton(gameLogic, y, x);
                GameButton btn = arr[y][x];
                String name = Character.toString('A' + x) + (3 - y);
                btn.setName("Button" + name);
                btn.addActionListener(new ButtonActionListener());
                btn.setFont(FONT);
                gamePanel.add(btn);
            }
        }
        JPanel bottomPanel = new JPanel(new BorderLayout());
        mainPanel.add(bottomPanel, BorderLayout.SOUTH);

        JLabel stateLabel = new JLabel("State");
        stateLabel.setText(gameLogic.getGameState().getValue());
        stateLabel.setName("LabelStatus");
        bottomPanel.add(stateLabel, BorderLayout.WEST);

        JButton resetButton = new JButton();
        resetButton.setText("Reset");
        resetButton.setName("ButtonReset");
        bottomPanel.add(resetButton, BorderLayout.EAST);

        add(mainPanel);
    }



    public Font getFont() {
        return FONT;
    }


}
