import java.awt.*;

public class Game {
    GameWindow gameWindow;
    static GameField gameField;
    static Color wallColor = Color.GRAY;
    static Color snakeColor = Color.WHITE;
    static Color foodColor = Color.GREEN;
    final static int BLOCK_SIZE = 20;
    final static int WINDOW_WIDTH = 640+6;
    static final int WINDOW_HEIGHT = 480+28;
    static Dimension screen = Toolkit.getDefaultToolkit ().getScreenSize ();
    static final int WINDOW_TOP = (screen.height / 2) - (WINDOW_HEIGHT / 2);
    static final int WINDOW_LEFT = (screen.width / 2) - (WINDOW_WIDTH / 2);
    static int snakeLength = 8;
    static Snake snake;
    static final int paintDelay = 300;
    static boolean gameOver = false;
    //static Snake snake2;

    public static void main(String[] args) throws InterruptedException {new Game().play();}

    private void play() throws InterruptedException {
        gameWindow = new GameWindow(WINDOW_WIDTH, WINDOW_HEIGHT, WINDOW_LEFT, WINDOW_TOP);
        gameField = new GameField(Color.BLACK);
        gameWindow.add(gameField);
        gameField.addShape(new Line(0, 0, WINDOW_WIDTH / BLOCK_SIZE, Direction.RIGHT, wallColor));
        gameField.addShape(new Line(gameWindow.getHeight() - 28 - BLOCK_SIZE, 0,
                WINDOW_WIDTH / BLOCK_SIZE, Direction.RIGHT, wallColor));
        gameField.addShape(new Line(BLOCK_SIZE, 0, (gameWindow.getHeight() - 25 / BLOCK_SIZE) -1,
                Direction.DOWN, wallColor));
        gameField.addShape(new Line(BLOCK_SIZE, WINDOW_WIDTH - BLOCK_SIZE-6,
                (gameWindow.getHeight() - 25 / BLOCK_SIZE) -1,
                Direction.DOWN, wallColor));

        snake = new Snake(BLOCK_SIZE*2, BLOCK_SIZE*2, snakeLength, Direction.RIGHT, snakeColor);
        snake.setController(new SnakeController(snake, 38, 40, 37, 39));
        //snake2 = new Snake(BLOCK_SIZE*4, BLOCK_SIZE*4, snakeLength, Direction.RIGHT, snakeColor);
        //snake2.setController(new SnakeController(snake2, 87, 83, 65, 68));

        gameField.addShape(snake);
        //gameField.addShape(snake2);

        gameField.addShape(new Food(BLOCK_SIZE*6, BLOCK_SIZE*6, BLOCK_SIZE, foodColor));

        gameWindow.addKeyListener(snake.getController());
        //gameWindow.addKeyListener(snake2.getController());

        gameWindow.add(gameField);
        gameWindow.setVisible(true);
        while (!gameOver) {
            snake.move();
            gameField.repaint();
            Thread.sleep(paintDelay);
            if (gameField.blocksCrossing(snake.getNextBlock())) {gameOver = !gameOver;}
        }
    }

    public static void Paint(Graphics g) {
        for (Shape shapes:gameField.getShapes()) {shapes.draw(g);}
    }
}
