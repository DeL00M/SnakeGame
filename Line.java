import java.awt.*;

public class Line extends Shape{

    public Line() {
    }

    public Line(int left, int top, int blockSize, int length, Directions direction, Color color) {
        for (int i = 0; i < length; i++) {
            addBlock(new Block(left + (i * (direction.horizontal * blockSize)),
                    top + (i * (direction.vertical * blockSize)), blockSize, color));
        }
    }
}
