
package Controller;

import Model.*;
import Object.Corp;
import Object.SpaceShip;
import Viewer.*;
import java.awt.geom.Point2D;
import java.util.ArrayList;
public class PhysicsMachine 
{
    //Constants
    private double G = 6.67*Math.pow(10,-11);
    private double au = 1.49597*(double) Math.pow(10, 11);
    
    public double angle;
    public double resForceX = 0;
    public double resForceY = 0;
    public double unalteredForceX = 0;
    public double unalteredForceY = 0;
    
    public int iteratorTime;
    public ArrayList<Corp> corpList;
    
    Model m;
    Viewer v;
    
    public PhysicsMachine(Model m,Viewer v,int it,ArrayList<Corp> corpList)
    {
        this.m = m;
        this.v = v;
        this.iteratorTime = it;
        this.corpList = corpList;
        
        ArrayList<Corp> systemCorpList = corpList;
        //FOR EACH CORP INTO THE SOLAR SYSTEM
        for(Corp corpMoving : corpList)
        {
            //IF WE NEED TO REFRESH THIS CORP TYPE AT THE MOMENT(WITH THE TIME OBJECT ITERATOR RELATED TO THE PPS))
            if(iteratorTime % m.ppsRefreshPerCorpType.get(corpMoving.type) == 0)
            {
                if(corpMoving.type == 3)
                {
                    //CHANGE THE CORPLIST IF A SPACESHIP IS DETECTED
                    corpList =  m.currentSolarSystem.corpListOptimized;
                }
                    
                //IF THE TYPE IS AN ASTEROID, CHANGE THE GLOBAL CORPLIST TO INTEGRATE THEM          
                reinitializeVariables();
                findCorpPosition(corpMoving);
                
                if(corpMoving.type == 3 && m.showTrajectory == true && (corpList.equals(m.currentSolarSystem.corpListOptimized))){
                    previsionPoints(corpMoving);
                   
                }
                
                applyForceXToCorp(corpMoving,resForceX,m.deltaT * m.ppsRefreshPerCorpType.get(corpMoving.type));
                applyForceYToCorp(corpMoving,resForceY,m.deltaT * m.ppsRefreshPerCorpType.get(corpMoving.type));
                if(corpMoving.type == 3)
                {
                    corpList =  systemCorpList;
                }
            }  
        }
    }    
    //GET THE POSITION FOR EVERY CORP OF THE CURRENT SOLAR SYSTEM
    public void findCorpPosition(Corp corpMoving)
    {
        for(Corp corpInfluence : corpList)
        {
            double relativePosX;
            double relativePosY;
            double relativeDistance;
            //IF WE DONT COMPARE THE SAME CORP WITH HIMSELF
            if(!corpMoving.equals(corpInfluence))
            {
                relativePosX = (corpMoving.posX - corpInfluence.posX);
                relativePosY = (corpMoving.posY - corpInfluence.posY);
                angle = 0;
                if((relativePosX > 0)&&(relativePosY > 0))
                {
                    //FRAMING 1 X:+Y:+
                    angle = Math.atan(Math.abs(relativePosY/relativePosX));
                }
                else if((relativePosX < 0)&&(relativePosY > 0))
                {
                    //FRAMING 2 X:-Y:+
                    angle = Math.PI/2 + Math.atan(Math.abs(relativePosX/relativePosY));
                }
                else if((relativePosX < 0)&&(relativePosY < 0))
                {
                    //FRAMING 3 X:-Y:-
                    angle = Math.PI + Math.atan(Math.abs(relativePosY/relativePosX));
                }
                else if((relativePosX > 0)&&(relativePosY < 0))
                {
                    //FRAMING 4 X:+Y:-
                    angle = (3 * Math.PI/ 2) + Math.atan(Math.abs(relativePosX/relativePosY));
                }
                //SET THE CORP ANGLE VALUE INTO THE OBJECT FOR FURTHER PURPOSES
                corpMoving.angle = angle;
                
                relativeDistance = au * Math.sqrt(Math.pow(relativePosX, 2) + Math.pow(relativePosY, 2));
                
                if((corpMoving.type != 2)&&(corpInfluence.type != 2))
                    checkForCollision(corpInfluence, corpMoving);
                
                //m1
                double m1 = corpInfluence.mass;
                //m2
                double m2 = corpMoving.mass;
                double gravForce = ((G*m1*m2)/((double) Math.pow(relativeDistance,2)));
                double gravForceX = gravForce * Math.cos(angle) * -1;
                double gravForceY = gravForce * Math.sin(angle) * -1;
                //Sum Fg = Ft
                resForceX = resForceX + gravForceX;
                resForceY = resForceY + gravForceY;
                
            }
            
            unalteredForceX = resForceX;
            unalteredForceY = resForceY;
            //ADD SPACESHIP THRUST HERE
            if(corpMoving.type == 3){
                SpaceShip ss = (SpaceShip) corpMoving;
                ss.generateThrust(m);
                resForceX = resForceX + ss.fx;
                resForceY = resForceY + ss.fy;
                
                ss.resForceX = resForceX;
                ss.resForceY = resForceY;
                
                if(corpInfluence.type == 0){
                    ss.rechargeBatteries(m.au,getRelativeDistance(corpInfluence, ss));
                }
                
            }
        }
    }
        
    public void previsionPoints(Corp c_){
              
        SpaceShip ss = (SpaceShip) c_;
        SpaceShip copy = ss.getCopy();

        for(int i=0; i<3; i++){
        
            copy.pointTab[i] = new Point2D.Double();
            
            applyForceXToCorp(copy,copy.resForceX,(i+2)*10000* m.ppsRefreshPerCorpType.get(copy.type));
            copy.pointTab[i].x = copy.posX;
            
            applyForceYToCorp(copy,copy.resForceY,(i+2)*10000* m.ppsRefreshPerCorpType.get(copy.type));
            copy.pointTab[i].y = copy.posY;
            
        }
        copy.posX = 0;
        copy.posY = 0;
        
        ss.eCPoint.x = applyForceToCorpX(ss,m.deltaT*1000,unalteredForceX);
        ss.eCPoint.y = applyForceToCorpY(ss,m.deltaT*1000,unalteredForceY);
        
        ss.pointTab = copy.pointTab;
    }
    public void reinitializeVariables(){
        //INITIALIZE THE FORCE APPLIED TO THE CORP
        resForceX = 0;
        resForceY = 0;
        angle = 0;  
    }

    public void applyForceXToCorp(Corp c_,double forceX, double deltaT)
    {
        //ASTRODYNAMIC NEWTON'S LAWS... WITH X
        double accX =  forceX/c_.mass; 
        double posXInit = c_.posX * au;
        double posX = posXInit + (c_.speedX*deltaT) + (0.5*accX*(Math.pow(deltaT, 2)));
        double fSpeedX = c_.speedX + accX*deltaT;
        //CHANGE THE VALUE OF THE OBJECT
        c_.speedX = fSpeedX;
        c_.posX = posX/au;
    }
    public void applyForceYToCorp(Corp c_,double forceY, double deltaT)
    {
        //ASTRODYNAMIC NEWTON'S LAWS... WITH Y
        double accY =  forceY/c_.mass; 
        double posYInit = c_.posY * au;
        double posY = posYInit + (c_.speedY*deltaT) + (0.5*accY*(Math.pow(deltaT, 2)));
        double fSpeedY = c_.speedY + accY * deltaT;
        //CHANGE THE VALUE OF THE OBJECT
        c_.speedY = fSpeedY;
        c_.posY = posY/au;
    }
    
    public double applyForceToCorpX(Corp c_,double deltaT,double fx){
        //ASTRODYNAMIC NEWTON'S LAWS... WITH X
        double accX =  fx/c_.mass; 
        double posXInit = c_.posX * au;
        double posX = posXInit + (c_.speedX*deltaT) + (0.5*accX*(Math.pow(deltaT, 2)));  
        posX = posX/au;
        //RETURN THE VALUE FOR THE PATH
        return posX;
    }
    
    public double applyForceToCorpY(Corp c_,double deltaT, double fy){
        //ASTRODYNAMIC NEWTON'S LAWS... WITH Y
        double accY =  fy/c_.mass; 
        double posYInit = c_.posY * au;
        double posY = posYInit + (c_.speedY*deltaT) + (0.5*accY*(Math.pow(deltaT, 2)));
        posY = posY/au;
        //RETURN THE VALUE FOR THE PATH
        return posY;
    }
    
    public double getRelativeDistance(Corp influence, Corp c_){
        double adjustmentSatelliteXInfluence = 0;
        double adjustmentSatelliteYInfluence = 0;
        double adjustmentSatelliteXC_ = 0;
        double adjustmentSatelliteYC_ = 0;
        if(influence.type == 4)
        {
            Point2D.Double satelliteAdj = v.designer.getSatelliteAdjustement(influence);
            adjustmentSatelliteXInfluence = satelliteAdj.x;
            adjustmentSatelliteYInfluence = satelliteAdj.y;
            //System.out.println(influence.name + " (" + adjustmentSatelliteXInfluence + "," + adjustmentSatelliteYInfluence);
        }
        else if(c_.type == 4)
        {
            Point2D.Double satelliteAdj = v.designer.getSatelliteAdjustement(c_);
            adjustmentSatelliteXC_ = satelliteAdj.x;
            adjustmentSatelliteYC_ = satelliteAdj.y;
        }
        double ax = Math.abs(influence.posX + adjustmentSatelliteXInfluence);
        double bx = Math.abs(c_.posX + adjustmentSatelliteXC_);
        double rx = Math.max(ax, bx)- Math.min(ax,bx);
        double ay = Math.abs(influence.posY + adjustmentSatelliteYInfluence);
        double by = Math.abs(c_.posY + adjustmentSatelliteYC_);
        double ry = Math.max(ay, by)- Math.min(ay,by);
        
        double rd = Math.sqrt((rx*rx)+(ry*ry));
        return rd;
    } 
    
    public void checkForCollision(Corp c1, Corp c2){
        double relD = 0;
        double effectiveD = c1.initialRadiusDisplay*m.cameraZoom + c2.initialRadiusDisplay*m.cameraZoom;
        relD = getRelativeDistance(c1,c2);
        if(relD*m.pixelParAU*m.cameraZoom <= effectiveD){
            Collision c = new Collision(c1,c2,angle,m,v);
        }
    }
    
}