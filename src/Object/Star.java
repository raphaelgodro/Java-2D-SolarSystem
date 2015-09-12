package Object;

import java.awt.Color;
import java.awt.geom.Path2D;

public class Star extends Corp
{ 
    public Color color;
    
    public Star(String name,Color c, double posX,double posY,double mass,double radius,double speedX,double speedY,double rotation)
    {
        super(name,c,posX,posY,mass,radius,speedX,speedY,rotation);
        path = new Path2D.Double();
        path.moveTo(posX, -posY);
    }
}
 