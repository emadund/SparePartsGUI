/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package sparepartsnew.ui.modules;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import sparepartsnew.model.Location;
import sparepartsnew.model.Modul;
import sparepartsnew.model.Status;
import sparepartsnew.model.Users;
import sparepartsnew.service.impl.LocationServiceImpl;
import sparepartsnew.service.impl.ModulServiceImpl;
import sparepartsnew.model.Sort;
import sparepartsnew.ui.component.tablemodel.ModulesLocationTableModel;
import sparepartsnew.ui.component.tablemodel.ModulesTableModel;

/**
 *
 * @author Marko HP
 */
public class ModulesViewForm extends javax.swing.JFrame {
    private Users user;
    private ModulServiceImpl moduleRepo;
    private LocationServiceImpl locationRepo;
    private Location locationInput;

    /**
     * Creates new form ModulesViewForm
     */
    public ModulesViewForm(Users user) {
        initComponents();
        pnlSearch.setVisible(false);
        pnlLocation.setVisible(false);
        this.user=user;
        moduleRepo = new ModulServiceImpl();
        locationRepo = new LocationServiceImpl();
        locationInput = null;
        prepareForm();
        setUI();
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
        tblHome = new javax.swing.JTable();
        btnRefresh = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnQuantity = new javax.swing.JButton();
        btnSort = new javax.swing.JButton();
        lblUserInfo = new javax.swing.JLabel();
        btnNewLocation = new javax.swing.JButton();
        btnCreate = new javax.swing.JButton();
        btnViewLocations = new javax.swing.JButton();
        btnHistory = new javax.swing.JButton();
        btnSearch = new javax.swing.JButton();
        pnlSearch = new javax.swing.JPanel();
        lblSearch = new javax.swing.JLabel();
        txtSearch = new javax.swing.JTextField();
        btnGo = new javax.swing.JButton();
        pnlLocation = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtLocation = new javax.swing.JTextField();
        btnLocation = new javax.swing.JButton();
        btnViewLocation = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Modules");

        tblHome.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tblHome);

        btnRefresh.setText("Refresh");
        btnRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshActionPerformed(evt);
            }
        });

        btnEdit.setText("Edit");
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });

        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnQuantity.setText("Quantity (To Do)");

        btnSort.setText("Sort");
        btnSort.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSortActionPerformed(evt);
            }
        });

        btnNewLocation.setText("New location:");
        btnNewLocation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewLocationActionPerformed(evt);
            }
        });

        btnCreate.setText("Create");
        btnCreate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreateActionPerformed(evt);
            }
        });

        btnViewLocations.setText("View locations");
        btnViewLocations.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewLocationsActionPerformed(evt);
            }
        });

        btnHistory.setText("History");
        btnHistory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHistoryActionPerformed(evt);
            }
        });

        btnSearch.setText("Search");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        lblSearch.setText("Input:");

        btnGo.setText("Go");
        btnGo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlSearchLayout = new javax.swing.GroupLayout(pnlSearch);
        pnlSearch.setLayout(pnlSearchLayout);
        pnlSearchLayout.setHorizontalGroup(
            pnlSearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSearchLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(lblSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 388, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnGo, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlSearchLayout.setVerticalGroup(
            pnlSearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSearchLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(pnlSearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnGo))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        jLabel1.setText("Location:");

        btnLocation.setText("Submit");
        btnLocation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLocationActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlLocationLayout = new javax.swing.GroupLayout(pnlLocation);
        pnlLocation.setLayout(pnlLocationLayout);
        pnlLocationLayout.setHorizontalGroup(
            pnlLocationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlLocationLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtLocation, javax.swing.GroupLayout.PREFERRED_SIZE, 386, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnLocation, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlLocationLayout.setVerticalGroup(
            pnlLocationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlLocationLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(pnlLocationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtLocation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLocation))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        btnViewLocation.setText("View by location:");
        btnViewLocation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewLocationActionPerformed(evt);
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
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(pnlLocation, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlSearch, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnEdit)
                        .addGap(18, 18, 18)
                        .addComponent(btnCreate)
                        .addGap(25, 25, 25)
                        .addComponent(btnDelete)
                        .addGap(31, 31, 31)
                        .addComponent(btnSort)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnViewLocation, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnNewLocation, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 827, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(lblUserInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnCancel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnSearch)
                        .addGap(28, 28, 28)
                        .addComponent(btnHistory)
                        .addGap(40, 40, 40)
                        .addComponent(btnViewLocations)
                        .addGap(27, 27, 27)
                        .addComponent(btnRefresh)))
                .addContainerGap(183, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRefresh)
                    .addComponent(lblUserInfo)
                    .addComponent(btnViewLocations)
                    .addComponent(btnHistory)
                    .addComponent(btnSearch)
                    .addComponent(btnCancel))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEdit)
                    .addComponent(btnDelete)
                    .addComponent(btnQuantity)
                    .addComponent(btnSort)
                    .addComponent(btnNewLocation)
                    .addComponent(btnCreate)
                    .addComponent(btnViewLocation))
                .addGap(27, 27, 27)
                .addComponent(pnlSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlLocation, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
       int selectedRow = tblHome.getSelectedRow();
       if (selectedRow==-1) {
         JOptionPane.showMessageDialog(this, "Error", "You haven't seleced module to edit", JOptionPane.ERROR_MESSAGE);
     }
     else {
           Long id = Long.parseLong(tblHome.getValueAt(selectedRow, 0).toString());
           Location location = new Location();
           String sn="";
           try {
               String name = tblHome.getValueAt(selectedRow, 1).toString();
               sn += tblHome.getValueAt(selectedRow, 2).toString();
               String pn = tblHome.getValueAt(selectedRow, 3).toString();
               int mm = Integer.parseInt(tblHome.getValueAt(selectedRow, 4).toString());
               sparepartsnew.model.Type type = sparepartsnew.model.Type.valueOf(tblHome.getValueAt(selectedRow, 5).toString());
               String siteCode=tblHome.getValueAt(selectedRow, 6).toString();
               Status status = Status.valueOf(tblHome.getValueAt(selectedRow, 7).toString());
               location = locationRepo.getById(siteCode);
               Modul modul = new Modul(id, name, sn, pn, mm, type, location, status);
               new ModulesEditedForm(this, true, modul, user).setVisible(true);
           }
           catch (Exception e) {
               e.printStackTrace();
               String name = tblHome.getValueAt(selectedRow, 1).toString();
               String pn = tblHome.getValueAt(selectedRow, 3).toString();
               int mm = Integer.parseInt(tblHome.getValueAt(selectedRow, 4).toString());
               sparepartsnew.model.Type type = sparepartsnew.model.Type.valueOf(tblHome.getValueAt(selectedRow, 5).toString());
               String siteCode=tblHome.getValueAt(selectedRow, 6).toString();
               Status status = Status.valueOf(tblHome.getValueAt(selectedRow, 7).toString());
               try {
                   location = locationRepo.getById(siteCode);
               } catch (Exception ex) {
                   Logger.getLogger(ModulesViewForm.class.getName()).log(Level.SEVERE, null, ex);
               }
               Modul modul = new Modul(id, name, sn, pn, mm, type, location, status);
               try {
                   new ModulesEditedForm(this, true, modul, user).setVisible(true);
               } catch (Exception ex) {
                   Logger.getLogger(ModulesViewForm.class.getName()).log(Level.SEVERE, null, ex);
               }
               
           }
       }
    }//GEN-LAST:event_btnEditActionPerformed

    private void btnRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshActionPerformed
        prepareForm();
    }//GEN-LAST:event_btnRefreshActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
     int selectedRow = tblHome.getSelectedRow();
     if (selectedRow==-1) {
         JOptionPane.showMessageDialog(this, "Error", "You haven't seleced module to get deleted", JOptionPane.ERROR_MESSAGE);
     }
     else {
         Long id = Long.parseLong(tblHome.getValueAt(selectedRow, 0).toString());
         try {
             moduleRepo.delete(moduleRepo.getById(id), user);
             JOptionPane.showMessageDialog(this, "Delete successsfull!", "Refresh to check out", JOptionPane.INFORMATION_MESSAGE);
         } catch (Exception ex) {
             ex.printStackTrace();
             JOptionPane.showMessageDialog(this, "Delete error!", "There is a problem with removing modle", JOptionPane.ERROR_MESSAGE);
         }
     }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnCreateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreateActionPerformed
       
        try {
            new ModulesAddForm(this, true,  user).setVisible(true);
        } catch (Exception ex) {
            Logger.getLogger(ModulesViewForm.class.getName()).log(Level.SEVERE, null, ex);
        }
           
    }//GEN-LAST:event_btnCreateActionPerformed

    private void btnViewLocationsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewLocationsActionPerformed
        new LocationsViewForm( user).setVisible(true);
    }//GEN-LAST:event_btnViewLocationsActionPerformed

    private void btnHistoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHistoryActionPerformed
        new HistoryViewForm(this, true).setVisible(true);
    }//GEN-LAST:event_btnHistoryActionPerformed

    private void btnNewLocationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewLocationActionPerformed
      new LocationAddForm(this, true, user).setVisible(true);
    }//GEN-LAST:event_btnNewLocationActionPerformed

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
       pnlSearch.setVisible(true);
    }//GEN-LAST:event_btnSearchActionPerformed

    private void btnViewLocationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewLocationActionPerformed
        pnlLocation.setVisible(true);
        String locationInputText="";
        try { 
          locationInputText += txtLocation.getText().trim();          
           locationInput = locationRepo.getById(locationInputText);            
       }
        catch (Exception e) {
            e.printStackTrace();
            System.out.println("You must enter proper site code for location: ");
            JOptionPane.showMessageDialog(this,"Error", "Wrong site code input", JOptionPane.ERROR_MESSAGE);            
        }
    }//GEN-LAST:event_btnViewLocationActionPerformed

    private void btnLocationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLocationActionPerformed
       
    }//GEN-LAST:event_btnLocationActionPerformed

    private void btnGoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGoActionPerformed
       ModulesLocationTableModel dtm = new ModulesLocationTableModel(locationInput);
        tblHome.setModel(dtm);
    }//GEN-LAST:event_btnGoActionPerformed

    private void btnSortActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSortActionPerformed
    int selectedColumn= tblHome.getSelectedColumn();
    
    switch (selectedColumn) {
           case 0: 
            ModulesTableModel dtm0 = new ModulesTableModel(Sort.id);
            tblHome.setModel(dtm0);
           break;
           case 1: 
            ModulesTableModel dtm1 = new ModulesTableModel(Sort.name);
            tblHome.setModel(dtm1);
           break;
           case 4: 
            ModulesTableModel dtm4 = new ModulesTableModel(Sort.mm);
            tblHome.setModel(dtm4);
           break;           
           case 5: 
            ModulesTableModel dtm5 = new ModulesTableModel(Sort.type);
            tblHome.setModel(dtm5);
           break;
           case 6: 
            ModulesTableModel dtm6 = new ModulesTableModel(Sort.location);
            tblHome.setModel(dtm6);
           break;
           case 7: 
            ModulesTableModel dtm7 = new ModulesTableModel(Sort.status);
            tblHome.setModel(dtm7);
           break;
           
           default:
               JOptionPane.showMessageDialog(this,"Error", "Column not selected for sorting!", JOptionPane.ERROR_MESSAGE);
               break;
    }
   
    }//GEN-LAST:event_btnSortActionPerformed

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
      dispose();
    }//GEN-LAST:event_btnCancelActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnCreate;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnGo;
    private javax.swing.JButton btnHistory;
    private javax.swing.JButton btnLocation;
    private javax.swing.JButton btnNewLocation;
    private javax.swing.JButton btnQuantity;
    private javax.swing.JButton btnRefresh;
    private javax.swing.JButton btnSearch;
    private javax.swing.JButton btnSort;
    private javax.swing.JButton btnViewLocation;
    private javax.swing.JButton btnViewLocations;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblSearch;
    private javax.swing.JLabel lblUserInfo;
    private javax.swing.JPanel pnlLocation;
    private javax.swing.JPanel pnlSearch;
    private javax.swing.JTable tblHome;
    private javax.swing.JTextField txtLocation;
    private javax.swing.JTextField txtSearch;
    // End of variables declaration//GEN-END:variables

    private void prepareForm() {
        ModulesTableModel dtm = new ModulesTableModel(Sort.id);
        tblHome.setModel(dtm);
    }

    private void setUI() {
        
        lblUserInfo.setText("You are logged as: "+user.getFull_name());
        
        switch(user.getPrivilege()) {      
             
            case read_write:                
                btnDelete.setVisible(false);                
                btnNewLocation.setVisible(false);
                break;
            case read:
                btnEdit.setVisible(false);                
                btnCreate.setVisible(false);
                btnDelete.setVisible(false);          
                break;
        }
    }
}