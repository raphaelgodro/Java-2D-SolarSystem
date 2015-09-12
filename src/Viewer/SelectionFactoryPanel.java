
package Viewer;

import Model.Model;


public class SelectionFactoryPanel extends javax.swing.JPanel {

    Model m;
    int width = 248;
    int height = 248;

    public SelectionFactoryPanel(Model m) {
        this.m = m;
        initComponents();
        setVisible(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        addStarButton = new javax.swing.JButton();
        addPlanetButton = new javax.swing.JButton();
        addSatelliteButton = new javax.swing.JButton();
        addAsteroidButton = new javax.swing.JButton();
        addSpaceShipButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();

        setBackground(new java.awt.Color(15, 15, 15));
        setBorder(new javax.swing.border.LineBorder(new java.awt.Color(57, 156, 226), 1, true));

        addStarButton.setBackground(new java.awt.Color(0, 0, 0));
        addStarButton.setFont(new java.awt.Font("Courier New", 1, 13)); // NOI18N
        addStarButton.setForeground(new java.awt.Color(255, 255, 255));
        addStarButton.setText("Star");
        addStarButton.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        addStarButton.setRolloverEnabled(true);

        addPlanetButton.setBackground(new java.awt.Color(0, 0, 0));
        addPlanetButton.setFont(new java.awt.Font("Courier New", 1, 13)); // NOI18N
        addPlanetButton.setForeground(new java.awt.Color(255, 255, 255));
        addPlanetButton.setText("Planet");
        addPlanetButton.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        addSatelliteButton.setBackground(new java.awt.Color(0, 0, 0));
        addSatelliteButton.setFont(new java.awt.Font("Courier New", 1, 13)); // NOI18N
        addSatelliteButton.setForeground(new java.awt.Color(255, 255, 255));
        addSatelliteButton.setText("Satellite");
        addSatelliteButton.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        addAsteroidButton.setBackground(new java.awt.Color(0, 0, 0));
        addAsteroidButton.setFont(new java.awt.Font("Courier New", 1, 13)); // NOI18N
        addAsteroidButton.setForeground(new java.awt.Color(255, 255, 255));
        addAsteroidButton.setText("Asteroid");
        addAsteroidButton.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        addSpaceShipButton.setBackground(new java.awt.Color(0, 0, 0));
        addSpaceShipButton.setFont(new java.awt.Font("Courier New", 1, 13)); // NOI18N
        addSpaceShipButton.setForeground(new java.awt.Color(255, 255, 255));
        addSpaceShipButton.setText("Spaceship");
        addSpaceShipButton.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        cancelButton.setBackground(new java.awt.Color(0, 0, 0));
        cancelButton.setFont(new java.awt.Font("Courier New", 1, 13)); // NOI18N
        cancelButton.setForeground(new java.awt.Color(255, 153, 0));
        cancelButton.setText("Cancel");
        cancelButton.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(addPlanetButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(addSatelliteButton, javax.swing.GroupLayout.DEFAULT_SIZE, 246, Short.MAX_VALUE)
            .addComponent(addAsteroidButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(addSpaceShipButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(cancelButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(addStarButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(addStarButton, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(addPlanetButton, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(addSatelliteButton, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(addAsteroidButton, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(addSpaceShipButton, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cancelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton addAsteroidButton;
    public javax.swing.JButton addPlanetButton;
    public javax.swing.JButton addSatelliteButton;
    public javax.swing.JButton addSpaceShipButton;
    public javax.swing.JButton addStarButton;
    public javax.swing.JButton cancelButton;
    // End of variables declaration//GEN-END:variables
}
