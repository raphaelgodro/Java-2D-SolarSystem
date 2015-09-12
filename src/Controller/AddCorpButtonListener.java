/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.*;
import Viewer.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddCorpButtonListener 
{
    Viewer v;
    Model m;
    
    public AddCorpButtonListener(Model m,Viewer v)
    {
        this.m = m;
        this.v = v;
        v.addCorpButton.addActionListener(new ButtonActionListener());
    }
    class ButtonActionListener implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent ae) 
        {
           v.selecPanel.setVisible(true);
        }
        
    }
}
