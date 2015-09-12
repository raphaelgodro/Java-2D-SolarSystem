package Viewer;


import Model.*;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

class Template extends JPanel
{
    Model m;
    public int backgroundImgTranslationX = 0;
    public int backgroundImgTranslationY = 0;
    public double coordX = 0;
    public double coordY = 0;
    
    BufferedImage imageIni;
    
    public Template(Model m)
    {
        this.m = m;
        this.setPreferredSize(new Dimension(m.programWidth,m.programHeight));
        try 
        {
            imageIni = ImageIO.read(new File(m.BACKGROUND_ROOT));
        }
        catch (IOException ex)
        {
            Logger.getLogger(Template.class.getName()).log(Level.SEVERE, null, ex);
        }
        //CURSOR
        setCursor (Cursor.getPredefinedCursor(Cursor.MOVE_CURSOR));
    }
    public void paintComponent(Graphics g) 
    {
        setBackground((Graphics2D) g);
        drawCoordonateString(g);
    }
    public void drawCoordonateString(Graphics g)
    {
        g.setColor(Color.green);
        g.setFont(new Font("Arial", Font.PLAIN,20));
        g.drawString("(" + coordX + "," + coordY + ") AU" , 10, m.programHeight - 10);
    }
    public void setBackground(Graphics2D g2d) 
    {
        int widthImg = imageIni.getWidth(null);
        int heightImg = imageIni.getHeight(null);
        while((backgroundImgTranslationX > 0)||(backgroundImgTranslationY > 0))
        {
            if(backgroundImgTranslationX > 0)
                backgroundImgTranslationX = backgroundImgTranslationX - widthImg;
            if(backgroundImgTranslationY > 0)
                backgroundImgTranslationY = backgroundImgTranslationY - heightImg;
        }
        try
        {
            if(imageIni != null)
            {
                for(int i = backgroundImgTranslationX;i<this.getWidth();i+= widthImg)
                {
                    for(int j = backgroundImgTranslationY;j<this.getHeight();j+= heightImg)
                    {
                        g2d.drawImage(imageIni,i, j, this);
                    }
                }
            }   
        }
        catch(Exception e)
        {}
    }
    public BufferedImage imageResize(BufferedImage bi,int width,int height) 
    {
        BufferedImage biNew = new BufferedImage( (int) width, height, bi.getType());
        Graphics2D graphics = biNew.createGraphics();
        graphics.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_OFF);
        graphics.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_NEAREST_NEIGHBOR);
        graphics.drawImage(bi, 0, 0, width, height, null);
        graphics.dispose();
        return biNew;
    }
}