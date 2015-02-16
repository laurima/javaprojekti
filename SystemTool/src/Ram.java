
import com.jezhumble.javasysmon.JavaSysMon;


/**
 *
 * @author Sami
 */
public class Ram {
    
    private float totalram;
    private float freeram;
    private float usageram;
    
    
    // Paluttaa kokonais ram määrän megatavuina
    public float getTotalRam() {
        JavaSysMon monitor = new JavaSysMon();

        long totalBytes = monitor.physical().getTotalBytes();
        
        this.totalram = totalBytes/(float)(1024*1024*1024);
          
        return this.totalram;
    }
    
    // Palauttaa vapaana olevan ramin määrän megatavuina
    public float getFreeRam() {
        JavaSysMon monitor = new JavaSysMon();
        
        long freeBytes = monitor.physical().getFreeBytes();
        this.freeram = freeBytes/(float)(1024*1024*1024);
        
        return this.freeram;
    }
    
    // Palauttaa käytössä olevan ramin määrän megatavuina
    public float getUsageRam() {
        Ram ram = new Ram();
        this.usageram = ram.getTotalRam() - ram.getFreeRam();
        
        return this.usageram;
    }
    
}
