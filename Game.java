import javax.swing.*;
import java.awt.*;

public class Game {
    GameWindow gameWindow;
    static GameField gameField;
    final static int BLOCK_SIZE = 20;
    final static int WINDOW_WIDTH = 640;
     static int WINDOW_HEIGHT = 480+28;
    static int WINDOW_TOP = 0;
    static int WINDOW_LEFT = 0;
    static Line topLine;
    static Line bottomLine;
    static Line leftLine;

    public static void main(String[] args) throws InterruptedException {new Game().play();}

    private void play() throws InterruptedException {
        gameWindow = new GameWindow(WINDOW_WIDTH, WINDOW_HEIGHT, WINDOW_LEFT, WINDOW_TOP);
        gameWindow.setLocationRelativeTo(null); //center window
        gameField = new GameField(Color.BLACK);
        gameWindow.add(gameField);
        do {
            gameField.repaint();
            WINDOW_HEIGHT = gameField.getHeight();
        } while (WINDOW_HEIGHT == 0);
        topLine = new Line(WINDOW_TOP, 0, WINDOW_WIDTH / BLOCK_SIZE, Direction.RIGHT, Color.WHITE);
        bottomLine = new Line(WINDOW_HEIGHT - BLOCK_SIZE, 0,
                WINDOW_WIDTH / BLOCK_SIZE, Direction.RIGHT, Color.WHITE);
        leftLine = new Line(WINDOW_TOP + BLOCK_SIZE, 0, (WINDOW_HEIGHT / BLOCK_SIZE) -1,
                Direction.DOWN, Color.WHITE);

//        gameField.cells[0][0] = new Block(0, 0, BLOCK_SIZE, Color.WHITE);
//        Thread.sleep(2000);
//        gameField.cells[0][0].color = Color.BLUE;
    }

    public static void Paint(Graphics g) {
        topLine.draw(g);
        bottomLine.draw(g);
        leftLine.draw(g);
//        for (Block[] i: gameField.cells) {
//            for (Block j: i) {
//                if (j != null) j.draw(g);
//            }
//        }
    }
}
