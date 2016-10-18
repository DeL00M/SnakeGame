import java.awt.*;

public class Line extends Shape{
    public Line(int top, int left, int count, int[] direction, Color color) {
        for (int i = 0; i < count; i++) {
            this.blocks.add(new Block(left + (i * (direction[0] * Game.BLOCK_SIZE)),
                    top + (i * (direction[1] * Game.BLOCK_SIZE)), Game.BLOCK_SIZE, color));
        }
    }
}
