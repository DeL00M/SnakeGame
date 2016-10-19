import java.awt.*;

public class Block {

    private int top;
    private int left;
    private int size;
    private Color color;

    public int getTop() {
        return top;
    }
    public int getLeft() {
        return left;
    }

    public int getSize() {
        return size;
    }

    public Color getColor() {
        return color;
    }



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