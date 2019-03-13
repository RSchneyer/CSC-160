import java.awt.*;
import java.util.*;

/**
   A simple graph with round nodes and straight edges.
*/
public class SimpleGraph extends Graph
{
   public GNode[] getNodePrototypes()
   {
      GNode[] nodeTypes =
         {
            new CircleNode(Color.BLACK),
            new CircleNode(Color.WHITE),
            new SquareNode(Color.RED),
            new TriangleNode(Color.BLUE),
            new ColorChangingCircleNode(Color.RED)
         };
      return nodeTypes;
   }

   public Edge[] getEdgePrototypes()
   {
      Edge[] edgeTypes = 
         {
            new LineEdge(),
            new DashedLineEdge()
         };
      return edgeTypes;
   }
}






