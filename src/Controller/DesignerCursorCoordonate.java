
package Controller;

import Model.*;
import Viewer.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

public class DesignerCursorCoordonate 
{
    Model m;
    Viewer v;
    
    public DesignerCursorCoordonate(Model m,Viewer v)
    {
        this.m = m;
        this.v = v;
        v.designer.addMouseMotionListener(new DesignerMouseListener());
    }
    class DesignerMouseListener implements MouseMotionListener
    {
        @Override
        public void mouseMoved(MouseEvent e) 
        {
            v.designer.coordX = getXFromPxPoint(e.getX());
            v.designer.coordY = getYFromPxPoint(e.getY());
        }
        @Override
        public void mouseDragged(MouseEvent e) {}
        
        double getXFromPxPoint(int screenX)
        {
            double x = screenX - m.programWidth/2 - m.cameraXTranslation;
            x = (x)/(m.cameraZoom);
            x = x/m.pixelParAU + m.selectedCorp.posX;
            
            return (double)Math.round(x * 100) / 100;
        }
        double getYFromPxPoint(int screenY)
        {
            double y = m.programHeight/2 - screenY - m.cameraYTranslation;
            y = (y)/(m.cameraZoom);
            y = y/m.pixelParAU + m.selectedCorp.posY;
            return (double)Math.round(y * 100) / 100;
        }
    }


}
