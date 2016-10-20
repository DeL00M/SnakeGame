import java.awt.*;

public class Food extends Shape {

    public Food(Block block) {
        super.addBlock(block);
    }

    public Food(int left, int top, int size, Color color) {
        super.addBlock(new Block(left, top, size, color));
    }

    public Block getBlock() {
        return super.getBlocks().get(0);
    }
}
