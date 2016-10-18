import java.awt.*;
import java.util.ArrayList;

public class Shape {

    protected ArrayList<Block> blocks = new ArrayList<>();

    public ArrayList<Block> getBlocks() {
        return blocks;
    }

    public void addBlock(Block block) {
        blocks.add(block);
    }

    public Color getColor() {
        return blocks.get(0).getColor();
    }

    public void draw(Graphics g) {
        for (Block b:blocks) {
            b.draw(g);
        }
    }
}