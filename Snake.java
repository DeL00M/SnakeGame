import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Snake extends Line{

    private KeyListener controller;
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
        //snakeCount++;
        //setController(snakeCount);
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

    public void setController(KeyListener controller){
        this.controller = controller;
//        switch (number) {
//            default:
//            case 1: controller = controller1;
//                break;
//            case 2: controller = controller2;
//                break;
//        }
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
}