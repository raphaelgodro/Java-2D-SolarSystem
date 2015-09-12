
package Viewer;

import Model.Model;
import java.awt.geom.AffineTransform;

public class SpaceShipPanel extends javax.swing.JPanel {
    
Model m;
AffineTransform at;
int i = 1;
    
    public SpaceShipPanel(Model m) {
        this.m = m;
        this.setVisible(false);
        initComponents();   
    }
    
    public void refresh(){
        this.revalidate();
        speedXTextField.setText(String.valueOf(m.selectedSpaceShip.speedX));
        speedYTextField.setText(String.valueOf(m.selectedSpaceShip.speedY));
        
        thrustTextField.setText(String.valueOf(m.selectedSpaceShip.thrustersEfficiency));
        fuelTextField.setText(String.valueOf(m.selectedSpaceShip.fuelKg));
        
        adjustSpeedTextField();
        
        adjustFuelSlider();
        thrustSlider.setValue((int)m.selectedSpaceShip.thrustersEfficiency);
        
        angleTextField.setText(String.valueOf(m.selectedSpaceShip.currentRotationAngle));
        
        massTextField.setText(String.valueOf(m.selectedSpaceShip.mass)); 
    }
    
    public void adjustSpeedTextField(){
        speedTextField.setText(String.valueOf(Math.sqrt(Math.pow(m.selectedSpaceShip.speedX,2) + 
        Math.pow(m.selectedSpaceShip.speedX,2))));
    }
    
    public void adjustFuelSlider(){
        fluelSlider.setMaximum((int)m.selectedSpaceShip.maxFuel);
        fluelSlider.setMajorTickSpacing((int)(m.selectedSpaceShip.maxFuel/10));
        fluelSlider.setValue((int)m.selectedSpaceShip.fuelKg);
    }
    
    public int setInitialMax(){
        int max = (int) m.selectedSpaceShip.fuelKg;
        return max;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jSlider2 = new javax.swing.JSlider();
        jSlider3 = new javax.swing.JSlider();
        jLabel9 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        speedLabel = new javax.swing.JLabel();
        speedXLabel = new javax.swing.JLabel();
        speedYLabel = new javax.swing.JLabel();
        timeLabel = new javax.swing.JLabel();
        massLabel = new javax.swing.JLabel();
        xButton = new javax.swing.JButton();
        speedTextField = new javax.swing.JTextField();
        speedXTextField = new javax.swing.JTextField();
        speedYTextField = new javax.swing.JTextField();
        engineTextField = new javax.swing.JTextField();
        massTextField = new javax.swing.JTextField();
        spaceButton = new javax.swing.JButton();
        fuelTextField = new javax.swing.JTextField();
        thrustTextField = new javax.swing.JTextField();
        fuelLabel = new javax.swing.JLabel();
        thrustLabel = new javax.swing.JLabel();
        fluelSlider = new javax.swing.JSlider();
        thrustSlider = new javax.swing.JSlider();
        compassPanel = new CompassPanel(m);
        angleLabel = new javax.swing.JLabel();
        angleTextField = new javax.swing.JTextField();
        upButton = new javax.swing.JButton();
        downButton = new javax.swing.JButton();
        rightButton = new javax.swing.JButton();
        leftButton = new javax.swing.JButton();

        jLabel1.setText("jLabel1");

        jSlider2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jSlider2.setInverted(true);

        jSlider3.setOrientation(javax.swing.JSlider.VERTICAL);
        jSlider3.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jLabel9.setText("jLabel9");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setBackground(new java.awt.Color(0, 0, 0));
        setBorder(new javax.swing.border.LineBorder(new java.awt.Color(57, 156, 226), 1, true));
        setPreferredSize(new java.awt.Dimension(483, 250));

        speedLabel.setFont(new java.awt.Font("Courier New", 1, 13)); // NOI18N
        speedLabel.setForeground(new java.awt.Color(255, 255, 255));
        speedLabel.setText("Speed  :");

        speedXLabel.setFont(new java.awt.Font("Courier New", 1, 13)); // NOI18N
        speedXLabel.setForeground(new java.awt.Color(255, 255, 255));
        speedXLabel.setText("Speed X:");

        speedYLabel.setBackground(new java.awt.Color(0, 0, 0));
        speedYLabel.setFont(new java.awt.Font("Courier New", 1, 13)); // NOI18N
        speedYLabel.setForeground(new java.awt.Color(255, 255, 255));
        speedYLabel.setText("Speed Y:");
        speedYLabel.setOpaque(true);

        timeLabel.setBackground(new java.awt.Color(0, 0, 0));
        timeLabel.setFont(new java.awt.Font("Courier New", 1, 13)); // NOI18N
        timeLabel.setForeground(new java.awt.Color(255, 255, 255));
        timeLabel.setText("Engines:");

        massLabel.setFont(new java.awt.Font("Courier New", 1, 13)); // NOI18N
        massLabel.setForeground(new java.awt.Color(255, 255, 255));
        massLabel.setText("Mass   :");

        xButton.setBackground(new java.awt.Color(0, 0, 0));
        xButton.setFont(new java.awt.Font("Courier New", 1, 13)); // NOI18N
        xButton.setForeground(new java.awt.Color(255, 255, 255));
        xButton.setText("X");
        xButton.setActionCommand("");
        xButton.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));

        speedTextField.setEditable(false);
        speedTextField.setBackground(new java.awt.Color(0, 0, 0));
        speedTextField.setFont(new java.awt.Font("Courier New", 1, 13)); // NOI18N
        speedTextField.setForeground(new java.awt.Color(255, 255, 255));
        speedTextField.setText(String.valueOf(Math.sqrt(Math.pow(m.selectedSpaceShip.speedX,2) +
            Math.pow(m.currentSolarSystem.spaceship.get(0).speedX,2))));
speedTextField.setAutoscrolls(false);
speedTextField.setEnabled(false);
speedTextField.setMaximumSize(getPreferredSize());

speedXTextField.setBackground(new java.awt.Color(0, 0, 0));
speedXTextField.setFont(new java.awt.Font("Courier New", 1, 13)); // NOI18N
speedXTextField.setForeground(new java.awt.Color(255, 255, 255));
speedXTextField.setText(String.valueOf(m.selectedSpaceShip.speedX)
    );
    speedXTextField.setAutoscrolls(false);
    speedXTextField.setCaretColor(new java.awt.Color(255, 255, 255));
    speedXTextField.setDisabledTextColor(new java.awt.Color(255, 255, 255));
    speedXTextField.setEnabled(false);
    speedXTextField.setMaximumSize(getPreferredSize());
    speedXTextField.setSelectionColor(new java.awt.Color(51, 204, 0));

    speedYTextField.setBackground(new java.awt.Color(0, 0, 0));
    speedYTextField.setFont(new java.awt.Font("Courier New", 1, 13)); // NOI18N
    speedYTextField.setForeground(new java.awt.Color(255, 255, 255));
    speedYTextField.setText(String.valueOf(m.selectedSpaceShip.speedY));
    speedYTextField.setEnabled(false);

    engineTextField.setBackground(new java.awt.Color(0, 0, 0));
    engineTextField.setFont(new java.awt.Font("Courier New", 1, 13)); // NOI18N
    engineTextField.setForeground(new java.awt.Color(255, 255, 255));
    engineTextField.setText("OFF");
    engineTextField.setEnabled(false);

    massTextField.setBackground(new java.awt.Color(0, 0, 0));
    massTextField.setFont(new java.awt.Font("Courier New", 1, 13)); // NOI18N
    massTextField.setForeground(new java.awt.Color(255, 255, 255));
    massTextField.setText(String.valueOf(m.selectedSpaceShip.mass));
    massTextField.setEnabled(false);

    spaceButton.setBackground(new java.awt.Color(0, 0, 0));
    spaceButton.setFont(new java.awt.Font("Courier New", 1, 13)); // NOI18N
    spaceButton.setForeground(new java.awt.Color(255, 255, 255));
    spaceButton.setText("Space");
    spaceButton.setActionCommand("");
    spaceButton.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));

    fuelTextField.setBackground(new java.awt.Color(0, 0, 0));
    fuelTextField.setFont(new java.awt.Font("Courier New", 1, 13)); // NOI18N
    fuelTextField.setForeground(new java.awt.Color(255, 255, 255));
    fuelTextField.setText(String.valueOf(m.selectedSpaceShip.fuelKg));
    fuelTextField.setEnabled(false);

    thrustTextField.setBackground(new java.awt.Color(0, 0, 0));
    thrustTextField.setFont(new java.awt.Font("Courier New", 1, 13)); // NOI18N
    thrustTextField.setForeground(new java.awt.Color(255, 255, 255));
    thrustTextField.setText(String.valueOf(m.selectedSpaceShip.thrustersEfficiency));
    thrustTextField.setEnabled(false);

    fuelLabel.setFont(new java.awt.Font("Courier New", 1, 13)); // NOI18N
    fuelLabel.setForeground(new java.awt.Color(255, 255, 255));
    fuelLabel.setText("Fuel Kg");

    thrustLabel.setFont(new java.awt.Font("Courier New", 1, 13)); // NOI18N
    thrustLabel.setForeground(new java.awt.Color(255, 255, 255));
    thrustLabel.setText("Thrust %");

    fluelSlider.setBackground(new java.awt.Color(0, 0, 0));
    fluelSlider.setFont(new java.awt.Font("Courier New", 1, 13)); // NOI18N
    fluelSlider.setMajorTickSpacing((int)setInitialMax()/10
    );
    fluelSlider.setMaximum(setInitialMax());
    fluelSlider.setOrientation(javax.swing.JSlider.VERTICAL);
    fluelSlider.setPaintTicks(true);
    fluelSlider.setValue((int)m.selectedSpaceShip.fuelKg);
    fluelSlider.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 204, 51)));
    fluelSlider.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
    fluelSlider.setEnabled(false);

    thrustSlider.setBackground(new java.awt.Color(0, 0, 0));
    thrustSlider.setFont(new java.awt.Font("Courier New", 1, 13)); // NOI18N
    thrustSlider.setForeground(new java.awt.Color(255, 255, 255));
    thrustSlider.setMajorTickSpacing(10);
    thrustSlider.setOrientation(javax.swing.JSlider.VERTICAL);
    thrustSlider.setPaintTicks(true);
    thrustSlider.setValue((int)(m.currentSolarSystem.spaceship.get(0).thrustersEfficiency));
    thrustSlider.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
    thrustSlider.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
    thrustSlider.setEnabled(false);

    compassPanel.setBackground(new java.awt.Color(0, 0, 0));
    compassPanel.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
    compassPanel.setEnabled(false);
    compassPanel.setOpaque(false);
    compassPanel.setPreferredSize(new java.awt.Dimension(106, 106));

    javax.swing.GroupLayout compassPanelLayout = new javax.swing.GroupLayout(compassPanel);
    compassPanel.setLayout(compassPanelLayout);
    compassPanelLayout.setHorizontalGroup(
        compassPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGap(0, 106, Short.MAX_VALUE)
    );
    compassPanelLayout.setVerticalGroup(
        compassPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGap(0, 106, Short.MAX_VALUE)
    );

    angleLabel.setFont(new java.awt.Font("Courier New", 1, 13)); // NOI18N
    angleLabel.setForeground(new java.awt.Color(255, 255, 255));
    angleLabel.setText("Angle:");

    angleTextField.setBackground(new java.awt.Color(0, 0, 0));
    angleTextField.setFont(new java.awt.Font("Courier New", 1, 13)); // NOI18N
    angleTextField.setForeground(new java.awt.Color(255, 255, 255));
    angleTextField.setText(String.valueOf(m.selectedSpaceShip.currentRotationAngle));
    angleTextField.setEnabled(false);

    upButton.setBackground(new java.awt.Color(0, 0, 0));
    upButton.setFont(new java.awt.Font("Courier New", 1, 13)); // NOI18N
    upButton.setForeground(new java.awt.Color(255, 255, 255));
    upButton.setText("W");
    upButton.setActionCommand("");
    upButton.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));

    downButton.setBackground(new java.awt.Color(0, 0, 0));
    downButton.setFont(new java.awt.Font("Courier New", 1, 13)); // NOI18N
    downButton.setForeground(new java.awt.Color(255, 255, 255));
    downButton.setText("S");
    downButton.setActionCommand("");
    downButton.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));

    rightButton.setBackground(new java.awt.Color(0, 0, 0));
    rightButton.setFont(new java.awt.Font("Courier New", 1, 13)); // NOI18N
    rightButton.setForeground(new java.awt.Color(255, 255, 255));
    rightButton.setText("D");
    rightButton.setActionCommand("");
    rightButton.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));

    leftButton.setBackground(new java.awt.Color(0, 0, 0));
    leftButton.setFont(new java.awt.Font("Courier New", 1, 13)); // NOI18N
    leftButton.setForeground(new java.awt.Color(255, 255, 255));
    leftButton.setText("A");
    leftButton.setActionCommand("");
    leftButton.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
    this.setLayout(layout);
    layout.setHorizontalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(layout.createSequentialGroup()
            .addContainerGap()
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(xButton, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(spaceButton, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addComponent(speedLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(22, 22, 22)
                            .addComponent(speedTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGap(1, 1, 1))
                .addGroup(layout.createSequentialGroup()
                    .addComponent(speedXLabel)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(speedXTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(speedYLabel)
                        .addComponent(timeLabel)
                        .addComponent(massLabel))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(speedYTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 97, Short.MAX_VALUE)
                        .addComponent(massTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 97, Short.MAX_VALUE)
                        .addComponent(engineTextField))))
            .addGap(18, 18, 18)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(fuelTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(18, 18, 18)
                    .addComponent(thrustTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createSequentialGroup()
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(fuelLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(10, 10, 10)
                            .addComponent(fluelSlider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGap(18, 18, 18)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(10, 10, 10)
                            .addComponent(thrustSlider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(thrustLabel))))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(angleLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(angleTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(compassPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(upButton, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(leftButton, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(downButton, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rightButton, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(3, 3, 3))))
            .addGap(15, 15, Short.MAX_VALUE))
    );
    layout.setVerticalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(layout.createSequentialGroup()
            .addGap(17, 17, 17)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(compassPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(angleTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(angleLabel))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(upButton, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(downButton, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(rightButton, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(leftButton, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(layout.createSequentialGroup()
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(fuelTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(thrustTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(speedLabel)
                        .addComponent(speedTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(fuelLabel)
                                .addComponent(thrustLabel))
                            .addGap(9, 9, 9)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(fluelSlider, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(thrustSlider, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(31, 31, 31)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(speedXLabel)
                                    .addGap(27, 27, 27)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(speedYLabel)
                                        .addComponent(speedYTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addComponent(speedXTextField, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(14, 14, 14)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(engineTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(timeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(13, 13, 13)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(massLabel)
                                .addComponent(massTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(spaceButton, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(xButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel angleLabel;
    private javax.swing.JTextField angleTextField;
    private javax.swing.JPanel compassPanel;
    public javax.swing.JButton downButton;
    public javax.swing.JTextField engineTextField;
    private javax.swing.JSlider fluelSlider;
    private javax.swing.JLabel fuelLabel;
    private javax.swing.JTextField fuelTextField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JSlider jSlider2;
    private javax.swing.JSlider jSlider3;
    public javax.swing.JButton leftButton;
    private javax.swing.JLabel massLabel;
    private javax.swing.JTextField massTextField;
    public javax.swing.JButton rightButton;
    public javax.swing.JButton spaceButton;
    private javax.swing.JLabel speedLabel;
    private javax.swing.JTextField speedTextField;
    private javax.swing.JLabel speedXLabel;
    private javax.swing.JTextField speedXTextField;
    private javax.swing.JLabel speedYLabel;
    private javax.swing.JTextField speedYTextField;
    private javax.swing.JLabel thrustLabel;
    public javax.swing.JSlider thrustSlider;
    private javax.swing.JTextField thrustTextField;
    private javax.swing.JLabel timeLabel;
    public javax.swing.JButton upButton;
    public javax.swing.JButton xButton;
    // End of variables declaration//GEN-END:variables
}
