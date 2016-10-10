import java.awt.*;

public class Block {
    int posX;
    int posY;
    int width;
    int height;
    Color color;

    Block(int x, int y, int width, int height, Color color) {
        posX = x;
        posY = y;
        this.width = width;
        this.height = height;
        this.color = color;
    }

    public void draw(Graphics g) {
        g.setColor(color);
        g.fillRect(posX, posY, width, height);
    }
}