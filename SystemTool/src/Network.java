
import java.net.InetAddress;
import java.net.NetworkInterface;


/**
 *
 * @author Sami
 */
public class Network {
    
    private String computername;
    private String userdomain;
    private String roamingprofile;
    private String macaddress;
    private String ipaddress;
    private String interfacename;
    
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
    
    // Valmis koodi : http://stackoverflow.com/questions/19291814/get-mac-address-in-java
    // Palauttaa verkkokortin mac-osoitteen
    public String getMacAddress() {
        try {
        InetAddress ip = InetAddress.getLocalHost();
        NetworkInterface net = NetworkInterface.getByInetAddress(ip);
        
        byte[] mac = net.getHardwareAddress();
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < mac.length; i++) {
            sb.append(String.format("%02X%s", mac[i], (i < mac.length - 1) ? "-" : ""));        
        }
        
        this.macaddress = sb.toString();
        } catch (Exception e) {
            System.out.println(e);
        }
        return this.macaddress;
    }
    
    // Valmis koodi : http://stackoverflow.com/questions/19291814/get-mac-address-in-java
    // Palauttaa nykyisen ip-osoitteen
    // Huom: sisäverkon osoite
    public String getIpAddress() {
        try {    
            InetAddress ip = InetAddress.getLocalHost();
            this.ipaddress = ((String)ip.getHostAddress());
        } catch (Exception e) {
            System.out.println(e);
        }
        return this.ipaddress;
    }
    
    // Palauttaa sovittimen nimen
    public String getInterfaceName() {
        try {
            InetAddress ip = InetAddress.getLocalHost();
            NetworkInterface net = NetworkInterface.getByInetAddress(ip);
            this.interfacename = (String)net.getDisplayName();
        } catch (Exception e) {
            System.out.println(e);
        }         
        return this.interfacename;
    }
}
