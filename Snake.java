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

    private Snake(int top, int left, int count, Directions direction, Color color) {
        super(top, left, count, direction, color);
        setDirection(Direction.RIGHT);
    }


    public static Snake createSnake(int top, int left, int count, Directions direction, Color color) {
            return new Snake(top, left, count, direction, color);
    }

    public KeyListener getController() {
        return controller;
    }

    public void setController(KeyListener controller){
        this.controller = controller;
    }


    protected boolean canMove () {
        return true;
    }

    public void move(Directions direction) {
        Block head = super.getBlocks().get(super.getBlocks().size()-1);
        if (canMove()) {
            super.getBlocks().remove(0);
            super.getBlocks().add(new Block((head.top + head.size * direction.horizontal),
                    head.left + head.size * direction.vertical, head.size, getColor()));
        }
    }
}