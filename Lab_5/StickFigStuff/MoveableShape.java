import java.awt.*;
import java.awt.geom.*;

public interface MoveableShape
{
	void draw(Graphics2D g2);
	void translate(double dx, double dy);
}