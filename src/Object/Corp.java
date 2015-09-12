 
package Object;

import Model.CorpFolderLoading;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.Transparency;
import java.awt.geom.Path2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

public class Corp 
{
    public int type;
    public String name;
    
    public double posX;
    public double posY;
    
    public double speedX;
    public double speedY;
    
    public double direction;
    
    public double mass;
    public double angle;
    public double massPerInitialPixelCube;
    
    public double initialRadiusDisplay;
    public double currentRadiusDisplay;
    
    public double rotationPeriodHour = 0;
    public double currentRotationAngle = 0;
    
    public double widthToHeightProportion = 1;
    
    public String description = "";
    
    public Color color;
    
    public Path2D path;
    
    //ORIGINAL IMAGE (SENT BY THE MODEL)(FROM THE TOP) I
    public BufferedImage originalImage;
    //IMAGE RESIZED BY THE DESIGNER IN THE DISPLAY
    public BufferedImage bgImage;
    //IMAGE ON THE SOLARSYSTEM MENU MEMORIZED
    public BufferedImage infoImage = null;
    //PROFILE IMAGE SENT BY THE MODEL
    public BufferedImage profileImage = null;
    //ALL THE IMAGES IN THE FOLDER
    public ArrayList<BufferedImage> diaporamaImage = new ArrayList<BufferedImage>();
    
    public String fileImageString;
    
    public Corp(String name,Color c,double posX,double posY,double mass,
                double radiusDisplay,double speedX,double speedY,double rotation)
    {
        this.name = name;
        this.posX = posX;
        this.posY = posY;
        this.mass = mass;
        this.initialRadiusDisplay = radiusDisplay;
        this.currentRadiusDisplay = initialRadiusDisplay;
        this.speedX = speedX;
        this.speedY = speedY;
        this.color = c;
        this.rotationPeriodHour = rotation;
        this.massPerInitialPixelCube = mass/((4/3)*Math.PI*Math.pow(radiusDisplay,3));
        
        path = new Path2D.Double();
        path.moveTo(posX, -posY);
        
        CorpFolderLoading cil = new CorpFolderLoading(name);
        if(!cil.bgImage.equals(""))
            this.setBackgroundImage(cil.bgImage);
        if(!cil.profileImage.equals(""))
            this.setProfileImage(cil.profileImage);
        this.description = cil.description;
        diaporamaImage = cil.img;
    }
    
    public Corp(String name,Color c,double radius,double mass,double radiusDisplay,double averageSpeed,double rotation)
    {
        this.name = name;
        this.posX = radius * Math.sin(Math.toRadians(45)) * -1;
        this.posY = posX;
        this.mass = mass;
        this.initialRadiusDisplay = radiusDisplay;
        this.currentRadiusDisplay = initialRadiusDisplay;
        this.speedX = averageSpeed * Math.sin(Math.toRadians(45));
        this.speedY = speedX * -1;
        this.color = c;
        this.rotationPeriodHour = rotation;
        this.massPerInitialPixelCube = mass/((4/3)*Math.PI*Math.pow(radiusDisplay,3));
        
        path = new Path2D.Double();
        path.moveTo(posX, -posY);
        
        CorpFolderLoading cil = new CorpFolderLoading(name);
        if(!cil.bgImage.equals(""))
            this.setBackgroundImage(cil.bgImage);
        if(!cil.profileImage.equals(""))
            this.setProfileImage(cil.profileImage);
        this.description = cil.description;
        diaporamaImage = cil.img;
    }
    public Double getSpeed() 
    {
        return Math.sqrt(Math.pow(this.speedX,2) + Math.pow(this.speedY,2));
    }
    public void setSpeed(double newSpeed) 
    {
        this.speedX = newSpeed * Math.sin(angle) * -1;
        this.speedY = newSpeed * Math.cos(angle);
    }
    public void setMass(Double valueD,double currentZoom)
    {
        try
        {
            //SET THE MASS OF THE CORP WITH AN UPDATE OF THE SIZE DEPENDING ON THE INITIAL VOLUMIC MASS VALUE
            this.mass = valueD;
            this.initialRadiusDisplay = Math.cbrt((3 * mass)/(4* Math.PI * massPerInitialPixelCube));
            refreshImage((int)(initialRadiusDisplay*currentZoom));
        }
        catch(Exception e){}
    }
    public void setBackgroundImage(String s)
    {
        fileImageString = s;
        try 
        {
            bgImage = ImageIO.read(new File(s));
            originalImage = bgImage;
            bgImage = imageResize(bgImage,(int) (initialRadiusDisplay*2),(int) (initialRadiusDisplay*2));
            
            this.widthToHeightProportion = (double) originalImage.getWidth()/originalImage.getHeight();
        } 
        catch (IOException ex) 
        {}
    }
    public void setProfileImage(String s)
    {
        fileImageString = s;
        try 
        {
            profileImage = ImageIO.read(new File(s));
        } 
        catch (IOException ex) 
        {
            Logger.getLogger(Corp.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void refreshImage(int newRadius)
    {
        currentRadiusDisplay = newRadius;
        bgImage = imageResize(originalImage,(int) (currentRadiusDisplay*2 * widthToHeightProportion),(int) currentRadiusDisplay*2);
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
    public double getDirection(){
        if((speedX > 0)&&(speedY > 0))
        {
            //FRAMING 1 X:+Y:+
            direction = Math.atan(Math.abs(speedY/speedX));
        }
        else if((speedX < 0)&&(speedY > 0))
        {
            //FRAMING 2 X:-Y:+
            direction = Math.PI/2 + Math.atan(Math.abs(speedX/speedY));
        }
        else if((speedX < 0)&&(speedY < 0))
        {
            //FRAMING 3 X:-Y:-
            direction = Math.PI + Math.atan(Math.abs(speedY/speedX));
        }
        else if((speedX > 0)&&(speedY < 0))
        {
            //FRAMING 4 X:+Y:-
            direction = (3 * Math.PI/ 2) + Math.atan(Math.abs(speedX/speedY));
        }
        
        return direction;
    }
    
    public void setSpeed(double s, double a){
        setSpeedX(s,a);
        setSpeedY(s,a);
    }
    
    public void setSpeedX(double speed, double angle){
        speedX = speed*Math.cos(angle);
    }
    
    public void setSpeedY(double speed, double angle){
        speedY = speed*Math.sin(angle);
    }
}
