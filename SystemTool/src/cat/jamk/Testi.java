package cat.jamk;


import com.jezhumble.javasysmon.CpuTimes;
import com.jezhumble.javasysmon.JavaSysMon;

/**
 *
 * @author Sami
 */

public class Testi {
    
    public static void testi() {
      
       
       System.out.println("----------- OS INFO ----------"); 
        
       OperatingSystem os = new OperatingSystem();
       
       System.out.println("OS: " + os.getOS());
       System.out.println("OS Version: " + os.getOsVersion());
       System.out.println("Username: " + os.getUsername());
       System.out.println("User language: " + os.getUserLanguage());
       System.out.println("User country: " + os.getUserCountry());
       System.out.println("User homefolder: " + os.getHomeFolder());
       
       
        Runtime runtime = Runtime.getRuntime();
       
        
        Cpu cpu = new Cpu();
        JavaSysMon monitor=new JavaSysMon();
        
        System.out.println("-------- CPU INFO --------");
        System.out.println("Architecture: " + cpu.getArchitecture());
        System.out.println("Identifier: " + cpu.getIdentifier());
        System.out.println("Number of cores: " + cpu.getNumberOfCores());
        System.out.println("CPU frequency: " + cpu.getFrequency() + " MHz");
        System.out.println("CPU load: " + cpu.getCpuLoad() + " %");

        
        
        Network network = new Network();
        
        System.out.println("-------- NETWORK INFO --------");
        System.out.println("Computer name: " + network.getComputerName());
        System.out.println("User Domain: " + network.getUserDomain());
        System.out.println("Roaming Profile: " + network.getRoamingProfile());
        System.out.println("Mac address: " + network.getMacAddress());
        System.out.println("Ip address: " + network.getIpAddress());
        System.out.println("Interface Name: " + network.getInterfaceName());
        
        Processes p = new Processes();
        System.out.println("------ PROCESS INFO -------");
        System.out.println("Explorer.exe sessionname: " + p.getProcessSessionName("explorer.exe"));
        System.out.println("Explorer.exe memusage: " + p.getProcessMemUsage("explorer.exe"));
        
        /*
        for (int i = 0; i < p.getProcesses().length; i++) {
        System.out.println("Processes: " + p.getProcesses()[i]);
        }
        */
        
        System.out.println("------ RAM INFO ------");
        Ram ram = new Ram();
        System.out.println("Ram total: " + ram.getTotalRam() + " Gb");
        System.out.println("Ram free: " + ram.getFreeRam() + " Gb");
        System.out.println("Ram usage: " + ram.getUsageRam() + " Gb");
        
        
        Disk disk = new Disk();
        
        System.out.println("-------- DISK INFO --------");
        System.out.println("Total space: " + disk.getTotalSpace() + " Gb");
        System.out.println("Usable space: " + disk.getUsableSpace() + " Gb");
        System.out.println("Free space: " + disk.getFreeSpace() + " Gb");
        
        
    }
}
