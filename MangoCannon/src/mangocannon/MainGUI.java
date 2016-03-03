/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mangocannon;
import java.awt.Font;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;
import java.time.LocalDate;
import java.util.Date;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class MainGUI extends javax.swing.JFrame {
    GlobalVariables globalVar;
    private int selectedRow = 0;
    /**
     * Creates new form MainGUI
     */
    public MainGUI() {
        initComponents();
        jLabel2.setFont(new Font("SansSerif", Font.PLAIN, 30));
        jLabel11.setFont(new Font("SansSerif", Font.PLAIN, 30));
        jLabel12.setFont(new Font("SansSerif", Font.PLAIN, 30));
    }
    
    public void setGlobalVars(GlobalVariables usingVar) {
        globalVar = usingVar;
        createTableData();
        lblUserStatus.setText("You are logged in as: " + globalVar.currentUser.getFirstName() + " " + globalVar.currentUser.getSecondName());
        switch (globalVar.currentUser.getAccessLevel())
        {
            case 1:
                jButton7.setEnabled(false);
                jButton12.setEnabled(false);
                jButton1.setEnabled(false);
                jButton4.setEnabled(false);
                jButton5.setEnabled(false);
                break;
        }
    }
    
    public void addFieldTofarm (Field theField) {
        globalVar.currentFarm.addField(theField);
    }
    
    public void createTableData() {
        //Creates stuff to display in GUI     
        Vector<String> fieldNames = new Vector<String>();
        Vector<String> hasCropPlanted = new Vector<String>();
        Vector<Integer> fieldSize = new Vector<Integer>();
        
        for (int i=0; i < globalVar.currentFarm.size(); i++){
            fieldNames.addElement(globalVar.currentFarm.get(i).getFieldName());
            if (globalVar.currentFarm.get(i).getCrop() != null)
            {
                hasCropPlanted.addElement("Yes");
            }
            else
            {
                hasCropPlanted.addElement("No");
            }
            fieldSize.addElement(globalVar.currentFarm.get(i).getGPSBoundary().getSize());            
        }   
        //TableModel for Fields table
        DefaultTableModel modelFields = (DefaultTableModel)tableFields.getModel();        
        modelFields.setRowCount(0);
        modelFields.setColumnCount(0);
        modelFields.addColumn("Fields", fieldNames);
        modelFields.addColumn("Field Size (Square M)", fieldSize);
        modelFields.addColumn("Crop Planted", hasCropPlanted);
        
  
        fieldNames.clear();
        Vector<String> cropNames = new Vector<String>();
        Vector<LocalDate> datesPlanted = new Vector<LocalDate>();
        Vector<LocalDate> expectedDates = new Vector<LocalDate>();
        Vector<Float> expectedYield = new Vector<Float>();
        for (Field field : globalVar.currentFarm)
        {
            if (field.getCrop() != null)
            {
                fieldNames.addElement(field.getFieldName());
                cropNames.add(field.getCrop().getCropType().getCropName());
                datesPlanted.addElement(field.getCrop().getPlantDate());
                expectedDates.addElement(field.getCrop().getExpectedHarvest());
                expectedYield.addElement(field.getCrop().getEstimatedYield());
            }
        }
        
        DefaultTableModel modelHarvest = (DefaultTableModel)tableHarvest.getModel();        
        modelHarvest.setRowCount(0);
        modelHarvest.setColumnCount(0);
        modelHarvest.addColumn("Field Name", fieldNames);
        modelHarvest.addColumn("Crop Type", cropNames);
        modelHarvest.addColumn("Date Planted", datesPlanted);
        modelHarvest.addColumn("Expected Harvest", expectedDates);
        modelHarvest.addColumn("Expected Yield", expectedYield);
        
                
        Vector<String> sensors = new Vector<String>();
        Vector<Float> avgReadings = new Vector<Float>();
        Vector<String> unitType = new Vector<String>();
        
        
        for (Sensor sensor : globalVar.currentFarm.get(selectedRow).getFieldStation().getSensors())
        {
            sensors.addElement(sensor.getSensorTypeName());
            avgReadings.addElement(sensor.getReadings().getAverageReading());
            unitType.addElement(sensor.getSensorType().getReadingType());
        }

        DefaultTableModel modelSensor = (DefaultTableModel)tableSensorData.getModel();
        modelSensor.setRowCount(0);
        modelSensor.setColumnCount(0);
        modelSensor.addColumn("Sensor", sensors);
        modelSensor.addColumn("Reading", avgReadings);
        modelSensor.addColumn("Unit Type", unitType);
        
        Vector<String> fieldStations = new Vector<String>();
        Vector<String> fieldStationOwner = new Vector<String>();
        Vector<Integer> sensorNumber = new Vector<Integer>();
        Vector<String> gpsLocation = new Vector<String>();

        for (Field field : globalVar.currentFarm)
        {
            fieldStations.add(field.getFieldStation().getName());
            fieldStationOwner.add(field.getFieldName());
            sensorNumber.add(field.getFieldStation().getSensors().size());
            gpsLocation.add(field.getFieldStation().getGPS().getGlobalPosition()[0] + ", " + field.getFieldStation().getGPS().getGlobalPosition()[1]);
        }
        
        DefaultTableModel modelFieldStations = (DefaultTableModel)tableFieldStations.getModel();
        modelFieldStations.setColumnCount(0);
        modelFieldStations.setRowCount(0);
        modelFieldStations.addColumn("Field Station", fieldStations);
        modelFieldStations.addColumn("Field Name", fieldStationOwner);
        modelFieldStations.addColumn("No. of Sensors", sensorNumber);
        modelFieldStations.addColumn("GPS Location", gpsLocation);
    
        Vector<String> sensorNames = new Vector<String>();
        Vector<String> sensorMeasurement = new Vector<String>();
        Vector<Integer> sensorTimeInterval = new Vector<Integer>();
        for (SensorTypes sensorT : globalVar.sensorTypes)
        {
            sensorNames.addElement(sensorT.getTypeName());
            sensorMeasurement.addElement(sensorT.getReadingType());
            sensorTimeInterval.addElement(sensorT.getTimeInterval());
        }
        
        DefaultTableModel modelSensorTypes = (DefaultTableModel)tableSensorTypes.getModel();
        modelSensorTypes.setColumnCount(0);
        modelSensorTypes.setRowCount(0);
        modelSensorTypes.addColumn("Sensor Type Name", sensorNames);
        modelSensorTypes.addColumn("Measurement Unit", sensorMeasurement);
        modelSensorTypes.addColumn("Sensor Time Interval (sec)", sensorTimeInterval);
        
        
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        buttonGroup3 = new javax.swing.ButtonGroup();
        jTextField4 = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jButton11 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jButton8 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jButton10 = new javax.swing.JButton();
        jTextField3 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jButton9 = new javax.swing.JButton();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableSensorData = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        tableFields = new javax.swing.JTable();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        btnUpdateFields = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        txtBoxSearch = new javax.swing.JTextField();
        btnSensorData = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        tableHarvest = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jPanel4 = new javax.swing.JPanel();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        tableFieldStations = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableSensorTypes = new javax.swing.JTable();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton12 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        lblUserStatus = new javax.swing.JLabel();

        jLabel8.setText("X:");

        jLabel9.setText("Y:");

        jLabel5.setText("Boundaries");

        jLabel10.setText("Field Stations");

        jButton11.setText("Add/Remove");

        jLabel6.setText("Measurement");

        jButton8.setText("Set");

        jLabel7.setText("Order Settings:");

        jButton10.setText("Set");

        jLabel3.setText("Field Name:");

        jLabel4.setText("Sowing date:");

        jButton9.setText("Create");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        tableSensorData.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tableSensorData);

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 530, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 273, Short.MAX_VALUE))
        );

        tableFields.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tableFields.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                MainGUI.this.mousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tableFieldsMouseReleased(evt);
            }
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableFieldsMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tableFields);

        jButton3.setText("Detail View");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("Edit Field");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setText("Remove Field");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        btnUpdateFields.setText("Update");
        btnUpdateFields.setToolTipText("");
        btnUpdateFields.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateFieldsActionPerformed(evt);
            }
        });

        jButton2.setText("Search");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton1.setText("New Field");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel11.setText("Fields");

        btnSensorData.setText("Populate Data");
        btnSensorData.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSensorDataActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnUpdateFields)
                        .addGap(45, 45, 45)
                        .addComponent(txtBoxSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(17, 17, 17))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane3))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, 536, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 77, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnSensorData))
                .addGap(40, 40, 40))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jButton1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jButton2)
                                    .addComponent(txtBoxSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnUpdateFields)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(135, 135, 135)
                        .addComponent(jButton3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton5)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(btnSensorData)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Fields", jPanel1);

        jLabel12.setText("Harvests");

        tableHarvest.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane5.setViewportView(tableHarvest);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 718, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(75, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 679, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Harvests", jPanel2);

        jButton6.setText("Configure");

        jButton7.setText("Delete Station");

        tableFieldStations.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane4.setViewportView(tableFieldStations);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 592, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(7, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jButton6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton7))
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(223, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("Field Stations", jPanel4);

        tableSensorTypes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(tableSensorTypes);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 603, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(157, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(223, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("Sensor Categories/Types", jPanel5);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane6.setViewportView(jTable1);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 754, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 514, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(113, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("Unallocated Sensors", jPanel6);

        jButton12.setText("New Sensor");
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });

        jLabel2.setText("Settings");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jTabbedPane2)
                        .addContainerGap())
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton12)
                        .addGap(33, 33, 33))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton12))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jTabbedPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 679, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Field Stations / Sensors", jPanel3);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(lblUserStatus)
                .addContainerGap(816, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 820, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(lblUserStatus)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 596, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        FieldGUI fieldGUI = new FieldGUI();
        fieldGUI.setGlobalVars(globalVar);
        fieldGUI.setVisible(true);        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        EditFieldGUI editFieldGUI = new EditFieldGUI();
        //Gets the fields original data from selection
        selectedRow = tableFields.getSelectedRow();
        globalVar.editField = globalVar.currentFarm.get(selectedRow);
        editFieldGUI.setGlobalVars(globalVar);
        //editFieldGUI.populateGUIData(globalVar.currentFarm.get(selectedRow));
        editFieldGUI.setVisible(true);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        globalVar.currentFarm.remove(selectedRow);
        ((DefaultTableModel)tableFields.getModel()).removeRow(selectedRow);
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        if (txtBoxSearch.getText() != "")
        {
            String searchTerm = txtBoxSearch.getText();
            Vector<String> fieldNames = new Vector<String>();
            Vector<String> cropNames = new Vector<String>();
            Vector<LocalDate> datesPlanted = new Vector<LocalDate>();
            Vector<LocalDate> expectedDates = new Vector<LocalDate>();
            Vector<Integer> fieldSize = new Vector<Integer>();
            Vector<Float> expectedYield = new Vector<Float>();

            for (int i=0; i < globalVar.currentFarm.size(); i++){
                if (globalVar.currentFarm.get(i).getFieldName().toLowerCase().contains(searchTerm.toLowerCase()))
                {
                    fieldNames.addElement(globalVar.currentFarm.get(i).getFieldName());
                    cropNames.addElement(globalVar.currentFarm.get(i).getCrop().getCropType().getCropName());
                    datesPlanted.addElement(globalVar.currentFarm.get(i).getCrop().getPlantDate());
                    expectedDates.addElement(globalVar.currentFarm.get(i).getCrop().getExpectedHarvest());
                    //Change field size to get from field not crop when added boundaries!
                    fieldSize.addElement(globalVar.currentFarm.get(i).getCrop().getFieldSize());
                    expectedYield.addElement(globalVar.currentFarm.get(i).getCrop().getEstimatedYield());
                }
            }   
            //TableModel for Fields table
            DefaultTableModel model = (DefaultTableModel)tableFields.getModel();        
            model.setRowCount(0);
            model.setColumnCount(0);
            model.addColumn("Fields", fieldNames);
            model.addColumn("Crop Type", cropNames);
            model.addColumn("Date Planted", datesPlanted);
            model.addColumn("Expected Harvest", expectedDates);
            model.addColumn("Field Size (Square M)", fieldSize);
            model.addColumn("Expected Yield", expectedYield);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void tableFieldsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableFieldsMouseClicked
        // TODO add your handling code here:
        
    }//GEN-LAST:event_tableFieldsMouseClicked

    private void btnUpdateFieldsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateFieldsActionPerformed
        // TODO add your handling code here:
        createTableData();
    }//GEN-LAST:event_btnUpdateFieldsActionPerformed

    private void mousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mousePressed
        selectedRow = tableFields.getSelectedRow();
        createTableData();
        tableFields.setRowSelectionInterval(selectedRow, selectedRow);
    }//GEN-LAST:event_mousePressed

    private void tableFieldsMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableFieldsMouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_tableFieldsMouseReleased
    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
        FieldOverviewGUI fieldOverviewGUI = new FieldOverviewGUI();
        fieldOverviewGUI.setGlobalVars(globalVar);
        fieldOverviewGUI.setVisible(true);
    }//GEN-LAST:event_jButton12ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        
    }//GEN-LAST:event_jButton3ActionPerformed

    private void btnSensorDataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSensorDataActionPerformed
        globalVar.workingSensor = globalVar.currentFarm.get(selectedRow).getFieldStation().getSensors().get(tableSensorData.getSelectedRow());
        SensorDataGUI sensorGUI = new SensorDataGUI();
        sensorGUI.setGlobalVars(globalVar);
        sensorGUI.setVisible(true);
    }//GEN-LAST:event_btnSensorDataActionPerformed

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
            java.util.logging.Logger.getLogger(MainGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSensorData;
    private javax.swing.JButton btnUpdateFields;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.ButtonGroup buttonGroup3;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JLabel lblUserStatus;
    private javax.swing.JTable tableFieldStations;
    private javax.swing.JTable tableFields;
    private javax.swing.JTable tableHarvest;
    private javax.swing.JTable tableSensorData;
    private javax.swing.JTable tableSensorTypes;
    private javax.swing.JTextField txtBoxSearch;
    // End of variables declaration//GEN-END:variables
}
