/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mangocannon;

import java.util.Vector;

/**
 *
 * @author cameron
 */
public class SensorDataGUI extends javax.swing.JFrame {
    GlobalVariables globalVar;
    Vector<Float> dataReadings = new Vector<Float>();
    int remainingTime = 0;
    /**
     * Creates new form SensorData
     */
    public SensorDataGUI() {
        initComponents();
        btnTakeReading.setVisible(false);
    }
    
    /**
     * Here we set the global variables, by passing in the current object of vars we are using.
     * We also initialise some of the objects on the GUI to data that has been set.
     * @param theVars 
     */
    public void setGlobalVars(GlobalVariables theVars) {
        globalVar = theVars;
        lblSensorInfo.setText("You are workong on the sensor: " + globalVar.workingSensor.getSensorTypeName() + ".");
        lblSensorIntervals.setText("The sensor will be polling every " + globalVar.workingSensor.getSensorType().getTimeInterval() + " seconds.");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSlider1 = new javax.swing.JSlider();
        lblTimeLeft = new javax.swing.JLabel();
        btnStartPolling = new javax.swing.JButton();
        btnClose = new javax.swing.JButton();
        lblSensorInfo = new javax.swing.JLabel();
        txtBoxTimer = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        lblSensorIntervals = new javax.swing.JLabel();
        btnTakeReading = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblTimeLeft.setText("Time Left: N/A");

        btnStartPolling.setText("Start Polling");
        btnStartPolling.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStartPollingActionPerformed(evt);
            }
        });

        btnClose.setText("Finish & Close");
        btnClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCloseActionPerformed(evt);
            }
        });

        lblSensorInfo.setText("jLabel1");

        jLabel1.setText("Enter a time in seconds and click Start Polling!");

        lblSensorIntervals.setText("jLabel2");

        btnTakeReading.setText("Take Reading");
        btnTakeReading.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTakeReadingActionPerformed(evt);
            }
        });

        jLabel2.setText("0");

        jLabel3.setText("100");

        jLabel4.setText("50");

        jLabel5.setText("25");

        jLabel6.setText("75");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblSensorIntervals)
                            .addComponent(lblSensorInfo)))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addGap(46, 46, 46)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel1)
                                .addComponent(txtBoxTimer, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel2)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel5)
                                    .addGap(56, 56, 56)
                                    .addComponent(jLabel4)
                                    .addGap(128, 128, 128)
                                    .addComponent(jLabel3))))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addGap(37, 37, 37)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jSlider1, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(btnStartPolling)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnClose)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(154, 154, 154)
                        .addComponent(lblTimeLeft)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(btnTakeReading))))
                .addContainerGap(13, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblSensorInfo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblSensorIntervals)
                .addGap(12, 12, 12)
                .addComponent(jSlider1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6))
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTimeLeft)
                    .addComponent(btnTakeReading))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtBoxTimer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnClose)
                    .addComponent(btnStartPolling))
                .addGap(40, 40, 40))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Takes the time set by the user and starts the countdown.
     * old code is left in - hwoever the odl code requires multithreading
     * @param evt 
     */
    private void btnStartPollingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStartPollingActionPerformed
        dataReadings.clear();
        remainingTime = Integer.parseInt(txtBoxTimer.getText());
        btnStartPolling.setEnabled(false);
        btnTakeReading.setVisible(true);
        lblTimeLeft.setText("Time left: " + remainingTime);
        txtBoxTimer.setEnabled(false);
        /*if (timeLength > 0)
        {
            for (int i = timeLength; i >= 0; i--)
            {
                if (i % globalVar.workingSensor.getSensorType().getTimeInterval() == 0)
                {
                    dataReadings.add((float) jSlider1.getValue());
                }
                lblTimeLeft.setText("Time left: " + i);
                
            }
            System.out.println(dataReadings);
        }*/
        //System.out.println(timeLength);
    }//GEN-LAST:event_btnStartPollingActionPerformed

    private void btnCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCloseActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCloseActionPerformed

    /**
     * clicking this button gets the current position of the slider and adds it to the dataReading of 
     * the current sensor
     * @param evt 
     */
    private void btnTakeReadingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTakeReadingActionPerformed
        if (remainingTime >= 0)
        {
            dataReadings.add((float) jSlider1.getValue());
            remainingTime -= globalVar.workingSensor.getSensorType().getTimeInterval();
            lblTimeLeft.setText("Time left: " + remainingTime);
            if (remainingTime < 0)
            {
                btnTakeReading.setEnabled(false);
                lblTimeLeft.setText("Finished");
                DataReading newData = new DataReading();
                newData.setReadings(dataReadings);
                globalVar.workingSensor.setDataReadings(newData);
            }
        }
    }//GEN-LAST:event_btnTakeReadingActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(SensorDataGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SensorDataGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SensorDataGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SensorDataGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SensorDataGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClose;
    private javax.swing.JButton btnStartPolling;
    private javax.swing.JButton btnTakeReading;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JSlider jSlider1;
    private javax.swing.JLabel lblSensorInfo;
    private javax.swing.JLabel lblSensorIntervals;
    private javax.swing.JLabel lblTimeLeft;
    private javax.swing.JTextField txtBoxTimer;
    // End of variables declaration//GEN-END:variables
}
