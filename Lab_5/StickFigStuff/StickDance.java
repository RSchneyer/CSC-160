import java.awt.*;
import javax.swing.*;
import java.awt.geom.*;
import java.awt.event.*;

public class StickDance extends JFrame {
     private JLabel space;   // space stick figure occupies
     MoveableShapeWithPosition sticky;   // stick figure object
     ShapeIcon2 figure;        // Icon container for stick figure
     public StickDance () {
        setSize(500,500);
        setTitle("Dance!");
        setAlwaysOnTop(true);
        sticky = new StickFig(0, 0, 200);
        figure = new ShapeIcon2(sticky,50,200);
        space = new JLabel(figure);
        final Container contentPane = getContentPane();
        contentPane.add(space);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Timer t = new Timer(50, new ActionListener () {
            public void actionPerformed(ActionEvent event) {
                sticky.translate(1,.3);
                Point2D.Double posn = sticky.getPosition();
                if(posn.getX() > getWidth() ||
                    posn.getY() > getHeight ()) {
                    contentPane.remove(space);
                    sticky = new StickFig(0,0,200);
                    figure = new ShapeIcon2(sticky,50,200); 
                    space = new JLabel(figure);
                    contentPane.add(space);
                }
                space.repaint();
            }
        });
        t.start(); 
    }
    public static void main (String [] args) {
        StickDance dancer = new StickDance();
    }
}