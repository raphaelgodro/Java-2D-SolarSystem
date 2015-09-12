
package Viewer;

import Model.Model;


public class ZoomPanel extends javax.swing.JPanel {

    Model m;
    public int width = 240;
    public int height = 70;
    
    public ZoomPanel(Model m){
        this.m = m;
        initComponents();
    }
    
    public void setZoomValue() 
    {
        Double zoomValue = (double)Math.round(m.cameraZoom * 10000) / 100; 
        zoomTexteField.setText(Double.toString(zoomValue));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        zommLabel = new javax.swing.JLabel();
        zoomTexteField = new javax.swing.JTextField();
        zoomSlider = new javax.swing.JSlider();

        setBackground(new java.awt.Color(0, 0, 0));
        setBorder(new javax.swing.border.LineBorder(new java.awt.Color(57, 156, 226), 1, true));
        setPreferredSize(new java.awt.Dimension(240, 70));

        zommLabel.setBackground(new java.awt.Color(0, 0, 0));
        zommLabel.setFont(new java.awt.Font("Courier New", 1, 16)); // NOI18N
        zommLabel.setForeground(new java.awt.Color(255, 255, 255));
        zommLabel.setText("Zoom % :");

        zoomTexteField.setBackground(new java.awt.Color(0, 0, 0));
        zoomTexteField.setFont(new java.awt.Font("Courier New", 1, 13)); // NOI18N
        zoomTexteField.setForeground(new java.awt.Color(255, 255, 255));
        zoomTexteField.setText(String.valueOf((double)Math.round(m.cameraZoom * 10000) / 100));

        zoomSlider.setBackground(new java.awt.Color(0, 0, 0));
        zoomSlider.setMajorTickSpacing(10);
        zoomSlider.setPaintTicks(true);
        zoomSlider.setValue((int)(10*((1/0.762)*Math.log((1/0.762)*m.cameraZoom))));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(zommLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(zoomTexteField)
                .addContainerGap())
            .addComponent(zoomSlider, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 238, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(zoomTexteField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(zommLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(zoomSlider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel zommLabel;
    public javax.swing.JSlider zoomSlider;
    public javax.swing.JTextField zoomTexteField;
    // End of variables declaration//GEN-END:variables
}
