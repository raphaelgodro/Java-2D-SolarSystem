
package Controller;

import Model.*;
import Viewer.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class ZoomMenuListener 
{
    Model m;
    Viewer v;
    
    boolean handUpdated = true;
    double f = 0.762;
    
    JTextField zoomTextField;
    
    public ZoomMenuListener(Model m, Viewer v)
    {
        this.m = m;
        this.v = v;
        zoomTextField = v.zoomPanel.zoomTexteField;
        zoomTextField.getDocument().addDocumentListener(new ZoomTextFieldListener());
        zoomTextField.addMouseListener(new ZoomTextFieldMouseListener());
        v.zoomPanel.zoomSlider.addChangeListener(new ZoomSliderListener());
    }
    
    class ZoomTextFieldMouseListener implements MouseListener{

        @Override
        public void mouseClicked(MouseEvent e) {
        handUpdated = true;
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
    
    class ZoomTextFieldListener implements DocumentListener
    {
        double newZoomValue;
        
        @Override
        public void insertUpdate(DocumentEvent de) 
        {
            try
            {
                newZoomValue = Double.parseDouble(zoomTextField.getText());
                if((newZoomValue/100 < m.maxZoomValue)&&(newZoomValue/100 > m.minZoomValue))
                {
                    m.cameraZoom = newZoomValue/100;
                }
                else
                {
                    if(newZoomValue/100 > m.maxZoomValue){
                        m.cameraZoom = m.maxZoomValue;
                        newZoomValue = m.maxZoomValue*100;
                    }
                    else{
                        m.cameraZoom = m.minZoomValue;
                        newZoomValue = m.minZoomValue*100;
                    }
                }
                double x = 10*((1/f)*Math.log((1/f)*newZoomValue));
                if(handUpdated)
                v.zoomPanel.zoomSlider.setValue((int)x);
                
            }
            catch(Exception e)
            {
                DialogBox error = new DialogBox(v.frame,m.errorMessage.get(0));
            }
        }
        @Override
        public void removeUpdate(DocumentEvent de) 
        {}
        @Override
        public void changedUpdate(DocumentEvent de) 
        {}
    }
    
    class ZoomSliderListener implements ChangeListener{

        
        @Override
        public void stateChanged(ChangeEvent e) {
            
            JSlider source = (JSlider) e.getSource();
            
            if(source.getValueIsAdjusting()){   
                
                double z = (((double)source.getValue())/10);
                double newZoomValue = f*Math.pow(Math.E, (f*z));

                if((newZoomValue/100 < m.maxZoomValue)&&(newZoomValue > m.minZoomValue/100))
                {
                    m.cameraZoom = newZoomValue/100;
                }
                else
                {
                    if(newZoomValue > m.maxZoomValue)
                        m.cameraZoom = m.maxZoomValue;
                    else
                        m.cameraZoom = m.minZoomValue;
                }
                handUpdated = false;
                if(!handUpdated)
                v.zoomPanel.zoomTexteField.setText(String.valueOf((float)(newZoomValue)));
            }
            
            v.designer.requestFocus();
        }
        
    } 
}
