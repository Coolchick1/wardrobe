/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mywardrobeprogram.ui;

import java.sql.SQLException;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import mywardrobeprogram.dao.WardrobeDao;
import mywardrobeprogram.dao.persistence.impl.BrandAddPersist;
import mywardrobeprogram.dao.persistence.impl.BrandUpdatePersist;
import mywardrobeprogram.model.Brand;
import mywardrobeprogram.ui.listener.FormWindowListener;
import mywardrobeprogram.ui.model.BrandTableModel;

/**
 *
 * @author Natalia Luiz
 */
public class ViewBrandsFrame extends javax.swing.JFrame {

    /**
     * Creates new form ViewBrandsFrame
     * 
     * Code to add an image as a background for the ViewBrandFrame
     */
    public ViewBrandsFrame() {
        initComponents();
        refreshData();
	setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
	addWindowListener(new FormWindowListener());
        brandFrame = new BrandFrame(this, true);
	 JPanel image = new ImagePanel(new ImageIcon(getClass().getResource("donut-tumblr-backgrounds.jpg")).getImage());
        add(image);

        repaint();
        pack();

    }
    /**
     * Refresh the list of brands allowing for the new created brands to be shown
     */
    public void refreshData() {
        try {
            List<Brand> allBrands = WardrobeDao.getInstance().getAllBrands();

            brandsTable.setModel(new BrandTableModel(allBrands));
        } catch (SQLException sqlE) {

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
        brandsTable = new javax.swing.JTable();
        addButton = new javax.swing.JButton();
        editButton = new javax.swing.JButton();
        deleteButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        brandsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Name", "Recommended", "Shopping Mall"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(brandsTable);

        addButton.setText("Add");
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });

        editButton.setText("Edit");
        editButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editButtonActionPerformed(evt);
            }
        });

        deleteButton.setText("Delete");
        deleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 449, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(addButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(editButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(deleteButton)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(74, 74, 74)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addButton)
                    .addComponent(editButton)
                    .addComponent(deleteButton))
                .addContainerGap(70, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    /**
     * Sets up BrandFrame to add a new brand
     */
    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed
        brandFrame.reset();
        brandFrame.setPersistence(new BrandAddPersist());
	brandFrame.setLocationRelativeTo(this);
        brandFrame.setVisible(true);
        refreshData();
    }//GEN-LAST:event_addButtonActionPerformed
    /**
     * Method to edit a field/fields of a clothing item. Select the row to edit.
     * 
     * Validation check includes a MessageDialog that will pop up informing the user to select a row to edit
     */
    private void editButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editButtonActionPerformed
        int selectedRow = brandsTable.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Select the row to edit");
        } else {

            BrandTableModel model = (BrandTableModel) brandsTable.getModel();
            Brand selectedBrand = model.getSelectedBrand(selectedRow);
            brandFrame.reset();
            brandFrame.displayData(selectedBrand);
            brandFrame.setPersistence(new BrandUpdatePersist());
	    brandFrame.setLocationRelativeTo(this);
            brandFrame.setVisible(true);
            refreshData();
        }
    }//GEN-LAST:event_editButtonActionPerformed
     /**
     * Method to delete a clothing item. Select a row to delete. 
     * 
     * Validation check includes a MessageDialog that will pop up informing the user to select a row to delete
     */
    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed
        int selectedRow = brandsTable.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Select the row to delete");
        } else {

            BrandTableModel model = (BrandTableModel) brandsTable.getModel();
            Brand selectedBrand = model.getSelectedBrand(selectedRow);
            try {
                WardrobeDao.getInstance().deleteBrandByID(selectedBrand.getId());
                refreshData();

            } catch (SQLException sql) {
                sql.printStackTrace();
            }

        }

    }//GEN-LAST:event_deleteButtonActionPerformed

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
            java.util.logging.Logger.getLogger(ViewBrandsFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewBrandsFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewBrandsFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewBrandsFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewBrandsFrame().setVisible(true);
            }
        });
    }
    private BrandFrame brandFrame;

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addButton;
    private javax.swing.JTable brandsTable;
    private javax.swing.JButton deleteButton;
    private javax.swing.JButton editButton;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
