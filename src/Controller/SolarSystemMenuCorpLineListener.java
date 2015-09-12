
package Controller;

import Model.*;
import Object.*;
import Viewer.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class SolarSystemMenuCorpLineListener 
{
    Model m;
    Viewer v;
    
    public SolarSystemMenuCorpLineListener(Model m,Viewer v)
    {
        this.m = m;
        this.v = v;
        for(SolarSystemMenu.LineCorpPanel lcp: v.solarSystemMenu.corpLine)
        {
            lcp.addMouseListener(new CorpClickAction(lcp.lineCorp));
        }
        //FOR EACH SATELLITE MENU
        for(SolarSystemMenu s : v.solarSystemSatelliteMenu)
        {
            for(SolarSystemMenu.LineCorpPanel lcp: s.corpLine)
            {
                lcp.addMouseListener(new CorpClickAction(lcp.lineCorp));
            }
        }
    }
    
    class CorpClickAction implements MouseListener
    {
        Corp actionCorp;
        
        public CorpClickAction(Corp c_)
        {
            actionCorp = c_;
        }
        
        @Override
        public void mouseClicked(MouseEvent e) 
        {
            m.selectedCorp = actionCorp;
            if(actionCorp.type == 3)
            {
                m.selectedSpaceShip = (SpaceShip) actionCorp;
                v.spaceshipPanel.setVisible(true);
            }
            else
            {
                m.selectedSpaceShip = m.emptySpaceShip;
                v.spaceshipPanel.setVisible(false);
            }
            if(m.selectedCorp.diaporamaImage.size() > 0)
                v.corpPanel.currentImage = m.selectedCorp.diaporamaImage.get(0);
            else
                v.corpPanel.currentImage = m.selectedCorp.originalImage;
            
            v.corpPanel.setValueFromSelectedCorp();
            m.cameraXTranslation = 0;
            m.cameraYTranslation = 0;
            m.cameraZoom += 0.01;
            for(SolarSystemMenu.LineCorpPanel lcp: v.solarSystemMenu.corpLine)
            {
                lcp.setBackground();
            }
            for(SolarSystemMenu s : v.solarSystemSatelliteMenu)
            {
                for(SolarSystemMenu.LineCorpPanel lcp: s.corpLine)
                {
                   lcp.setBackground();
                }
            }
            v.designer.updateZoomOnCorpImg();
        }
        @Override
        public void mousePressed(MouseEvent e) {}
        @Override
        public void mouseReleased(MouseEvent e) {}
        @Override
        public void mouseEntered(MouseEvent e) {}
        @Override
        public void mouseExited(MouseEvent e) {}
    }
}
