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

public class TimePanelListener {

    Model m;
    Viewer v;

    double x;
    double fraction;
    
    boolean handUpdated;
    
    JTextField timeTextField;

    public TimePanelListener(Model m, Viewer v) {
        this.m = m;
        this.v = v;
        timeTextField = v.timePanel.jTextField1;
        timeTextField.getDocument().addDocumentListener(new TimeMenuTextFieldListener());
        timeTextField.addMouseListener(new TimePanelMouseListener());
        v.timePanel.jSlider1.addChangeListener(new timeChangeListener());
    }
    
    class TimePanelMouseListener implements MouseListener{

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

    class TimeMenuTextFieldListener implements DocumentListener {

        @Override
        public void insertUpdate(DocumentEvent de) {
            try {
                double newTimeValue = Double.parseDouble(timeTextField.getText());
                m.deltaT = (int) (newTimeValue * 3600 * 24) / m.pps;
                
                if(handUpdated){
                    double z = 10*Math.sqrt((newTimeValue/fraction));
                    v.timePanel.jSlider1.setValue((int)z);
                } 
                
            } catch (Exception e) {
                DialogBox error = new DialogBox(v.frame, m.errorMessage.get(0));
            }
        }

        @Override
        public void removeUpdate(DocumentEvent de) {}

        @Override
        public void changedUpdate(DocumentEvent de) {}
        
    }

    class timeChangeListener implements ChangeListener {

        @Override
        public void stateChanged(ChangeEvent ce) {
            JSlider source = (JSlider) ce.getSource();
            if(source.getValueIsAdjusting()){
                handUpdated = false;
                if(m.selectedCorp.type != 3){
                    fraction = 0.25;
                }else{
                    fraction = 0.125;
                }
                x = ((double)source.getValue())/10;
                
                double t = fraction*((double)Math.pow(x, 2));
                m.deltaT = (int)((t*3600*24)/m.pps);
                
                if(!handUpdated){
                    v.timePanel.jTextField1.setText(String.valueOf((float)(t)));
                }
                v.designer.requestFocus();
            }
        }

    }
}
