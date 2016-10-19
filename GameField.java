import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class GameField extends JPanel {
    private ArrayList<Shape> shapes = new ArrayList<>();

    public GameField(Color color) {
        this.setBackground(color);
    }

    public void addShape(Shape shape){
        shapes.add(shape);
    }

    public ArrayList<Shape> getShapes() {
        return shapes;
    }

    public boolean blocksCrossing(Block block) {
        for (Shape s:shapes) {
            for (Block b:s.getBlocks()) {
                if (!(b.equals(block)) && b.getTop() == block.getTop() && b.getLeft() == block.getLeft()) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Game.Paint(g);
    }
}