
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;

public class Square extends MyShape {

    public Square(Point2D.Double location, Color color, int size) {
        super(location, color, size);
    }

    @Override
    public void draw(Graphics2D g2) {
        Rectangle2D.Double square = new Rectangle2D.Double();
        square.setFrameFromCenter(super.getLocation().getX(), super.getLocation().getY(), super.getLocation().getX()- super.getSize()/2, super.getLocation().getY()- super.getSize()/2);
        g2.setColor(super.getColor());
        g2.draw(square);
        g2.fill(square);
    } 
}
