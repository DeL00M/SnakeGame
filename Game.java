import java.awt.*;

public class Game {
    static GameWindow gameWindow;
    static Shape figure = new Shape();

    public static void main(String[] args) {
        figure.blocks.add(new Block(10, 10, 20, 20, Color.YELLOW));
        gameWindow = new GameWindow();
    }

    public static void Paint(Graphics g) {
        figure.draw(g);
    }
}
