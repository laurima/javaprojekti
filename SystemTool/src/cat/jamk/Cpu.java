package cat.jamk;


import com.jezhumble.javasysmon.JavaSysMon;
import com.sun.management.OperatingSystemMXBean;
import java.lang.management.ManagementFactory;

/**
 *
 * @author Sami
 */
public class Cpu {
    
    private String cpuarchitecture;
    private String cpuidentifier;
    private String numberofcores;
    private long frequency;
    private int cpuload;
    
    // Konstruktori
    public Cpu() {
        cpuarchitecture = "";
        cpuidentifier = "";
        numberofcores = "";
        frequency = 0;
        cpuload = 0;             
    }
    
    // Palauttaa prosessorin arkkitehtuurin
    public String getArchitecture() {
        this.cpuarchitecture = System.getenv("PROCESSOR_ARCHITECTURE");
        return this.cpuarchitecture;
    }
    
    // Palauttaa prosessorin identifierin
    public String getIdentifier() {
        this.cpuidentifier = System.getenv("PROCESSOR_IDENTIFIER");
        return this.cpuidentifier;
    }
    
    // Palauttaa prosessorin ytimien määrän 
    // Huom: Intelin hyperthread ytimet lasketaan mukaan myös (kai)
    public String getNumberOfCores() {
        this.numberofcores = System.getenv("NUMBER_OF_PROCESSORS");
        return this.numberofcores;
    }
    
    // Palauttaa prosessorin kellotaajuuden
    public long getFrequency() {
        JavaSysMon monitor=new JavaSysMon();
        this.frequency = (monitor.cpuFrequencyInHz() / 1000000);
        return this.frequency;
    }
    
    // Palauttaa prosessorin käytön / rasituksen prosentteina
    // Huom: ensimmäinen tulos ei pidä paikkaansa, stabiloituu vasta muutaman mittauksen jälkeen
    public int getCpuLoad() {
        OperatingSystemMXBean operatingSystemMXBean = (com.sun.management.OperatingSystemMXBean)ManagementFactory.getOperatingSystemMXBean();
        this.cpuload = (int)(operatingSystemMXBean.getSystemCpuLoad() * 100);
        return this.cpuload;
    }
}
