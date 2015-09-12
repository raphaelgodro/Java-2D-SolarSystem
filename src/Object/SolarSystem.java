 
package Object;

import java.util.ArrayList;

public class SolarSystem 
{
    public ArrayList<Corp> corpList = new ArrayList<Corp>();
    public ArrayList<Corp> corpListOptimized = new ArrayList<Corp>();
    
    public ArrayList<Star> star = new ArrayList<Star>();
    public ArrayList<Planet> planet = new ArrayList<Planet>();
    public ArrayList<Astroid> astroids = new ArrayList<Astroid>();
    public ArrayList<SpaceShip> spaceship = new ArrayList<SpaceShip>();
    public ArrayList<Satellite> satelliteGlobal = new ArrayList<Satellite>();
    public Corp defaultSystemSelectedCorp;
    
    public SolarSystem()
    {}
    public void addStar(Star star)
    {
        star.type = 0;
        this.star.add(star);
        corpList.add(star);
        corpListOptimized.add(star);
    }
    public void addPlanet(Planet planet)
    {
        planet.type = 1;
        this.planet.add(planet);
        corpList.add(planet);
        corpListOptimized.add(planet);
    }
    public void addAstroid(Astroid astroid)
    {
        astroid.type = 2;
        this.astroids.add(astroid);
        corpList.add(astroid);
    }
    public void addSpaceShip(SpaceShip spaceship)
    {
        spaceship.type = 3;
        this.spaceship.add(spaceship);
        corpList.add(spaceship);
        corpListOptimized.add(spaceship);
    }
    public void addSatellite(Satellite satellite,Planet planet)
    {
        satellite.type = 4;
        this.satelliteGlobal.add(satellite);
        corpList.add(satellite);
        planet.addSatellite(satellite);
        corpListOptimized.add(satellite);
    }
}
