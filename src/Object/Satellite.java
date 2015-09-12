
package Object;

import java.awt.Color;
import java.awt.geom.Path2D;

public class Satellite extends Corp
{
    public Color color;
    public Planet relatedPlanet;
    public double initialDistanceWithRelatedPlanet = 0;
    public double initialSpeed = 0;
    
    public Satellite(String name,Color c,double radius,double mass,double radiusDisplay,double averageSpeed,
                     Planet relatedPlanet,double rotation)  
    {
        super(name,c,radius + Math.sqrt(2* Math.pow(relatedPlanet.posX, 2)),mass,
                radiusDisplay,averageSpeed + Math.sqrt(2* Math.pow(relatedPlanet.speedX, 2)),rotation);
        this.relatedPlanet = relatedPlanet;
        initialDistanceWithRelatedPlanet = radius;
        initialSpeed = averageSpeed;
    }
}
