/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cat.jamk;


import java.sql.Array;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;

/**
 *
 * @author lauri
 */
public class FXMLProjectGuiController {
    
    Array muuttujalista = new Array("computernametext2", "cpuarchitecturetext2", "cpufrequencytext2", "cputext", "diskfreespacetext2", "disktext", "disktext2", "homefoldertext2", "identifiertext2", "interfacenametext2", "ipaddresstext2", "macaddresstext2", "networktext2", "numberofcorestext2", "osarchitecturetext", "ostext", "ostext2", "osversiontext2", "processlisttext", "ramfreespacetext2", "ramtext2", "roamingprofiletext2", "usercountrytext2", "userdomaintext2", "userlanguagetext2", "usernametext2", "usertext");
    
    
    for (int i=0; muuttujalista.getLenght() < i;i++){
    private Label muuttujalista(i);
}


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
    String cpufrequency = Long.toString(cpu.getFrequency());
    String cpuload = Integer.toString(cpu.getCpuLoad());
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
//labelit taulukkoon ja taulukolla loopataan assert
        assert computernametext2 != null : "fx:id=\"computernametext2\" was not injected: check your FXML file 'FXMLProjectGui.fxml'.";
        assert cpuarchitecturetext2 != null : "fx:id=\"cpuarchitecturetext2\" was not injected: check your FXML file 'FXMLProjectGui.fxml'.";
        assert cpufrequencytext2 != null : "fx:id=\"cpufrequencytext2\" was not injected: check your FXML file 'FXMLProjectGui.fxml'.";
        assert cputext != null : "fx:id=\"cputext\" was not injected: check your FXML file 'FXMLProjectGui.fxml'.";
        assert diskfreespacetext2 != null : "fx:id=\"diskfreespacetext2\" was not injected: check your FXML file 'FXMLProjectGui.fxml'.";
        assert disktext != null : "fx:id=\"disktext\" was not injected: check your FXML file 'FXMLProjectGui.fxml'.";
        assert disktext2 != null : "fx:id=\"disktext2\" was not injected: check your FXML file 'FXMLProjectGui.fxml'.";
        assert homefoldertext2 != null : "fx:id=\"homefoldertext2\" was not injected: check your FXML file 'FXMLProjectGui.fxml'.";
        assert identifiertext2 != null : "fx:id=\"identifiertext2\" was not injected: check your FXML file 'FXMLProjectGui.fxml'.";
        assert interfacenametext2 != null : "fx:id=\"interfacenametext2\" was not injected: check your FXML file 'FXMLProjectGui.fxml'.";
        assert ipaddresstext2 != null : "fx:id=\"ipaddresstext2\" was not injected: check your FXML file 'FXMLProjectGui.fxml'.";
        assert macaddresstext2 != null : "fx:id=\"macaddresstext2\" was not injected: check your FXML file 'FXMLProjectGui.fxml'.";
        assert networktext2 != null : "fx:id=\"networktext2\" was not injected: check your FXML file 'FXMLProjectGui.fxml'.";
        assert numberofcorestext2 != null : "fx:id=\"numberofcorestext2\" was not injected: check your FXML file 'FXMLProjectGui.fxml'.";
        assert osarchitecturetext2 != null : "fx:id=\"osarchitecturetext2\" was not injected: check your FXML file 'FXMLProjectGui.fxml'.";
        assert ostext != null : "fx:id=\"ostext\" was not injected: check your FXML file 'FXMLProjectGui.fxml'.";
        assert ostext2 != null : "fx:id=\"ostext2\" was not injected: check your FXML file 'FXMLProjectGui.fxml'.";
        assert osversiontext2 != null : "fx:id=\"osversiontext2\" was not injected: check your FXML file 'FXMLProjectGui.fxml'.";
        assert processesscroll != null : "fx:id=\"processesscroll\" was not injected: check your FXML file 'FXMLProjectGui.fxml'.";
        assert processlisttext != null : "fx:id=\"processlisttext\" was not injected: check your FXML file 'FXMLProjectGui.fxml'.";
        assert ramfreespacetext2 != null : "fx:id=\"ramfreespacetext2\" was not injected: check your FXML file 'FXMLProjectGui.fxml'.";
        assert ramtext2 != null : "fx:id=\"ramtext2\" was not injected: check your FXML file 'FXMLProjectGui.fxml'.";
        assert roamingprofiletext2 != null : "fx:id=\"roamingprofiletext2\" was not injected: check your FXML file 'FXMLProjectGui.fxml'.";
        assert usercountrytext2 != null : "fx:id=\"usercountry2\" was not injected: check your FXML file 'FXMLProjectGui.fxml'.";
        assert userdomaintext2 != null : "fx:id=\"userdomaintext2\" was not injected: check your FXML file 'FXMLProjectGui.fxml'.";
        assert userlanguagetext2 != null : "fx:id=\"userlanguagetext2\" was not injected: check your FXML file 'FXMLProjectGui.fxml'.";
        assert usernametext2 != null : "fx:id=\"usernametext2\" was not injected: check your FXML file 'FXMLProjectGui.fxml'.";
        assert usertext != null : "fx:id=\"usertext\" was not injected: check your FXML file 'FXMLProjectGui.fxml'.";
        
        
        //etusivun tietoja
        cputext.setText(cpuarchitecture + " " + numberofcores + " " + cpufrequency);
        ramtext2.setText(ramtotalspace);
        ostext.setText(os + " " + osversion);
        disktext.setText(disktotalspace);
        usertext.setText(username);
        
        //takasivun tietoja
        ostext2.setText(os);
        osversiontext2.setText(osversion);
        osarchitecturetext2.setText(osarchitecture);
        usernametext2.setText(username);
        userlanguagetext2.setText(userlanguage);
        usercountrytext2.setText(usercountry);
        homefoldertext2.setText(homefolder);
        
        cpuarchitecturetext2.setText(cpuarchitecture);
        identifiertext2.setText(identifier);
        numberofcorestext2.setText(numberofcores);
        cpufrequencytext2.setText(cpufrequency);
        
        networktext2.setText(computername);
        computernametext2.setText(computername);
        userdomaintext2.setText(userdomain);
        roamingprofiletext2.setText(roamingprofile);
        macaddresstext2.setText(macaddress);
        ipaddresstext2.setText(ipaddress);
        interfacenametext2.setText(interfacename);
        
        ramtext2.setText(ramtotalspace);
        ramfreespacetext2.setText(ramfreespace);
        
        disktext2.setText(disktotalspace);
        diskfreespacetext2.setText(diskfreespace);
        
        
        
        
        for (int i = 0; i < processes.getProcesses().length; i++) {
        processlisttext.setText(processes.getProcesses()[i] + "\t" + processes.getProcessMemUsage(os) + "\n");

        }
        
        
}
    


    
    
    
    }
