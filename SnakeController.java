import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class SnakeController implements KeyListener {
    private int up;
    private int down;
    private int left;
    private int right;
    Snake snake;
    public SnakeController(Snake snake, int up, int down, int left, int right) {
        this.snake = snake;
        this.up = up;
        this.down = down;
        this.left = left;
        this.right = right;
    }
    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == up) snake.setDirection(Direction.UP);
        if (e.getKeyCode() == down) snake.setDirection(Direction.DOWN);
        if (e.getKeyCode() == left) snake.setDirection(Direction.LEFT);
        if (e.getKeyCode() == right) snake.setDirection(Direction.RIGHT);
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
