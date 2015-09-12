
package Viewer;

import Model.Model;


public class TimePanel extends javax.swing.JPanel {

    Model m;
    double currentDayperSecond;
    int width;
    int height;
    
    public TimePanel(Model m) {
        this.m = m;
        initComponents();
        currentDayperSecond = (( m.pps * m.deltaT) / (double) (3600*24));
        currentDayperSecond = (double)Math.round(currentDayperSecond * 100) / 100;
        jTextField1.setText(Double.toString(currentDayperSecond));
        width = 240;
        height = 69;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        dpsLabel = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jSlider1 = new javax.swing.JSlider();

        setBackground(new java.awt.Color(0, 0, 0));
        setBorder(new javax.swing.border.LineBorder(new java.awt.Color(57, 156, 226), 1, true));

        dpsLabel.setBackground(new java.awt.Color(0, 0, 0));
        dpsLabel.setFont(new java.awt.Font("Courier New", 1, 13)); // NOI18N
        dpsLabel.setForeground(new java.awt.Color(255, 255, 255));
        dpsLabel.setText("Day / s :");

        jTextField1.setBackground(new java.awt.Color(0, 0, 0));
        jTextField1.setFont(new java.awt.Font("Courier New", 1, 13)); // NOI18N
        jTextField1.setForeground(new java.awt.Color(255, 255, 255));
        jTextField1.setText("jTextField1");

        jSlider1.setBackground(new java.awt.Color(0, 0, 0));
        jSlider1.setFont(new java.awt.Font("Courier New", 1, 13)); // NOI18N
        jSlider1.setForeground(new java.awt.Color(255, 255, 255));
        jSlider1.setMajorTickSpacing(10);
        jSlider1.setPaintTicks(true);
        jSlider1.setValue(0);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(dpsLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField1)
                .addContainerGap())
            .addComponent(jSlider1, javax.swing.GroupLayout.DEFAULT_SIZE, 238, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(dpsLabel)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSlider1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(3, 3, 3))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel dpsLabel;
    public javax.swing.JSlider jSlider1;
    public javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
