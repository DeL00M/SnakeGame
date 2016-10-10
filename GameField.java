import javax.swing.*;
import java.awt.*;

public class GameField extends JPanel {
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Game.Paint(g);
        repaint();
    }
}