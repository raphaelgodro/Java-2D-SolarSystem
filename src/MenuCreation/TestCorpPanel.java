/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MenuCreation;

/**
 *
 * @author Hatchery
 */
public class TestCorpPanel extends javax.swing.JPanel {

    /**
     * Creates new form TestCorpPanel
     */
    public TestCorpPanel() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabelMass1 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jPanelImg = new javax.swing.JPanel();
        jLabelTitle = new javax.swing.JLabel();
        jLabelPosition = new javax.swing.JLabel();
        jTextFieldMass = new javax.swing.JTextField();
        jLabelMass = new javax.swing.JLabel();
        jLabelX = new javax.swing.JLabel();
        jTextFieldX = new javax.swing.JTextField();
        jLabelY = new javax.swing.JLabel();
        jTextFieldY = new javax.swing.JTextField();
        jLabelSpeed = new javax.swing.JLabel();
        jTextFieldSpeed = new javax.swing.JTextField();
        jLabelRadius = new javax.swing.JLabel();
        jTextFieldRadius = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextAreaCorpDescription = new javax.swing.JTextArea();
        jButtonNext = new javax.swing.JButton();
        jButtonBack = new javax.swing.JButton();

        jLabelMass1.setText("Mass (KG)");

        jButton2.setBackground(new java.awt.Color(0, 0, 0));
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText(">");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        setBackground(new java.awt.Color(0, 0, 0));

        jPanelImg.setBackground(new java.awt.Color(0, 0, 0));
        jPanelImg.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 255, 102)));

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

        jLabelTitle.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabelTitle.setForeground(new java.awt.Color(255, 255, 255));
        jLabelTitle.setText("THE EARTH");

        jLabelPosition.setForeground(new java.awt.Color(255, 255, 255));
        jLabelPosition.setText("Position (au)");

        jTextFieldMass.setText("jTextField1");
        jTextFieldMass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldMassActionPerformed(evt);
            }
        });

        jLabelMass.setForeground(new java.awt.Color(255, 255, 255));
        jLabelMass.setText("Mass (kg)");

        jLabelX.setForeground(new java.awt.Color(255, 255, 255));
        jLabelX.setText("X :");

        jTextFieldX.setText("jTextField1");
        jTextFieldX.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldXActionPerformed(evt);
            }
        });

        jLabelY.setForeground(new java.awt.Color(255, 255, 255));
        jLabelY.setText("Y :");

        jTextFieldY.setText("jTextField2");
        jTextFieldY.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldYActionPerformed(evt);
            }
        });

        jLabelSpeed.setBackground(new java.awt.Color(0, 0, 0));
        jLabelSpeed.setForeground(new java.awt.Color(255, 255, 255));
        jLabelSpeed.setText("Speed (m/s)");

        jTextFieldSpeed.setText("jTextField1");
        jTextFieldSpeed.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldSpeedActionPerformed(evt);
            }
        });

        jLabelRadius.setForeground(new java.awt.Color(255, 255, 255));
        jLabelRadius.setText("Radius (m)");

        jTextFieldRadius.setText("jTextField1");
        jTextFieldRadius.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldRadiusActionPerformed(evt);
            }
        });

        jTextAreaCorpDescription.setBackground(new java.awt.Color(51, 51, 51));
        jTextAreaCorpDescription.setColumns(20);
        jTextAreaCorpDescription.setFont(new java.awt.Font("Minion Pro SmBd", 0, 14)); // NOI18N
        jTextAreaCorpDescription.setForeground(new java.awt.Color(255, 255, 255));
        jTextAreaCorpDescription.setRows(5);
        jTextAreaCorpDescription.setText("All the rivers of blood, spilt by generations of ");
        jScrollPane1.setViewportView(jTextAreaCorpDescription);

        jButtonNext.setBackground(new java.awt.Color(0, 0, 0));
        jButtonNext.setForeground(new java.awt.Color(255, 255, 255));
        jButtonNext.setText(">");
        jButtonNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonNextActionPerformed(evt);
            }
        });

        jButtonBack.setBackground(new java.awt.Color(0, 0, 0));
        jButtonBack.setForeground(new java.awt.Color(255, 255, 255));
        jButtonBack.setText("<");
        jButtonBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBackActionPerformed(evt);
            }
        });

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
                        .addComponent(jLabelRadius, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldRadius))
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
                    .addComponent(jLabelRadius, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldRadius, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 143, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jTextFieldMassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldMassActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldMassActionPerformed

    private void jTextFieldXActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldXActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldXActionPerformed

    private void jTextFieldYActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldYActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldYActionPerformed

    private void jTextFieldSpeedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldSpeedActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldSpeedActionPerformed

    private void jTextFieldRadiusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldRadiusActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldRadiusActionPerformed

    private void jButtonNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonNextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonNextActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButtonBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBackActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonBackActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButtonBack;
    private javax.swing.JButton jButtonNext;
    private javax.swing.JLabel jLabelMass;
    private javax.swing.JLabel jLabelMass1;
    private javax.swing.JLabel jLabelPosition;
    private javax.swing.JLabel jLabelRadius;
    private javax.swing.JLabel jLabelSpeed;
    private javax.swing.JLabel jLabelTitle;
    private javax.swing.JLabel jLabelX;
    private javax.swing.JLabel jLabelY;
    private javax.swing.JPanel jPanelImg;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextAreaCorpDescription;
    private javax.swing.JTextField jTextFieldMass;
    private javax.swing.JTextField jTextFieldRadius;
    private javax.swing.JTextField jTextFieldSpeed;
    private javax.swing.JTextField jTextFieldX;
    private javax.swing.JTextField jTextFieldY;
    // End of variables declaration//GEN-END:variables
}
