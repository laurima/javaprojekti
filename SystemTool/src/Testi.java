
import com.jezhumble.javasysmon.CpuTimes;
import com.jezhumble.javasysmon.JavaSysMon;

/**
 *
 * @author Sami
 */

public class Testi {
    
    public static void main(String args[]) {
      
       
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

        CpuTimes times = new CpuTimes(monitor.cpuTimes().getUserMillis(), monitor.cpuTimes().getSystemMillis(), monitor.cpuTimes().getIdleMillis());
        System.out.println(monitor.cpuTimes().getCpuUsage(times));
        
        Network network = new Network();
        
        System.out.println("-------- NETWORK INFO --------");
        System.out.println("Computer name: " + network.getComputerName());
        System.out.println("User Domain: " + network.getUserDomain());
        System.out.println("Roaming Profile: " + network.getRoamingProfile());
        
        Processes p = new Processes();

        
        System.out.println("------ RAM INFO ------");
        Ram ram = new Ram();
        System.out.println("ram total: " + ram.getTotalRam() + " Gb");
        System.out.println("ram free: " + ram.getFreeRam() + " Gb");
        System.out.println("ram usage: " + ram.getUsageRam() + " Gb");
        
        
        Disk disk = new Disk();
        
        System.out.println("-------- DISK INFO --------");
        System.out.println("Total space: " + disk.getTotalSpace() + " Mb");
        System.out.println("Usable space: " + disk.getUsableSpace() + " Mb");
        System.out.println("Free space: " + disk.getFreeSpace() + " Mb");
        
        
    }
}
