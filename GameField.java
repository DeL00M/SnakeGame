import javax.swing.*;
import java.awt.*;

public class GameField extends JPanel {
    Block[][] cells;
    public GameField(int rows, int cols, int size, Color color) {
        setBackground(color);
        cells = new Block[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                cells[i][j] = new Block(i*size, j*size, size, color);
            }
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Game.Paint(g);
        repaint();
    }
}