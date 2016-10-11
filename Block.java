import java.awt.*;

public class Block {
    public int top;
    public int left;
    public int size;
    Color color;

    Block(int top, int left, int size, Color color) {
        this.top = top;
        this.left = left;
        this.size = size;
        this.color = color;
    }

    public void draw(Graphics g) {
        g.setColor(color);
        g.fillRect(top, left, size, size);
    }
}