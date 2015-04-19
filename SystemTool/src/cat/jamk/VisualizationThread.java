/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cat.jamk;

/**
 *
 * @author Sami
 */
public class VisualizationThread extends Thread {
    
    private String name;
    
    // Konstruktori
    public VisualizationThread(String name) {
        this.name = name;
    }
    
    @Override
    public void run() {
        DataUpdates dataupdates = new DataUpdates(null,null,null,null);
        while (true) {
            
            // TODO: Visualisoinnin päivittäminen
            dataupdates.getCdiskfree();
            dataupdates.getCpufrequency();
            dataupdates.getCpuload();
            dataupdates.getFreeram();
            
            System.out.println("Thread: " + name); 
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
                System.out.println(e);
            }
        }        
    }
    
    
}