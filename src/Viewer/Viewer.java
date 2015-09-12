
package Viewer;

import Model.*;
import Object.*;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

public class Viewer 
{
    Model m;
    public Frame frame;
    public Designer designer;
    public GeneralPanel generalPanel;
    public TimePanel timePanel;
    public ZoomPanel zoomPanel;
    public SpaceShipPanel spaceshipPanel;
    public SolarSystemMenu solarSystemMenu;
    public ArrayList<SolarSystemMenu> solarSystemSatelliteMenu = new ArrayList<SolarSystemMenu>() {};
    public CorpPanel corpPanel;
    public JButton addCorpButton;
    public JButton resetButton;
    public JLabel titleJLabel;
    public boolean displayTitle = false;
    public SpaceshipFactoryPanel spaceshipFactoryPanel;
    public SelectionFactoryPanel selecPanel;
    
    public StartPagePane startPane;
    public StartPagePanel startPanel;
    public StartButtonPanel startButtonPanel;
    public TitlePanel title;
    
    public Viewer(Model m)
    {
        this.m = m;
        //SCREEN DIMENSION
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        m.programWidth = (int) screenSize.getWidth();
        m.programHeight = (int) screenSize.getHeight();
        //FRAME
        frame = new Frame(m);
        //DESIGNER ,DRAWS EVERYTHING IN THE SOLAR SYSTEM
        designer = new Designer(m); 
        //TIME MENU
        timePanel = new TimePanel(m);
        //ZOOM MENU
        zoomPanel = new ZoomPanel(m);
        //SOLAR SYSTEM MENU
        solarSystemMenu = new SolarSystemMenu(m,Arrays.asList(0, 1, 3),180,400);
        //ADD CORP BUTTON
        addCorpButton = new JButton("NEW");
        addCorpButton.setBackground(new java.awt.Color(57, 156, 226));
        addCorpButton.setForeground(new java.awt.Color(255, 255, 255));
        addCorpButton.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(57, 156, 226), 1, true));
        //RESET BUTTON
        resetButton = new JButton("RESET");
        resetButton.setBackground(new java.awt.Color(57, 156, 226));
        resetButton.setForeground(new java.awt.Color(255, 255, 255));
        resetButton.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(57, 156, 226), 1, true));
        //TITLE
        titleJLabel = new JLabel();
        titleJLabel.setFont(m.SYSTEM_FONT_TITLE); // NOI18N
        titleJLabel.setFont(titleJLabel.getFont().deriveFont(55.0f));
        titleJLabel.setForeground(new java.awt.Color(255, 255, 255));
        titleJLabel.setText("\"The Local Solar System\"");
        
        //CREATE A SOLAR SYSTEM MENU FOR EACH PLANET WHO HAS SATELLITE
        for(Planet p :m.currentSolarSystem.planet)
        {
            if(p.satelliteOfThisPlanet.size() > 0)
                solarSystemSatelliteMenu.add(new SolarSystemMenu(m,Arrays.asList(4),180,p));
        }
        //SPACE SHIP PANEL
        spaceshipPanel = new SpaceShipPanel(m);
        //CORPPANEL
        corpPanel = new CorpPanel(m);
        //SELECTION FACTORY PANEL
        selecPanel = new SelectionFactoryPanel(m);
        
        //STARTPAGE PANEL
        startPanel = new StartPagePanel(m);
        //START BUTTON PANEL
        startButtonPanel = new StartButtonPanel(m);
        //TITLEPANEL
        title = new TitlePanel(m);
        //SPACESHIP FACTORY PANEL
        spaceshipFactoryPanel = new SpaceshipFactoryPanel(m);
        //GENERAL PANEL (THE ONE WITH EVERY LAYER)
        generalPanel = new GeneralPanel();
        //START PAGE PANEL
        startPane = new StartPagePane();
        
        //CRÉATION DU FRAME AVEC LES HEADER ET GRAPHIC À L'INTÉRIEUR 
        frame.setLayout(new BorderLayout());
        frame.add(startPane, BorderLayout.CENTER);
        frame.setVisible(true);
    }
    public void refreshView() 
    {
        designer.repaint();
        designer.revalidate();
        spaceshipPanel.refresh();
        generalPanel.refreshLayer();
        corpPanel.setValueFromSelectedCorp();
    }
    public class GeneralPanel extends JLayeredPane
    {
        boolean containCorpPanel = false;
        
        public GeneralPanel()
        {
            //SET THE POSITION IN THE SCREEN OF EVERY COMPONENT IN THE LAYERED PANE
            this.setFocusable(true);
            this.setBounds(0,0,m.programWidth,m.programHeight);
            designer.setBounds(0,0,m.programWidth,m.programHeight);
            designer.setOpaque(true);
            timePanel.setBounds(15, 10, timePanel.width, timePanel.height);
            timePanel.setOpaque(true);
            zoomPanel.setBounds(15, 25 + timePanel.height, zoomPanel.width, zoomPanel.height);
            zoomPanel.setOpaque(true);
            spaceshipPanel.setBounds(m.programWidth/2 - 506/2,m.programHeight-300 , 506, 275);
            spaceshipPanel.setOpaque(true);
            corpPanel.setBounds(m.programWidth - (10 + corpPanel.width),10, corpPanel.width, corpPanel.height);
            corpPanel.setOpaque(true);
            solarSystemMenu.setBounds(10, 50 + timePanel.height + zoomPanel.height, solarSystemMenu.width + 10, solarSystemMenu.height);
            solarSystemMenu.setOpaque(true);
            selecPanel.setBounds(m.programWidth/2 - selecPanel.width/2,m.programHeight/2 - selecPanel.height/2, selecPanel.width,selecPanel.height);
            selecPanel.setOpaque(true);
            selecPanel.setVisible(false);
            spaceshipFactoryPanel.setBounds(m.programWidth/2 - 418/2,m.programHeight/2 - 436/2, 418,436);
            spaceshipFactoryPanel.setOpaque(true);
            
            //DISPLAY SATELLITE MENU
            for(SolarSystemMenu ssm : solarSystemSatelliteMenu)
            {
                if(( 60 + timePanel.height + zoomPanel.height + solarSystemMenu.height + ssm.height) > m.programHeight)
                   ssm.setBounds(10 + solarSystemMenu.width, 60 + timePanel.height + zoomPanel.height,solarSystemMenu.width + ssm.width + 10, ssm.height); 
                else
                    ssm.setBounds(10, 60 + timePanel.height + zoomPanel.height + solarSystemMenu.height, ssm.width + 10, ssm.height);
                ssm.setOpaque(true);                
            }
            displayLayer();
        }
        
        public void displayLayer()
        {
            this.removeAll();
            this.add(designer, new Integer(0), 0);
            this.add(timePanel, new Integer(1), 0);
            this.add(zoomPanel, new Integer(2), 0);
            this.add(solarSystemMenu, new Integer(3), 0);
            this.add(spaceshipPanel, new Integer(4), 0);
            this.add(corpPanel, new Integer(5), 0);
            this.add(addCorpButton, new Integer(6), 0);
            this.add(resetButton, new Integer(7), 0);
            this.add(titleJLabel, new Integer(8), 0);
            this.add(spaceshipFactoryPanel, new Integer(9), 0);
            this.add(selecPanel, new Integer(10), 0);
            //DISPLAY EVERY SATELLITE MENU LAYER (DEPENDING ON THE CORP)
            int i = 0;
            for(SolarSystemMenu ssm : solarSystemSatelliteMenu)
            {
                this.add(ssm, new Integer(10+i), 0);
                i++;
            }
            refreshLayer();           
        }
        public void refreshLayer()
        {
            //CORP PANEL REFRESH
            if((m.cameraXTranslation < 100)&&(m.cameraYTranslation < 100)
            &&(m.cameraXTranslation > -100)&&(m.cameraYTranslation > -100)
            &&(!m.freeViewMode))
            {
                if(!containCorpPanel)
                {
                    corpPanel.setVisible(true);
                    containCorpPanel = true;
                }
            }
            else
            {
                corpPanel.setVisible(false);
                containCorpPanel = false;
            }
            //BOUNDS OF THE TITLE
            titleJLabel.setBounds(m.programWidth/2 - titleJLabel.getText().length() *12, 30, m.programWidth/2, 100);
            if(displayTitle)
                titleJLabel.setVisible(true);
            else
                titleJLabel.setVisible(false);
            //SATELLITE MENU REFRESH DEPENDING ON THE CORP SELECTED
            for(SolarSystemMenu ssm : solarSystemSatelliteMenu)
            {
                if((ssm.relatedPlanetMenu != null)&&(m.selectedCorp.equals(ssm.relatedPlanetMenu)))
                {
                    ssm.setVisible(true);
                    addCorpButton.setBounds(10, 60 + timePanel.height + zoomPanel.height + solarSystemMenu.height + ssm.height + 10, 100,20);
                    resetButton.setBounds(10, 60 + timePanel.height + zoomPanel.height + solarSystemMenu.height + ssm.height + 40, 100,20);
                }
                else
                {
                    //IF THE SELECTED CORP IS A SATELLITE THEN PUT THE PLANET MENU RELATED
                    if(m.selectedCorp.type == 4)
                    {
                        Satellite s = (Satellite) m.selectedCorp;
                        if(s.relatedPlanet.equals(ssm.relatedPlanetMenu))
                        {
                            ssm.setVisible(true);
                            addCorpButton.setBounds(10, 60 + timePanel.height + zoomPanel.height + solarSystemMenu.height + ssm.height + 10, 100,20);
                            resetButton.setBounds(10, 60 + timePanel.height + zoomPanel.height + solarSystemMenu.height + ssm.height + 40, 100,20);
                        }
                    }
                    else
                    {
                        ssm.setVisible(false);
                        if(m.selectedCorp.type == 1)
                        {
                            if(((Planet) m.selectedCorp ).satelliteOfThisPlanet.size() == 0)
                            {
                                addCorpButton.setBounds(10, 60 + timePanel.height + zoomPanel.height + solarSystemMenu.height, 100,20);
                                resetButton.setBounds(10, 90 + timePanel.height + zoomPanel.height + solarSystemMenu.height, 100,20);
                            }
                        }
                        else
                        {
                            addCorpButton.setBounds(10, 60 + timePanel.height + zoomPanel.height + solarSystemMenu.height, 100,20);
                            resetButton.setBounds(10, 90 + timePanel.height + zoomPanel.height + solarSystemMenu.height, 100,20);
                        }
                    }
                }
            }
        }
    }
    public class StartPagePane extends JLayeredPane{
        
        public StartPagePane(){
            
            this.setFocusable(true);
            this.setBounds(0,0,m.programWidth,m.programHeight);
            
            startPanel.setBounds(0,0,m.programWidth,m.programHeight);
            startPanel.setOpaque(true);
            
            title.setBounds(m.programWidth/2 - title.w/2, title.h/2, title.w, title.h);
            startButtonPanel.setBounds(m.programWidth/2 - startButtonPanel.w/2,
                    m.programHeight/2 - startButtonPanel.h/2 + 100, 
                    startButtonPanel.w,startButtonPanel.h);
            this.add(startPanel, new Integer(0),0);
            this.add(title, new Integer(1),0);
            this.add(startButtonPanel, new Integer(2), 0);
            
        }
    }
}
