package cat.jamk;



/**
 *
 * @author Sami
 */

public class OperatingSystem {
    
    private String os;
    private String osversion;
    private String osarchitecture;
    private String username;
    private String userlanguage;
    private String usercountry;
    private String homefolder;
    
    // Konstruktori
    public OperatingSystem() {
        os = "";
        osversion = "";
        osarchitecture = "";
        username = "";
        userlanguage = "";
        usercountry = "";
        homefolder = "";
    }
    
    // Palauttaa käyttöjärjestelmän
    public String getOS(){
        this.os = System.getProperty("os.name");
        return this.os;
    }
    
    // Palauttaa käyttöjärjestelmän version
    public String getOsVersion() {
        this.osversion = System.getProperty("os.version");
        return this.osversion;
    }
    
    // Palauttaa käyttöjärjestelmän arkkitehtuurin
    public String getOsArchitecture() {
        this.osarchitecture = System.getProperty("os.arch");
        return this.osarchitecture;
    }
    
    // Palauttaa käyttäjänimen
    public String getUsername() {
        this.username = System.getProperty("user.name");
        return this.username;
    }
    
    // Paluttaa käyttäjän kieliasetuksen
    public String getUserLanguage() {
        this.userlanguage = System.getProperty("user.language");
        return this.userlanguage;
    }
    
    // Palauttaa käyttäjän kotikansion polun
    public String getHomeFolder() {
        this.homefolder = System.getProperty("user.home");
        return this.homefolder;
    }
    
    // Palauttaa käyttäjän maan
    public String getUserCountry() {
        this.usercountry = System.getProperty("user.country");
        return this.usercountry;
    }
}

/*
System.out.println("OS: " + os.getOS());
       System.out.println("OS Version: " + os.getOsVersion());
       System.out.println("Username: " + os.getUsername());
       System.out.println("User language: " + os.getUserLanguage());
       System.out.println("User country: " + os.getUserCountry());
       System.out.println("User homefolder: " + os.getHomeFolder());
*/