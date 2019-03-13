import java.awt.*;
import java.awt.geom.*;
import javax.swing.*;

public class SubComponent extends JComponent{
    public synchronized void paintComponent(Graphics g){
        Graphics2D g2 = (Graphics2D) g;
        int height = getHeight();
        int width = getWidth();
        Rectangle2D ocean = new Rectangle2D.Double(0,0,width,height);
        Ellipse2D sub = new Ellipse2D.Double(x, (height*2)/3, 200, 60);
        Ellipse2D fish = new Ellipse2D.Double(width-x,height/4,50,10);
        Rectangle2D periscope = new Rectangle2D.Double(x+85, ((height*2)/3)-50, 20, 55);
        g2.setColor(Color.CYAN);
        g2.fill(ocean);
        g2.setColor(Color.GRAY);
        g2.fill(periscope);
        g2.setColor(Color.YELLOW);
        g2.fill(sub);
        g2.setColor(Color.RED);
        g2.fill(fish);
        if(bubbles){
            Ellipse2D bubble1 = new Ellipse2D.Double(x-30,((height*2)/3)+30,20,20);
            g2.setColor(Color.BLACK);
            g2.draw(bubble1);
        }
        else{
            Ellipse2D bubble2 = new Ellipse2D.Double(x-60,((height*2)/3)+20,20,20);
            g2.setColor(Color.BLACK);
            g2.draw(bubble2);
        }

    }
    public synchronized void setValues(){
        int width = getWidth();
        x = (x>=width)?(x = -200):(x+=width/100);
        bubbles = !bubbles;
        repaint();
    }
    private boolean bubbles = true;
    private double x = 0;
    private double y;
}