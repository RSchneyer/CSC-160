import java.awt.*;
import java.awt.geom.*;
import javax.swing.*;

public class SubComponent extends JComponent{
    public synchronized void paintComponent(Graphics g){
        Graphics2D g2 = (Graphics2D) g;
        Ellipse2D ball = new Ellipse2D.Double(x,y,50,50);
        g2.draw(ball);
    }
    public synchronized void setValues(double x, double y){
        this.x = x;
        this.y = y;
        repaint();
    }
    
    
    private double x;
    private double y;
}