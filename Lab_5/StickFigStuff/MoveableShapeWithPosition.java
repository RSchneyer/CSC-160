import java.awt.*;
import java.awt.geom.*;

public interface MoveableShapeWithPosition extends MoveableShape
{
	Point2D.Double getPosition();
}