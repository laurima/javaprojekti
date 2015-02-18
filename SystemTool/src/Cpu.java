
import com.jezhumble.javasysmon.JavaSysMon;

/**
 *
 * @author Sami
 */
public class Cpu {
    
    private String cpuarchitecture;
    private String cpuidentifier;
    private String numberofcores;
    private long frequency;
    
    
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
    // (Huom: Intelin hyperthread ytimet lasketaan mukaan myös)
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
}
