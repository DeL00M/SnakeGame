import java.awt.*;

public class Food extends Shape {

    public Food(Block block) {
        super.addBlock(block);
    }

    public Food(int top, int left, int size, Color color) {
        super.addBlock(new Block(top, left, size, color));
    }
}
