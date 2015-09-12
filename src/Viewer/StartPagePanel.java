
package Viewer;

import Model.Model;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;


public class StartPagePanel extends Template{
    
    Model m;
    BufferedImage bgImage;
    BufferedImage resizedImage;
    
    public StartPagePanel(Model m){
        super(m);
        this.setVisible(true);
        
        try{
            bgImage  = ImageIO.read(new File("images/reman.jpg"));
            resizedImage = imageResize(bgImage,m.programWidth+350, m.programHeight);
        }
        catch(Exception ex){
            this.setBackground(Color.BLUE);
        }
        
    }
    
    public void paintComponent(Graphics g){
        
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        
        try{
            g2.drawImage(resizedImage,0,0,null);
        }
        catch(Exception ex){}
  
    }
    
    public BufferedImage imageResize(BufferedImage bi,int width,int height) 
    {
        BufferedImage biNew;
        try
        {
            biNew = new BufferedImage( (int) width, height, bi.getType());
            Graphics2D graphics = biNew.createGraphics();
            graphics.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
            graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_OFF);
            graphics.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_NEAREST_NEIGHBOR);
            graphics.drawImage(bi, 0, 0, width, height, null);
            graphics.dispose();
        }
        catch(java.lang.OutOfMemoryError e)
        {
            biNew = bi;
        }
        return biNew;
    }
}
