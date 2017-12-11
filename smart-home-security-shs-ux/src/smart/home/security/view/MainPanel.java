/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smart.home.security.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.InputStream;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.Timer;
import smart.home.security.model.Device;
import smart.home.security.model.Devices;
import smart.home.security.utilities.AudioManager;
import smart.home.security.utilities.DeviceSocketManager;


/**
 *
 * @author chana
 */
public class MainPanel extends javax.swing.JPanel {
private static final int TIME_VISIBLE = 2000;
    /**
     * Creates new form MainPanel
     */   
    public MainPanel() {
        initComponents();
        updateStatus();        
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        addButton = new javax.swing.JButton();
        removeButton = new javax.swing.JButton();
        armButton = new javax.swing.JButton();
        disarmButton = new javax.swing.JButton();
        enableButton = new javax.swing.JButton();
        disableButton = new javax.swing.JButton();
        statusLabel = new javax.swing.JLabel();

        setBorder(javax.swing.BorderFactory.createTitledBorder(null, "SMART HOME SECURITY", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Lucida Grande", 1, 14))); // NOI18N
        setForeground(new java.awt.Color(0, 0, 0));
        setToolTipText("");
        setPreferredSize(new java.awt.Dimension(408, 309));

        addButton.setFont(new java.awt.Font("Lucida Grande", 1, 12)); // NOI18N
        addButton.setText("Add Device");
        addButton.setToolTipText("Add a device");
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });

        removeButton.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        removeButton.setText("Remove Device");
        removeButton.setToolTipText("Remove a device");
        removeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeButtonActionPerformed(evt);
            }
        });

        armButton.setFont(new java.awt.Font("Lucida Grande", 1, 12)); // NOI18N
        armButton.setText("Arm System");
        armButton.setToolTipText("Arm system");
        armButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                armButtonActionPerformed(evt);
            }
        });

        disarmButton.setFont(new java.awt.Font("Lucida Grande", 1, 12)); // NOI18N
        disarmButton.setText("Disarm System");
        disarmButton.setToolTipText("Disarm system");
        disarmButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                disarmButtonActionPerformed(evt);
            }
        });

        enableButton.setFont(new java.awt.Font("Lucida Grande", 1, 12)); // NOI18N
        enableButton.setText("Enable Device");
        enableButton.setToolTipText("Enable device");
        enableButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                enableButtonActionPerformed(evt);
            }
        });

        disableButton.setFont(new java.awt.Font("Lucida Grande", 1, 12)); // NOI18N
        disableButton.setText("Disable Device");
        disableButton.setToolTipText("Disable a device");
        disableButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                disableButtonActionPerformed(evt);
            }
        });

        statusLabel.setFont(new java.awt.Font("Lucida Grande", 1, 12)); // NOI18N
        statusLabel.setText("Status");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(addButton, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(armButton, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1)
                        .addComponent(enableButton, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(removeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(disarmButton, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(disableButton, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(statusLabel)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(statusLabel)
                .addGap(152, 152, 152)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(addButton)
                    .addComponent(armButton)
                    .addComponent(enableButton))
                .addGap(9, 9, 9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(removeButton)
                    .addComponent(disarmButton)
                    .addComponent(disableButton))
                .addContainerGap(39, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private SmartHomeSecurityFrame getSmartHomeSecurityFrame() {
        return (SmartHomeSecurityFrame) SwingUtilities.getWindowAncestor(this);
    }

    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed
       DisablePanel1 add = new DisablePanel1();
        getSmartHomeSecurityFrame().replaceFramePanel(add);
    }//GEN-LAST:event_addButtonActionPerformed

    private void removeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeButtonActionPerformed
        // TODO add your handling code here:
        RemoveDevicePanel removeDevicePanel = new RemoveDevicePanel();
        getSmartHomeSecurityFrame().replaceFramePanel(removeDevicePanel);
    }//GEN-LAST:event_removeButtonActionPerformed

    private void armButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_armButtonActionPerformed
        Devices.getInstance().armDevices();
        for (Device device : Devices.getInstance().getDevices()) 
        {
            DeviceSocketManager.getInstance().sendDeviceMessage(device);
        }
        updateStatus();
        JOptionPane pane = new JOptionPane("The System is Armed", JOptionPane.INFORMATION_MESSAGE);
        JDialog dialog = pane.createDialog(null, "");
        dialog.setModal(false);
        dialog.setVisible(true);

        new Timer(TIME_VISIBLE, new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent evt) {
                dialog.setVisible(false);
            }
        }).start();
        AudioManager audioManager = new AudioManager();
        audioManager.playAudio(AudioManager.SYSTEM_ARMED);
    }//GEN-LAST:event_armButtonActionPerformed

    private void disarmButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_disarmButtonActionPerformed
         Devices.getInstance().disarmDevices();
        for (Device device : Devices.getInstance().getDevices()) {
            DeviceSocketManager.getInstance().sendDeviceMessage(device);
        }
                
        updateStatus();
        
        
        InputStream inputStream;
        JOptionPane pane = new JOptionPane("The System is Disarmed", JOptionPane.INFORMATION_MESSAGE);
        JDialog dialog = pane.createDialog(null, "");
        dialog.setModal(false);
        dialog.setVisible(true);

        new Timer(TIME_VISIBLE, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {

                dialog.setVisible(false);

            }
        }).start();
        AudioManager audioManager = new AudioManager();
        audioManager.playAudio(AudioManager.SYSTEM_DISARMED);
    }//GEN-LAST:event_disarmButtonActionPerformed

    private void enableButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_enableButtonActionPerformed
        EnablePanel enablePanel = new EnablePanel();
        getSmartHomeSecurityFrame().replaceFramePanel(enablePanel);
    }//GEN-LAST:event_enableButtonActionPerformed

    private void disableButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_disableButtonActionPerformed
        DisablePanel disablePanel = new DisablePanel();
        getSmartHomeSecurityFrame().replaceFramePanel(disablePanel);
    }//GEN-LAST:event_disableButtonActionPerformed

    private void updateStatus() {        
        if (Devices.getInstance().armed()) {            
            statusLabel.setText("Status: System Armed");
        } else {
            statusLabel.setText("Status: System Disarmed");
        } 
        armButton.setEnabled(Devices.getInstance().canArmDevices());
        disarmButton.setEnabled(Devices.getInstance().canDisarmDevices());
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addButton;
    private javax.swing.JButton armButton;
    private javax.swing.JButton disableButton;
    private javax.swing.JButton disarmButton;
    private javax.swing.JButton enableButton;
    private javax.swing.JButton removeButton;
    public javax.swing.JLabel statusLabel;
    // End of variables declaration//GEN-END:variables
}
