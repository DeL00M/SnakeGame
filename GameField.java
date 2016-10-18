import javax.swing.*;
import java.awt.*;

public class GameField extends JPanel {

    public GameField(Color color) {
        setBackground(color);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Game.Paint(g);
        repaint();
    }
}