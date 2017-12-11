package smart.home.security.view;

import java.awt.TextArea;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;
import smart.home.security.model.Device;
import smart.home.security.model.Devices;
import smart.home.security.utilities.DeviceTableModel;

public class DisablePanel1 extends javax.swing.JPanel {
    String ss=null;

    /**
     * Creates new form DisablePanel
     */
    public DisablePanel1() {
        initComponents();
        ///
          try {

            DefaultTableModel dtm = (DefaultTableModel) jTable1.getModel();
            dtm.setRowCount(0);
            
           
            Vector<String> Available_Devices = new Vector<>();
            String myip = InetAddress.getLocalHost().getHostAddress();
            String mynetworkips = new String();

            for (int i = myip.length(); i > 0; --i) {
                if (myip.charAt(i - 1) == '.') {
                    mynetworkips = myip.substring(0, i);
                    break;
                }
            }

            System.out.println("My Device IP: " + myip + "\n");

            System.out.println("Search log:");
            for (int i = 1; i <= 250; ++i) {
                try {
                    InetAddress addr = InetAddress.getByName(mynetworkips + new Integer(i).toString());
                    if (addr.isReachable(1000)) 
                    {
                        System.out.println("Available: " + addr.getHostAddress());
                        //Available_Devices.add(addr.getHostAddress());
            
                        Process proc = Runtime.getRuntime().exec("arp -a " + addr.getHostAddress());
                        BufferedReader stdInput = new BufferedReader(new InputStreamReader(proc.getInputStream()));
                       String s = null;
                        String s1 = null;
                        while ((s = stdInput.readLine()) != null) 
                        {
                            s1 = s;
//                            System.err.println(s1);

                        }
                         ss = s1.substring(s1.length() - 32, (s1.indexOf("dynamic")));
//                        list.add(ss);
                        System.out.println("only mac =" + ss);
             Available_Devices.add(addr.getHostAddress()+":"+ss);
                        
                        
                        
                    } 
                } catch (Exception ioex) {
                    System.out.println(ioex);
                }
            }
            List<String> list = new ArrayList();
            System.out.println("\nAll Connected devices(" + Available_Devices.size() + "):");
            int i = 0;
            for (i = 0; i < Available_Devices.size(); ++i) 
            {
                //list.add(Available_Devices.get(i));
                list.add(Available_Devices.get(i));
                System.out.println(Available_Devices.get(i));

            }

            Iterator itr = list.iterator();

            for (String a : list) 
            {
                String str[]= {a};
                dtm.addRow(str);

            }
            
            
            
            ///
            
            
            
                    
            
            
            ///
            
            
        } catch (Exception e) {
        }
        ///
        
        
        
        
        
        
        

//      try {
//
//            DefaultTableModel dtm = (DefaultTableModel) jTable1.getModel();
//            dtm.setRowCount(0);
//            Vector<String> Available_Devices = new Vector<>();
//            String myip = InetAddress.getLocalHost().getHostAddress();
//            String mynetworkips = new String();
//
//            for (int i = myip.length(); i > 0; --i) {
//                if (myip.charAt(i - 1) == '.') {
//                    mynetworkips = myip.substring(0, i);
//                    break;
//                }
//            }
//
//            System.out.println("My Device IP: " + myip + "\n");
//
//            System.out.println("Search log:");
//            for (int i = 73; i <= 200; ++i) {
//                try {
//                    InetAddress addr = InetAddress.getByName(mynetworkips + new Integer(i).toString());
//                    if (addr.isReachable(1000)) {
//                        System.out.println("Available: " + addr.getHostAddress());
//                        Available_Devices.add(addr.getHostAddress());
//                    } else {
////                    System.out.println("Not available: " + addr.getHostAddress());
//                    }
//                } catch (IOException ioex) {
//                }
//            }
//            List<String> list = new ArrayList();
//            System.out.println("\nAll Connected devices(" + Available_Devices.size() + "):");
//            int i = 0;
//            for (i = 0; i < Available_Devices.size(); ++i) {
//                list.add(Available_Devices.get(i));
//                System.out.println(Available_Devices.get(i));
//
//            }
//
//            Iterator itr = list.iterator();
////            while (itr.hasNext()) {
////                Object element = itr.next();
////                String hhh = element.toString();
////
////                System.out.println("element=" + element);
////            }
//            for (String a : list) {
//                String str[] = {a};
//                dtm.addRow(str);
//
//            }
//
//        } catch (Exception e) {
//        }

//        try {
//
//            DefaultTableModel dtm = (DefaultTableModel) jTable1.getModel();
//            dtm.setRowCount(0);
//            Vector<String> Available_Devices = new Vector<>();
//            
//            
//            String myip = InetAddress.getLocalHost().getHostAddress();
//            String mynetworkips = new String();
//
//            for (int i = myip.length(); i > 0; --i) 
//            {
//                if (myip.charAt(i - 1) == '.') {
//                    mynetworkips = myip.substring(0, i);
//                    break;
//                }
//            }
//
//            System.out.println("My Device IP: " + myip + "\n");
//
//            System.out.println("Search log:");
//            for (int i = 1; i <= 7; ++i) {
//                try {
//                    InetAddress addr = InetAddress.getByName(mynetworkips + new Integer(i).toString());
//                    if (addr.isReachable(1000)) {
//                        System.out.println("Available: " + addr.getHostAddress());
//                        Available_Devices.add(addr.getHostAddress());
//                    } else {
////                    System.out.println("Not available: " + addr.getHostAddress());
//                    }
//                } catch (IOException ioex) {
//                }
//            }
//            
//            
//            
//            
//            List<String> list = new ArrayList();
//            System.out.println("\nAll Connected devices(" + Available_Devices.size() + "):");
//            int i = 0;
//            for (i = 0; i < Available_Devices.size(); ++i) 
//            {
//                list.add(Available_Devices.get(i));
//                System.out.println(Available_Devices.get(i));
//
//            }
//
//            Iterator itr = list.iterator();
////            while (itr.hasNext()) {
////                Object element = itr.next();
////                String hhh = element.toString();
////
////                System.out.println("element=" + element);
////            }
//            for (String a : list) 
//            {
//                String str[] = {a};
//                dtm.addRow(str);
//
//            }
//
//        } catch (Exception e) {
//        }
//
////            DefaultTableModel model = new DefaultTableModel();
////            model.addRow(new String[]{hostIP});
////            jTable1.setModel(model);
////        } catch (Exception e) {
////        }
////        } catch (Exception e) 
////        {
////
////        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cancelButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Disable Device", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 1, 13))); // NOI18N
        setPreferredSize(new java.awt.Dimension(408, 309));

        cancelButton.setText("Cancel");
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Device Address"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jTable1MouseEntered(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 383, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(162, 162, 162)
                        .addComponent(cancelButton)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(cancelButton)
                .addContainerGap(43, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        // TODO add your handling code here:

        getSmartHomeSecurityFrame().replaceFramePanel(new MainPanel());
    }//GEN-LAST:event_cancelButtonActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
        int selectedIndex = jTable1.getSelectedRow();
        System.out.println("selectedIndex=" + selectedIndex);
        String val1 = (String) jTable1.getModel().getValueAt(selectedIndex, 0);
        System.out.println("val1=" + val1);
        
         String vall1=val1.substring(0,val1.length()-23);
        AddDevicePanel addDevicePanel = new AddDevicePanel(vall1);
        
//        AddDevicePanel addDevicePanel = new AddDevicePanel(val1);
        getSmartHomeSecurityFrame().replaceFramePanel(addDevicePanel);
//        int row = this.jTable1.getSelectedRow();
//        int column = this.jTable1.getSelectedColumn();
//        this.jTable1.getValueAt(selectedRow, selectedColumn);

    }//GEN-LAST:event_jTable1MouseClicked

    private void jTable1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseEntered
        // TODO add your handling code here:

    }//GEN-LAST:event_jTable1MouseEntered

    private SmartHomeSecurityFrame getSmartHomeSecurityFrame() {
        return (SmartHomeSecurityFrame) SwingUtilities.getWindowAncestor(this);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelButton;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
