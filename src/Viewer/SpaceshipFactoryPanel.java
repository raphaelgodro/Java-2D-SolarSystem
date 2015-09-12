
package Viewer;

import Model.Model;

public class SpaceshipFactoryPanel extends javax.swing.JPanel {

    
    public SpaceshipFactoryPanel(Model m) {
        setVisible(false);
        initComponents();
    }
    
    public void resetValues(){
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bcLabel = new javax.swing.JLabel();
        bcSlider = new javax.swing.JSlider();
        tpnLabel = new javax.swing.JLabel();
        tpnSlider = new javax.swing.JSlider();
        avSpeedLabel = new javax.swing.JLabel();
        aveSpeedSlider = new javax.swing.JSlider();
        initPosLabel = new javax.swing.JLabel();
        intiPosSlider = new javax.swing.JSlider();
        fuelLabel = new javax.swing.JLabel();
        fuelTextField = new javax.swing.JTextField();
        massLabel = new javax.swing.JLabel();
        massTextField = new javax.swing.JTextField();
        showcasePanel = new javax.swing.JPanel();
        lButton = new javax.swing.JButton();
        rButton = new javax.swing.JButton();
        nameLabel = new javax.swing.JLabel();
        nameTextField = new javax.swing.JTextField();
        oRatioLabel = new javax.swing.JLabel();
        oRatioTextField = new javax.swing.JTextField();
        okButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();

        setBackground(new java.awt.Color(0, 0, 0));
        setBorder(new javax.swing.border.LineBorder(new java.awt.Color(57, 156, 226), 1, true));
        setForeground(new java.awt.Color(255, 255, 255));

        bcLabel.setBackground(new java.awt.Color(0, 0, 0));
        bcLabel.setFont(new java.awt.Font("Courier New", 1, 13)); // NOI18N
        bcLabel.setForeground(new java.awt.Color(255, 255, 255));
        bcLabel.setText("Battery Capacity [W]");

        bcSlider.setBackground(new java.awt.Color(0, 0, 0));
        bcSlider.setForeground(new java.awt.Color(255, 255, 255));
        bcSlider.setMajorTickSpacing(10);
        bcSlider.setPaintTicks(true);
        bcSlider.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 204, 0)));

        tpnLabel.setBackground(new java.awt.Color(0, 0, 0));
        tpnLabel.setFont(new java.awt.Font("Courier New", 1, 13)); // NOI18N
        tpnLabel.setForeground(new java.awt.Color(255, 255, 255));
        tpnLabel.setText("Thrust power     [N]");

        tpnSlider.setBackground(new java.awt.Color(0, 0, 0));
        tpnSlider.setForeground(new java.awt.Color(255, 255, 255));
        tpnSlider.setMajorTickSpacing(10);
        tpnSlider.setPaintTicks(true);
        tpnSlider.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));

        avSpeedLabel.setBackground(new java.awt.Color(0, 0, 0));
        avSpeedLabel.setFont(new java.awt.Font("Courier New", 1, 13)); // NOI18N
        avSpeedLabel.setForeground(new java.awt.Color(255, 255, 255));
        avSpeedLabel.setText(" Average speed  [m/s]");

        aveSpeedSlider.setBackground(new java.awt.Color(0, 0, 0));
        aveSpeedSlider.setMajorTickSpacing(10);
        aveSpeedSlider.setPaintTicks(true);
        aveSpeedSlider.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));

        initPosLabel.setBackground(new java.awt.Color(0, 0, 0));
        initPosLabel.setFont(new java.awt.Font("Courier New", 1, 13)); // NOI18N
        initPosLabel.setForeground(new java.awt.Color(255, 255, 255));
        initPosLabel.setText("Initial position [A.U.]");

        intiPosSlider.setBackground(new java.awt.Color(0, 0, 0));
        intiPosSlider.setMajorTickSpacing(2);
        intiPosSlider.setMaximum(20);
        intiPosSlider.setPaintTicks(true);
        intiPosSlider.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));

        fuelLabel.setBackground(new java.awt.Color(0, 0, 0));
        fuelLabel.setFont(new java.awt.Font("Courier New", 1, 13)); // NOI18N
        fuelLabel.setForeground(new java.awt.Color(255, 255, 255));
        fuelLabel.setText("Fuel  [Kg]");

        fuelTextField.setBackground(new java.awt.Color(0, 0, 0));
        fuelTextField.setFont(new java.awt.Font("Courier New", 1, 13)); // NOI18N
        fuelTextField.setForeground(new java.awt.Color(255, 255, 255));
        fuelTextField.setText("jTextField1");
        fuelTextField.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));

        massLabel.setFont(new java.awt.Font("Courier New", 1, 13)); // NOI18N
        massLabel.setForeground(new java.awt.Color(255, 255, 255));
        massLabel.setText("Mass  [Kg]");

        massTextField.setEditable(false);
        massTextField.setBackground(new java.awt.Color(0, 0, 0));
        massTextField.setFont(new java.awt.Font("Courier New", 1, 13)); // NOI18N
        massTextField.setForeground(new java.awt.Color(255, 204, 0));
        massTextField.setText("20000");
        massTextField.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        massTextField.setEnabled(false);

        showcasePanel.setBackground(new java.awt.Color(102, 102, 102));

        javax.swing.GroupLayout showcasePanelLayout = new javax.swing.GroupLayout(showcasePanel);
        showcasePanel.setLayout(showcasePanelLayout);
        showcasePanelLayout.setHorizontalGroup(
            showcasePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 187, Short.MAX_VALUE)
        );
        showcasePanelLayout.setVerticalGroup(
            showcasePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 187, Short.MAX_VALUE)
        );

        lButton.setBackground(new java.awt.Color(0, 0, 0));
        lButton.setFont(new java.awt.Font("Courier New", 1, 13)); // NOI18N
        lButton.setForeground(new java.awt.Color(255, 255, 255));
        lButton.setText("<");
        lButton.setBorder(null);

        rButton.setBackground(new java.awt.Color(0, 0, 0));
        rButton.setFont(new java.awt.Font("Courier New", 1, 13)); // NOI18N
        rButton.setForeground(new java.awt.Color(255, 255, 255));
        rButton.setText(">");
        rButton.setBorder(null);

        nameLabel.setBackground(new java.awt.Color(0, 0, 0));
        nameLabel.setFont(new java.awt.Font("Courier New", 1, 13)); // NOI18N
        nameLabel.setForeground(new java.awt.Color(255, 255, 255));
        nameLabel.setText("Spaceship name");

        nameTextField.setBackground(new java.awt.Color(0, 0, 0));
        nameTextField.setFont(new java.awt.Font("Courier New", 1, 13)); // NOI18N
        nameTextField.setForeground(new java.awt.Color(255, 255, 255));
        nameTextField.setText("jTextField3");
        nameTextField.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));

        oRatioLabel.setBackground(new java.awt.Color(0, 0, 0));
        oRatioLabel.setFont(new java.awt.Font("Courier New", 1, 13)); // NOI18N
        oRatioLabel.setForeground(new java.awt.Color(255, 255, 255));
        oRatioLabel.setText("Rotation [ °/s ]");

        oRatioTextField.setBackground(new java.awt.Color(102, 102, 102));
        oRatioTextField.setFont(new java.awt.Font("Courier New", 1, 13)); // NOI18N
        oRatioTextField.setForeground(new java.awt.Color(255, 255, 255));
        oRatioTextField.setText("jTextField4");
        oRatioTextField.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));

        okButton.setBackground(new java.awt.Color(0, 0, 0));
        okButton.setFont(new java.awt.Font("Courier New", 1, 13)); // NOI18N
        okButton.setForeground(new java.awt.Color(255, 255, 255));
        okButton.setText("OK");
        okButton.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));

        cancelButton.setBackground(new java.awt.Color(0, 0, 0));
        cancelButton.setFont(new java.awt.Font("Courier New", 1, 13)); // NOI18N
        cancelButton.setForeground(new java.awt.Color(255, 153, 0));
        cancelButton.setText("Cancel");
        cancelButton.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 153, 0)));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(bcSlider, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(tpnSlider, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(aveSpeedSlider, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(intiPosSlider, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(bcLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tpnLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(avSpeedLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(fuelLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(initPosLabel)
                            .addComponent(massLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(fuelTextField)
                            .addComponent(massTextField))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(showcasePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(lButton, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(rButton, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(nameTextField)
                                    .addComponent(oRatioTextField)
                                    .addComponent(nameLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(oRatioLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(cancelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(okButton, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(14, 14, 14))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(bcLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bcSlider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tpnLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tpnSlider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(avSpeedLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(aveSpeedSlider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(showcasePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(initPosLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(intiPosSlider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lButton, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(rButton, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fuelLabel)
                    .addComponent(nameLabel))
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fuelTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(massLabel)
                    .addComponent(oRatioLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(oRatioTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(massTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(okButton, javax.swing.GroupLayout.DEFAULT_SIZE, 44, Short.MAX_VALUE)
                    .addComponent(cancelButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(13, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel avSpeedLabel;
    public javax.swing.JSlider aveSpeedSlider;
    private javax.swing.JLabel bcLabel;
    public javax.swing.JSlider bcSlider;
    public javax.swing.JButton cancelButton;
    private javax.swing.JLabel fuelLabel;
    public javax.swing.JTextField fuelTextField;
    private javax.swing.JLabel initPosLabel;
    public javax.swing.JSlider intiPosSlider;
    public javax.swing.JButton lButton;
    private javax.swing.JLabel massLabel;
    public javax.swing.JTextField massTextField;
    private javax.swing.JLabel nameLabel;
    public javax.swing.JTextField nameTextField;
    private javax.swing.JLabel oRatioLabel;
    public javax.swing.JTextField oRatioTextField;
    public javax.swing.JButton okButton;
    public javax.swing.JButton rButton;
    public javax.swing.JPanel showcasePanel;
    private javax.swing.JLabel tpnLabel;
    public javax.swing.JSlider tpnSlider;
    // End of variables declaration//GEN-END:variables
}
