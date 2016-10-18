import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Snake extends Line{

    private KeyListener controller;
    final static int UP = 38;
    final static int DOWN = 40;
    final static int LEFT = 37;
    final static int RIGHT = 39;
    private static int snakeCount = 0;
    private Directions direction;

    public Directions getDirection() {
        return direction;
    }

    public void setDirection(Directions direction) {
        this.direction = direction;
    }

    private Snake(int top, int left, int count, Directions direction, Color color) {
        super(top, left, count, direction, color);
        snakeCount++;
        setController(snakeCount);
        setDirection(Direction.RIGHT);
    }


    public static Snake createSnake(int top, int left, int count, Directions direction, Color color) {
        if (snakeCount < 2) {
            return new Snake(top, left, count, direction, color);
        } else return null;
    }

    public KeyListener getController() {
        return controller;
    }

    public void setController(int number){
        switch (number) {
            default:
            case 1: controller = controller1;
                break;
            case 2: controller = controller2;
                break;
        }
    }


    protected boolean canMove () {
        return true;
    }

    public void move(Directions direction) {
        Block head = blocks.get(blocks.size()-1);
        if (canMove()) {
            blocks.remove(0);
            blocks.add(new Block((head.top + head.size * direction.horizontal), head.left + head.size * direction.vertical,
                    head.size, getColor()));
        }
    }


    KeyListener controller1 = new KeyListener() {
        @Override
        public void keyTyped(KeyEvent e) {

        }

        @Override
        public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case UP: setDirection(Direction.UP);
                break;
            case DOWN:setDirection(Direction.DOWN);
                break;
            case LEFT:setDirection(Direction.LEFT);
                break;
            case RIGHT:setDirection(Direction.RIGHT);
                break;
        }
        }

        @Override
        public void keyReleased(KeyEvent e) {

        }
    };


    KeyListener controller2 = new KeyListener() {
        @Override
        public void keyTyped(KeyEvent e) {

        }

        @Override
        public void keyPressed(KeyEvent e) {
            switch (e.getKeyCode()) {
                case 57: setDirection(Direction.UP);
                    break;
                case 53:setDirection(Direction.DOWN);
                    break;
                case 41:setDirection(Direction.LEFT);
                    break;
                case 44:setDirection(Direction.RIGHT);
                    break;
            }
        }

        @Override
        public void keyReleased(KeyEvent e) {

        }
    };
}