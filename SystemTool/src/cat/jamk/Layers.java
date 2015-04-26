/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cat.jamk;


/**
 *
 * @author Laurin
 */

public class Layers extends GuiSetup{
    
    private String operatingsystem, operatingversion,operatingarchitecture,operatingusername,operatinguserlanguage,operatingusercounry,operatinghomefolder,cpuarchitecture,cpuidentifier,cpunumberofcores,cpufrequency,networkcomputername,networkipaddress,networkuserdomain,networkroamingprofile,networkmacaddress,networkinterfacename,ramtotalspace, ramfreespace,disktotalspace,diskfreespace, frontuser,frontcpu,frontram,frontdisk;

    
    //konstruktori
    public Layers() {
        OperatingSystem os = new OperatingSystem();
        Cpu cpu = new Cpu();
        Ram ram = new Ram();
        Disk disk = new Disk();
        Network network = new Network();
        
        this.operatingsystem = os.getOS();
        this.operatingversion = os.getOsVersion();
        this.operatingarchitecture = os.getOsArchitecture();
        this.operatingusername = os.getUsername();
        this.operatinguserlanguage = os.getUserLanguage();
        this.operatingusercounry = os.getUserCountry();
        this.operatinghomefolder = os.getHomeFolder();
        this.cpuarchitecture = cpu.getArchitecture();
        this.cpuidentifier = cpu.getIdentifier();
        this.cpunumberofcores = cpu.getNumberOfCores();
        this.cpufrequency = String.valueOf(cpu.getFrequency());
        this.networkcomputername = network.getComputerName();
        this.networkuserdomain = network.getUserDomain();
        this.networkipaddress = network.getIpAddress();
        this.networkroamingprofile = network.getRoamingProfile();
        this.networkmacaddress = network.getMacAddress();
        this.networkinterfacename = network.getInterfaceName();
        this.ramtotalspace = String.valueOf(ram.getTotalRam());
        this.ramfreespace = String.valueOf(ram.getFreeRam());
        this.disktotalspace = String.valueOf(disk.getTotalSpace());
        this.diskfreespace = String.valueOf(disk.getUsableSpace());
        this.frontuser = os.getUsername();
        this.frontcpu = cpu.getArchitecture() + " @" + cpu.getFrequency() + " Hz";
        this.frontram = String.valueOf(ram.getTotalRam());
        this.frontdisk = String.valueOf(disk.getTotalSpace());
    }

    

    
    public void updateLiveLabels() {
        Cpu cpu = new Cpu();
        Ram ram = new Ram();
        Disk disk = new Disk();
        this.diskfreespace=(String.valueOf(disk.getUsableSpace()) + " Gt");
        this.ramfreespace=(String.valueOf(ram.getFreeRam()) + " Gt");
        this.cpufrequency=(String.valueOf(cpu.getFrequency()) + " Hz");
        
        
    }

    
    //getterit
    
    
    public String getOperatingsystem() {
        return operatingsystem;
    }

    public String getNetworkipaddress() {
        return networkipaddress;
    }

    public String getOperatingversion() {
        return operatingversion;
    }

    public String getOperatingarchitecture() {
        return operatingarchitecture;
    }

    public String getOperatingusername() {
        return operatingusername;
    }

    public String getOperatinguserlanguage() {
        return operatinguserlanguage;
    }

    public String getOperatingusercounry() {
        return operatingusercounry;
    }

    public String getOperatinghomefolder() {
        return operatinghomefolder;
    }

    public String getCpuarchitecture() {
        return cpuarchitecture;
    }

    public String getCpuidentifier() {
        return cpuidentifier;
    }

    public String getCpunumberofcores() {
        return cpunumberofcores;
    }

    public String getCpufrequency() {
        return cpufrequency;
    }

    public String getNetworkcomputername() {
        return networkcomputername;
    }

    public String getNetworkuserdomain() {
        return networkuserdomain;
    }

    public String getNetworkroamingprofile() {
        return networkroamingprofile;
    }

    public String getNetworkmacaddress() {
        return networkmacaddress;
    }

    public String getNetworkinterfacename() {
        return networkinterfacename;
    }

    public String getRamtotalspace() {
        return ramtotalspace;
    }

    public String getRamfreespace() {
        return ramfreespace;
    }

    public String getDisktotalspace() {
        return disktotalspace;
    }

    public String getDiskfreespace() {
        return diskfreespace;
    }

    public String getFrontuser() {
        return frontuser;
    }

    public String getFrontcpu() {
        return frontcpu;
    }

    public String getFrontram() {
        return frontram;
    }

    public String getFrontdisk() {
        return frontdisk;
    }

    
    //setterit
    public void setCpufrequency(String cpufrequency) {
        this.cpufrequency = cpufrequency;
    }

    public void setRamfreespace(String ramfreespace) {
        this.ramfreespace = ramfreespace;
    }

    public void setDiskfreespace(String diskfreespace) {
        this.diskfreespace = diskfreespace;
    }

    public void setFrontcpu(String frontcpu) {
        this.frontcpu = frontcpu;
    }
    
    
}