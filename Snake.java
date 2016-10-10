import java.awt.*;

public class Snake extends Shape{
 public Snake(Color color) {
     blocks.add(new Block(10, 10, 20, 20, color));
     blocks.add(new Block(30, 10, 20, 20, color));
     blocks.add(new Block(50, 10, 20, 20, color));
 }
}