import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class GameWindow extends JFrame {

    public GameWindow() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocation(400, 200);
        setSize(640, 480);
        setResizable(false);
        GameField gameField = new GameField();
        gameField.setBackground(Color.BLACK);
        add(gameField);
        setVisible(true);
    }
}
