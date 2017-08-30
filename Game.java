import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

public class Game {
    GameWindow gameWindow;
    static GameField gameField;
    static Color wallColor = Color.GRAY;
    static Color snakeColor = Color.WHITE;
    static Color foodColor = Color.GREEN;
    final static int BLOCK_SIZE = 20;
    final static int COLS = 32;
    final static int ROWS = 24;
    final static int WINDOW_WIDTH = BLOCK_SIZE * COLS;
    static final int WINDOW_HEIGHT = BLOCK_SIZE * ROWS;
    static Dimension screen = Toolkit.getDefaultToolkit ().getScreenSize ();
    static final int WINDOW_TOP = (screen.height / 2) - (WINDOW_HEIGHT / 2);
    static final int WINDOW_LEFT = (screen.width / 2) - (WINDOW_WIDTH / 2);
    static int snakeLength = 8;
    static ArrayList<Snake> players = new ArrayList<>();
    static ArrayList<SnakeController> controllers = new ArrayList<>();
    static int playersCount = 1;
    static final int paintDelay = 300;
    static boolean gameOver;
    static final String TITLE = "Snake";


    public static void main(String[] args) throws InterruptedException {new Game().run();}

    private void play(int playersCount) throws InterruptedException{
        gameOver = false;
        gameField.clear();
        players.clear();
        //up wall
        gameField.addShape(new Line(0, 0, BLOCK_SIZE, WINDOW_WIDTH / BLOCK_SIZE, Direction.RIGHT, wallColor));
        //down wall
        gameField.addShape(new Line(0, WINDOW_HEIGHT - BLOCK_SIZE * 2,  BLOCK_SIZE,
                WINDOW_WIDTH / BLOCK_SIZE, Direction.RIGHT, wallColor));
        //left wall
        gameField.addShape(new Line(0, BLOCK_SIZE, BLOCK_SIZE, (WINDOW_HEIGHT / BLOCK_SIZE) - 3,
                Direction.DOWN, wallColor));
        //right wall
        gameField.addShape(new Line(WINDOW_WIDTH - BLOCK_SIZE, BLOCK_SIZE, BLOCK_SIZE,
                (WINDOW_HEIGHT  / BLOCK_SIZE) - 3, Direction.DOWN, wallColor));
        //init snakes for players
        for (int i = 0; i < playersCount; i++) {
            players.add(new Snake((BLOCK_SIZE * 2) * (i+1), (BLOCK_SIZE * 2) * (i+1),
                    BLOCK_SIZE,  snakeLength, Direction.RIGHT, snakeColor));
            controllers.get(i).setSnake(players.get(i));
            players.get(i).setController(controllers.get(i));
            gameField.addShape(players.get(i));
            gameWindow.addKeyListener(players.get(i).getController());
        }
        //add some food on field
        gameField.addShape(getFood());
        gameField.addShape(getFood());

        gameField.repaint();
        Shape sameBlockShape;
        //make move for all snakes
        while (!gameOver) {
            gameField.repaint();
            for (Snake snake:players) {
                snake.move();
            }

            Thread.sleep(paintDelay);
            for (Snake snake:players) {
                sameBlockShape = gameField.getSameBlockShape(snake.getNextBlock());
                if (sameBlockShape != null) {
                    if (sameBlockShape instanceof Food) {
                        snake.eat(((Food) sameBlockShape).getBlock());
                        gameField.removeShape(sameBlockShape);
                        gameField.addShape(getFood());
                        //gameWindow.setTitle(TITLE +" "+Integer.toString(snake.getBlocks().size()));
                    } else {
                        gameOver = !gameOver;
                    }
                }
            }
        }
        restartGameDialog();
    }

    private void run() throws InterruptedException {
        gameWindow = new GameWindow(WINDOW_WIDTH + 2, WINDOW_HEIGHT + 5, WINDOW_LEFT, WINDOW_TOP, TITLE);
        gameField = new GameField(Color.BLACK);
        gameWindow.add(gameField);
        gameWindow.setTitle(TITLE);
        gameWindow.setVisible(true);
        controllers.add(new SnakeController(38, 40, 37, 39));
        controllers.add(new SnakeController(87, 83, 65, 68));
        playersCount = getNumberOfPlayersDialog();
        if (playersCount <= 0) System.exit(0);
        play(playersCount);
    }

    public void restartGameDialog() throws InterruptedException {
        Object[] options = {"Да", "Нет"};
        int n = JOptionPane.showOptionDialog(gameWindow, "Начать игру заново?", "Вы проиграли! ",
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
        if (n == JOptionPane.YES_OPTION) {
            playersCount = getNumberOfPlayersDialog();
            play(playersCount);
        } else if (n == JOptionPane.NO_OPTION) {
            System.exit(0);
        } else {
            System.exit(0);
        }
    }

    public int getNumberOfPlayersDialog() {
        Object[] options = {"Один игрок", "Два игрока"};
        int n = JOptionPane.showOptionDialog(gameWindow, "Выберите количество игроков", "",
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
        if (n == JOptionPane.YES_OPTION) {
            return 1;
        } else if (n == JOptionPane.NO_OPTION) {
            return  2;
        } else {
            return  0;
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
