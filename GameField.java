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

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Game.Paint(g);
        //repaint();
    }
}