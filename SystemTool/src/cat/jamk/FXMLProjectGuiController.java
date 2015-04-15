/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cat.jamk;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;

/**
 *
 * @author lauri
 */
public class FXMLProjectGuiController {
    
        @FXML
    private ResourceBundle resources;

        @FXML
    private URL location;

    @FXML
    private Label cputext;

    @FXML
    private Label disktext;

    @FXML
    private Label ostext;

    @FXML
    private Label ramtext;

    @FXML
    private Label usertext;
    
    @FXML
    private Label processlisttext;
    
    @FXML
    private ScrollPane processesscroll;


        
    OperatingSystem operatingsystem = new OperatingSystem();
    Cpu cpu = new Cpu();
    Network network = new Network();
    Ram ram = new Ram();
    Processes processes = new Processes();
    Disk disk = new Disk();
    
    //operating system
    String osversion = operatingsystem.getOsVersion();
    String os = operatingsystem.getOS();
    String osarchitecture = operatingsystem.getOsArchitecture();
    String username = operatingsystem.getUsername();
    String userlanguage = operatingsystem.getUserLanguage();
    String homefolder = operatingsystem.getHomeFolder();
    String usercountry = operatingsystem.getUserCountry();
    //CPU
    String cpuarchitecture = cpu.getArchitecture();
    String identifier = cpu.getIdentifier();
    String numberofcores = cpu.getNumberOfCores();
    long cpufrequency = cpu.getFrequency();
    int cpuload = cpu.getCpuLoad();
    //network
    String computername = network.getComputerName();
    String userdomain = network.getUserDomain();
    String roamingprofile = network.getRoamingProfile();
    String macaddress = network.getMacAddress();
    String ipaddress = network.getIpAddress();
    String interfacename = network.getInterfaceName();
    //process
    String sessionname = processes.getProcessSessionName(os);
    String explorermemusage = processes.getProcessMemUsage(os);
    //ram
    String ramtotalspace = Float.toString(ram.getTotalRam());
    String ramusablespace = Float.toString(ram.getUsageRam());
    String ramfreespace = Float.toString(ram.getFreeRam());
    //disk
    String disktotalspace = Long.toString(disk.getTotalSpace());
    String diskusablespace = Long.toString(disk.getUsableSpace());
    String diskfreespace = Long.toString(disk.getUsableSpace());
        
    
    
    
    

    
    
    
    @FXML
    void initialize() {

        assert cputext != null : "fx:id=\"cputext\" was not injected: check your FXML file 'FXMLProjectGui.fxml'.";
        assert disktext != null : "fx:id=\"disktext\" was not injected: check your FXML file 'FXMLProjectGui.fxml'.";
        assert ostext != null : "fx:id=\"ostext\" was not injected: check your FXML file 'FXMLProjectGui.fxml'.";
        assert ramtext != null : "fx:id=\"ramtext\" was not injected: check your FXML file 'FXMLProjectGui.fxml'.";
        assert usertext != null : "fx:id=\"usertext\" was not injected: check your FXML file 'FXMLProjectGui.fxml'.";
        assert processlisttext != null : "fx:id=\"processlisttext\" was not injected: check your FXML file 'FXMLProjectGui.fxml'.";
        
        cputext.setText(cpuarchitecture + " " + numberofcores + " " + cpufrequency);
        ramtext.setText(ramtotalspace);
        ostext.setText(os + " " + osversion);
        disktext.setText(disktotalspace);
        usertext.setText(username);
        for (int i = 0; i < processes.getProcesses().length; i++) {
        processlisttext.setText(processes.getProcesses()[i] + "        " + processes.getProcessMemUsage(os));

        }
        
        
}

   

    


    }
