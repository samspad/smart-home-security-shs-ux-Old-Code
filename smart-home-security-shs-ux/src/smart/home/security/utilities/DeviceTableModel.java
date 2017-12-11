package smart.home.security.utilities;

import java.net.InetAddress;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import smart.home.security.model.Device;
public class DeviceTableModel 
{
    public static DefaultTableModel defaultTableModel(List<Device> devices) {
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Name");
//        model.addColumn("Address");
        
        for (Device device : devices) 
        {
            model.addRow(new String[] {device.getAddress()});
        }
        
        return model;
    }    

    
}
