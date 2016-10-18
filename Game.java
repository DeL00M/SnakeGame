import javax.swing.*;
import java.awt.*;

public class Game {
    GameWindow gameWindow;
    static GameField gameField;
    static Color wallColor = Color.GRAY;
    static Color snakeColor = Color.WHITE;
    final static int BLOCK_SIZE = 20;
    final static int WINDOW_WIDTH = 640;
    static final int WINDOW_HEIGHT = 480+28;
    static Dimension screen = Toolkit.getDefaultToolkit ().getScreenSize ();
    static final int WINDOW_TOP = (screen.height / 2) - (WINDOW_HEIGHT / 2);
    static final int WINDOW_LEFT = (screen.width / 2) - (WINDOW_WIDTH / 2);
    static int snakeSize = 5;
    static Snake snake;
    static Snake snake2;


    public static void main(String[] args) throws InterruptedException {new Game().play();}

    private void play() throws InterruptedException {
        gameWindow = new GameWindow(WINDOW_WIDTH, WINDOW_HEIGHT, WINDOW_LEFT, WINDOW_TOP);
        gameField = new GameField(Color.BLACK);
        gameWindow.add(gameField);
        gameField.addShape(new Line(0, 0, WINDOW_WIDTH / BLOCK_SIZE, Direction.RIGHT, wallColor));
        gameField.addShape(new Line(gameWindow.getHeight() - 25 - BLOCK_SIZE, 0,
                WINDOW_WIDTH / BLOCK_SIZE, Direction.RIGHT, wallColor));
        gameField.addShape(new Line(0 + BLOCK_SIZE, 0, (gameWindow.getHeight() - 25 / BLOCK_SIZE) -1,
                Direction.DOWN, wallColor));
        gameField.addShape(new Line(0 + BLOCK_SIZE, WINDOW_WIDTH - BLOCK_SIZE,
                (gameWindow.getHeight() - 25 / BLOCK_SIZE) -1,
                Direction.DOWN, wallColor));

        snake = Snake.createSnake(BLOCK_SIZE*2, BLOCK_SIZE*2, snakeSize,
                Direction.RIGHT, snakeColor);

        snake2 = Snake.createSnake(BLOCK_SIZE*4, BLOCK_SIZE*4, snakeSize,
                Direction.RIGHT, snakeColor);
        gameField.addShape(snake2);

        gameField.addShape(snake);

        gameWindow.addKeyListener(snake.getController());
        gameWindow.addKeyListener(snake2.getController());

        while (true) {
            snake.move(snake.getDirection());
            snake2.move(snake2.getDirection());
            Thread.sleep(500);
            gameField.repaint();
        }
    }

    public static void Paint(Graphics g) {
        for (Shape shapes:gameField.getShapes()) {
            shapes.draw(g);
        }
    }
}
