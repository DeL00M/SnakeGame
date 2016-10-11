import javax.swing.*;
import java.awt.*;

public class GameField extends JPanel {
    Block[][] cells;
    public GameField(int rows, int cols, int size, Color color) {
        setBackground(color);
        cells = new Block[rows][cols];
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Game.Paint(g);
        repaint();
    }
}