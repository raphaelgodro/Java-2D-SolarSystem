
package Controller;

import Model.*;
import Viewer.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JPanel;
import javax.swing.JTextField;

class SystemFocusListener 
{
    Model m;
    Viewer v;
    
    public SystemFocusListener(Model m,Viewer v)
    {
        this.m = m;
        this.v = v;
        //SET THE DEFAULT FOCUSED JCOMPONENT
        v.designer.requestFocusInWindow();
        v.timePanel.jTextField1.addMouseListener(new FocusSmallMenu(v.timePanel.jTextField1));
        v.zoomPanel.addMouseListener(new FocusSmallMenu(v.zoomPanel.zoomTexteField));
        v.addCorpButton.addMouseListener(new FocusSmallMenu(null));
        v.resetButton.addMouseListener(new FocusSmallMenu(null));
        
        v.corpPanel.jTextFieldMass.addMouseListener(new FocusCorpPanel());
        v.corpPanel.jTextFieldRotation.addMouseListener(new FocusCorpPanel());
        v.corpPanel.jTextFieldSpeed.addMouseListener(new FocusCorpPanel());
        v.corpPanel.jTextFieldSpeed.addMouseListener(new FocusCorpPanelSpeed());
        v.corpPanel.jTextFieldX.addMouseListener(new FocusCorpPanel());
        v.corpPanel.jTextFieldY.addMouseListener(new FocusCorpPanel());
        v.corpPanel.jButtonNext.addMouseListener(new FocusCorpPanel());
        v.corpPanel.jButtonBack.addMouseListener(new FocusCorpPanel());
    }
    class FocusSmallMenu implements MouseListener
    {
        Object o;
        
        public FocusSmallMenu(Object o)
        {
            this.o = o;
        }
        
        @Override
        public void mouseClicked(MouseEvent me){}
        @Override
        public void mousePressed(MouseEvent me) {}
        @Override
        public void mouseReleased(MouseEvent me) {}
        @Override
        public void mouseEntered(MouseEvent me) 
        {
            try
            {
                JTextField jtxtf = (JTextField) o;
                jtxtf.setEditable(true);
            }
            catch(Exception e)
            {}
        }
        @Override
        public void mouseExited(MouseEvent me) 
        {
            try
            {
                JTextField jtxtf = (JTextField) o;
                jtxtf.setEditable(false);
            }
            catch(Exception e)
            {
                
            }
            v.designer.requestFocusInWindow();
        }
    }
    class FocusCorpPanel extends MouseAdapter
    {
        @Override
        public void mouseClicked(MouseEvent me){}
        @Override
        public void mousePressed(MouseEvent me) {}
        @Override
        public void mouseReleased(MouseEvent me) {}
        @Override
        public void mouseEntered(MouseEvent me) 
        {
            v.corpPanel.mouseIntoPanel = true;
        }
        @Override
        public void mouseExited(MouseEvent me) 
        {
            v.corpPanel.mouseIntoPanel = false;
            v.designer.requestFocusInWindow();
        }
    }
    class FocusCorpPanelSpeed extends MouseAdapter
    {
        @Override
        public void mouseClicked(MouseEvent me){}
        @Override
        public void mousePressed(MouseEvent me) {}
        @Override
        public void mouseReleased(MouseEvent me) {}
        @Override
        public void mouseEntered(MouseEvent me) 
        {
            v.corpPanel.mouseIntoSpeedTextField = true;
        }
        @Override
        public void mouseExited(MouseEvent me) 
        {
            v.corpPanel.mouseIntoSpeedTextField = false;
            v.designer.requestFocusInWindow();
        }
    }
}
