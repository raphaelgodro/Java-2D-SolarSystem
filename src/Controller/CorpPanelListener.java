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
import java.awt.image.BufferedImage;
import javax.swing.event.CaretListener;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class CorpPanelListener 
{
    Model m;
    Viewer v;
    
    int imgIterator = 0;
    
    public CorpPanelListener(Model m,Viewer v)
    {
        this.m = m;
        this.v = v;
        v.corpPanel.jTextFieldMass.addCaretListener(new MassTextFieldListener());
        v.corpPanel.jTextFieldSpeed.addCaretListener(new SpeedTextFieldListener());
        v.corpPanel.jTextFieldX.addCaretListener(new PositionXTextFieldListener());
        v.corpPanel.jTextFieldY.addCaretListener(new PositionYTextFieldListener());
        v.corpPanel.jTextFieldRotation.addCaretListener(new RotationTextFieldListener());
        v.corpPanel.jButtonNext.addActionListener(new ButtonDiaporamaNextListener());
        v.corpPanel.jButtonBack.addActionListener(new ButtonDiaporamaBackListener());
    }
    class MassTextFieldListener implements CaretListener
    {
        @Override
        public void caretUpdate(javax.swing.event.CaretEvent e)
        {
            try
            {
                if(v.corpPanel.mouseIntoPanel)
                {
                    String valueS = v.corpPanel.jTextFieldMass.getText();
                    Double valueD = Double.parseDouble(valueS);
                    m.selectedCorp.setMass(valueD,m.cameraZoom);
                }
            }
            catch(Exception ex)
            {}
        }
    }
    class SpeedTextFieldListener implements CaretListener
    {
        @Override
        public void caretUpdate(javax.swing.event.CaretEvent de)
        {
            try
            {
                if(v.corpPanel.mouseIntoSpeedTextField)
                {
                    String valueS = v.corpPanel.jTextFieldSpeed.getText();
                    Double valueD = Double.parseDouble(valueS);
                    if(valueD>0)
                        m.selectedCorp.setSpeed(valueD);
                }
            }
            catch(Exception e)
            {}
        }
    }
    class PositionXTextFieldListener implements CaretListener
    {
        @Override
        public void caretUpdate(javax.swing.event.CaretEvent de)
        {
            try
            {
                if(v.corpPanel.mouseIntoPanel)
                {
                    String valueS = v.corpPanel.jTextFieldX.getText();
                    Double valueD = Double.parseDouble(valueS);
                    m.selectedCorp.path.reset();
                    m.selectedCorp.posX = valueD;
                }
            }
            catch(Exception e)
            {}
        }
    }
    class PositionYTextFieldListener implements CaretListener
    {
        @Override
        public void caretUpdate(javax.swing.event.CaretEvent de)
        {
            try
            {
                if(v.corpPanel.mouseIntoPanel)
                {
                    String valueS = v.corpPanel.jTextFieldY.getText();
                    Double valueD = Double.parseDouble(valueS);
                    m.selectedCorp.path.reset();
                    m.selectedCorp.posY = valueD;
                }
            }
            catch(Exception e)
            {}
        }
    }
    class RotationTextFieldListener implements CaretListener
    {
        @Override
        public void caretUpdate(javax.swing.event.CaretEvent de)
        {
            try
            {
                if(v.corpPanel.mouseIntoPanel)
                {
                    String valueS = v.corpPanel.jTextFieldRotation.getText();
                    Double valueD = Double.parseDouble(valueS);
                    m.selectedCorp.rotationPeriodHour = valueD;
                }
            }
            catch(Exception e)
            {}
        }
    }
    class ButtonDiaporamaNextListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e) 
        {
            imgIterator++;
            if(imgIterator >= m.selectedCorp.diaporamaImage.size())
            {
                imgIterator = 0;
            }
            v.corpPanel.currentImage = m.selectedCorp.diaporamaImage.get(imgIterator);
            v.corpPanel.setImgJLabel();
        }
    }
    class ButtonDiaporamaBackListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e) 
        {
            imgIterator--;
            if(imgIterator < 0)
            {
                imgIterator = m.selectedCorp.diaporamaImage.size() - 1;
            }
            v.corpPanel.currentImage = m.selectedCorp.diaporamaImage.get(imgIterator);
            v.corpPanel.setImgJLabel();
        }
    }
}
