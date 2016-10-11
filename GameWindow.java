import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class GameWindow extends JFrame {

    public GameWindow(int width, int height, int top, int left) {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocation(top, left);
        setSize(width, height);
        setResizable(false);
        setVisible(true);
    }
}
