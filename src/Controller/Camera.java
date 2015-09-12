package Controller;

import Model.Model;
import Object.*; 
import Viewer.Viewer;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.SwingUtilities;

public class Camera
{
    Model m;
    Viewer v;    
    
    public MouseMotionListener mouseMotionListener = new MotionAction();
    public MouseListener mouseListener = new ClickAction();
    public MouseWheelListener mouseWheelListener = new WheelAction();
    public TranslationListener translationListener = new TranslationListener();
    
    public Camera(Model m,Viewer v)
    {
        this.m = m;
        this.v = v;
        
        v.designer.addMouseMotionListener(this.mouseMotionListener);
        v.designer.addMouseListener(this.mouseListener);
        v.designer.addMouseWheelListener(this.mouseWheelListener);
        v.designer.addKeyListener(this.translationListener);
        
        
    }
    
    class MotionAction implements MouseMotionListener
    {
        int deltaX = 0;
        int deltaY = 0;
        int xIni = 0;
        int yIni = 0;
    
        public void mouseDragged(MouseEvent e)
        { 
            if(SwingUtilities.isRightMouseButton(e))
            {
                if(m.cameraTranslationTurn > 2)
                {
                    deltaX = e.getX() - this.xIni;
                    deltaY = e.getY() - this.yIni;
                }
                else
                {
                    deltaX = 0;
                    deltaY = 0;
                }
                m.cameraXTranslation += deltaX;
                m.cameraYTranslation -= deltaY;
                this.xIni = e.getX();
                this.yIni = e.getY();
                m.cameraTranslationTurn++;
                v.designer.updateZoomOnCorpImg();
            }
        }
        public void mouseMoved(MouseEvent e) 
        {} 
    }
    class TranslationListener implements KeyListener
    {
        private final Set<Integer> pressed = new HashSet<Integer>();
        int pxMovingConstant = 10;
        
        @Override
        public synchronized void keyPressed(KeyEvent e) 
        {
            //TRANSLATION
            pressed.add(e.getKeyCode());
            int sumTransX = 0;
            int sumTransY = 0;
            for(Integer c : pressed)
            {
                //TRANSLATION
                if(c == 39)
                    sumTransX -= pxMovingConstant;
                if(c == 37)
                    sumTransX += pxMovingConstant;
                if(c == 40)
                    sumTransY += pxMovingConstant;
                if(c == 38)
                    sumTransY -= pxMovingConstant;
                //ZOOM
                if((c == m.KEY_ZOOM_OUT_ID1 )||( c == m.KEY_ZOOM_OUT_ID2))
                {
                    unzoom();
                }
                else if((c == m.KEY_ZOOM_IN_ID1 )||( c == m.KEY_ZOOM_IN_ID2))
                {
                    zoom();
                } 
            }
            m.cameraXTranslation += sumTransX;
            m.cameraYTranslation += sumTransY;
            v.designer.updateZoomOnCorpImg();
        }

        @Override
        public synchronized void keyReleased(KeyEvent e) 
        {
            int c = e.getKeyCode();
            pressed.remove(c);
        }

        @Override
        public void keyTyped(KeyEvent e) 
        {}
    }
    class ClickAction implements MouseListener
    {   
        public void mouseClicked(MouseEvent e) 
        {}
        public void mousePressed(MouseEvent e) 
        {}
        public void mouseReleased(MouseEvent e) 
        {
            m.cameraTranslationTurn = 0;
        }
        public void mouseEntered(MouseEvent e) 
        {}
        public void mouseExited(MouseEvent e) 
        {}
    }
    class WheelAction implements MouseWheelListener
    {
        public void mouseWheelMoved(MouseWheelEvent e) 
        {
            if(e.getWheelRotation()< 0)
            {
                unzoom();
                v.designer.updateZoomOnCorpImg();
            }
            else
            {
                zoom();
                v.designer.updateZoomOnCorpImg();
            }
        }  
    }
    void zoom()
    {
        if(m.cameraZoom < m.maxZoomValue)
        {
            //INZOOM
            m.cameraZoom += m.cameraZoomConstantPerKey * m.cameraZoom;
            v.zoomPanel.setZoomValue();
            v.designer.revalidate();
            v.generalPanel.revalidate();
        }
    }
    void unzoom()
    {
        if(m.cameraZoom > m.minZoomValue)
        {
            double oldCameraZoom = m.cameraZoom;
            //OUTZOOM
            m.cameraZoom -= m.cameraZoomConstantPerKey * m.cameraZoom;
            v.zoomPanel.setZoomValue();
            if(m.cameraZoom < 0)
                m.cameraZoom = oldCameraZoom;
            v.designer.revalidate();
            v.generalPanel.revalidate();
        }
    }
}
