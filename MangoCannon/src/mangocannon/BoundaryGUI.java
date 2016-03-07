package mangocannon;

import java.awt.Graphics;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Shape;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class BoundaryGUI extends javax.swing.JFrame {
    
    GlobalVariables globalVar;
    int mouseStartX, mouseStartY, mouseEndX, mouseEndY;
    ArrayList<Shape> shapes = new ArrayList<Shape>();
    ArrayList<Shape> sensorShapes = new ArrayList<Shape>();
    Shape drawingShape;
    ArrayList<String> ShapeFieldNames = new ArrayList<String>();

    public BoundaryGUI() {
        initComponents();
        //Mouse x and y set to -1 to prevent accidental drawing on form
        mouseStartX = -1;
        mouseStartY = -1;
    }

    //Allows us to use 1 set of information, and pass information between GUI's.
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
        }
        this.repaint();
    }
    
    //Paint method both repaints the GUI and draws on the new stuff that we are displaying on the fields
    public void paint(Graphics g) {
        paintComponents(g);
        Graphics2D g2 = (Graphics2D)g;
        Color transColour = new Color(0, 252, 0, 128);
        Color fieldColour = new Color(71, 152, 245, 128);
        Color sensorColour = new Color(255, 0, 0);
        int i = 0;
        //Draws all the fields in the farm
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

        //Draws the sensors on the GUI, being highlighted in red.
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
        
        //The code for drawing the shape that the user has created by clicking
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
        jLabel3 = new javax.swing.JLabel();
        btnSetBoundaries = new javax.swing.JButton();
        btnViewAllFields = new javax.swing.JButton();
        btnClose = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBounds(new java.awt.Rectangle(0, 23, 1000, 1000));
        setResizable(false);

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
                BoundaryGUI.this.mouseMoved(evt);
            }
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                recordDrag(evt);
            }
        });
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                BoundaryGUI.this.mousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                MouseUp(evt);
            }
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BoundaryGUI.this.mouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jLabel1);

        jLabel2.setText("View current fields");

        jLabel3.setText("Add these boundaries to field");

        btnSetBoundaries.setText("Add");
        btnSetBoundaries.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSetBoundariesActionPerformed(evt);
            }
        });

        btnViewAllFields.setText("View");
        btnViewAllFields.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewAllFieldsActionPerformed(evt);
            }
        });

        btnClose.setText("Close");
        btnClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCloseActionPerformed(evt);
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
                .addComponent(btnViewAllFields)
                .addGap(153, 153, 153)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSetBoundaries)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 83, Short.MAX_VALUE)
                .addComponent(btnClose)
                .addGap(14, 14, 14))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 635, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(btnSetBoundaries)
                    .addComponent(btnViewAllFields)
                    .addComponent(btnClose))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void mouseClick(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mouseClick
        
    }//GEN-LAST:event_mouseClick

    private void recordDrag(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_recordDrag
        
    }//GEN-LAST:event_recordDrag

    private void MouseUp(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MouseUp
        //Creates the shape based on user input and redraws the GUI
        mouseEndX = evt.getX();
        mouseEndY = evt.getY();

        Shape shape = null;

        if (mouseStartX != mouseEndX && mouseStartY != mouseEndY) {
                shape = new Rectangle(mouseStartX, mouseStartY + 10, mouseEndX - mouseStartX, mouseEndY - mouseStartY + 10);
        }

        if (shape != null) {
            drawingShape = shape;
            this.repaint();
        }
        
        mouseStartX = -1;
        mouseStartY = -1;
        mouseEndX = -1;
        mouseEndY = -1;
    }//GEN-LAST:event_MouseUp

    private void mousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mousePressed
        //Saves the initial click from the user
        mouseStartX = evt.getX();
        mouseStartY = evt.getY();
    }//GEN-LAST:event_mousePressed

    private void mouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mouseClicked
        
    }//GEN-LAST:event_mouseClicked

    private void mouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mouseMoved
        
    }//GEN-LAST:event_mouseMoved

    private void scrollChangedListener(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_scrollChangedListener
        // Repaints when the scroll pane has been scrolled
        this.repaint();
    }//GEN-LAST:event_scrollChangedListener

    private void btnViewAllFieldsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewAllFieldsActionPerformed
        //Draws all the GUI again, showing new fields
        this.repaint();
    }//GEN-LAST:event_btnViewAllFieldsActionPerformed

    private void btnSetBoundariesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSetBoundariesActionPerformed
        //creates the boundary in global vars to be used in the previous GUI
        if (drawingShape != null)
        {
            GPS loc1 = new GPS(drawingShape.getBounds().x, drawingShape.getBounds().y);
            GPS loc2 = new GPS(drawingShape.getBounds().x + drawingShape.getBounds().width, drawingShape.getBounds().y);
            GPS loc3 = new GPS(drawingShape.getBounds().x, drawingShape.getBounds().y + drawingShape.getBounds().height);
            GPS loc4 = new GPS(drawingShape.getBounds().x + drawingShape.getBounds().width, drawingShape.getBounds().y + drawingShape.getBounds().height);
            GPSBoundary newGPSBndry = new GPSBoundary();
            newGPSBndry.createBoundary(loc1, loc2, loc3, loc4);
            globalVar.setWorkingBoundary(newGPSBndry);
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Please ensure you have drawn a field.");
        }
    }//GEN-LAST:event_btnSetBoundariesActionPerformed

    private void btnCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCloseActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCloseActionPerformed

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
            java.util.logging.Logger.getLogger(BoundaryGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BoundaryGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BoundaryGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BoundaryGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BoundaryGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClose;
    private javax.swing.JButton btnSetBoundaries;
    private javax.swing.JButton btnViewAllFields;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
