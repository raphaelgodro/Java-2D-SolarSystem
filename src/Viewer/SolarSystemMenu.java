
package Viewer;

import Model.*;
import Object.*;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.geom.Ellipse2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout.Group;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;

public class SolarSystemMenu extends JLayeredPane 
{
    Model m;
    
    public int width;
    public int height;
    
    public ArrayList<LineCorpPanel> corpLine = new ArrayList<LineCorpPanel>();
    public List<Integer> corpTypeAllowedInTheMenu;
    //NULL WHEN ITS NOT THE MENU OF A SATELLITE (GENERAL SOLARSYSTEM MENU)
    public Planet relatedPlanetMenu = null;
    
    public SolarSystemMenu(Model m,List<Integer> corpTypeAllowed, int width,int height) 
    {
        this.width =  width;
        this.height = height;
        this.m = m;
        corpTypeAllowedInTheMenu = corpTypeAllowed;
        addComponents();
    }
    public SolarSystemMenu(Model m,List<Integer> corpTypeAllowed, int width,Planet p) 
    {
        this.relatedPlanetMenu = p;
        this.width =  width;
        this.height = relatedPlanetMenu.satelliteOfThisPlanet.size() * 40;
        this.m = m;
        corpTypeAllowedInTheMenu = corpTypeAllowed;
        addComponents();
    }
    public void addComponents() 
    {
        this.removeAll();
        corpLine.clear();
        int tableLine = 0;
        for(Corp c_ : m.currentSolarSystem.corpList)
        {
            boolean allowed = false;
            for(Integer i:corpTypeAllowedInTheMenu)
            {
                if(relatedPlanetMenu == null)
                {
                    if(c_.type == i)
                        allowed = true;
                }
                else
                {
                    boolean isCorpSatelliteOfThePlanet = false;
                    for(Satellite s : relatedPlanetMenu.satelliteOfThisPlanet)
                    {
                        if(c_.equals(s))
                            isCorpSatelliteOfThePlanet = true;
                    }
                    if((c_.type == i)&&(isCorpSatelliteOfThePlanet))
                        allowed = true;
                }
            }
            if(allowed)
            {
                tableLine ++;
            }
        }
        int lineHeight = (height -3*tableLine)/tableLine;
        //INSERT EVERY CORP INTO THE MENU
        for(Corp c_ : m.currentSolarSystem.corpList)
        {
            boolean allowed = false;
            for(Integer i:corpTypeAllowedInTheMenu)
            {
                if(relatedPlanetMenu == null)
                {
                    if(c_.type == i)
                        allowed = true;
                }
                else
                {
                    boolean isCorpSatelliteOfThePlanet = false;
                    for(Satellite s : relatedPlanetMenu.satelliteOfThisPlanet)
                    {
                        if(c_.equals(s))
                            isCorpSatelliteOfThePlanet = true;
                    }
                    if((c_.type == i)&&(isCorpSatelliteOfThePlanet))
                        allowed = true;
                }
            }
            if(allowed)
            {
                corpLine.add(new LineCorpPanel(c_,lineHeight));
            }
        }
        setBackground(Color.BLACK);
        setBorder(new javax.swing.border.LineBorder(new Color(57, 156, 226), 1, true));
        this.setBounds(0,0,width,height);
        
        int yPointer = 2;
        
        for(LineCorpPanel lcp : corpLine)
        {
            lcp.setBounds(5, yPointer, width, lcp.height);
            lcp.setOpaque(true);
            yPointer += (lcp.height + 2);
        }
        for(int i = 0; i<corpLine.size();i++)
        {
            this.add(corpLine.get(i), new Integer(i), 0);
        }
        
    }
    public class LineCorpPanel extends JPanel
    { 
        public Corp lineCorp;
        public int height;  
        private javax.swing.JLabel jLabel1;
        private JLabel jLabelImg;
        public Image corpImg = null;
        
        public LineCorpPanel(Corp c_,int height)
        {
            this.height = height;
            lineCorp = c_;
            if(c_.profileImage != null)
                corpImg = c_.profileImage.getScaledInstance(this.height,this.height, 0);
            else if( c_.originalImage != null)
                corpImg = c_.originalImage.getScaledInstance(this.height,this.height, 0);
            jLabelImg = new JLabel()
            {
                @Override
                public void paintComponent(Graphics g) 
                {
                    Graphics2D graphics2d = (Graphics2D) g;
                    if(corpImg != null)
                        graphics2d.drawImage(corpImg, 0, 0, null);
                    else
                    {
                        graphics2d.setColor(lineCorp.color);
                        graphics2d.fill(new Ellipse2D.Double(0, 0, 30, 30));
                    }
                    super.paintComponents(g);
                }
            };
            initComponents();
        }
        private void initComponents() 
        {
            setBackground();
            jLabel1 = new javax.swing.JLabel();
            jLabel1.setFont(m.SYSTEM_FONT_TEXT); 
            jLabel1.setFont(jLabel1.getFont().deriveFont(17.0f));
            jLabel1.setForeground(new java.awt.Color(255, 255, 255));
            jLabel1.setText(lineCorp.name);

            javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
            this.setLayout(layout);
            layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addComponent(jLabelImg, javax.swing.GroupLayout.DEFAULT_SIZE, 68, Short.MAX_VALUE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap())
            );
            layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE)
                    .addContainerGap())
                .addComponent(jLabelImg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            );
        }
        public void setBackground()
        {
            if(lineCorp.equals(m.selectedCorp))
                setBackground(new java.awt.Color(57, 156, 226));
            else
                setBackground(Color.BLACK);
        }
    }
}