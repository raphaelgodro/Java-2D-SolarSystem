
package Viewer;

import Model.Model;


public class StartButtonPanel extends javax.swing.JPanel {

    Model m;
    int w = 250;
    int h = 202;
    
    public StartButtonPanel(Model m) {
        this.m = m;
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        solarSystemButton = new javax.swing.JButton();
        sandBoxButton = new javax.swing.JButton();
        creditButton = new javax.swing.JButton();
        exitButton = new javax.swing.JButton();

        setBackground(new java.awt.Color(0, 0, 0));
        setOpaque(false);

        solarSystemButton.setBackground(new java.awt.Color(0, 0, 0));
        solarSystemButton.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        solarSystemButton.setForeground(new java.awt.Color(255, 255, 255));
        solarSystemButton.setText("Our Solar System");
        solarSystemButton.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        solarSystemButton.setBorderPainted(false);

        sandBoxButton.setBackground(new java.awt.Color(0, 0, 0));
        sandBoxButton.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        sandBoxButton.setForeground(new java.awt.Color(255, 255, 255));
        sandBoxButton.setText("SandBox");
        sandBoxButton.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        sandBoxButton.setBorderPainted(false);

        creditButton.setBackground(new java.awt.Color(0, 0, 0));
        creditButton.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        creditButton.setForeground(new java.awt.Color(255, 255, 255));
        creditButton.setText("Credits");
        creditButton.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        creditButton.setBorderPainted(false);

        exitButton.setBackground(new java.awt.Color(0, 0, 0));
        exitButton.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        exitButton.setForeground(new java.awt.Color(255, 255, 255));
        exitButton.setText("Quit");
        exitButton.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        exitButton.setBorderPainted(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(creditButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(sandBoxButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(solarSystemButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
            .addComponent(exitButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(solarSystemButton, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sandBoxButton, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(creditButton, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(exitButton, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton creditButton;
    public javax.swing.JButton exitButton;
    public javax.swing.JButton sandBoxButton;
    public javax.swing.JButton solarSystemButton;
    // End of variables declaration//GEN-END:variables
}
