import java.awt.*;

public class Game {
    GameWindow gameWindow;
    GameField gameField;
    final static int BLOCK_SIZE = 20;
    final static int WINDOW_WIDTH = 640;
    final static int WINDOW_HEIGHT = 480;
    final static int WINDOW_TOP = 400;
    final static int WINDOW_LEFT = 200;

    static Snake snake = new Snake(Color.CYAN);

    public static void main(String[] args) {new Game().play();}

    private void play() {
        gameWindow = new GameWindow(WINDOW_WIDTH, WINDOW_HEIGHT, WINDOW_TOP, WINDOW_LEFT);
        gameField = new GameField(gameWindow.getWidth()/BLOCK_SIZE, gameWindow.getHeight()/BLOCK_SIZE, BLOCK_SIZE, Color.BLACK);
        gameWindow.add(gameField);
    }

    public static void Paint(Graphics g) {
        snake.draw(g);
    }
}
