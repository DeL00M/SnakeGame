import java.awt.*;

public class Game {
    GameWindow gameWindow;
    static Snake snake = new Snake(Color.CYAN);

    public static void main(String[] args) {new Game().play();}

    private void play() {
        gameWindow = new GameWindow();
    }

    public static void Paint(Graphics g) {
        snake.draw(g);
    }
}
