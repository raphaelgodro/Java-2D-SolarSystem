
package Model;

import Object.*;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Random;

public class SolarSystemDataBase 
{
    public ArrayList<SolarSystem> ssList = new ArrayList<SolarSystem>();
     
    public SolarSystemDataBase()
    {
        ssList.add(getOurSolarSystem());
    }
    public Astroid randomAstroid(String name,double minMass,double maxMass,double minDistance,double maxDistance,
                double minSpeed,double maxSpeed,double minRotation,double maxRotation)
    {
        //Color c = new Color(randInt(60,100),randInt(0,50),randInt(0,69));
        Color c = Color.ORANGE;
        double angle = randDouble(0,360);
        double posX = randDouble(minDistance,maxDistance) * Math.cos(Math.toRadians(angle));
        double posY = randDouble(minDistance,maxDistance) * Math.sin(Math.toRadians(angle));
        double mass = randDouble(minMass,maxMass);
        double speedX = randDouble(minSpeed,maxSpeed) * Math.sin(Math.toRadians(angle)) * -1;
        double speedY = randDouble(minSpeed,maxSpeed)  * Math.cos(Math.toRadians(angle));
        double rotation = randDouble(minRotation,maxRotation);
        Astroid a = new Astroid(name,c,posX,posY,mass,1,speedX,speedY,rotation);
        
        
        return a;
    }
    public SolarSystem getOurSolarSystem()
    {
        SolarSystem ourSolarSystem = new SolarSystem();
        Star sun = new Star("SUN",Color.YELLOW,0,0,(1.99*Math.pow(10,30)),200,0,0,0);
        ourSolarSystem.addStar(sun);  
         
        
        Planet mercury = new Planet("MERCURY",Color.DARK_GRAY,0.38709893,(330.2*Math.pow(10,21)),10,47360,58.6462);
        ourSolarSystem.addPlanet(mercury);
        
        Planet venus = new Planet("VENUS",Color.ORANGE,0.723332,(4.8685*Math.pow(10,24)),18,35020,243.018);
        ourSolarSystem.addPlanet(venus);
        
        Planet earth = new Planet("EARTH",Color.BLUE,1,(5.98*Math.pow(10,27)),20,29783,24);
        ourSolarSystem.addPlanet(earth);
        
            Satellite moon = new Satellite("MOON",Color.WHITE,0.0027,(7.3477*Math.pow(10,22)),3,30805,earth,27.32);
            ourSolarSystem.addSatellite(moon,earth);
            

        Planet mars = new Planet("MARS",Color.RED,1.52366231,(641.85*Math.pow(10,21)),16,24077,24.62);
        ourSolarSystem.addPlanet(mars);

        Planet jupiter = new Planet("JUPITER",new Color(238,203,173),5.20336301,(1.89*Math.pow(10,27)),80,13057.2,9.924);
        ourSolarSystem.addPlanet(jupiter);

            Satellite io = new Satellite("IO",Color.YELLOW,0.002819559,(8.93*Math.pow(10,22)),4,17339.75,jupiter,42.456);
            ourSolarSystem.addSatellite(io,jupiter);
            Satellite europa = new Satellite("EUROPA",Color.BLUE,0.004486036,(4.8*Math.pow(10,22)),3,13743.36,jupiter,85.224);
            ourSolarSystem.addSatellite(europa,jupiter);
            Satellite ganymede = new Satellite("GANYMEDE",Color.GRAY,0.007155182,(1.4819*Math.pow(10,23)),5,10879.33,jupiter,171.72);
            ourSolarSystem.addSatellite(ganymede,jupiter);
            Satellite callisto = new Satellite("CALLISTO",Color.GRAY,0.012585,(1.0759*Math.pow(10,23)),4,8203.22,jupiter,400.536);
            ourSolarSystem.addSatellite(callisto,jupiter);
        
        Planet saturn = new Planet("SATURN",new Color(49,79,79),9.53707032,(568.46*Math.pow(10,24)),65,9644.6,10.656);
        ourSolarSystem.addPlanet(saturn);
        Satellite titan = new Satellite("TITAN",Color.GREEN,0.008167663,(1.3455*Math.pow(10,23)),6,5570.965134,saturn,382.8);
        ourSolarSystem.addSatellite(titan,saturn);
        Satellite encelade = new Satellite("ENCELADUS",Color.GRAY,0.001591179,(1.0794*Math.pow(10,20)),3,12635.36,saturn,10.656);
        ourSolarSystem.addSatellite(encelade,saturn);
        Satellite rhea = new Satellite("RHEA",Color.GRAY,0.003523232,(2.0371*Math.pow(10,21)),4,8483.722,saturn,108.432);
        ourSolarSystem.addSatellite(rhea,saturn);
        Satellite iapetus = new Satellite("IAPETUS",Color.green,0.023802819,(1.8060*Math.pow(10,21)),4,3263.56,saturn,1903.92);
        ourSolarSystem.addSatellite(iapetus,saturn);
        
        Planet uranus = new Planet("URANUS",new Color(110,117,149),19.22941195,(86.810*Math.pow(10,24)),55,6810,17.23992);
        ourSolarSystem.addPlanet(uranus);
        
        Planet neptune = new Planet("NEPTUNE",new Color(59,80,183),30.10366151,(102.43*Math.pow(10,24)),60,5431.7,16.11);
        ourSolarSystem.addPlanet(neptune);

        SpaceShip iss = new SpaceShip("CONSTELLATION",Color.WHITE,1-0.020,45000,2,10052,20000,5,10000,1000,0);
        ourSolarSystem.addSpaceShip(iss);
        iss.setBackgroundImage("lib/images/iss.png");
        
        SpaceShip iss2 = new SpaceShip("VERMINE",Color.WHITE,3-0.027,45000,2,10052,20000,5,10000,1000,0);
        ourSolarSystem.addSpaceShip(iss2);
        iss2.setBackgroundImage("lib/images/issdamn2.png");        
       
        
        /*SpaceShip dickjeff = new SpaceShip("DICKJEFF ENGINE",Color.WHITE,1-0.010,45000,5,10052,100000,1,30000,1000,0);
        ourSolarSystem.addSpaceShip(dickjeff);
        dickjeff.setBackgroundImage("images/dickjeff.png");*/

        
        ourSolarSystem.defaultSystemSelectedCorp = sun;
        
        //ADD ASTROID RANDOM ...
        int astroidNumber = 300;
        for(int i = 0;i<astroidNumber;i++)
        {
            Astroid a = randomAstroid("ASTEROID#"+i,Math.pow(10, 15),2.12 * Math.pow(10, 18),2.5,2.8,17000,22000,0,0);
            ourSolarSystem.addAstroid(a);
        }
        
        
        return ourSolarSystem;
    }
    public double randDouble(double rangeMin, double rangeMax) 
    {
        Random r = new Random();
        double randomValue = rangeMin + (rangeMax - rangeMin) * r.nextDouble();

        return randomValue;
    }
    public int randInt(int min, int max) 
    {
        Random rand = new Random();
        int randomNum = rand.nextInt((max - min) + 1) + min;
        return randomNum;
    }
    
}
