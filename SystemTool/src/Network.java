
/**
 *
 * @author Sami
 */
public class Network {
    
    private String computername;
    private String userdomain;
    private String roamingprofile;
    
    // Palauttaa työaseman nimen
    public String getComputerName(){
        this.computername = System.getenv("COMPUTERNAME");
        return this.computername;
    }
    
    // Palauttaa toiminta-alueen (Toivottavasti)
    public String getUserDomain() {
        this.userdomain = System.getenv("USERDOMAIN");
        return this.userdomain;
    }
    
    
    // Palauttaa roaming profiilin
    public String getRoamingProfile() {
        this.roamingprofile = System.getenv("USERDOMAIN_ROAMINGPROFILE");
        return this.roamingprofile;
    }
}
