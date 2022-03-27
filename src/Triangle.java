
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
public class Triangle extends MyShape {

    public Triangle(Point2D.Double location, Color color, int size) {
        super(location, color, size);
    }

    @Override
    public void draw(Graphics2D g2) {
        Point2D.Double point1 = new Point2D.Double(super.getLocation().getX(), super.getLocation().getY() - super.getSize());
        Point2D.Double point2 = new Point2D.Double(super.getLocation().getX()+ super.getSize(), super.getLocation().getY());        
        Line2D.Double line1 = new Line2D.Double(super.getLocation(),point1);
        Line2D.Double line2 = new Line2D.Double(super.getLocation(),point2); 
        Line2D.Double line3 = new Line2D.Double(point1,point2);   
        g2.setColor(super.getColor());
        g2.draw(line1);
        g2.draw(line2);
        g2.draw(line3); 
    }
    
}
