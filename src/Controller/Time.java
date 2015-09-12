
package Controller;

import Model.*;
import Object.Corp;
import Viewer.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Time extends Thread
{
    Model m;
    Viewer v;
    PhysicsMachine physicsMachine;
    
    public Time(Model m,Viewer v)
    {
        this.m = m;
        this.v = v;
    }
    public void run()
    {
        //TANT QUE LE TEMPS N'EST PAS EN PAUSE
        int i = 1;
        while(!m.timeOnPause)
        {
            
            PhysicsMachine pm = new PhysicsMachine(m,v,i,getCorpListIteration(i));
            //REFRESH THE PANEL
            if(i% (m.pps/m.fps) == 0)
            {
                //REFRESH THE VIEW OF THE PROGRAM
                v.refreshView();       
                //SATELLITE TIME CORRECTOR
                ObjectTimeCorrector stc = new ObjectTimeCorrector(m,v);
                //ROTATION CORP MACHINE
                CorpRotationMachine crm = new CorpRotationMachine(m,v);
            }
            try 
            {
                Thread.sleep(1000/m.pps);
            } 
            catch (InterruptedException ex) 
            {
                Logger.getLogger(Time.class.getName()).log(Level.SEVERE, null, ex);
            }
            i++;
        }
    }
    ArrayList<Corp> getCorpListIteration(int programTurn)
    {
        //UPDATE THE GLOBAL CORPLIST FOR THE PHYSICS MACHINE DEPENDING ON IF THE ASTEROID NEEDS TO BE REFRESH
        if(programTurn % m.ppsRefreshPerCorpType.get(2) == 0)
        {
            //ASTEROID REFRESH TURN
            return m.currentSolarSystem.corpList;
        } 
        else
        {
            return m.currentSolarSystem.corpListOptimized;
        }
    }
}
