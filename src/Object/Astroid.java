/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Object;

import java.awt.Color;
import java.awt.geom.Path2D;
 
public class Astroid extends Corp 
{
    public Astroid(String name,Color c,double radius,double mass,double radiusDisplay,double averageSpeed,double rotation)
    {
        super(name,c,radius,mass,radiusDisplay,averageSpeed,rotation);
    }
    public Astroid(String name,Color c,double posX,double posY,double mass,
                double radiusDisplay,double speedX,double speedY,double rotation)
    {
        super(name,c,posX,posY,mass,radiusDisplay,speedX,speedY,rotation);
    }
}
