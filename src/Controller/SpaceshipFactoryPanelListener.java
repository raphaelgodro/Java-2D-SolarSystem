
package Controller;

import Model.Model;
import Object.SpaceShip;
import Viewer.Viewer;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;


public class SpaceshipFactoryPanelListener {
    
    Model m;
    Viewer v;
    
   double batteryLVL; 
   double thrustpN;
   double fuelKg;
   double avSpeed;
   double oRatio;
   double mass;
   double x;
   String name;
   
   JTextField nameTextField;
   JTextField fuelTextField;
   JTextField massTextField;
   JTextField oRatioTextField;
    
    public SpaceshipFactoryPanelListener(Model m, Viewer v){
        this.m = m;
        this.v = v;
        
        this.nameTextField = v.spaceshipFactoryPanel.nameTextField;
        this.fuelTextField = v.spaceshipFactoryPanel.fuelTextField;
        this.massTextField = v.spaceshipFactoryPanel.massTextField;
        this.oRatioTextField = v.spaceshipFactoryPanel.oRatioTextField;
        
        fillVariables();
        
        v.spaceshipFactoryPanel.bcSlider.addChangeListener(new bcSliderListener());
        v.spaceshipFactoryPanel.tpnSlider.addChangeListener(new tnpSliderListener());
        v.spaceshipFactoryPanel.aveSpeedSlider.addChangeListener(new avSpeedSliderListener());
        v.spaceshipFactoryPanel.intiPosSlider.addChangeListener(new initPosSliderListener());
        
        v.spaceshipFactoryPanel.cancelButton.addActionListener(new cancelButtonListener());
        v.spaceshipFactoryPanel.okButton.addActionListener(new okButtonListener());
        
        v.spaceshipFactoryPanel.nameTextField.getDocument().addDocumentListener(new spaceshipNameListener());
        v.spaceshipFactoryPanel.oRatioTextField.getDocument().addDocumentListener(new oRatioTextFieldListener());
        v.spaceshipFactoryPanel.fuelTextField.getDocument().addDocumentListener(new fuelTextFieldListener());
    }
    
    public void fillVariables(){
        batteryLVL = 0; 
        thrustpN = 0;
        fuelKg = 0;
        avSpeed = 0;
        oRatio = 1;
        mass = 0;
        x = 0;
        name = "";
    }
    
    public void closeFactoryPanel(){
        v.spaceshipFactoryPanel.setVisible(false);
        v.spaceshipFactoryPanel.resetValues();
    }
    
   
    class bcSliderListener implements ChangeListener{

        @Override
        public void stateChanged(ChangeEvent e) {
            JSlider source = (JSlider)e.getSource();
            if (source.getValueIsAdjusting()) {
                batteryLVL = source.getValue();
                v.designer.requestFocus();
            }
        }
    }
    
    
    class tnpSliderListener implements ChangeListener{
        
        @Override
        public void stateChanged(ChangeEvent e) {
            JSlider source = (JSlider)e.getSource();
            if (source.getValueIsAdjusting()) {
                thrustpN = source.getValue();
                v.designer.requestFocus();
            }
        }
    }
    
    
    class avSpeedSliderListener implements ChangeListener{
        
        @Override
        public void stateChanged(ChangeEvent e) {
            JSlider source = (JSlider)e.getSource();
            if (source.getValueIsAdjusting()) {
                avSpeed = source.getValue();
                v.designer.requestFocus();
            }
        }
        
    }
    
    
    class initPosSliderListener implements ChangeListener{
        
       @Override
        public void stateChanged(ChangeEvent e) {
            JSlider source = (JSlider)e.getSource();
            if (source.getValueIsAdjusting()) {
                x = source.getValue();
                v.designer.requestFocus();
            }
        }
    }

    
    class cancelButtonListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            batteryLVL = 0; 
            thrustpN = 0;
            avSpeed = 0;
            x = 0;
            
            v.spaceshipFactoryPanel.setVisible(false);
            closeFactoryPanel();
            v.designer.requestFocus();
        }
        
    }
   
    
    class okButtonListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            try{
                mass = Double.parseDouble(massTextField.getText());
                //SpaceShip(String name,Color c,double radius,double mass,double radiusDisplay,double averageSpeed,double fuelKg,double oRatio,double tpn, double bc){
                SpaceShip s = new SpaceShip(name, Color.RED, x,mass,5,avSpeed,fuelKg,oRatio,thrustpN,batteryLVL,0);
                m.currentSolarSystem.addSpaceShip(s);
                m.ourSolarSystem.addSpaceShip(s);
                closeFactoryPanel();
                v.spaceshipFactoryPanel.setVisible(false);
                v.designer.requestFocus();
            }
            catch(Exception ex){}

        }
    }
   
    
    class lButtonListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {}
        
    }
    
    
    class rButtonListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {}
        
    }
    
    
    class fuelTextFieldListener implements DocumentListener{

        @Override
        public void insertUpdate(DocumentEvent de) {
            try{
                fuelKg = Double.parseDouble(fuelTextField.getText());
                //if(fuelKg > m.maxFuelKg)
                   //fuelKg = m.maxFuelKg;
            }
            catch(Exception e){}
        }
       
        @Override
        public void removeUpdate(DocumentEvent e) {}

        @Override
        public void changedUpdate(DocumentEvent e) {}
        
    }
    
    
    class spaceshipNameListener implements DocumentListener{

        @Override
        public void insertUpdate(DocumentEvent de) {
            try{
                name = nameTextField.getText();
            }
            catch(Exception e){}
        }

        @Override
        public void removeUpdate(DocumentEvent e) {}

        @Override
        public void changedUpdate(DocumentEvent e) {}
        
    }
    
    
    class oRatioTextFieldListener implements DocumentListener{

        @Override
        public void insertUpdate(DocumentEvent de) {
            try{
                oRatio = Double.parseDouble(oRatioTextField.getText());
            }
            catch(Exception e){}
        }

        @Override
        public void removeUpdate(DocumentEvent e) {}

        @Override
        public void changedUpdate(DocumentEvent e) {}
        
    }
}
