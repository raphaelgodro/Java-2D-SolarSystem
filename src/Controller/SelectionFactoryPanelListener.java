
package Controller;

import Model.Model;
import Viewer.Viewer;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JButton;


public class SelectionFactoryPanelListener {
    
    Model m;
    Viewer v;
    
    int type;
    
    Color overColor;
    Color bgColor;
    Color cancelColor;
    
    public SelectionFactoryPanelListener(Model m, Viewer v){
        this.m = m;
        this.v = v;
        
        overColor = new Color(57,156,226);
        bgColor = new Color(0,0,0);
        cancelColor = Color.RED;
        
        //ADD MOUSE LISTENERS   
        v.selecPanel.addStarButton.addMouseListener(new ButtonsMouseListener());
        v.selecPanel.addPlanetButton.addMouseListener(new ButtonsMouseListener());
        v.selecPanel.addSatelliteButton.addMouseListener(new ButtonsMouseListener());
        v.selecPanel.addAsteroidButton.addMouseListener(new ButtonsMouseListener());
        v.selecPanel.addSpaceShipButton.addMouseListener(new ButtonsMouseListener());
        v.selecPanel.cancelButton.addMouseListener(new CancelButtonMouseListener());
        
        //ADD BUTTON ACTION LISTENERS
        v.selecPanel.addStarButton.addActionListener(new StarBActionListener());
        v.selecPanel.addPlanetButton.addActionListener(new PlanetBActionListener());
        v.selecPanel.addSatelliteButton.addActionListener(new SatelliteBActionListener());
        v.selecPanel.addAsteroidButton.addActionListener(new AsteroidBActionListener());
        v.selecPanel.addSpaceShipButton.addActionListener(new SpaceshipBActionListener());
        v.selecPanel.cancelButton.addActionListener(new CancelBActionListener());
    }
    
    public void closeSelectFactoryPanel(){
        v.selecPanel.setVisible(false);
        v.designer.requestFocus();
    }
    
    public int getType(){
        return type;
    }
    
    class StarBActionListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            type = 0;
            closeSelectFactoryPanel();
        }
        
    }
    
    class ButtonsMouseListener implements MouseListener{
        @Override
        public void mouseClicked(MouseEvent e) {}
        @Override
        public void mousePressed(MouseEvent e) {}
        @Override
        public void mouseReleased(MouseEvent e) {} 
        @Override
        public void mouseExited(MouseEvent e) {
            JButton b = (JButton) e.getSource();
            b.setBackground(bgColor);
        }
        
        @Override
        public void mouseEntered(MouseEvent e) {
            JButton b = (JButton) e.getSource();
            b.setBackground(overColor);
        } 
    }
    
    class CancelButtonMouseListener implements MouseListener{
        @Override
        public void mouseClicked(MouseEvent e) {}
        @Override
        public void mousePressed(MouseEvent e) {}
        @Override
        public void mouseReleased(MouseEvent e) {} 
        @Override
        public void mouseExited(MouseEvent e) {
            JButton b = (JButton) e.getSource();
            b.setBackground(bgColor);
        }
        
        @Override
        public void mouseEntered(MouseEvent e) {
            JButton b = (JButton) e.getSource();
            b.setBackground(cancelColor);
        } 
    }
    
    class PlanetBActionListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            type = 1;
            closeSelectFactoryPanel();
        }
        
    }
    
    class SatelliteBActionListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            type = 4;
            //v.spaceshiFactoryPanel
            closeSelectFactoryPanel();
        }
        
    }
    
    class AsteroidBActionListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            type = 2;
            closeSelectFactoryPanel();
        }
        
    }
    
    class SpaceshipBActionListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            type = 3;
            v.spaceshipFactoryPanel.setVisible(true);
            closeSelectFactoryPanel();
        }
        
    }
    
    class CancelBActionListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            closeSelectFactoryPanel();
        }
        
    }
}
