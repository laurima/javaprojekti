
package cat.jamk;

/**
 *
 * @author Sami
 */
public class Timer {
    
    private String name;
    private long time;
    private long delay;
    private boolean expired;
    private int minutesrunning;
    
    public Timer(String name) {
        this.name = name;
        this.delay = 60000;
        this.expired = false;
        this.minutesrunning = 0;
    }
    
    public void startTimer() {
        this.time = System.currentTimeMillis();
    }
    
    public boolean isExpired() {
        if (System.currentTimeMillis() - this.time > this.delay) {
            this.expired = true;
        } else {
            this.expired = false;
        }
        
        return this.expired;
    }
    
    public void addMinute() {
        this.minutesrunning++;
    }
    
    public int getMinutesRunning() {
        return this.minutesrunning;
    }
    
    public String getName() {
        return this.name;
    }
}
