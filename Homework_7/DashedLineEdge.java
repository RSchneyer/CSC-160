import java.awt.*;
import java.awt.geom.*;

/**
   An edge that is shaped like a straight line.
*/
public class DashedLineEdge extends AbstractEdge
{
   public void draw(Graphics2D g2)
   {
        float[] dashPattern = {2f,2f};
        Stroke stroke = new BasicStroke(2f, BasicStroke.CAP_BUTT,
                BasicStroke.JOIN_MITER, 1.0f, dashPattern, 2.0f);
        g2.setStroke(stroke);
        g2.draw(getConnectionPoints());
   }

   public boolean contains(Point2D aPoint)
   {
      final double MAX_DIST = 2;
      return getConnectionPoints().ptSegDist(aPoint) 
         < MAX_DIST;
   }
}