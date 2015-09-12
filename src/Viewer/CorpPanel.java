
package Viewer;

import Model.*;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.image.BufferedImage;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class CorpPanel extends javax.swing.JPanel 
{
    Model m;
    
    public int width = 284;
    public int height = 633;
    
    public boolean mouseIntoPanel = false;
    public boolean mouseIntoSpeedTextField = false;
    
    public BufferedImage currentImage;
    
    public JPanel jPanelImg = new javax.swing.JPanel();
    public JLabel jLabelTitle = new javax.swing.JLabel();
    public JLabel jLabelPosition = new javax.swing.JLabel();
    public JTextField jTextFieldMass = new javax.swing.JTextField();
    public JLabel jLabelMass = new javax.swing.JLabel();
    public JLabel jLabelX = new javax.swing.JLabel();
    public JTextField jTextFieldX = new javax.swing.JTextField();
    public JLabel jLabelY = new javax.swing.JLabel();
    public JTextField jTextFieldY = new javax.swing.JTextField();
    public JLabel jLabelSpeed = new javax.swing.JLabel();
    public JTextField jTextFieldSpeed = new javax.swing.JTextField();
    public JLabel jLabelRotation = new javax.swing.JLabel();
    public JTextField jTextFieldRotation= new javax.swing.JTextField();
    public JScrollPane jScrollPane1 = new javax.swing.JScrollPane();
    public JTextArea jTextAreaCorpDescription = new javax.swing.JTextArea();
    public JButton jButtonNext = new javax.swing.JButton();
    public JButton jButtonBack = new javax.swing.JButton();
    
    public CorpPanel(Model m) 
    {
        this.m = m;
        drawPanel();
    }  
    double roundNumber(double number,int numberOfDecimal)
    {
        int value = 10^numberOfDecimal;
        return (double)Math.round(number * value) / value;
    }
    public void setValueFromSelectedCorp()
    {
        //IF THE MOUSE IS OUT OF THE PANEL
        if(!mouseIntoPanel)
        {
            jLabelTitle.setText((String) m.selectedCorp.name);
            jTextFieldMass.setText((String) Double.toString(m.selectedCorp.mass));
            jTextFieldX.setText(Double.toString(roundNumber(m.selectedCorp.posX,0)));
            jTextFieldY.setText(Double.toString(roundNumber(m.selectedCorp.posY,0)));
            jTextFieldSpeed.setText(Double.toString(roundNumber(m.selectedCorp.getSpeed(),0)));
            jTextFieldRotation.setText(Double.toString(m.selectedCorp.rotationPeriodHour));
            jTextAreaCorpDescription.setText(getLineString(m.selectedCorp.description));
        }
    }
    public void setImgJLabel() 
    {
        jPanelImg = new JPanel()
        {
            @Override
            public void paintComponent(Graphics g) 
            {
                Graphics2D graphics2d = (Graphics2D) g;
                if(currentImage != null)
                {
                    double widthToHeightProportion = (double) currentImage.getWidth()/currentImage.getHeight();
                    graphics2d.drawImage(m.selectedCorp.imageResize(currentImage, (int)(260 * widthToHeightProportion ), 260), 0, 0, null);
                }
                else
                {
                    g.setColor(m.selectedCorp.color);
                    graphics2d.fill(new Ellipse2D.Double(0, 0, 260, 260));
                }
            }
        };
    }
    String getLineString(String s)
    {
        int length = s.length();
        int charPerLine = 33;
        String sRemains = "";
        String finalString = "";
        
        for(int x=charPerLine;x<=length;x+=charPerLine)
        {
            finalString += s.substring(x-charPerLine, x) + "\n";
        }
        return finalString;
    }
    private void drawPanel() 
    {
        setBorder(new javax.swing.border.LineBorder(new java.awt.Color(57, 156, 226), 1, true));
        setBackground(new java.awt.Color(0, 0, 0));

        jPanelImg.setBackground(new java.awt.Color(0, 0, 0));
        jPanelImg.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(57, 156, 226)));



        
        javax.swing.GroupLayout jPanelImgLayout = new javax.swing.GroupLayout(jPanelImg);
        jPanelImg.setLayout(jPanelImgLayout);
        jPanelImgLayout.setHorizontalGroup(
            jPanelImgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanelImgLayout.setVerticalGroup(
            jPanelImgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 262, Short.MAX_VALUE)
        );
 
        jLabelTitle.setFont(m.SYSTEM_FONT_TITLE.deriveFont(26.0f));
        jLabelTitle.setForeground(new java.awt.Color(255, 255, 255));

        jLabelPosition.setForeground(new java.awt.Color(255, 255, 255));
        jLabelPosition.setText("Position (au)");
        jLabelPosition.setFont(m.SYSTEM_FONT_TEXT.deriveFont(12.0f));

        jLabelMass.setForeground(new java.awt.Color(255, 255, 255));
        jLabelMass.setText("Mass (kg)");
        jLabelMass.setFont(m.SYSTEM_FONT_TEXT.deriveFont(12.0f));

        jLabelX.setForeground(new java.awt.Color(255, 255, 255));
        jLabelX.setText("X :");
        jLabelX.setFont(m.SYSTEM_FONT_TEXT.deriveFont(12.0f));

        jLabelY.setForeground(new java.awt.Color(255, 255, 255));
        jLabelY.setText("Y :");
        jLabelY.setFont(m.SYSTEM_FONT_TEXT.deriveFont(12.0f));

        jLabelSpeed.setBackground(new java.awt.Color(0, 0, 0));
        jLabelSpeed.setForeground(new java.awt.Color(255, 255, 255));
        jLabelSpeed.setText("Speed (m/s)");
        jLabelSpeed.setFont(m.SYSTEM_FONT_TEXT.deriveFont(12.0f));

        jLabelRotation.setForeground(new java.awt.Color(255, 255, 255));
        jLabelRotation.setText("Rotation period (H)");
        jLabelRotation.setFont(m.SYSTEM_FONT_TEXT.deriveFont(12.0f));

        jTextAreaCorpDescription.setColumns(20);
        jTextAreaCorpDescription.setBackground(new java.awt.Color(0, 0, 0));
        jTextAreaCorpDescription.setFont(new java.awt.Font("Courier New", 1, 11)); // NOI18N
        jTextAreaCorpDescription.setForeground(new java.awt.Color(255, 255, 255));
        jTextAreaCorpDescription.setRows(5);
        jScrollPane1.setViewportView(jTextAreaCorpDescription);

        jButtonNext.setBackground(new java.awt.Color(0, 0, 0));
        jButtonNext.setForeground(new java.awt.Color(255, 255, 255));
        jButtonNext.setText(">");

        jButtonBack.setBackground(new java.awt.Color(0, 0, 0));
        jButtonBack.setForeground(new java.awt.Color(255, 255, 255));
        jButtonBack.setText("<");
        
        currentImage = m.selectedCorp.diaporamaImage.get(0);
        setValueFromSelectedCorp();
        setImgJLabel();
        
        
        jPanelImg.setPreferredSize(new Dimension(260,264));
        
        //SET STYLE OF JTEXTFIELD
        jTextFieldMass.setBackground(new java.awt.Color(0, 0, 0));
        jTextFieldMass.setFont(new java.awt.Font("Courier New", 1, 13)); // NOI18N
        jTextFieldMass.setForeground(new java.awt.Color(255, 255, 255));
        jTextFieldX.setBackground(new java.awt.Color(0, 0, 0));
        jTextFieldX.setFont(new java.awt.Font("Courier New", 1, 13)); // NOI18N
        jTextFieldX.setForeground(new java.awt.Color(255, 255, 255));
        jTextFieldY.setBackground(new java.awt.Color(0, 0, 0));
        jTextFieldY.setFont(new java.awt.Font("Courier New", 1, 13)); // NOI18N
        jTextFieldY.setForeground(new java.awt.Color(255, 255, 255));
        jTextFieldSpeed.setBackground(new java.awt.Color(0, 0, 0));
        jTextFieldSpeed.setFont(new java.awt.Font("Courier New", 1, 13)); // NOI18N
        jTextFieldSpeed.setForeground(new java.awt.Color(255, 255, 255));
        jTextFieldRotation.setBackground(new java.awt.Color(0, 0, 0));
        jTextFieldRotation.setFont(new java.awt.Font("Courier New", 1, 13)); // NOI18N
        jTextFieldRotation.setForeground(new java.awt.Color(255, 255, 255));
        
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButtonBack, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonNext, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(92, 92, 92))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanelImg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 260, Short.MAX_VALUE)
                    .addComponent(jLabelTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(jLabelSpeed, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldSpeed))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(jLabelRotation, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldRotation))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelMass, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelPosition, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabelX)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextFieldX, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabelY)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextFieldY, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jTextFieldMass))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(jLabelTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelImg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonNext, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonBack, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldMass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelMass, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelPosition, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelX)
                    .addComponent(jTextFieldX, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelY)
                    .addComponent(jTextFieldY, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelSpeed, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldSpeed, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelRotation, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldRotation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 143, Short.MAX_VALUE)
                .addContainerGap())
        );
    }              
}
