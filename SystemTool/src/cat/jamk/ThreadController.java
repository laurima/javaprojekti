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
public class ThreadController extends Thread {
    
    private String name;
    
    // Konstruktori
    public ThreadController(String name) {
        this.name = name;        
    }        
    
    @Override
    public void run() {
        while (true) {
            if (name.equals("Visualization")) {                
                // TODO: visualisoinnin päivittäminen
                System.out.println("Thread: " + name);
            }
            if (name.equals("Analyzation")) {
                MysqlHandler handler = new MysqlHandler();
                if (handler.isConnection()) {
                // TODO: tausta analysointi, mysliin tuuppaukset
                System.out.println("Thread: " + name);
                }
            }           
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }   
}
