import java.awt.*;
import java.awt.geom.*;

/**
   A square node that is filled with a color.
*/
public class SquareNode implements GNode
{
   /**
      Construct a square node with a given size and color.
      @param size the size
      @param aColor the fill color
   */
   public SquareNode(Color aColor)
   {
      size = DEFAULT_SIZE;
      x = 0;
      y = 0;
      color = aColor;
   }

   public Object clone()
   {
      try
      {
         return super.clone();
      }
      catch (CloneNotSupportedException exception)
      {
         return null;
      }
   }

   public void draw(Graphics2D g2)
   {
      Rectangle2D square = new Rectangle2D.Double(
         x, y, size, size);
      Color oldColor = g2.getColor();
      g2.setColor(color);
      g2.fill(square);
      g2.setColor(oldColor);
      g2.draw(square);
   }

   public void translate(double dx, double dy)
   {
      x += dx;
      y += dy;
   }

   public boolean contains(Point2D p)
   {
      Rectangle2D square = new Rectangle2D.Double(
         x, y, size, size);
      return square.contains(p);
   }

   public Rectangle2D getBounds()
   {
      return new Rectangle2D.Double(
         x, y, size, size);
   }

   public Point2D getConnectionPoint(Point2D other)
   {
      double centerX = x + size / 2;
      double centerY = y + size / 2;
      double dx = other.getX() - centerX;
      double dy = other.getY() - centerY;
      double distance = Math.sqrt(dx * dx + dy * dy);
      if (distance == 0) return other;
      else return new Point2D.Double(
         centerX + dx * (size / 2) / distance,
         centerY + dy * (size / 2) / distance);
   }

   private int x;
   private int y;
   private int size;
   private Color color;  
   private static final int DEFAULT_SIZE = 20;
}

