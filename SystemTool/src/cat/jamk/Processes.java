package cat.jamk;


import java.io.BufferedReader;
import java.io.InputStreamReader;


/**
 *
 * @author Sami
 */
public class Processes {
    private int processcount;
    private String[] processes;
    private String processsessionname;
    private String memusage;
    
    // Konstruktori
    
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
    
    // Laskee käynnissä olevat prosessit
    public int countProcesses() {
        try {
        String line;
        Process p = Runtime.getRuntime().exec("tasklist.exe");
        BufferedReader input = new BufferedReader(new InputStreamReader(p.getInputStream()));
        while ((line = input.readLine()) != null) {
            String[] split = line.split("\\s+");
            for (int i = 0; i < split.length; i++) {
                if (split[i].equals("Services") || split[i].equals("Console")) {
                    this.processcount++;
                }
            }
        }
        input.close();
        }  catch (Exception e) {
            System.out.println(e);
        }
        return this.processcount;
    }
    
    // Palauttaa listan käynnissä olevista prosesseista    
    public String[] getProcesses() {
        Processes proc = new Processes();
        try {
        String line;
        String result[] = new String[proc.countProcesses()];
        int y = 0;
        Process p = Runtime.getRuntime().exec("tasklist.exe");
        BufferedReader input = new BufferedReader(new InputStreamReader(p.getInputStream()));
        while ((line = input.readLine()) != null) {
            String[] split = line.split("\\s+");
            for (int i = 0; i < split.length; i++) {
                if (split[i].equals("Services") || split[i].equals("Console")) {
                    result[y] = split[i-2];
                    y++;
                }
            }
        }
        this.processes = result;
        input.close();
        } catch (Exception e) {
            System.out.println(e);
        }

        return this.processes;
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
