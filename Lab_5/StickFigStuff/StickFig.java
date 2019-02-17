import java.awt.*;
import java.awt.geom.*;

public class StickFig implements MoveableShapeWithPosition {
    private int pose, // one of several possible poses for stick figure
                poses;// number of poses in the dance
    private double  x,// x & y describe upper left corner of figure
                    y,
                    size; // height of figure
    public StickFig (double xpos, double ypos, double height) {
        pose = 0;
        poses = 4;
        x = xpos;
        y = ypos;
        size = height;
    }
    public void draw(Graphics2D g2) {
        double headSize = size/4;   // size of circle head
        double bodyLen = size/2;    // length of stick body (minus legs)
        Point2D.Double armSpot = new Point2D.Double(x+headSize/2, y + bodyLen);
                                    // mid point on body where arms attach
        Point2D.Double legSpot = new Point2D.Double(x+headSize/2, y + size*.75);
        Ellipse2D.Double head = new Ellipse2D.Double(x, y, headSize, headSize);
        Line2D.Double body = new Line2D.Double(x+size/8, y+headSize, 
                                               x+size/8, y+headSize+bodyLen);
        Line2D.Double arm1, arm2, lega, legb;
        Point2D.Double a1end, a2end, laEnd, lbEnd;
        g2.draw(head);
        g2.draw(body);                                       
        if (pose == 0) {    
           // arms raised, legs out
           a1end = new Point2D.Double(x,y+size/3);
           a2end = new Point2D.Double(x+headSize, y+size/3);
           arm1 = new Line2D.Double(armSpot, a1end);
           arm2 = new Line2D.Double(armSpot, a2end);
           g2.draw(arm1);
           g2.draw(arm2);
           laEnd = new Point2D.Double(x, y+size);
           lbEnd = new Point2D.Double(x+headSize, y+size);
           lega = new Line2D.Double(legSpot, laEnd);
           legb = new Line2D.Double(legSpot, lbEnd);
           g2.draw(lega);
           g2.draw(legb);  
        }
        else if (pose == 1) {
          // arms lowered, legs in
           a1end = new Point2D.Double(x,y+size*2/3);
           a2end = new Point2D.Double(x+headSize, y+size*2/3);
           arm1 = new Line2D.Double(armSpot, a1end);
           arm2 = new Line2D.Double(armSpot, a2end);
           g2.draw(arm1);
           g2.draw(arm2);
           laEnd = new Point2D.Double(x+headSize/4, y+size);
           lbEnd = new Point2D.Double(x+headSize*3/4, y+size);
           lega = new Line2D.Double(legSpot, laEnd);
           legb = new Line2D.Double(legSpot, lbEnd);
           g2.setColor(Color.RED);
           g2.draw(lega);
           g2.setColor(Color.BLUE);
           g2.draw(legb);    
        }
        else if(pose == 2){
            //Arms flat, one leg straight down and the other to the side
            a1end = new Point2D.Double(x, y+bodyLen);
            a2end = new Point2D.Double(x+headSize, y+bodyLen);
            arm1 = new Line2D.Double(armSpot,a1end);
            arm2 = new Line2D.Double(armSpot,a2end);
            g2.draw(arm1);
            g2.draw(arm2);
            laEnd = new Point2D.Double(x+headSize/2, y+size);
            lbEnd = new Point2D.Double(x+headSize, y+size);
            lega = new Line2D.Double(legSpot, laEnd);
            legb = new Line2D.Double(legSpot, lbEnd);
            g2.setColor(Color.GREEN);   
            g2.draw(lega);
            g2.setColor(Color.ORANGE);
            g2.draw(legb);
        }
        else if(pose == 3){
            //All red, all limbs perpendicular to the body
            g2.setColor(Color.RED);
            a1end = new Point2D.Double(x, y+bodyLen);
            a2end = new Point2D.Double(x+headSize, y+bodyLen);
            arm1 = new Line2D.Double(armSpot, a1end);
            arm2 = new Line2D.Double(armSpot, a2end);
            g2.draw(arm1);
            g2.draw(arm2);
            laEnd = new Point2D.Double(x, y + size*.75);
            lbEnd = new Point2D.Double(x+headSize, y + size*.75);
            lega = new Line2D.Double(legSpot, laEnd);
            legb = new Line2D.Double(legSpot, lbEnd);
            g2.draw(lega);
            g2.draw(legb);
        }
        pose++;
        if(pose >= poses)
            pose = 0;
    }       
    public void translate(double dx, double dy)
    {
        x+=dx;
        y+=dy;
    }
    public double getX() {return x;}
    public double getY() {return y;}
    public double getSize() {return size;}
    public Point2D.Double getPosition() {
        return new Point2D.Double(getX(), getY());
    }
}
