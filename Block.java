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

    public void setColor(Color color) {
        this.color = color;
    }

    public Block() {

    }

    public Block(int left, int top, int size, Color color) {
        this.left = left;
        this.top = top;
        this.size = size;
        this.color = color;
    }

    public void draw(Graphics g) {
        g.setColor(color);
        g.fillRect(left, top, size, size);
    }
}