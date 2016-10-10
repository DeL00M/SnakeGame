import java.awt.*;

public class Snake extends Shape{
 public Snake(Color color) {
     blocks.add(new Block(0, 0, 20, color));
     blocks.add(new Block(0, 20, 20, color));
     blocks.add(new Block(0, 40, 20, color));
 }
}