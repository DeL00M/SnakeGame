import java.awt.*;

public class Snake extends Line{

    public Snake(int top, int left, int count, Directions direction, Color color) {
        super(top, left, count, direction, color);
    }

    public void deleteLastBlock() {
        blocks.remove(blocks.size());
    }

    protected boolean canMove () {
        return true;
    }

    public void move() {
        if (canMove()) {

        }
    }
}