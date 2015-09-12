package Controller;

import Model.*;
import Viewer.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ResetButtonListener 
{
    Viewer v;
    Model m;
    
    public ResetButtonListener(Model m,Viewer v)
    {
        this.m = m;
        this.v = v;
        v.resetButton.addActionListener(new ResetActionListener());
    }
    class ResetActionListener implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent ae) 
        {
            //SET THE DEFAULT SOLAR SYSTEM AT THE BEGINNING OF THE PROGRAM
            SolarSystemDataBase ssdb = new SolarSystemDataBase();
            m.currentSolarSystem = ssdb.ssList.get(0);
            m.selectedCorp = m.currentSolarSystem.defaultSystemSelectedCorp;
            
            m.deltaT = 10;
            
            v.refreshView();
        }
        
    }
}
