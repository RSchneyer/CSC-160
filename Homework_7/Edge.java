import java.awt.*;
import java.awt.geom.*;
import java.io.*;

/**
   An edge in a graph.
*/
public interface Edge extends Serializable, Cloneable
{
   /**
      Draw the edge.
      @param g2 the graphics context
   */
   void draw(Graphics2D g2);

   /**
      Tests whether the edge contains a point.
      @param aPoint the point to test
      @return true if this edge contains aPoint
   */
   boolean contains(Point2D aPoint);

   /**
      Connects this edge to two nodes.
      @param aStart the starting node
      @param anEnd the ending node
   */
   void connect(GNode aStart, GNode anEnd);

   /**
      Gets the starting node.
      @return the starting node
   */
   GNode getStart();

   /**
      Gets the ending node.
      @return the ending node
   */
   GNode getEnd();

   /**
      Gets the points at which this edge is connected to
      its nodes.
      @return a line joining the two connection points
   */
   Line2D getConnectionPoints();

   /**
      Gets the smallest rectangle that bounds this edge.
      The bounding rectangle contains all labels.
      @return the bounding rectangle
   */
   Rectangle2D getBounds(Graphics2D g2);

   Object clone();
}


