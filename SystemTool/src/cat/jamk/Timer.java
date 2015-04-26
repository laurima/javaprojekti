
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
    
    // Konstruktori
    public Timer(String name) {
        this.name = name;
        this.delay = 60000; // Minuutin viive
        this.expired = false;
        this.minutesrunning = 0;
    }
    
    // Kellon starttaus / resetointi
    public void startTimer() {
        this.time = System.currentTimeMillis();
    }
    
    // Ajan tsekkaus
    public boolean isExpired() {
        if (System.currentTimeMillis() - this.time > this.delay) {
            this.expired = true;
        } else {
            this.expired = false;
        }
        
        return this.expired;
    }
    
    // Minuutin lisääminen. (Ei käyttöä nykyisessä versiossa, mahdollisesti tulevaisuudessta)
    public void addMinute() {
        this.minutesrunning++;
    }
    
    // Minuuttien kysyminen. ( Ei käyttöä nykyisessä versiossa, mahdollisesti tulevaisuudessta )
    public int getMinutesRunning() {
        return this.minutesrunning;
    }
    
    // Nimen kysyminen.
    public String getName() {
        return this.name;
    }
}
