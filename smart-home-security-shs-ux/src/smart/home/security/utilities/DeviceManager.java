package smart.home.security.utilities;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import smart.home.security.model.Device;
import smart.home.security.model.Devices;

public class DeviceManager extends Thread {

    public static final String DEVICES_FILE_NAME = ".shs_devices.txt";
//    public static final String DEVICES_FILE_NAME = "D:\\Shahid_ali_sent_code\\smart-home-security-shs-ux_10_12\\smart-home-security-shs-ux\\src\\smart\\home\\security\\model\\File.txt";

    public void run() {
        try {
            saveDevices();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void loadDevices() {
        try {
            FileManager fileManager = new FileManager();
            List<String> rawDevices = fileManager.readFile(deviceFilePath());
            for (String rawDevice : rawDevices) {
                Devices.getInstance().addDevice(Device.deserialize(rawDevice));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void saveDevices() throws IOException {
        List<Device> devices = Devices.getInstance().getDevices();
        List<String> rawDevices = new ArrayList<>();
        for (Device device : devices) {
            rawDevices.add(device.serialize());
        }

        FileManager fileManager = new FileManager();
        fileManager.saveFile(rawDevices, deviceFilePath());
    }

    private static String deviceFilePath() {
        return System.getProperty("user.home") + File.separator + DEVICES_FILE_NAME;
    }
}
