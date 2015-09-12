
package Controller;

import Model.*;
import Object.*;
import Viewer.*;

public class CorpRotationMachine 
{
    Model m;
    Viewer v;
    
    public CorpRotationMachine(Model m,Viewer v)
    {
        //IF THE DISPLAY OF THE ROTATION ISNT AUTHORIZED, DO NOT CALCULATE IT FOR NOTHING.
        if(m.rotationDisplay)
        {
            //FOR EACH CORP OF THE SOLAR SYSTEM
            for(Corp c : m.currentSolarSystem.corpListOptimized)
            {
                //IF THE ROTATION IS DEFINED
                if(c.rotationPeriodHour > 0)
                {
                    double periodInS = c.rotationPeriodHour * 3600;
                    double deltaT = m.deltaT * (m.pps/m.fps);
                    double angleAdd = deltaT*360/periodInS;
                    c.currentRotationAngle += angleAdd;
                    while(c.currentRotationAngle > 360)
                    {
                        c.currentRotationAngle -= 360;
                    }
                }
            }
        }
    }
}
