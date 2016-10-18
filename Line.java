import java.awt.*;

public class Line extends Shape{

    public Line() {

    }

    public Line(int top, int left, int count, Directions direction, Color color) {
        for (int i = 0; i < count; i++) {
            this.getBlocks().add(new Block(left + (i * (direction.horizontal * Game.BLOCK_SIZE)),
                    top + (i * (direction.vertical * Game.BLOCK_SIZE)), Game.BLOCK_SIZE, color));
        }
    }
}
