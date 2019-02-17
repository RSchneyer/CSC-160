import java.awt.*;
import java.awt.geom.*;
import javax.swing.*;

public class ShapeIcon2 implements Icon {
    private int width;
    private int height;
    private MoveableShapeWithPosition shape; 

    public ShapeIcon2(MoveableShapeWithPosition shape, int width, int height) {
       this.shape = shape;
       this.width = width;
       this.height = height;
    }
    public int getIconWidth() {
       return width;
    }
 
    public int getIconHeight() {
       return height;
    }
 
    public void paintIcon(Component c, Graphics g, int x, int y) {
       Graphics2D g2 = (Graphics2D) g;
       shape.draw(g2);
    }
}