
package Controller;

import Model.*;
import Object.*;
import Viewer.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ObjectTimeCorrector
{
    Model m;
    Viewer v;
    
    public ObjectTimeCorrector(Model m,Viewer v)
    {
        this.m = m;
        this.v = v;
        correctSatelliteWithTime();
        correctRotationWithTime();
    }
    public void correctSatelliteWithTime()
    {
       if((m.deltaT >= m.satelliteMaxDeltaT)&&(!m.satelliteReset))
        {
            //CREATE A NEW CORPLIST WITHOUT ANY SATELLITE IN IT
            ArrayList<Corp> newSolarSystem = new ArrayList<Corp>();
            for(Satellite s : m.currentSolarSystem.satelliteGlobal)
            {

                for(Corp c : m.currentSolarSystem.corpListOptimized)
                {
                    if(!c.equals(s))
                    {
                        newSolarSystem.add(c);
                    }
                }
                //SAVE EVERY SATELLITE WE GOT BEFORE DESTROYING IT
                m.memorySatellite.add(s);
                //DESTROY THE SATELLITE LIST INTO THE RELATED PLANET
                s.relatedPlanet.satelliteOfThisPlanet.clear();
            }
            m.currentSolarSystem.satelliteGlobal.clear();
            //m.currentSolarSystem.corpList = newSolarSystem;
            m.satelliteReset = true;
            DialogBox error = new DialogBox(v.frame,m.errorMessage.get(2));
        }
        else if((m.deltaT < m.satelliteMaxDeltaT)&&(m.satelliteReset))
        {
            for(Satellite s : m.memorySatellite)
            {
                s.posX = (double) (s.relatedPlanet.posX - 0.707107 * s.initialDistanceWithRelatedPlanet);
                s.posY = (double) (s.relatedPlanet.posY + 0.707107 * s.initialDistanceWithRelatedPlanet);
                s.speedX = Math.sqrt(Math.pow(s.initialSpeed,2)/2);
                s.speedY = s.speedX;
                m.currentSolarSystem.addSatellite(s,s.relatedPlanet);
            }
            m.satelliteReset = false;
            DialogBox error = new DialogBox(v.frame,m.errorMessage.get(3));
        }
    }
    public void correctRotationWithTime()
    {
        if((m.deltaT >= m.rotationMaxDeltaT)&&(!m.rotationReset))
        {
            //RESET ANGLE INTO EACH CORP
            for(Corp c : m.currentSolarSystem.corpListOptimized)
            {
                c.currentRotationAngle = 0;
            }
            m.rotationDisplay = false;
            DialogBox error = new DialogBox(v.frame,m.errorMessage.get(5));
            m.rotationReset = true;
        }
        else if((m.deltaT < m.rotationMaxDeltaT)&&(m.rotationReset))
        {
            m.rotationDisplay = true;
            DialogBox error = new DialogBox(v.frame,m.errorMessage.get(4));
            m.rotationReset = false;
        }
    }
}
