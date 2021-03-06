/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smart.home.security.view;

import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;
import smart.home.security.model.Device;
import smart.home.security.model.Devices;
import smart.home.security.utilities.DeviceSocketManager;
import smart.home.security.utilities.DeviceTableModel;

public class DisablePanel extends javax.swing.JPanel {

    /**
     * Creates new form DisablePanel
     */
    public DisablePanel() 
    {
        initComponents(); 
        
        List<Device> enabledDevices = Devices.getInstance().getEnabledDevices();
        DefaultTableModel model = DeviceTableModel.defaultTableModel(enabledDevices);
        disableDeviceTable.setModel(model);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        disableButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        disableDeviceTable = new javax.swing.JTable();

        setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Disable Device", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 1, 13))); // NOI18N
        setPreferredSize(new java.awt.Dimension(408, 309));

        disableButton.setText("Disable");
        disableButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                disableButtonActionPerformed(evt);
            }
        });

        cancelButton.setText("Cancel");
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });

        disableDeviceTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "                                                Device Name"
            }
        ));
        jScrollPane2.setViewportView(disableDeviceTable);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(117, 117, 117)
                .addComponent(disableButton)
                .addGap(18, 18, 18)
                .addComponent(cancelButton)
                .addContainerGap(129, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(disableButton)
                    .addComponent(cancelButton))
                .addGap(19, 19, 19))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void disableButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_disableButtonActionPerformed
        // TODO add your handling code here:
        //when clicked on disable button remove the device from disable panel and 
        // show it in enable panel(and the device needs to be disable in enable panel).
        int selectedIndex = disableDeviceTable.getSelectedRow();
        if (selectedIndex >= 0) {
            Device device = Devices.getInstance().getEnabledDevices().get(selectedIndex);
            Devices.getInstance().disableDevice(device);
            DeviceSocketManager.getInstance().sendDeviceMessage(device);
            getSmartHomeSecurityFrame().replaceFramePanel(new MainPanel());
        }
    }//GEN-LAST:event_disableButtonActionPerformed

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        // TODO add your handling code here:
        getSmartHomeSecurityFrame().replaceFramePanel(new MainPanel());
    }//GEN-LAST:event_cancelButtonActionPerformed

    private SmartHomeSecurityFrame getSmartHomeSecurityFrame() {
        return (SmartHomeSecurityFrame) SwingUtilities.getWindowAncestor(this);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelButton;
    private javax.swing.JButton disableButton;
    private javax.swing.JTable disableDeviceTable;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}
