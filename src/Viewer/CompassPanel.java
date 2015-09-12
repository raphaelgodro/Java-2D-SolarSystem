
package Viewer;

import Model.Model;
import Object.Corp;
import Object.SpaceShip;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import javax.swing.JPanel;

public class CompassPanel extends JPanel {
    
    AffineTransform at;
    BufferedImage img;
    Model m;
    Corp c;
    
    int RESIZE_X;
    int RESIZE_Y;
    
    public CompassPanel(Model m){
        this.m = m;
    }
    
    public void paintComponent(Graphics g){        
        c = m.selectedSpaceShip;
        try{
            img = c.originalImage;
            img = c.imageResize(img, 50, 50);
        }catch(Exception e){}
        
        
        Graphics2D g2 = (Graphics2D) g;
        
       
        SpaceShip ss = (SpaceShip) c;
        double viewAngle = Math.toRadians(ss.currentRotationAngle);
        
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(Color.GRAY);
        
        g2.setColor(new Color(57, 156, 226));
        g2.drawOval(0,0,(int)(this.getWidth()-1),(int)(this.getHeight()-1));
        g2.drawLine((int)(this.getWidth()/2),0, (int)(this.getWidth()/2), (int)(this.getHeight()));
        g2.drawLine(0, (int)(this.getHeight()/2),(int)(this.getWidth()), (int)(this.getHeight()/2));
        
        g2.translate((int) 107/2,(int) 107/2);
        g2.rotate(-viewAngle);
        try{
            g2.translate(-img.getWidth(null) / 2, -img.getHeight(null) / 2);
            g2.drawImage(img,0,0, null);
        } catch(Exception e){}
    }
}
