/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mywardrobeprogram.ui;

import java.awt.Frame;

import java.sql.SQLException;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import mywardrobeprogram.dao.WardrobeDao;
import mywardrobeprogram.dao.persistence.ClothingPersist;
import mywardrobeprogram.model.Brand;
import mywardrobeprogram.model.Clothing;
import mywardrobeprogram.ui.listener.FormWindowListener;

/**
 * UI frame to capture information relating to clothing item to persist 
 * 
 * @author Natalia Luiz
 */
public class ClothingFrame extends javax.swing.JDialog {

    /**
     * Creates new form AddingFrame
     * 
     * @param parent 
     */
    public ClothingFrame(Frame parent) {
        super(parent, true);
        initComponents();
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
	JPanel image = new ImagePanel(new ImageIcon(getClass().getResource("IMG_7668_1024.jpg")).getImage());
        add(image);

        repaint();
        pack();
        addWindowListener(new FormWindowListener());
	refreshBrands();
    }
    
    /**
     * Helper method to refresh brands from database
     */
    private void refreshBrands() {
	try {
	    List<Brand> brands = WardrobeDao.getInstance().getAllBrands();
	    
	    DefaultComboBoxModel model = new DefaultComboBoxModel();
	    for (Brand currentBrand : brands) {
		model.addElement(currentBrand);
	    }
	    
	    brandComboBox.setModel(model);
	} catch (SQLException sqlE) {
	    JOptionPane.showMessageDialog(this, "Unable to retrieve brands from the db.");
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

        itemTypeLabel = new javax.swing.JLabel();
        sizeLabel = new javax.swing.JLabel();
        colourLabel = new javax.swing.JLabel();
        brandIDLabel = new javax.swing.JLabel();
        styleLabel = new javax.swing.JLabel();
        colourTxt = new javax.swing.JTextField();
        styleTxt = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        addButton = new javax.swing.JButton();
        sizeComboBox = new javax.swing.JComboBox();
        messageLabel = new javax.swing.JLabel();
        brandComboBox = new javax.swing.JComboBox();
        itemTypeComboBox = new javax.swing.JComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        itemTypeLabel.setText("Item Type");

        sizeLabel.setText("Size");

        colourLabel.setText("Colour");

        brandIDLabel.setText("Brand");

        styleLabel.setText("Style");

        jLabel1.setText("Add to your wardrobe");

        addButton.setText("Add");
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });

        sizeComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Extra small", "Small", "Medium", "Large" }));

        itemTypeComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Blazer", "Blouse", "Bow Tie", "Boxers", "Bra", "Cardigan", "Coat", "Dress", "Dungarees", "Gloves", "Hair Accessory", "Hat", "Hoody", "Jacket", "Jeans", "Jumper", "Leggings", "Overalls", "PJs", "Scarf", "Shawl", "Shirt", "Shoes", "Shorts", "Skirt", "Stockings", "Suit", "Sunglasses", "Sweatpants", "Sweatshirt", "Swimming costume", "Trousers", "Waistcoat" }));
        itemTypeComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemTypeComboBoxActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(486, 486, 486)
                                .addComponent(messageLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 22, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addComponent(addButton))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(styleLabel)
                                            .addComponent(brandIDLabel)
                                            .addComponent(colourLabel)
                                            .addComponent(sizeLabel)
                                            .addComponent(itemTypeLabel))
                                        .addGap(189, 189, 189)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(brandComboBox, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(sizeComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(colourTxt)
                                            .addComponent(styleTxt, javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(itemTypeComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                                .addGap(76, 76, 76)))
                        .addGap(115, 115, 115))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 517, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel1)
                .addGap(43, 43, 43)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(itemTypeLabel)
                    .addComponent(itemTypeComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(sizeLabel)
                    .addComponent(sizeComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(colourLabel)
                    .addComponent(colourTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(brandIDLabel)
                    .addComponent(brandComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(styleLabel)
                    .addComponent(styleTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(addButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addComponent(messageLabel)
                .addGap(131, 131, 131))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    /**
     * Validates data entered by user into UI. If valid persist to db, otherwise display dialog indicating error
     * 
     * @param evt action event
     * 
     * @throws SQLException Database unable to save item of clothing  
     */
    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed
        boolean validData = validateClothingValues();
        if (validData) {
            
            Brand selectedBrand = (Brand) brandComboBox.getModel().getSelectedItem();
            Clothing newItem = new Clothing();
            newItem.setBrandID(selectedBrand.getId());
            newItem.setSize(sizeComboBox.getSelectedItem().toString());
            newItem.setStyle(styleTxt.getText());
            newItem.setColour(colourTxt.getText());
            newItem.setType((String)itemTypeComboBox.getSelectedItem());
            newItem.setUserID(LoginForm.loggedInUser.getId());
            newItem.setId(clothingID);
            
            try {
               persist.execute(newItem);
            }catch (SQLException sqle){
                JOptionPane.showMessageDialog(this, "Unable to save new item of clothing");
                sqle.printStackTrace();
            }
            setVisible(false);
            
        }
    }//GEN-LAST:event_addButtonActionPerformed

    private void itemTypeComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemTypeComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_itemTypeComboBoxActionPerformed

    /**
     * validate data captured in UI components 
     * 
     * @return true returned if validation successful else false 
     */
    boolean validateClothingValues() {
        String itemType = (String)itemTypeComboBox.getSelectedItem();
        String size = sizeComboBox.getSelectedItem().toString();
        String style = styleTxt.getText();
        String colour = colourTxt.getText();

        boolean valid = true;

        Object[][] values = {
            {itemType, itemTypeComboBox},
            {size, sizeComboBox},
            {style, styleTxt},
            {colour, colourTxt}
        };

        for (int i = 0; i < values.length; i++) {
            if (values[i][0] == null || ((String) values[i][0]).trim().equals("")) {
                JOptionPane.showMessageDialog(this, "Please enter a value for the wardrobe item");
                ((JComponent) values[i][1]).requestFocus();
                valid = false;
                break;
            }
        }

        return valid;
    }

    private ClothingPersist persist;
    private Integer clothingID;
    

    public ClothingPersist getPersist() {
        return persist;
    }

    public void setPersist(ClothingPersist persist, String persistButtonName) {
        this.persist = persist;
        addButton.setText(persistButtonName);
    }
    /**
     * Displays clothing item 
     * 
     * @param displayItem clothing item to display 
     */
    public void display (Clothing displayItem){
        colourTxt.setText(displayItem.getColour());
        itemTypeComboBox.setSelectedItem(displayItem.getType());
        sizeComboBox.setSelectedItem(displayItem.getSize());
        styleTxt.setText(displayItem.getStyle());
        clothingID = displayItem.getId();
        try {
            Brand displayBrand = WardrobeDao.getInstance().findBrandByID(displayItem.getBrandID());
        
            brandComboBox.setSelectedItem(displayBrand);
        } catch (SQLException sql) {
            sql.printStackTrace();
	    JOptionPane.showMessageDialog(this, "Unable to retrieve brand for ID:" +displayItem.getBrandID());
        }
    }
    /**
     * Reinitialize the UI component to remove previously entered data 
     */
    public void reset (){
         colourTxt.setText("");
        itemTypeComboBox.setSelectedIndex(0);
        sizeComboBox.setSelectedIndex(0);
        styleTxt.setText("");
        clothingID = null;
	refreshBrands();
        brandComboBox.setSelectedIndex(0);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addButton;
    private javax.swing.JComboBox brandComboBox;
    private javax.swing.JLabel brandIDLabel;
    private javax.swing.JLabel colourLabel;
    private javax.swing.JTextField colourTxt;
    private javax.swing.JComboBox itemTypeComboBox;
    private javax.swing.JLabel itemTypeLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel messageLabel;
    private javax.swing.JComboBox sizeComboBox;
    private javax.swing.JLabel sizeLabel;
    private javax.swing.JLabel styleLabel;
    private javax.swing.JTextField styleTxt;
    // End of variables declaration//GEN-END:variables
}
