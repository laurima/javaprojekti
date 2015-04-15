/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cat.jamk;

/**
 *
 * @author h8543
 */
public class ThreadController extends Thread {
    
    private Thread thread;
    private String name;
    
    // Konstruktori
    public ThreadController(String name) {
        this.name = name;
    }
    
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("Thread name: " + name);
        }
    }

    
}
