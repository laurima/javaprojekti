
import java.io.BufferedReader;
import java.io.InputStreamReader;


/**
 *
 * @author Sami
 */
public class Processes {
    
    private String processsessionname;
    private String memusage;
    
    
    // Tulostaa kaikki käynnissä olevat prosessit tietoineen
    public void printProcesses() {
    try {
        String line;
        Process p = Runtime.getRuntime().exec("tasklist.exe");
        BufferedReader input =
                new BufferedReader(new InputStreamReader(p.getInputStream()));
        while ((line = input.readLine()) != null) {
            System.out.println(line);
        }
        input.close();
        }  catch (Exception e) {
            System.out.println(e);
        }
    }
    
    
    // Palauttaa prosessin sessionin nimen
    public String getProcessSessionName(String process) {
        try {
        String line;
        Process p = Runtime.getRuntime().exec("tasklist.exe");
        BufferedReader input = new BufferedReader(new InputStreamReader(p.getInputStream()));
        while ((line = input.readLine()) != null) {
            String[] split = line.split("\\s+");
            for (int i = 0; i < split.length; i++) {
                if (split[i].equals(process)) {
                    this.processsessionname = split[2];
                }
            }
        }
        input.close();
        }  catch (Exception e) {
            System.out.println(e);
        }
        return this.processsessionname;
    }
    
    
    // Palauttaa prosessin muistinkäytön nykyisellä hetkellä
    public String getProcessMemUsage(String process) {
        try {
        String line;
        char[] result;
        Process p = Runtime.getRuntime().exec("tasklist.exe");
        BufferedReader input = new BufferedReader(new InputStreamReader(p.getInputStream()));
        while ((line = input.readLine()) != null) {
            String[] split = line.split("\\s+");
            for (int i = 0; i < split.length; i++) {
                if (split[i].equals(process)) {
                    if (split[4].contains("�")) {
                        for (int y = 0; y < split[4].length(); y++) {
                            if (split[4].charAt(y) == '�') {
                                result = split[4].toCharArray();
                                result[y] = '0';
                                this.memusage = String.valueOf(result);
                            }
                        }
                    } else {
                        this.memusage = split[4];
                    }                
                }
            }
        }
        input.close();
        }  catch (Exception e) {
            System.out.println(e);
        }
        return this.memusage;
    }
}
