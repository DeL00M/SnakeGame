import java.awt.*;
import java.util.ArrayList;

public class Shape {

    private ArrayList<Block> blocks = new ArrayList<>();

    public ArrayList<Block> getBlocks() {
        return blocks;
    }

    public void addBlock(Block block) {
        blocks.add(block);
    }

    public void removeBlock(int index) {
        blocks.remove(index);
    }

    public Color getColor() {
        return blocks.get(0).getColor();
    }

    public void draw(Graphics g) {
        for (Block block:blocks) {block.draw(g);}
    }
}