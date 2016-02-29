package mangocannon;

import java.awt.Graphics;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Shape;
import java.util.ArrayList;
import javax.swing.JOptionPane;


public class FieldOverviewGUI extends javax.swing.JFrame {
    GlobalVariables globalVar;
    int mouseX, mouseY;
    ArrayList<Shape> shapes = new ArrayList<Shape>();
    ArrayList<Shape> sensorShapes = new ArrayList<Shape>();
    Shape drawingShape;
    ArrayList<String> ShapeFieldNames = new ArrayList<String>();

    public FieldOverviewGUI() {
        initComponents();
        //WORK FROM HERE!
        mouseX = -1;
        mouseY = -1;
    }

    public void setGlobalVars(GlobalVariables usingVar) {
        globalVar = usingVar;
        
        for (Field field : globalVar.currentFarm)
        {
            Shape shape = null;
            int posX = field.getBoundaries().get(0).getGlobalPosition()[0];
            int posY = field.getBoundaries().get(0).getGlobalPosition()[1];
            int width = field.getBoundaries().get(3).getGlobalPosition()[0] - field.getBoundaries().get(0).getGlobalPosition()[0];
            int height = field.getBoundaries().get(3).getGlobalPosition()[1] - field.getBoundaries().get(0).getGlobalPosition()[1];

            //if (width!= 0 && height != 0)
            shape = new Rectangle(posX, posY, width, height);
            
            if (shape != null) {
                this.shapes.add(shape);
                ShapeFieldNames.add(field.getFieldName());
            }
            
            for (Sensor sensor : field.getFieldStation().getSensors())
            {
                Shape sShape = null;
                posX = sensor.getLocation().getGlobalPosition()[0] - 3;
                posY = sensor.getLocation().getGlobalPosition()[1] - 3;
                width = 6;
                height = 6;
                
                sShape = new Rectangle(posX, posY, width, height);
            
                if (sShape != null) {
                    this.sensorShapes.add(sShape);
                }
            }
        }
        
        for (Sensor sensor : globalVar.unallocatedSensors)
        {
            Shape sShape = null;
            int posX = sensor.getLocation().getGlobalPosition()[0] - 3;
            int posY = sensor.getLocation().getGlobalPosition()[1] - 3;
            int width = 6;
            int height = 6;
                
            sShape = new Rectangle(posX, posY, width, height);
            
                if (sShape != null) {
                    this.sensorShapes.add(sShape);
                }
        }
        
        
        this.repaint();
    }
    
    public void paint(Graphics g) {
        paintComponents(g);
        Graphics2D g2 = (Graphics2D)g;
        Color transColour = new Color(0, 252, 0, 128);
        Color fieldColour = new Color(71, 152, 245, 128);
        Color sensorColour = new Color(255, 0, 0);
        int i = 0;
        for (Shape shape : shapes) {
          int shapeX = shape.getBounds().x + 3,
              shapeY = shape.getBounds().y + 25,
              widthX = shape.getBounds().width,
              heightY = shape.getBounds().height;
          if ((shapeX + widthX > jScrollPane1.getHorizontalScrollBar().getValue()) && (shapeX < jScrollPane1.getHorizontalScrollBar().getValue() + jScrollPane1.getWidth()) && (shapeY < jScrollPane1.getVerticalScrollBar().getValue() + jScrollPane1.getHeight()) && (shapeY + heightY > jScrollPane1.getVerticalScrollBar().getValue()))
          {
            int xCoord = shapeX - jScrollPane1.getHorizontalScrollBar().getValue();
            int yCoord = shapeY - jScrollPane1.getVerticalScrollBar().getValue();
            if ((yCoord + heightY) > 638)
            {
                heightY = 638 - yCoord;
            }
            if ((xCoord + widthX) > 694)
            {
                widthX = 694 - xCoord;
            }
            Shape moveShape = new Rectangle(xCoord, yCoord, widthX, heightY);
            g2.setColor(fieldColour);
            g2.fill(moveShape);
            g2.setColor(Color.black);
            g2.draw(moveShape);
            g2.setColor(Color.WHITE);
            g2.drawString(ShapeFieldNames.get(i), xCoord, yCoord);
          }
          i++;
        }

        for (Shape shape : sensorShapes) {
          int shapeX = shape.getBounds().x + 3,
              shapeY = shape.getBounds().y + 25,
              widthX = shape.getBounds().width,
              heightY = shape.getBounds().height;
          if ((shapeX + widthX > jScrollPane1.getHorizontalScrollBar().getValue()) && (shapeX < jScrollPane1.getHorizontalScrollBar().getValue() + jScrollPane1.getWidth()) && (shapeY < jScrollPane1.getVerticalScrollBar().getValue() + jScrollPane1.getHeight()) && (shapeY + heightY > jScrollPane1.getVerticalScrollBar().getValue()))
          {
            int xCoord = shapeX - jScrollPane1.getHorizontalScrollBar().getValue();
            int yCoord = shapeY - jScrollPane1.getVerticalScrollBar().getValue();
            if ((yCoord + heightY) > 638)
            {
                heightY = 638 - yCoord;
            }
            if ((xCoord + widthX) > 694)
            {
                widthX = 694 - xCoord;
            }
            Shape moveShape = new Rectangle(xCoord, yCoord, widthX, heightY);
            g2.setColor(sensorColour);
            g2.fill(moveShape);
            g2.setColor(Color.black);
            g2.draw(moveShape);
          }
        }
        
        if (drawingShape != null)
        {
            int shapeX = drawingShape.getBounds().x + 1,
              shapeY = drawingShape.getBounds().y,
              widthX = drawingShape.getBounds().width,
              heightY = drawingShape.getBounds().height;
            
            if ((shapeX + widthX > jScrollPane1.getHorizontalScrollBar().getValue()) && (shapeX < jScrollPane1.getHorizontalScrollBar().getValue() + jScrollPane1.getWidth()) && (shapeY < jScrollPane1.getVerticalScrollBar().getValue() + jScrollPane1.getHeight()) && (shapeY + heightY > jScrollPane1.getVerticalScrollBar().getValue()))
            {
                int xCoord = shapeX - jScrollPane1.getHorizontalScrollBar().getValue();
                int yCoord = shapeY - jScrollPane1.getVerticalScrollBar().getValue();
                if ((yCoord + heightY) > 638)
                {
                    heightY = 638 - yCoord;
                }
                if ((xCoord + widthX) > 694)
                {
                    widthX = 694 - xCoord;
                }
                Shape moveShape = new Rectangle(xCoord, yCoord, widthX, heightY);
                g2.setColor(transColour);
                g2.fill(moveShape);
                g2.setColor(Color.black);
                g2.draw(moveShape);
            }
        }
    }


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBounds(new java.awt.Rectangle(0, 23, 1000, 1000));
        setResizable(false);
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                MouseClicked(evt);
            }
        });

        jScrollPane1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mouseClick(evt);
            }
        });
        jScrollPane1.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                scrollChangedListener(evt);
            }
        });

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mangocannon/fieldOverview.png"))); // NOI18N
        jLabel1.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                FieldOverviewGUI.this.mouseMoved(evt);
            }
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                recordDrag(evt);
            }
        });
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                FieldOverviewGUI.this.mousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                MouseUp(evt);
            }
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                FieldOverviewGUI.this.mouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jLabel1);

        jLabel2.setText("Add Sensor");
        jLabel2.setToolTipText("");

        jButton2.setText("Add");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Close");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 549, Short.MAX_VALUE)
                .addComponent(jButton3)
                .addGap(14, 14, 14))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 635, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jButton2)
                    .addComponent(jButton3))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void mouseClick(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mouseClick
        
    }//GEN-LAST:event_mouseClick

    private void recordDrag(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_recordDrag
        
    }//GEN-LAST:event_recordDrag

    private void MouseUp(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MouseUp
        
    }//GEN-LAST:event_MouseUp

    private void mousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mousePressed
        
    }//GEN-LAST:event_mousePressed

    private void mouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mouseClicked
        mouseX = evt.getX();
        mouseY = evt.getY();

        Shape shape = new Rectangle(mouseX - 3, mouseY + 18, 6, 6);
        
        drawingShape = shape;
        this.repaint();
        
        mouseX = -1;
        mouseY = -1;
    }//GEN-LAST:event_mouseClicked

    private void mouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mouseMoved
        
    }//GEN-LAST:event_mouseMoved

    private void scrollChangedListener(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_scrollChangedListener
        // TODO add your handling code here:
        this.repaint();
    }//GEN-LAST:event_scrollChangedListener

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        globalVar.workingField = -1;
        GPS newGPS = new GPS(drawingShape.getBounds().x + 3, drawingShape.getBounds().y - 22);
        globalVar.workingGPS = newGPS;
        /*for (Field field : globalVar.currentFarm)
        {
            if (field.isInside(newGPS))
               globalVar.workingField = field;
        }*/
        for (int i = 0; i < globalVar.currentFarm.size(); i++)
        {
            Field field = globalVar.currentFarm.get(i);
            if (field.isInside(newGPS))
                globalVar.workingField = i;
        }
        
        CreateSensorGUI sensorGUI = new CreateSensorGUI();
        sensorGUI.setVisible(true);
        sensorGUI.setGlobalVars(globalVar);
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_MouseClicked

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
            java.util.logging.Logger.getLogger(FieldOverviewGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FieldOverviewGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FieldOverviewGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FieldOverviewGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FieldOverviewGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
