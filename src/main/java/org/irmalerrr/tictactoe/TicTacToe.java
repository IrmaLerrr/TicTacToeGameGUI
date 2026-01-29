package org.irmalerrr.tictactoe;

import javax.swing.*;
import java.awt.*;

public class TicTacToe extends JFrame {
    public TicTacToe() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Tic Tac Toe");
        setSize(450, 450);
        setLocationRelativeTo(null);
        initComponents();
        setVisible(true);
    }

    private void initComponents() {
        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        JPanel gamePanel = new JPanel(new GridLayout(3, 3, 10, 10));
        Font font = new Font("Courier", Font.BOLD, 45);

        JButton[][] arr = new JButton[3][3];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = new JButton();
                arr[i][j].setFont(font);
                arr[i][j].setBackground(Color.ORANGE);
                String name = Character.toString('A' + j) + (3 - i);
                arr[i][j].setText(name);
                arr[i][j].setName("Button" + name);
                gamePanel.add(arr[i][j]);
            }
        }

        mainPanel.add(gamePanel, BorderLayout.CENTER);
        add(mainPanel);

    }


}
