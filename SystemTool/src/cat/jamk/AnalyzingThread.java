/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cat.jamk;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 *
 * @author Sami
 */
public class AnalyzingThread extends Thread {
    
    private String name;
    private HashMap<String, Timer> softwaretimers;
    private String[] processes;
    private String[] lastprocesses;
    
    // Konstruktori
    public AnalyzingThread(String name) {
        this.name = name;
        this.lastprocesses = null;
        this.processes = null;
        softwaretimers = new HashMap<>();
    }        
    
    @Override
    public void run() {
        while (true) {
            MysqlHandler handler = new MysqlHandler();
            if (handler.isConnection()) {
            // TODO: tausta analysointi, mysliin tuuppaukset
                Processes proc = new Processes();
                
                // Etsitään nykyiset prosessit
                processes = proc.getProcesses();
                if (lastprocesses == null) {
                    lastprocesses = processes;
                }

                /* Tsekataan onko softien kellotus päällä. Jos ei ole,
                   niin tehdään ja startataan uusi. */
                String software;                    
                for (int i = 0; i < processes.length; i++) {
                    software = handler.translate(processes[i], "software");
                    if (!(software.equals(""))) {
                        if (!(softwaretimers.containsKey(software))) {                            
                            softwaretimers.put(software, new Timer(software));
                            softwaretimers.get(software).startTimer();
                        }
                    }
                }
                
                /* Jos edelliset prosessit eroaa nykyisistä (eli jokin softa
                   on suljettu), niin poistetaan sen timeri */
                if (!(lastprocesses == processes)) {
                    Set<String> diff = new HashSet<>(Arrays.asList(lastprocesses));
                    diff.removeAll(Arrays.asList(processes));
                    
                    Iterator it = diff.iterator();
                    while (it.hasNext()) {
                        String key = (String)it.next();
                        if (softwaretimers.containsKey(key)) {
                            softwaretimers.remove(key);
                        }
                    }
                }
                
                // Softien aikojen päivitys tietokantaan
                Iterator it = softwaretimers.keySet().iterator();
                while (it.hasNext()) {
                    String key = (String)it.next();
                    if (softwaretimers.get(key).isExpired()) {
                        Network nw = new Network();
                        if (!(handler.isSoftwareTime(handler.getUserId(nw.getMacAddress()), key))) {
                            handler.insertSoftwareTime(handler.getUserId(nw.getMacAddress()), key, 1);
                        } else if (handler.isSoftwareTime(handler.getUserId(nw.getMacAddress()), key)) {
                            handler.updateSoftwareTime(handler.getUserId(nw.getMacAddress()), key, 1);
                        }
                        softwaretimers.get(key).startTimer();
                    }
                }
                
                lastprocesses = processes;
                System.out.println("Thread: " + name);
            }
                      
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }   
}
