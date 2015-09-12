
package Model;

import Controller.Sound;
import Model.*;
import Object.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Model 
{ 
    //GENERAL INFORMATION
        public final String PROGRAM_TITLE = "ENTROPY";
        public final String BACKGROUND_ROOT = "lib/images/background.jpg";
        public final String ICON_ROOT = "lib/images/icon.png";
        public Sound SYSTEM_SONG1 = new Sound("lib/music/backsound1.wav");
        public Sound SYSTEM_SONG2 = new Sound("lib/music/backsound2.wav");
        public Font SYSTEM_FONT_TITLE = loadFont("lib/font/basictitlefont.ttf");
        public Font SYSTEM_FONT_TEXT = loadFont("lib/font/Track.ttf");
        public Font SYSTEM_FONT_NUMBER = loadFont("lib/font/din-regular.ttf");
        
    //MATH CONSTANTS
        public double G = 6.67*Math.pow(10,-11);
        public double au = 1.49597*(double) Math.pow(10, 11);
        
    //SOLARSYSTEM STATE
        public SolarSystem ourSolarSystem = new SolarSystem();
        public SolarSystem currentSolarSystem;
    
    //PROGRAM REFRESHING SETTINGS
        public boolean timeOnPause = false;
        //Physics per second
        public int pps = 500;
        //Frame per second
        public int fps = 24;
        //Time in seconds
        public int deltaT = 10;
        
    
    
    //DISPLAY PARAMETERS
        public int programWidth = 1440;
        public int programHeight = 900;
        public boolean windowedMode = false;
        public int pixelParAU = 8000;
        public int satelliteScaleFactor = 100;
        public double satelliteMaxDeltaT = 172;
        public double rotationMaxDeltaT = 300;
        public boolean corpLineDisplay = true;
        public boolean rotationDisplay = true;
        public double cameraZoom = 1;
        public int cameraXTranslation = 0;
        public int cameraYTranslation = 0;
        public int cameraTranslationTurn = 0;
        public boolean cameraIsOnZoom = false;
        public double cameraZoomConstantPerKey = 0.03;
        public double hyp = 0.1;
        public double maxZoomValue = 20;
        public double minZoomValue = 0.007;
        public boolean drawingOrbitstatus = true;
        public boolean showTrajectory = true;
        public boolean satelliteReset = false;
        public boolean rotationReset = false;
        public boolean freeViewMode = false;
        public boolean showSSPanel = true;
        
        
    //CORP
        //EMPTY CORP TO GET OVER NULL POINTER EXCEPTION
        public Corp emptyCorp = new Corp("",Color.RED,0,0,0,0,0,0,0);
        //PROGRAM STATE OF CORP SELECTED
        public Corp selectedCorp = emptyCorp;
        public SpaceShip emptySpaceShip = new SpaceShip("",Color.WHITE,0,0,0,0,0,0,0,0,0);
        public SpaceShip selectedSpaceShip = emptySpaceShip;
        public ArrayList<Satellite> memorySatellite = new ArrayList<Satellite>();
        
        
    //DEFAULT KEY ID
        public final int KEY_ZOOM_IN_ID1 = 107;
        public final int KEY_ZOOM_IN_ID2 = 49;
        public final int KEY_ZOOM_OUT_ID1 = 109;
        public final int KEY_ZOOM_OUT_ID2 = 50;
        
    //CORP TYPE
        public ArrayList<Integer> authorizedOrbitLineCorpID = new ArrayList<Integer>();
        public ArrayList<Integer> ppsRefreshPerCorpType = new ArrayList<Integer>();
        
    //COLLISION ABSORBTION PARAMETERS
        public double absorb = 1;
    
    //ERROR NOTICE
        public ArrayList<String> errorMessage = new ArrayList<String>();
        
        
    public Model()
    {
        //SET THE DEFAULT SOLAR SYSTEM AT THE BEGINNING OF THE PROGRAM
        SolarSystemDataBase ssdb = new SolarSystemDataBase();
        currentSolarSystem = ssdb.ssList.get(0);
        selectedCorp = currentSolarSystem.defaultSystemSelectedCorp;
        //SET THE RULES ABOUT THE CORP TYPE INTO THE SS
        declareCorpTypeRules();
        //SET THE ERROR MESSAGE INTO THE PROGRAM
        declareErrorsMessage();
    }
    void declareErrorsMessage()
    {
        ErrorMessage em = new ErrorMessage();
        errorMessage = em.errorMessage;
    }
    void declareCorpTypeRules()
    {
      /*public int starID = 0;
        public int planetID = 1;
        public int astroidID = 2;
        public int spaceShipID = 3; 
        public int satellite = 4;*/
        //authorizedOrbitLineCorpID.add(0);
        authorizedOrbitLineCorpID.add(1);
        authorizedOrbitLineCorpID.add(3);
        authorizedOrbitLineCorpID.add(4);
        
        //CORP PPS
        ppsRefreshPerCorpType.add(10);
        ppsRefreshPerCorpType.add(1);
        ppsRefreshPerCorpType.add(20);
        ppsRefreshPerCorpType.add(1);
        ppsRefreshPerCorpType.add(1);
    }   
    Font loadFont(String fontDir)
    {
        try 
        {
            GraphicsEnvironment ge = 
            GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File(fontDir)));
            return Font.createFont(Font.TRUETYPE_FONT, new File(fontDir));
        } 
        catch (IOException|FontFormatException e) 
        {
            return Font.getFont("Arial");
        }

    }
    
}
