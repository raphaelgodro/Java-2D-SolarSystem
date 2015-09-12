
package Controller;

import Model.*;
import Object.*;
import Viewer.*;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Timer;

public class TitleAnimation 
{
    Model m; 
    Viewer v;
    Corp lastSelectedCorp = null;
    
    
    public TitleAnimation(Model m,Viewer v)
    {
        this.m = m;
        this.v = v;
        
        TitleChangeThread tct = new TitleChangeThread();
        tct.start();
    }
    class TitleChangeThread extends Thread
    {
        public void run()
        {
            while(true)
            {
                double relDSelected = Math.sqrt(Math.pow(m.selectedCorp.posX,2) + Math.pow(m.selectedCorp.posY,2));
                if(relDSelected>30000)
                {
                    changeTitle("LOST IN OUTER SPACE");
                }
                else if((relDSelected>10000)&&(relDSelected<= 30000))
                {
                    changeTitle("OORT CLOUD");
                }
                else if((m.cameraZoom<0.15)&&(m.cameraZoom > 0.015))
                {
                    if(relDSelected<5)
                        changeTitle("INNER SOLAR SYSTEM");
                    else
                        changeTitle("OUTER SOLAR SYSTEM");
                }
                else if(m.cameraZoom < 0.015)
                {
                    changeTitle("THE LOCAL SOLAR SYSTEM");
                }
                //IF THE SELECTED CORP HAD BEEN CHANGED
                else if(!m.selectedCorp.equals(lastSelectedCorp))
                {
                    changeTitle(m.selectedCorp.name);
                }
                
                try 
                {
                    Thread.sleep(100);
                } 
                catch (InterruptedException ex) 
                {}
            }
        }
    }
    void changeTitle(String s)
    {
        if(!s.equals(v.titleJLabel.getText()))
        {
            v.displayTitle = true;
            v.titleJLabel.setForeground(new Color(0,0,0));
            v.titleJLabel.setText(s);
            v.titleJLabel.setForeground(new Color(255,255,255));
            //WAIT 8 SECOND UNTIL IT DISAPPEAR
            try 
            {
                Thread.sleep(5000);
            } 
            catch (InterruptedException ex) 
            {}
            v.displayTitle = false;
        }
    }    
}
