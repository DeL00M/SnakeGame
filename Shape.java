import java.awt.*;
import java.util.ArrayList;

public class Shape {
    public ArrayList<Block> blocks = new ArrayList<Block>();;

    public void draw(Graphics g) {
        for (Block b:blocks
             ) {
            b.draw(g);
        }
    }
}