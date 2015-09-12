
package Controller;

import Model.Model;
import Viewer.Viewer;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JButton;

public class StartPagePanelListener {
    
    Model m;
    Viewer v;
    Controller c;
    
    Color overColor;
    Color bgColor;
    
    public StartPagePanelListener(Model m, Viewer v, Controller c){
        this.m = m;
        this.v = v;
        this.c = c;
        
        overColor = new Color(57,156,226);
        bgColor = new Color(0,0,0);
        
        //ADD MOUSEOVER NOTIFICATION
        v.startButtonPanel.creditButton.addMouseListener(new ButtonsMouseListener());
        v.startButtonPanel.exitButton.addMouseListener(new ButtonsMouseListener());
        v.startButtonPanel.sandBoxButton.addMouseListener(new ButtonsMouseListener());
        v.startButtonPanel.solarSystemButton.addMouseListener(new ButtonsMouseListener());
        v.title.addMouseListener(new TitleMouseListener());
        
        //ADD ACTION LISTENERS
        v.startButtonPanel.solarSystemButton.addActionListener(new SolarSystemActionListener());
        v.startButtonPanel.exitButton.addActionListener(new ExitListener());
        v.startButtonPanel.creditButton.addActionListener(new CreditListener());
        v.startButtonPanel.sandBoxButton.addActionListener(new SandboxListener());
        
        
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
            if(b.getText() == "Quit"){
                b.setBackground(Color.RED);
            }
            else{
                b.setBackground(overColor);
            } 
        } 
    }
    
    class TitleMouseListener implements MouseListener{

        @Override
        public void mouseClicked(MouseEvent e) {}
        @Override
        public void mousePressed(MouseEvent e) {}
        @Override
        public void mouseReleased(MouseEvent e) {}

        @Override
        public void mouseEntered(MouseEvent e) {
        v.title.jLabel1.setForeground(Color.YELLOW);
        v.title.jLabel2.setForeground(Color.YELLOW);
        }

        @Override
        public void mouseExited(MouseEvent e) {
        v.title.jLabel1.setForeground(Color.WHITE);
        v.title.jLabel2.setForeground(Color.WHITE);
        }
        
    }
    
    class SolarSystemActionListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            launchGame();
        }
    }
    
    class ExitListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            System.exit(0);
        } 
    }
    
    class CreditListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            
        }  
    }
    
    class SandboxListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            m.currentSolarSystem.corpList.clear();
            m.currentSolarSystem.corpListOptimized.clear();
            launchGame();
        }  
    }
    
    public void launchGame(){
        c.startGame();
        v.frame.remove(v.startPane);
        v.frame.add(v.generalPanel,BorderLayout.CENTER);
        v.designer.requestFocusInWindow();
    }
}
