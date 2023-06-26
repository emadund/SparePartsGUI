/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package sparepartsnew.ui.modules;

import java.util.List;
import javax.swing.JOptionPane;
import sparepartsnew.model.Sort;
import sparepartsnew.model.Location;
import sparepartsnew.model.Status;
import sparepartsnew.model.Users;
import sparepartsnew.model.Modul;

import sparepartsnew.service.impl.LocationServiceImpl;
import sparepartsnew.service.impl.ModulServiceImpl;

/**
 *
 * @author Marko HP
 */
public class ModulesAddForm extends javax.swing.JDialog {
     
    private Users user;
    private ModulServiceImpl moduleRepository;
    private LocationServiceImpl locationRepository;
    /**
     * Creates new form ModulesAddForm
     */
    public ModulesAddForm(java.awt.Frame parent, boolean modal, Users user) throws Exception {
        super(parent, modal);
        moduleRepository=new ModulServiceImpl();
        locationRepository=new LocationServiceImpl();
        this.user=user;
        initComponents();        
        prepareForm();
        
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        groupStatus = new javax.swing.ButtonGroup();
        groupType = new javax.swing.ButtonGroup();
        lblName = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        lblSn = new javax.swing.JLabel();
        txtSn = new javax.swing.JTextField();
        lblPn = new javax.swing.JLabel();
        txtPn = new javax.swing.JTextField();
        lblMM = new javax.swing.JLabel();
        txtMM = new javax.swing.JTextField();
        lblStatus = new javax.swing.JLabel();
        lblType = new javax.swing.JLabel();
        lblLocation = new javax.swing.JLabel();
        radioOperative = new javax.swing.JRadioButton();
        radioFaulty = new javax.swing.JRadioButton();
        radioTest = new javax.swing.JRadioButton();
        radioRadio = new javax.swing.JRadioButton();
        radioTransport = new javax.swing.JRadioButton();
        radioPower = new javax.swing.JRadioButton();
        radioAsset = new javax.swing.JRadioButton();
        comboLocation = new javax.swing.JComboBox<>();
        btnNewLocation = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("New module");

        lblName.setText("Name:");

        lblSn.setText("S/N:");

        lblPn.setText("P/N:");

        txtPn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPnActionPerformed(evt);
            }
        });

        lblMM.setText("MM:");

        lblStatus.setText("Status:");

        lblType.setText("Type:");

        lblLocation.setText("Location:");

        groupStatus.add(radioOperative);
        radioOperative.setText("Operative");

        groupStatus.add(radioFaulty);
        radioFaulty.setText("Faulty");

        groupStatus.add(radioTest);
        radioTest.setText("Test");

        radioRadio.setText("Radio");

        radioTransport.setText("Transport");

        radioPower.setText("Power");

        radioAsset.setText("Asset");

        btnNewLocation.setText("New location");
        btnNewLocation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewLocationActionPerformed(evt);
            }
        });

        btnSave.setText("Save");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        btnCancel.setText("Cancel");
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnSave)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnCancel))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblName, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(67, 67, 67)
                        .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, 399, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblSn, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(67, 67, 67)
                        .addComponent(txtSn, javax.swing.GroupLayout.PREFERRED_SIZE, 399, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblPn, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(67, 67, 67)
                        .addComponent(txtPn, javax.swing.GroupLayout.PREFERRED_SIZE, 399, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblMM, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblType, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblLocation, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(67, 67, 67)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(radioRadio)
                                .addGap(18, 18, 18)
                                .addComponent(radioTransport)
                                .addGap(18, 18, 18)
                                .addComponent(radioPower)
                                .addGap(18, 18, 18)
                                .addComponent(radioAsset))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(radioOperative)
                                .addGap(18, 18, 18)
                                .addComponent(radioFaulty)
                                .addGap(18, 18, 18)
                                .addComponent(radioTest))
                            .addComponent(txtMM, javax.swing.GroupLayout.PREFERRED_SIZE, 399, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(comboLocation, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(70, 70, 70)
                                .addComponent(btnNewLocation, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(288, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblName, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSn, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPn, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblMM, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(radioOperative)
                    .addComponent(radioFaulty)
                    .addComponent(radioTest))
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblType, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(radioRadio)
                        .addComponent(radioTransport)
                        .addComponent(radioPower)
                        .addComponent(radioAsset)))
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblLocation, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(comboLocation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnNewLocation)))
                .addGap(45, 45, 45)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSave)
                    .addComponent(btnCancel))
                .addContainerGap(47, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCancelActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
       String name= txtName.getText().trim();
       String sn= txtSn.getText().trim();
       String pn= txtPn.getText().trim();
       int mm= Integer.parseInt(txtMM.getText().trim());
       Status status = null;
       if (radioOperative.isSelected()) status=Status.Operative;
       else if (radioFaulty.isSelected()) status=Status.Faulty;
       else status=Status.Test;
       sparepartsnew.model.Type type=null;
       if (radioRadio.isSelected()) type=sparepartsnew.model.Type.Radio;
       else if (radioTransport.isSelected()) type=sparepartsnew.model.Type.Transport;
       else if (radioPower.isSelected()) type=sparepartsnew.model.Type.Power;
       else type=sparepartsnew.model.Type.Asset;
       
       
       try {
           Location location=(Location) comboLocation.getSelectedItem();
       Modul modul = new Modul(null, name, sn, pn, mm, type, location, status);
           moduleRepository.add(modul, user);
           JOptionPane.showMessageDialog(this, "Successfully addition", "Module has been added successfully", JOptionPane.INFORMATION_MESSAGE);
       }
       
       catch (Exception e) {
           e.printStackTrace();
           JOptionPane.showMessageDialog(this, "Error", "There has been an error with adding module", JOptionPane.ERROR_MESSAGE);
       }
       
       
    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnNewLocationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewLocationActionPerformed
       new LocationAddForm(null, true, user).setVisible(true);
    }//GEN-LAST:event_btnNewLocationActionPerformed

    private void txtPnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPnActionPerformed

  

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnNewLocation;
    private javax.swing.JButton btnSave;
    private javax.swing.JComboBox<Location> comboLocation;
    private javax.swing.ButtonGroup groupStatus;
    private javax.swing.ButtonGroup groupType;
    private javax.swing.JLabel lblLocation;
    private javax.swing.JLabel lblMM;
    private javax.swing.JLabel lblName;
    private javax.swing.JLabel lblPn;
    private javax.swing.JLabel lblSn;
    private javax.swing.JLabel lblStatus;
    private javax.swing.JLabel lblType;
    private javax.swing.JRadioButton radioAsset;
    private javax.swing.JRadioButton radioFaulty;
    private javax.swing.JRadioButton radioOperative;
    private javax.swing.JRadioButton radioPower;
    private javax.swing.JRadioButton radioRadio;
    private javax.swing.JRadioButton radioTest;
    private javax.swing.JRadioButton radioTransport;
    private javax.swing.JTextField txtMM;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtPn;
    private javax.swing.JTextField txtSn;
    // End of variables declaration//GEN-END:variables

    private void prepareForm() throws Exception {
         List<Location> locations = locationRepository.getAll(Sort.site_code);
        
        for (Location l:locations) {
            comboLocation.addItem(l);
        }
    }

    
}
