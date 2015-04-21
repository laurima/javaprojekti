/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cat.jamk;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;

/**
 *
 * @author lauri
 */
public class FXMLProjectGuiController {
    private String labelslist[] = {"cpufrequencytext2","macaddresstext2", "processlisttext", "cpuarchitecturetext2", "disktext2", "usernametext2", "roamingprofiletext2", "ramtext", "diskfreespacetext3", "networktext2", "homefoldertext2", "ramtext2", "usertext", "cputext", "usercountrytext2", "computernametext2", "ostext2", "osarchitecturetext2", "identifiertext2", "ostext", "userlanguagetext2", "processpiechart", "disktext", "ipaddresstext2", "numberofcorestext2", "userdomaintext2", "osversiontext2", "ramfreespacetext2", "interfacenametext2"};
    
    
private String cpufrequency,  cpuload, ramtotalspace,ramusablespace, ramfreespace, disktotalspace,diskusablespace, diskfreespace, macaddress, cpuarrchitecture, username, roamingprofile, network2, homefolder,
            user, usercountry, computername, os, userlanguage, ipaddress, numberofcores, userdomain, osversion,interfacename;





  @FXML
    private Label cpufrequencytext2, macaddresstext2, processlisttext, cpuarchitecturetext2, disktext2, usernametext2, roamingprofiletext2, ramtext, diskfreespacetext2, networktext2, homefoldertext2, ramtext2, usertext, cputext, usercountrytext2, computernametext2, ostext2,
          osarchitecturetext2, identifiertext2, ostext, userlanguagetext2, disktext, ipaddresstext2, numberofcorestext2, userdomaintext2, osversiontext2, ramfreespacetext2, interfacenametext2;

  private TextArea textarea;
  
    @FXML
    private ScrollPane processesscroll;
    
    @FXML
    private PieChart frontpagepie;

private boolean firstrun = false;



    
public void updateLiveLabels() {
        Cpu cpu = new Cpu();
        Ram ram = new Ram();
        Disk disk = new Disk();
        this.cpuload = Integer.toString(cpu.getCpuLoad());
        diskfreespacetext2.setText(Long.toString(disk.getUsableSpace()));
        ramfreespacetext2.setText(Float.toString(ram.getFreeRam()));
        cpufrequencytext2.setText(Long.toString(cpu.getFrequency()));
    }
    
    public void updateStaticLabels() {
         if (firstrun == true){}
         else {
              //Home page info
        cputext.setText(cpu.getArchitecture() + " " + cpu.getNumberOfCores() + " " + cpufrequency);
        ramtext2.setText(ramtotalspace);
        ostext.setText(operatingsystem.getOS() + " ver. " + operatingsystem.getOsVersion());
        disktext.setText(disktotalspace);
        usertext.setText(operatingsystem.getUsername());
        
        //Overview page info
        ostext2.setText(operatingsystem.getOS());
        osversiontext2.setText(operatingsystem.getOsVersion());
        osarchitecturetext2.setText(operatingsystem.getOsArchitecture());
        usernametext2.setText(operatingsystem.getUsername());
        userlanguagetext2.setText(operatingsystem.getUserLanguage());
        usercountrytext2.setText(operatingsystem.getUserCountry());
        homefoldertext2.setText(operatingsystem.getHomeFolder());
        
        cpuarchitecturetext2.setText(cpu.getArchitecture());
        identifiertext2.setText(cpu.getIdentifier());
        numberofcorestext2.setText(cpu.getNumberOfCores());
        cpufrequencytext2.setText(cpufrequency);
        
        networktext2.setText( network.getComputerName());
        computernametext2.setText(network.getComputerName());
        userdomaintext2.setText(network.getUserDomain());
        roamingprofiletext2.setText(network.getRoamingProfile());
        macaddresstext2.setText(network.getMacAddress());
        ipaddresstext2.setText(network.getIpAddress());
        interfacenametext2.setText(network.getInterfaceName());
        
        
        ramtext2.setText(ramtotalspace);
        ramfreespacetext2.setText(ramfreespace);
        
        disktext2.setText(disktotalspace);
        diskfreespacetext2.setText(diskfreespace);
        }
    }
    
    public void updateProcessesList() {
        Processes processes = new Processes();
        String result[] = new String[processes.countProcesses()];
        
        for (int i = 0; i < processes.getProcesses().length; i++) {
        result[i] = processes.getProcesses()[i];
        }
        result = processes.getProcesses();
        for (int i = 0; i < processes.getProcesses().length; i++) {
        textarea.setText(result[i] + "\t" + processes.getProcessMemUsage(result[i]));
        }
    }
    
    public void updateFrontPagePie() {
            
    }
        
    OperatingSystem operatingsystem = new OperatingSystem();
    Cpu cpu = new Cpu();
    Network network = new Network();
    Ram ram = new Ram();
    Processes processes = new Processes();
    Disk disk = new Disk();
    /*
    //typecasted toString for labels
    String cpufrequency = Long.toString(cpu.getFrequency());
    String cpuload = Integer.toString(cpu.getCpuLoad());
    //ram
    String ramtotalspace = Float.toString(ram.getTotalRam());
    String ramusablespace = Float.toString(ram.getUsageRam());
    String ramfreespace = Float.toString(ram.getFreeRam());
    //disk
    String disktotalspace = Long.toString(disk.getTotalSpace());
    String diskusablespace = Long.toString(disk.getUsableSpace());
    String diskfreespace = Long.toString(disk.getUsableSpace());
*/

    
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
        cputext.setText(cpu.getArchitecture() + " " + cpu.getNumberOfCores() + " " + cpufrequency);
        ramtext.setText(ramtotalspace);
        ostext.setText(operatingsystem.getOS() + " ver. " + operatingsystem.getOsVersion());
        disktext.setText(disktotalspace);
        usertext.setText(operatingsystem.getUsername());
        
        //takasivun tietoja
        ostext2.setText(operatingsystem.getOS());
        osversiontext2.setText(operatingsystem.getOsVersion());
        osarchitecturetext2.setText(operatingsystem.getOsArchitecture());
        usernametext2.setText(operatingsystem.getUsername());
        userlanguagetext2.setText(operatingsystem.getUserLanguage());
        usercountrytext2.setText(operatingsystem.getUserCountry());
        homefoldertext2.setText(operatingsystem.getHomeFolder());
        
        cpuarchitecturetext2.setText(cpu.getArchitecture());
        identifiertext2.setText(cpu.getIdentifier());
        numberofcorestext2.setText(cpu.getNumberOfCores());
        cpufrequencytext2.setText(cpufrequency);
        
        networktext2.setText( network.getComputerName());
        computernametext2.setText(network.getComputerName());
        userdomaintext2.setText(network.getUserDomain());
        roamingprofiletext2.setText(network.getRoamingProfile());
        macaddresstext2.setText(network.getMacAddress());
        ipaddresstext2.setText(network.getIpAddress());
        interfacenametext2.setText(network.getInterfaceName());
        
        
        ramtext2.setText(ramtotalspace);
        ramfreespacetext2.setText(ramfreespace);
        
        disktext2.setText(disktotalspace);
        diskfreespacetext2.setText(diskfreespace);
        
       String processeshelp[] = null;
       int processlaskuri = processes.countProcesses();
       for(int k=0;k>processlaskuri;k++){
           processeshelp[k] = processes.getProcesses()[k];
       }
       

}

}
