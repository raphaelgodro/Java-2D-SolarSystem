
package Controller;

import Model.*;
import Viewer.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class SystemKeyListener 
{
    Model m;
    Viewer v;
    
    public SystemKeyListener(Model m,Viewer v)
    {
        this.m = m;
        this.v = v;
        
        v.designer.addKeyListener(new KeyListenerMain());
        v.designer.revalidate();
        v.generalPanel.revalidate();
    }
    
    class ExitListener implements KeyListener{

        @Override
        public void keyTyped(KeyEvent e) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void keyPressed(KeyEvent e) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void keyReleased(KeyEvent e) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
        
    }
    
    
    class KeyListenerMain implements KeyListener
    {
        @Override
        public void keyTyped(KeyEvent ke) 
        {}

        @Override
        public void keyPressed(KeyEvent ke) 
        {
            if(ke.getKeyCode() == 27)
                systemExit();
            if(ke.getKeyCode() == 122)
                switchViewMode();
        }

        @Override
        public void keyReleased(KeyEvent ke) 
        {}
        
    }
    void systemExit()
    {
        System.exit(0);
    }
    void switchViewMode()
    {
        if(m.freeViewMode)
            m.freeViewMode = false;
        else
            m.freeViewMode = true;
        
        if(m.freeViewMode)
        {
            v.addCorpButton.setVisible(false);
            v.resetButton.setVisible(false);
            v.corpPanel.setVisible(false);
            v.selecPanel.setVisible(false);
            v.solarSystemMenu.setVisible(false);
            for(SolarSystemMenu ssm: v.solarSystemSatelliteMenu)
            {
                ssm.setVisible(false);
            }
            v.spaceshipFactoryPanel.setVisible(false);
            v.spaceshipPanel.setVisible(false);
            v.timePanel.setVisible(false);
            v.zoomPanel.setVisible(false);
        }
        else
        {
            for(SolarSystemMenu ssm: v.solarSystemSatelliteMenu)
            {
                ssm.setVisible(true);
            }
            v.addCorpButton.setVisible(true);
            v.resetButton.setVisible(true);
            v.corpPanel.setVisible(true);
            v.solarSystemMenu.setVisible(true);
            if(m.selectedCorp.type == 3)
                v.spaceshipPanel.setVisible(true);
            v.timePanel.setVisible(true);
            v.zoomPanel.setVisible(true);
        }
    }
}
