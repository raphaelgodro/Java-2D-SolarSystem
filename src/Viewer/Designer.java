 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Viewer;

import Model.Model;
import Object.*;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.Toolkit;
import java.awt.geom.AffineTransform;
import java.awt.geom.Ellipse2D;
import java.awt.geom.GeneralPath;
import java.awt.geom.Path2D;
import java.awt.geom.PathIterator;
import java.awt.geom.Point2D;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.File;
import java.nio.file.Path;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class Designer extends Template
{
    AffineTransform transformer;
    public Designer(Model m)
    {
        super(m);
    }

    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        transformer = g2.getTransform();
        transformer.translate(m.programWidth/2, m.programHeight/2);
        g2.setTransform(transformer);
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        //FOR EACH CORP DECLARED INTO THE SOLAR SYSTEM
        for(Corp c : m.currentSolarSystem.corpList)
        {
            //CHECK IF THE DRAWLINE OF THE ORBIT IS AUTHORIZED FOR THIS TYPE OF CORP INTO THE MODEL
            boolean drawOrbitLineAuthorizedByID = false;
            for(int i : m.authorizedOrbitLineCorpID)
            {
                if(i == c.type)
                    drawOrbitLineAuthorizedByID = true;
            }
    
            //ADJUST THE DISTANCE FOR THE SATELLITE (THEY DON'T RESPECT THE SCALE OF THE UNIVERSE BECAUSE THE PLANETS ARE BIGGER IN THE SIMULATOR...)
            double adjX = 0;
            double adjY = 0;
            double adjXselected = 0;
            double adjYselected = 0;
            //IF THE TYPE IS A SATELLITE
            if(c.type == 4)
            {
                Point2D.Double satelliteAdj = getSatelliteAdjustement(c);
                adjX = satelliteAdj.x;
                adjY = satelliteAdj.y;
            }
            //IF A SATELLITE IS DETECTED
            if((m.selectedCorp != null)&&(m.selectedCorp.type == 4))
            {
                Point2D.Double satelliteAdj = getSatelliteAdjustement(m.selectedCorp);
                adjXselected = satelliteAdj.x;
                adjYselected = satelliteAdj.y;
            }
            //DEFINITION OF THE X AND Y ACCORDING TO THE CAMERA AND THE SETTINGS
            double posXRel = getPosXRelative(c,adjX,adjXselected);
            double posYRel = getPosYRelative(c,adjY,adjYselected);
            //MOVE THE BACKGROUND DEPENDING ON THE MOVEMENT OF THE CORPS
            backgroundImgTranslationX = getXBackgroundTranslation(adjX,adjXselected);
            backgroundImgTranslationY = getYBackgroundTranslation(adjY,adjYselected);
            //SET THE TRANSFORMER FOR THE PATH (ORBITS LINE)
            AffineTransform pathTransform = new AffineTransform();
            pathTransform.translate
            (
                transformer.getTranslateX() + getXPathTranslation(adjX,adjXselected,c),
                transformer.getTranslateY() + getYPathTranslation(adjY,adjYselected,c)
            );
            pathTransform.scale(m.cameraZoom, m.cameraZoom);
            g2.setTransform(pathTransform);
            //DRAW TRACE IF AUTHORIZED
            if((m.corpLineDisplay)&&(drawOrbitLineAuthorizedByID))
            {
                if(c.type != 4)
                {
                    drawTrace(g2,c.path,c.posX * m.pixelParAU,c.posY * m.pixelParAU,Math.toDegrees(c.angle));
                }
                else
                {
                    drawTrace(g2,c.path,(adjX + c.posX) * m.pixelParAU,(c.posY + adjY) * m.pixelParAU,Math.toDegrees(c.angle));
                }
            }
            //GET BACK OUR ORIGINAL TRANSFORMER
            g2.setTransform(transformer);
            if(c.type == 3)
            {
                drawTrajectory(c, g2, adjX, adjXselected,adjY,adjYselected);
                drawTangent(c, g2, adjX, adjXselected, adjY, adjYselected);
            }
            //DRAW CORP IF IT IS IN THE SCREEN RANGE WITH ALL THE PARAMETERS
            if(isInTheScreen(c))
                drawCorp(g2,posXRel,posYRel,c);
        }
        
    }
    public double getPosXRelative(Corp x,double adjX,double adjXselected)
    {
        double posXRel = ((x.posX + adjX) - (m.selectedCorp.posX + adjXselected)) * m.pixelParAU * m.cameraZoom + m.cameraXTranslation;
        return posXRel;
    }
    public double getPosYRelative(Corp x,double adjY,double adjYselected)
    {
        double posYRel = ((x.posY + adjY) - (m.selectedCorp.posY + adjYselected)) * m.pixelParAU * m.cameraZoom + m.cameraYTranslation;
        return posYRel;
    }
    public int getXBackgroundTranslation(double adjX,double adjXselected)
    {
        adjX = 0;
        adjXselected = 0;
        int xTrans = 0;
        xTrans = (int) (( -(m.selectedCorp.posX + adjXselected))
            * m.pixelParAU * m.cameraZoom   + m.cameraXTranslation);
        return xTrans;    
    }
    public int getYBackgroundTranslation(double adjY,double adjYselected)
    {
        adjY = 0;
        adjYselected = 0;
        int yTrans = 0;
        yTrans = (int)(( - (m.selectedCorp.posY + adjYselected))
                * -m.pixelParAU * m.cameraZoom  - m.cameraYTranslation);
        return yTrans;
    }
    public double getXPathTranslation(double adjX,double adjXselected,Corp c)
    {
        double xTrans;
        if(c.type != 4) 
        {
            xTrans = (((adjX) -(m.selectedCorp.posX + adjXselected))
                * m.pixelParAU * m.cameraZoom  + m.cameraXTranslation);
        }
        else
        {
            Satellite s = (Satellite) c;
            xTrans = (((0) - (m.selectedCorp.posX + adjXselected))
                * m.pixelParAU * m.cameraZoom  + m.cameraXTranslation);
        }
        return xTrans;       
    }
    public double getYPathTranslation(double adjY,double adjYselected,Corp c)
    {
        double yTrans; 
        if(c.type != 4)
        {
            yTrans = (((adjY) - (m.selectedCorp.posY + adjYselected))
                * -m.pixelParAU * m.cameraZoom  - m.cameraYTranslation);  
        }
        else
        {
            Satellite s = (Satellite) c;
            yTrans = (((0) - (m.selectedCorp.posY + adjYselected))
                * -m.pixelParAU * m.cameraZoom  - m.cameraYTranslation);  
        }
        return yTrans;
    }
    public Point2D.Double getSatelliteAdjustement(Corp x)
    {
        Satellite s = null;
        try
        {
            s = (Satellite) x;
        }
        catch(Exception e)
        {}
        double posXAdjustementSatellite = (s.posX - s.relatedPlanet.posX) * m.satelliteScaleFactor;
        double posYAdjustementSatellite = (s.posY - s.relatedPlanet.posY) * m.satelliteScaleFactor;
        return new Point2D.Double(posXAdjustementSatellite,posYAdjustementSatellite);
    }
    boolean isInTheScreen(Corp c)
    {
        int width = m.programWidth;
        int height = m.programHeight;
        //ADJUST THE DISTANCE FOR THE SATELLITE (THEY DON'T RESPECT THE SCALE OF THE UNIVERSE BECAUSE THE PLANETS ARE BIGGER IN THE SIMULATOR...)
        double adjX = 0;
        double adjY = 0;
        double adjXselected = 0;
        double adjYselected = 0;
        //IF THE TYPE IS A SATELLITE
        if(c.type == 4)
        {
            Point2D.Double satelliteAdj = getSatelliteAdjustement(c);
            adjX = satelliteAdj.x;
            adjY = satelliteAdj.y;
        }
        //IF A SATELLITE IS DETECTED
        if((m.selectedCorp != null)&&(m.selectedCorp.type == 4))
        {
            Point2D.Double satelliteAdj = getSatelliteAdjustement(m.selectedCorp);
            adjXselected = satelliteAdj.x;
            adjYselected = satelliteAdj.y;
        }
        //DEFINITION OF THE X AND Y ACCORDING TO THE CAMERA AND THE SETTINGS
        double posXScreen = getPosXRelative(c,adjX,adjXselected) + width;
        double posYScreen = getPosYRelative(c,adjY,adjYselected) + height;
        boolean returnedBoolean = 
                ((posXScreen > 0)&&(posXScreen < 2*width + c.currentRadiusDisplay)&&
                (posYScreen > 0)&&(posYScreen < 2*height + c.currentRadiusDisplay));    
        return returnedBoolean;
    }
    private void drawCorp(Graphics2D g2, double x, double y, Corp c)
    {   
        Graphics g = (Graphics) g2;
        double radius = c.currentRadiusDisplay;
        Color color = c.color;
        BufferedImage img = c.bgImage;
        if(img != null)
        {
            int drawLocationX = (int) (x - radius);
            int drawLocationY = (int) (-y -radius);
            double rotationRequired = Math.toRadians(c.currentRotationAngle);
            double locationX = img.getWidth() / 2;
            double locationY = img.getHeight() / 2;
            AffineTransform tx = AffineTransform.getRotateInstance(-rotationRequired, locationX, locationY);
            AffineTransformOp op = new AffineTransformOp(tx, AffineTransformOp.TYPE_BILINEAR);
            try
            {
                g2.drawImage(op.filter(img, null), drawLocationX, drawLocationY, null);
            }
            catch(java.lang.OutOfMemoryError e)
            {
                //JAVA HEAP SPACE MEMORY(ZOOM TOO BIG FOR THE CORP)
                m.cameraZoom -= m.cameraZoomConstantPerKey * m.cameraZoom;
            }
        }
        else
        {
            g2.setColor(color);
            g2.fill(new Ellipse2D.Double(x - radius, -y -radius, radius*2, radius*2));
        }
    }
    void drawTrace(Graphics2D g2,Path2D path,double x,double y,double angle)
    {
        double tv = 0.8;
        g2.setPaint(Color.LIGHT_GRAY);
        g2.setStroke(new BasicStroke((int)(1/(m.cameraZoom*3))));
        if((Math.toDegrees(angle)>= 358)&&(Math.toDegrees(angle)<= 1))
        {
           path.reset();
           path.moveTo(x,-y);
        }
        if(path.contains(x,-y))
        {
           path.reset();
           path.moveTo(x,-y);
        }
        if(m.drawingOrbitstatus)
        {
            path.lineTo(x+tv,-y+tv);
            g2.draw(path);
        }
        else
        {
           //path.closePath();
           path.reset();
           path.moveTo(x,-y);
        }
        
    }
    //TRAJECTORY PREVISION WITH CUT ENGINES
    void drawTrajectory(Corp c_, Graphics2D g2, double adjX,double adjXselected,double adjY, double adjYselected){
        g2.setStroke(new BasicStroke(1));
        SpaceShip s_ = (SpaceShip) c_;
        double posXRel = getPosXRelative(c_,adjX,adjXselected);
        double posYRel = getPosYRelative(c_,adjY,adjYselected);
        
        
        double au = m.au;
        
        double x  = posXRel;
        double x1 = s_.pointTab[0].getX();
        x1 = ((x1 + adjX) - (m.selectedCorp.posX + adjXselected)) * m.pixelParAU * m.cameraZoom + m.cameraXTranslation;
        double x2 = s_.pointTab[1].getX();
        x2 = ((x2 + adjX) - (m.selectedCorp.posX + adjXselected)) * m.pixelParAU * m.cameraZoom + m.cameraXTranslation;
        double x3 = s_.pointTab[2].getX();
        x3 = ((x3 + adjX) - (m.selectedCorp.posX + adjXselected)) * m.pixelParAU * m.cameraZoom + m.cameraXTranslation;
        
        double y  = posYRel;
        double y1 = s_.pointTab[0].getY();
        y1 = ((y1 + adjY) - (m.selectedCorp.posY + adjYselected)) * m.pixelParAU * m.cameraZoom + m.cameraYTranslation;
        double y2 = s_.pointTab[1].getY();
        y2 = ((y2 + adjY) - (m.selectedCorp.posY + adjYselected)) * m.pixelParAU * m.cameraZoom + m.cameraYTranslation;
        double y3 = s_.pointTab[2].getY();
        y3 = ((y3 + adjY) - (m.selectedCorp.posY + adjYselected)) * m.pixelParAU * m.cameraZoom + m.cameraYTranslation;
        
        Path2D pt = new Path2D.Double();
        pt.moveTo(posXRel, -posYRel);
        g2.setColor(Color.ORANGE);
        pt.curveTo(x1,-y1,x2,-y2,x3,-y3);
        g2.draw(pt);
        pt.reset();  
    }
    void drawTangent(Corp c_, Graphics2D g2,double adjX,double adjXselected,double adjY,double adjYselected){
        SpaceShip s_ = (SpaceShip) c_;
        
        s_.calculateInstantDirection(m);
        
        double proportion = s_.setProportion();
        
        double posXRel, posYRel;
        posXRel = ((s_.posX + adjX) - (m.selectedCorp.posX + adjXselected)) * m.pixelParAU * m.cameraZoom 
                    + m.cameraXTranslation ;
        posYRel = ((s_.posY + adjY) - (m.selectedCorp.posY + adjYselected)) * m.pixelParAU * m.cameraZoom 
                    + m.cameraYTranslation ;
        
        double x2 = ((s_.variation.x*proportion + (s_.posX + adjX)  - (m.selectedCorp.posX + adjXselected))
                    * m.pixelParAU * m.cameraZoom + m.cameraXTranslation);
        double y2 = ((s_.variation.y*proportion + (s_.posY + adjY) - (m.selectedCorp.posY + adjYselected))
                    * m.pixelParAU * m.cameraZoom + m.cameraYTranslation);
        
        Path2D pt = new Path2D.Double();
        pt.moveTo(posXRel, -posYRel);
        pt.lineTo(x2,-y2);
        g2.setColor(Color.MAGENTA);
        g2.draw(pt);
        pt.reset();
    }
    public void updateZoomOnCorpImg()
    {
        for(Corp c : m.currentSolarSystem.corpList)
        {
            if((m.cameraZoom < 2)&&(c.type == 2))
            {
                c.currentRadiusDisplay = 1;
            }
            else if(c.type == 2)
            {
                c.currentRadiusDisplay = 2;
            }
            else
            {
                try
                { 
                    int newRadiusDisplay = (int) (c.initialRadiusDisplay * m.cameraZoom);    
                    int minRadiusDisplayPerType = 1;
                    if(c.type == 0)
                        minRadiusDisplayPerType = 5;
                    if(c.type == 1)
                        minRadiusDisplayPerType = 3;
                    if(c.type == 2)
                        minRadiusDisplayPerType = 1;
                    if(c.type == 3)
                        minRadiusDisplayPerType = 1;
                    if(c.type == 4)
                        minRadiusDisplayPerType = 1;

                    if(newRadiusDisplay<minRadiusDisplayPerType)
                        newRadiusDisplay = minRadiusDisplayPerType;
                    if(isInTheScreen(c))
                        c.refreshImage(newRadiusDisplay);
                }
                catch(Exception e){}
            }
        }
    }
}
