import java.awt.*;
import java.util.Random;

public class Game {
    GameWindow gameWindow;
    static GameField gameField;
    static Color wallColor = Color.GRAY;
    static Color snakeColor = Color.WHITE;
    static Color foodColor = Color.GREEN;
    final static int BLOCK_SIZE = 20;
    final static int COLS = 32;
    final  static int ROWS = 24;
    final static int WINDOW_WIDTH = BLOCK_SIZE * COLS;
    static final int WINDOW_HEIGHT = BLOCK_SIZE * ROWS;
    static Dimension screen = Toolkit.getDefaultToolkit ().getScreenSize ();
    static final int WINDOW_TOP = (screen.height / 2) - (WINDOW_HEIGHT / 2);
    static final int WINDOW_LEFT = (screen.width / 2) - (WINDOW_WIDTH / 2);
    static int snakeLength = 8;
    static Snake snake;
    static final int paintDelay = 150;
    static boolean gameOver = false;
    //static Snake snake2;

    public static void main(String[] args) throws InterruptedException {new Game().play();}

    private void play() throws InterruptedException {
        gameWindow = new GameWindow(WINDOW_WIDTH + 2, WINDOW_HEIGHT + 5, WINDOW_LEFT, WINDOW_TOP);
        gameField = new GameField(Color.BLACK);

        gameField.addShape(new Line(0, 0, BLOCK_SIZE, WINDOW_WIDTH / BLOCK_SIZE, Direction.RIGHT, wallColor));

        gameField.addShape(new Line(0, WINDOW_HEIGHT - BLOCK_SIZE * 2,  BLOCK_SIZE,
                WINDOW_WIDTH / BLOCK_SIZE, Direction.RIGHT, wallColor));

        gameField.addShape(new Line(0, BLOCK_SIZE, BLOCK_SIZE, (WINDOW_HEIGHT / BLOCK_SIZE) - 3,
                Direction.DOWN, wallColor));

        gameField.addShape(new Line(WINDOW_WIDTH - BLOCK_SIZE, BLOCK_SIZE, BLOCK_SIZE,
                (WINDOW_HEIGHT  / BLOCK_SIZE) - 3, Direction.DOWN, wallColor));

        snake = new Snake(BLOCK_SIZE * 2, BLOCK_SIZE * 2, BLOCK_SIZE,  snakeLength, Direction.RIGHT, snakeColor);
        snake.setController(new SnakeController(snake, 38, 40, 37, 39));
        //snake2 = new Snake(BLOCK_SIZE*4, BLOCK_SIZE*4, snakeLength, Direction.RIGHT, snakeColor);
        //snake2.setController(new SnakeController(snake2, 87, 83, 65, 68));

        gameField.addShape(snake);
        //gameField.addShape(snake2);

        gameField.addShape(getFood());
        gameField.addShape(getFood());

        gameWindow.addKeyListener(snake.getController());
        //gameWindow.addKeyListener(snake2.getController());

        gameWindow.add(gameField);
        gameWindow.setVisible(true);

        Shape sameBlockShape;

        while (!gameOver) {
            gameField.repaint();
            snake.move();
            Thread.sleep(paintDelay);
            sameBlockShape = gameField.getSameBlockShape(snake.getNextBlock());
            if (sameBlockShape != null) {
                if (sameBlockShape instanceof Food) {
                    snake.eat(((Food) sameBlockShape).getBlock());
                    gameField.removeShape(sameBlockShape);
                    gameField.addShape(getFood());
                    gameWindow.setTitle(Integer.toString(snake.getBlocks().size()));
                } else {
                gameOver = !gameOver;
                }
            }
        }
    }

    public Food getFood() {
        Random random = new Random();
        Block randomBlock = new Block((random.nextInt(COLS - 2) + 1) * BLOCK_SIZE,
                (random.nextInt(ROWS - 2) + 1) * BLOCK_SIZE, BLOCK_SIZE, foodColor);
        if (gameField.getSameBlockShape(randomBlock) == null) {
            return new Food(randomBlock);
        } else {return getFood();}
    }

    public static void Paint(Graphics g) {
        for (Shape shapes:gameField.getShapes()) {
            shapes.draw(g);
        }
    }
}
