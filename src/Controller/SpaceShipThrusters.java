

package Controller;

import Model.Model;
import Object.SpaceShip;
import Viewer.Viewer;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class SpaceShipThrusters implements KeyListener{
    
    Model m;
    Viewer v;
    PhysicsMachine physicsMachine;
    public SpaceShip spaceShip;
    
    public SpaceShipThrusters(Model m, Viewer v){
        this.m = m;
        this.v = v;
        
        v.designer.addKeyListener(this);
    }
    
    @Override
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();
        spaceShip = m.selectedSpaceShip;
        switch(keyCode){ 
        
        //INCREASE THRUSTERS EFFICIENCY
        case KeyEvent.VK_W:
            spaceShip.increaseThrustersEfficiency();
            break;
            
            
        //LOWER THRUSTERS EFFICIENCY
        case KeyEvent.VK_S:
            spaceShip.decreaseThrustersEfficiency();
            break;
            
            
        //ANTI_CLOCKWISE ROTATION
        case KeyEvent.VK_A:    
            spaceShip.ACWRotation();
            break;
            
            
        //CLOCKWISE ROTATION
        case KeyEvent.VK_D:    
            spaceShip.CWRotation();
            break;
            
            
        //START THRUSTERS   
        case KeyEvent.VK_SPACE:
            spaceShip.startEngines();
            v.spaceshipPanel.engineTextField.setText("ON");
            break;
            
        //COMPLETE STOP OF THRUSTERS    
        case KeyEvent.VK_X:
            spaceShip.cutEngines();
            v.spaceshipPanel.engineTextField.setText("OFF");
            break;
            
        case KeyEvent.VK_T:
            if(m.showTrajectory)
                m.showTrajectory = false;
            else{
                m.showTrajectory = true;
            }
            break;
            
        case KeyEvent.VK_M:
            if(m.showSSPanel)
                m.showSSPanel = false;
            else{
                m.showSSPanel = true;
            }
            v.spaceshipPanel.setVisible(m.showSSPanel);
            break;
            
        case KeyEvent.VK_I:
            System.out.println(spaceShip.mass);
            System.out.println(spaceShip.fuelKg);
            System.out.println(spaceShip.thrustersEfficiency);
            System.out.println(spaceShip.currentRotationAngle);
            break;
     }
    }
    
    @Override
    public void keyReleased(KeyEvent e)
    {}
    
    @Override
    public void keyTyped(KeyEvent e) {
    }
    
    //FRAME CODE
    
    //Add key stroke listener to the frame
    //SpaceShipThrusters sst = new SpaceShipThrusters(m , v);
    //addKeyListener(sst);
    
    
    //SOLARSYSTEM CODING
    
    //public void addSpaceShip(SpaceShip spaceShip){  
    //this.spaceShip = spaceShip;
    //corpList.add(spaceShip);
    //} 
    
}
