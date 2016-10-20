import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Snake extends Line{

    private KeyListener controller;
    private Directions direction;

    public Directions getDirection() {
        return direction;
    }

    public void setDirection(Directions direction) {
        this.direction = direction;
    }

    public Snake(int top, int left, int blockSize, int count, Directions direction, Color color) {
        super(top, left,  blockSize, count, direction, color);
        setDirection(direction);
    }

    public KeyListener getController() {
        return controller;
    }

    public void setController(KeyListener controller){
        this.controller = controller;
    }

    public Block getHead(){
        return super.getBlocks().get(super.getBlocks().size()-1);
    }

    public Block getNextBlock() {
        Block head = getHead();
        int blockSize = head.getSize();
        return new Block((head.getLeft() + blockSize * getDirection().horizontal),
                head.getTop() + blockSize * getDirection().vertical, blockSize, getColor());
    }

    public void move() {
        super.getBlocks().remove(0);
        super.addBlock(getNextBlock());
    }

    public void eat(Block block) {
        block.setColor(this.getColor());
        super.addBlock(0, block);
    }
}


class SnakeController implements KeyListener {
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
    public void keyTyped(KeyEvent e) {}

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == up && snake.getDirection() != Direction.DOWN)
        {snake.setDirection(Direction.UP); return;}
        if (e.getKeyCode() == down && snake.getDirection() != Direction.UP)
        {snake.setDirection(Direction.DOWN); return;}
        if (e.getKeyCode() == left && snake.getDirection() != Direction.RIGHT)
        {snake.setDirection(Direction.LEFT); return;}
        if (e.getKeyCode() == right && snake.getDirection() != Direction.LEFT)
        {snake.setDirection(Direction.RIGHT); return;}
    }

    @Override
    public void keyReleased(KeyEvent e) {}
}