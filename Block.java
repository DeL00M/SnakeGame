import java.awt.*;

public class Block {
    int posX;
    int posY;
    int size;
    Color color;

    Block(int x, int y, int size, Color color) {
        posX = x;
        posY = y;
        this.size = size;
        this.color = color;
    }

    public void draw(Graphics g) {
        g.setColor(color);
        g.fillRect(posX, posY, size, size);
    }
}