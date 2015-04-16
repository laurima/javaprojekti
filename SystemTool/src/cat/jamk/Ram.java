package cat.jamk;


import com.jezhumble.javasysmon.JavaSysMon;

/**
 *
 * @author Sami
 */
public class Ram {
    
    private float totalram;
    private float freeram;
    private float usageram;
    
    public Ram() {
        totalram = 0;
        freeram = 0;
        usageram = 0;
    }
    
    // Palauttaa kokonais ram määrän gigatavuina
    public float getTotalRam() {
        JavaSysMon monitor = new JavaSysMon();

        long totalBytes = monitor.physical().getTotalBytes();
        this.totalram = totalBytes/(float)(1024*1024*1024);
          
        return this.totalram;
    }
    
    // Palauttaa vapaana olevan ramin määrän gigatavuina
    public float getFreeRam() {
        JavaSysMon monitor = new JavaSysMon();
        
        long freeBytes = monitor.physical().getFreeBytes();
        this.freeram = freeBytes/(float)(1024*1024*1024);
        
        return this.freeram;
    }
    
    // Palauttaa käytössä olevan ramin määrän gigatavuina
    public float getUsageRam() {
        Ram ram = new Ram();
        this.usageram = ram.getTotalRam() - ram.getFreeRam();
        
        return this.usageram;
    }
    
}
