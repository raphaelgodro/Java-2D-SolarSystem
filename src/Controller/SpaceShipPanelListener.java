
package Controller;

import Model.Model;
import Viewer.Viewer;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JSlider;


public class SpaceShipPanelListener{
    
    Model m;
    Viewer v;
    Point point;
    
    public SpaceShipPanelListener(Model m, Viewer v){
        
        this.m = m;
        this.v = v;
        
        point = new Point();
        
        v.spaceshipPanel.xButton.addActionListener(new XButtonListener());
        v.spaceshipPanel.upButton.addActionListener(new UpListener());
        v.spaceshipPanel.downButton.addActionListener(new DownListener());
        v.spaceshipPanel.leftButton.addActionListener(new LeftListener());
        v.spaceshipPanel.spaceButton.addActionListener(new SpaceBarListener());
        v.spaceshipPanel.rightButton.addActionListener(new RightListener());
        v.spaceshipPanel.thrustSlider.addMouseListener(new ThrustListener());
    }
    
    
        class SpaceBarListener  implements ActionListener{

            @Override
            public void actionPerformed(ActionEvent e) {
                m.selectedSpaceShip.startEngines();
                v.designer.requestFocus();
            }   
        }


        class XButtonListener implements ActionListener{

            @Override
             public void actionPerformed(ActionEvent e) {
                m.selectedSpaceShip.cutEngines();
                v.designer.requestFocus();
            }
        }


        class UpListener implements ActionListener{

            @Override
            public void actionPerformed(ActionEvent e) {
                m.selectedSpaceShip.increaseThrustersEfficiency();
                v.designer.requestFocus();
            }
        }


        class DownListener implements ActionListener{

            @Override
            public void actionPerformed(ActionEvent e) {
                m.selectedSpaceShip.decreaseThrustersEfficiency();
                v.designer.requestFocus();
            }
        }


        class RightListener implements ActionListener{

            @Override
            public void actionPerformed(ActionEvent e){
                m.selectedSpaceShip.CWRotation();
                v.designer.requestFocus();
            }
        }


        class LeftListener implements ActionListener{

            @Override
            public void actionPerformed(ActionEvent e){
                m.selectedSpaceShip.ACWRotation();
                v.designer.requestFocus();
            }
        }


        class ThrustListener implements MouseListener{

            @Override
            public void mouseClicked(MouseEvent click){
                JSlider source = (JSlider) click.getSource();
                int thrust = (int)(source.getHeight()-click.getY())*100/source.getHeight();
                if(thrust < 0)
                    m.selectedSpaceShip.thrustersEfficiency = 0;
                else if(thrust > 100)
                    m.selectedSpaceShip.thrustersEfficiency = 100; 
                else{   
                    m.selectedSpaceShip.thrustersEfficiency = thrust;
                }
                v.designer.requestFocus();
            }
            @Override
            public void mouseExited(MouseEvent arg0){}
            @Override
            public void mouseEntered(MouseEvent arg0){}
            
            @Override
            public void mousePressed(MouseEvent press){
                point.y = press.getY();
                v.designer.requestFocus();
            }

            @Override
            public void mouseReleased(MouseEvent release){
                
                JSlider source = (JSlider) release.getSource();
                int dragVariation = point.y - release.getY();
                int value = (dragVariation*100)/(source.getHeight());
                
                int eff = (int) m.selectedSpaceShip.thrustersEfficiency;
                int thrust = eff + value;
                
                if(thrust < 0)
                    m.selectedSpaceShip.thrustersEfficiency = 0;
                else if(thrust > 100)
                    m.selectedSpaceShip.thrustersEfficiency = 100; 
                else{   
                    m.selectedSpaceShip.thrustersEfficiency = thrust;
                }  
                v.designer.requestFocus();
            }
        }
        
}
