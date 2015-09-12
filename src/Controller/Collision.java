
package Controller;

import Model.Model;
import Object.Corp;
import Viewer.Viewer;

public class Collision {
    
    Model m;
    Viewer v;
    Corp c1, c2, bigC, smallC;
    double m1, m2;
    double d1, d2, df1, df2;
    double v1, v2, vi1, vi2, vf1, vf2;
    double vxi1, vxi2, vxf;
    double vyi1, vyi2, vyf;
    double angle;
    double A,B,C,D;
    boolean elastic;
    
    public Collision(Corp c1, Corp c2,double angle, Model m, Viewer v){
        
        this.m = m;
        this.v = v;
        
        this.c1 = c1;
        this.c2 = c2;
        
        this.angle = angle;
        
        m1 = c1.mass;
        m2 = c2.mass;
        
        d1 = getEffectiveDirection(c1.getDirection(), angle);
        d2 = getEffectiveDirection(c2.getDirection(), angle);
        
        v1 = c1.getSpeed();
        v2 = c2.getSpeed();
        
        vxi1 = c1.speedX;
        vxi2 = c2.speedX;
        
        vyi1 = c1.speedY;
        vyi2 = c2.speedY;
        
        emptyCorp(c1);
        emptyCorp(c2);
        setBiggestCorp();
        compareCorpsMass();
        collide();
    }
    
    public void collide(){
        if(elastic){
            elasticCollision();
        }
        else{
            plasticCollision();
        }
    }
    
    public double getEffectiveDirection(double d, double angle){
        double di = d+angle;
        minimize(di);
        
        return di;
    }
    
    public void minimize(double d){
        if(d > 2*Math.PI){
            d = 2*Math.PI - d;
            minimize(d);
        }
    }
    
    public void elasticCollision(){
        
        //CORP ONE
        A = (m1-m2)/(m1+m2)*Math.tan(d1);
        B = 2*m2/(m1+m2);
        C = v2/v1;
        D = Math.sin(d2)/Math.cos(d1);
        
        df1 = Math.atan(A+(B*C*D));
        df1 = df1 - angle;
        vf1 = Math.sqrt(Math.pow(Math.cos(d1)*(A+(B*C*D)), 2) + Math.pow((v1*Math.cos(d1)), 2));
        c1.setSpeed(vf1,df1);
        
        //CORP TWO
        A = (m2-m1)/(m2+m1)*Math.tan(d2);
        B = 2*m1/(m1+m2);
        C = v1/v2;
        D = Math.sin(d1)/Math.cos(d2);
        
        df2 = Math.atan(A+(B*C*D));
        df2 = df2 - angle;
        vf2 = Math.sqrt(Math.pow(Math.cos(d2)*(A+(B*C*D)), 2) + Math.pow((v2*Math.cos(d2)), 2));
        c2.setSpeed(vf2,df2);
    }
    
    public  void plasticCollision(){
        vxf = ((m1*vxi1)+(m2*vxi2))/(m1+m2);
        vyf = ((m1*vyi1)+(m2*vyi2))/(m1+m2);

        bigC.speedX = vxf;
        bigC.speedY = vyf;

        //ADAPTING CORP VOLUME AND MASS
        bigC.setMass((m1+m2),m.cameraZoom);
        
        //DESTROYING CORP
        if(smallC.type !=4 && smallC.type !=2)
            m.currentSolarSystem.corpList.remove(smallC);
        
        int type = smallC.type;

        switch(type){
            
            case 0: m.currentSolarSystem.star.remove(smallC);
                break;
            case 1: m.currentSolarSystem.planet.remove(smallC);
                break;
            case 2: m.currentSolarSystem.astroids.remove(smallC);
                break;
            case 3: m.currentSolarSystem.spaceship.remove(smallC);
                break;
            case 4: m.currentSolarSystem.satelliteGlobal.remove(smallC);
                break;     
        }
        
    }
    
    public void setBiggestCorp(){
        if(m1 > m2){
            bigC = c1;
            smallC = c2;
        }
        
        else{
            bigC = c2;
            smallC = c1;
        }
    }
    
    public boolean compareCorpsMass(){
        if(smallC.mass/bigC.mass <= 0.25){
            
           elastic = false; 
        }
       
        else{
            elastic = false;
        }
        return elastic;
    }
    
    public void emptyCorp(Corp c){
        c.speedX = 0;
        c.speedY = 0;
    }
}
