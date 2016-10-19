import java.awt.*;

public class Line extends Shape{

    public Line() {

    }

    public Line(int top, int left, int length, Directions direction, Color color) {
        for (int i = 0; i < length; i++) {
            addBlock(new Block(left + (i * (direction.horizontal * Game.BLOCK_SIZE)),
                    top + (i * (direction.vertical * Game.BLOCK_SIZE)), Game.BLOCK_SIZE, color));
        }
    }
}
