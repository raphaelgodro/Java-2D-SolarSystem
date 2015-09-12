
package Controller;

import Model.*;
import Object.*;
import Viewer.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Point2D;

public class CorpFocus 
{
    Model m;
    Viewer v;
    ClickAction cl = new ClickAction();
    
    public CorpFocus(Model m,Viewer v)
    {
        this.m = m;
        this.v = v;
        v.frame.addMouseListener(cl);
    } 
    class ClickAction implements MouseListener
    {
        public void mouseClicked(MouseEvent e) 
        {
            int clicX = e.getX();
            int clicY = e.getY();
            int[][] pixel = new int[m.programWidth][m.programHeight];
            //PUT -1 FOR EVERY PIXEL IN THE SCREEN (-1 = EMPTY)
            for(int i = 0;i<pixel.length;i++)
            {
                for(int j = 0;j<pixel[i].length;j++)
                {
                    pixel[i][j] = -1;
                }
            }
            int i = 0;
            for(Corp c : m.currentSolarSystem.corpList)
            {
                double adjX = 0;
                double adjY = 0;
                double adjXselected = 0;
                double adjYselected = 0;
                if(c.type == 4)
                {
                    Point2D.Double satelliteAdj = v.designer.getSatelliteAdjustement(c);
                    adjX = satelliteAdj.x;
                    adjY = satelliteAdj.y;
                }
                double posXRel = v.designer.getPosXRelative(c, adjX, adjXselected);
                double posYRel = v.designer.getPosYRelative(c, adjY, adjYselected);
                int posXscreenValue = (int)(m.programWidth/2 + posXRel);
                int posYscreenValue = (int)(m.programHeight/2 - posYRel);
                if((posXscreenValue <= m.programWidth)&&(posYscreenValue <= m.programHeight)&&(posXscreenValue >= 0)&&(posYscreenValue >= 0))
                {
                    try
                    {
                        double tempZoom = m.cameraZoom;
                        if(m.cameraZoom < 2)
                        {
                            tempZoom = 2;
                        }
                        for(int radX = (int) (-c.currentRadiusDisplay * tempZoom * 2);radX < (int)(c.currentRadiusDisplay * tempZoom * 2);radX++)
                        {
                            for(int radY = (int) (-c.currentRadiusDisplay * tempZoom * 2);radY<(int)(c.currentRadiusDisplay * tempZoom * 2);radY++)
                            {
                                pixel[posXscreenValue + radX][posYscreenValue + radY] = i;
                            }
                        }
                    }
                    catch(Exception ex){}
                }
                i++;
            }
            if(pixel[clicX][clicY] != -1)
            {
               
                m.selectedCorp = m.currentSolarSystem.corpList.get(pixel[clicX][clicY]);
                m.cameraXTranslation = 0;
                m.cameraYTranslation = 0;
            }
        }
        public void mousePressed(MouseEvent e) 
        {}
        public void mouseReleased(MouseEvent e) 
        {}
        public void mouseEntered(MouseEvent e) 
        {}
        public void mouseExited(MouseEvent e) 
        {}
        
    }
}
