import java.awt.*;

public class Block {
    protected int top;
    protected int left;

    public int getSize() {
        return size;
    }

    protected int size;

    public Color getColor() {
        return color;
    }

    protected Color color;

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