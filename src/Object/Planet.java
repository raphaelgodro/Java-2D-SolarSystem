
package Object;

import java.awt.Color;
import java.awt.geom.Path2D;
import java.util.ArrayList;

public class Planet extends Corp
{
    public Color color;
    public ArrayList<Satellite> satelliteOfThisPlanet = new ArrayList<Satellite>();
    
    public Planet(String name,Color c,double radius,double mass,double radiusDisplay,double averageSpeed,double rotation)
    {
        super(name,c,radius,mass,radiusDisplay,averageSpeed,rotation);
    }
    public Planet(String name,Color c,double posX,double posY,double mass,
                  double radiusDisplay,double speedX,double speedY,double rotation)
    {
        super(name,c,posX,posY,mass,radiusDisplay,speedX,speedY,rotation);
    }
    public void addSatellite(Satellite satellite)
    {
        satelliteOfThisPlanet.add(satellite);
    }
    
}
