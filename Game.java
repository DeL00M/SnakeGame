import java.awt.*;

public class Game {
    GameWindow gameWindow;
    GameField gameField;
    final static int BLOCK_SIZE = 20;



    static Snake snake = new Snake(Color.CYAN);

    public static void main(String[] args) {new Game().play();}

    private void play() {
        gameWindow = new GameWindow();
        gameField = new GameField(gameWindow.getWidth()/BLOCK_SIZE, gameWindow.getHeight()/BLOCK_SIZE, BLOCK_SIZE, Color.BLACK);
        gameField.setBackground(Color.BLACK);
        gameWindow.add(gameField);
    }

    public static void Paint(Graphics g) {
        snake.draw(g);
    }
}
