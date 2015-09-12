 
package Controller;

import Model.*;
import Viewer.*;
import java.awt.event.ActionListener;
import java.net.URL;


public class Controller 
{
    Model m;
    Viewer v;
    
    Time gameTime;
    
    public Controller(Model m,Viewer v)
    {
        System.out.println(System.getProperty("java.specification.version"));
        this.m = m;
        this.v = v;
        
        //SOUND OF THE GAME
        m.SYSTEM_SONG2.start();

        //DEFINE THE DEFAULT SPACESHIP
        m.selectedSpaceShip = m.currentSolarSystem.spaceship.get(0);
        //SET THE STAR AS THE DEFAULT CORP
        m.selectedCorp = m.currentSolarSystem.star.get(0);
        
        
        //SYSTEM KEYLISTENER
        SystemKeyListener skl = new SystemKeyListener(m,v);
        //CAMERA
        Camera camera = new Camera(m,v);
        
        //SPACESHIP
        SpaceShipThrusters sst = new SpaceShipThrusters(m,v);
        
        //CORP CLIC FOCUS LISTENER
        CorpFocus cp = new CorpFocus(m,v);
        
        //SYSTEM FOCUS LISTENER
        SystemFocusListener sfl = new SystemFocusListener(m,v);
        
        //TIMEMENU LISTENER
        TimePanelListener tml = new TimePanelListener(m,v);
        
        //ZOOMENU LISTENER
        ZoomMenuListener zml = new ZoomMenuListener(m,v);
        
        //SOLARSYSTEM MENU LISTENER
        SolarSystemMenuCorpLineListener ssmcll = new SolarSystemMenuCorpLineListener(m,v);
        
        //SPACESHIP PANEL LISTENER
        SpaceShipPanelListener sspl = new SpaceShipPanelListener(m,v);
        
        //CORP PANEL LISTENER
        CorpPanelListener cpl = new CorpPanelListener(m,v);
        
        //COORDONATE LISTENER
        DesignerCursorCoordonate dcm = new DesignerCursorCoordonate(m,v);
        
        //TITLE ANIMATION
        TitleAnimation ta = new TitleAnimation(m,v);
        
        //SELECTION FACTORY PANEL
        SelectionFactoryPanelListener sfpl = new SelectionFactoryPanelListener(m, v);
        
        //SPACESHIP FACTORY PANEL LISTENER
        SpaceshipFactoryPanelListener ssfpl = new SpaceshipFactoryPanelListener(m,v);
        
        //START PAGE BUTTON LISTENER
        StartPagePanelListener sppl = new StartPagePanelListener(m,v,this);
        
        //ADDCORPBUTTONLISTENER
        AddCorpButtonListener acbl = new AddCorpButtonListener(m,v);
        
        //RESET BUTTON LISTENER
        ResetButtonListener rbl = new ResetButtonListener(m,v);
        
         //COEUR DU JEU (TEMPS)
        gameTime = new Time(m,v);
        
    }
    
    public void startGame()
    {
        
        //SOUND OF THE GAME
        //m.SYSTEM_SONG1.start();
        
        //INITIATE THREAD LOOP OF PHYSICS MACHINE
        gameTime.start();
    }
}
