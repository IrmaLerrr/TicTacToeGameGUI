package org.irmalerrr.tictactoe;

public class ApplicationRunner {
    public static void main(String[] args) {
        GameLogic model = new GameLogic();
        GameGUI view = new GameGUI();
        GameController controller = new GameController(model, view);

        controller.start();
    }
}
