
package Viewer;

import Model.Model;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.KeyStroke;

public class FrameMenuBar extends JMenuBar
{
    Model m;
    Color bgColor = Color.BLACK;
    Color itembgColor;
    Color fontColor = Color.WHITE;
    
    public ArrayList<MenuBar> systemMenuItem = new ArrayList<MenuBar>();
    public FrameMenuBar(Model m)
    {
        this.m = m;
        SystemMenu sm = new SystemMenu(this.m);
        this.removeAll();
        for(MenuBar menuBarIterator :  systemMenuItem)
        {
            this.add((JMenu) menuBarIterator);
        }
    }
    @Override
    protected void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(bgColor);
        g2d.fillRect(0, 0, getWidth() - 1, getHeight() - 1);
    }
    public class MenuBar extends JMenu
    {
        public ArrayList<JMenuItem> menuItem;
        public MenuBar(String s,int i,String s2,ArrayList<JMenuItem> menuItem)
        {
            super(s);
            this.menuItem = menuItem;
            this.setMnemonic(i);
            this.getAccessibleContext().setAccessibleDescription(s2);
            for(JMenuItem item :  menuItem)
            {
                this.add(item);
            }
            this.setForeground(fontColor);
        }
    }

    public class SystemMenu 
    {
        Model m;

        public SystemMenu(Model m)
        {
            this.m = m;
            ArrayList<JMenuItem> jmi = new ArrayList<JMenuItem>();
            jmi.add(save());
            jmi.add(leave());
            MenuBar menuBar = new MenuBar("Files",KeyEvent.VK_A,"Files",jmi);
            systemMenuItem.add(menuBar);   

            //MENU WINDOW
            ArrayList<JMenuItem> jmi3 = new ArrayList<JMenuItem>();
            jmi3.add(leftMenu());
            jmi3.add(rightMenu());
            menuBar = new MenuBar("Window",KeyEvent.VK_A,"Window",jmi3);
            systemMenuItem.add(menuBar); 

            //MENU ABOUT US
            ArrayList<JMenuItem> jmi4 = new ArrayList<JMenuItem>();
            jmi4.add(aboutUs());
            menuBar = new MenuBar("About",KeyEvent.VK_A,"About",jmi4);
            systemMenuItem.add(menuBar);
        }
        //FILE
        JMenuItem save()
        {
            BackgroundJMenuItem menuItem =  new BackgroundJMenuItem("Enregistrer",KeyEvent.VK_T);
            menuItem.getAccessibleContext().setAccessibleDescription("This doesn't really do anything");
            return menuItem;
        }
        JMenuItem leave()
        {
            BackgroundJMenuItem menuItem = new BackgroundJMenuItem("Quitter");
            menuItem.setMnemonic(KeyEvent.VK_B);
            return menuItem;      
        }
        //WINDOW
        JMenuItem leftMenu()
        {
            BackgroundJMenuItem rbMenuItem = new BackgroundJMenuItem("Menu Fonction");
            return rbMenuItem;  
        }
        JMenuItem rightMenu()
        {
            BackgroundJMenuItem rbMenuItem = new BackgroundJMenuItem("Menu Dessin");
            return rbMenuItem;  
        }
        //ABOUT US
        JMenuItem aboutUs()
        {
            BackgroundJMenuItem menuItem =  new BackgroundJMenuItem("Projet final SIM session automne 2014 ",KeyEvent.VK_T);
            menuItem.getAccessibleContext().setAccessibleDescription("This doesn't really do anything");
            return menuItem;
        }
        
        class BackgroundJMenuItem extends JMenuItem
        {
            private BackgroundJMenuItem(String s) 
            {
                super(s);
            }
            private BackgroundJMenuItem(String s, int i) 
            {
                super(s,i);
            }
            @Override
            protected void paintComponent(Graphics g)
            {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g;
                g2d.setColor(bgColor);
                g2d.fillRect(0, 0, getWidth() - 1, getHeight() - 1);
                
            }
        }
    } 
}

