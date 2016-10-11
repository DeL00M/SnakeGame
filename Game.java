import java.awt.*;

public class Game {
    GameWindow gameWindow;
    static GameField gameField;
    final static int BLOCK_SIZE = 20;
    final static int WINDOW_WIDTH = 640;
    final static int WINDOW_HEIGHT = 480;
    final static int WINDOW_TOP = 400;
    final static int WINDOW_LEFT = 200;

    public static void main(String[] args) {new Game().play();}

    private void play() {
        gameWindow = new GameWindow(WINDOW_WIDTH, WINDOW_HEIGHT, WINDOW_TOP, WINDOW_LEFT);
        gameField = new GameField(gameWindow.getWidth()/BLOCK_SIZE, gameWindow.getHeight()/BLOCK_SIZE, BLOCK_SIZE, Color.BLACK);
        gameWindow.add(gameField);
        gameField.cells[0][0] = new Block(0, 0, BLOCK_SIZE, Color.WHITE);
    }

    public static void Paint(Graphics g) {
        for (Block[] i: gameField.cells) {
            for (Block j: i) {
                if (j != null) j.draw(g);
            }
        }
    }
}
