/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.jamk;
import javax.swing.JFrame;

/**
 *
 * @author lauri
 */
    public class IkkunaTesti extends JFrame {
        
        public IkkunaTesti() {
            super("IkkunaTesti");
            setDefaultCloseOperation(EXIT_ON_CLOSE);
            setSize(600,400);
            setResizable(false);
        }
        public static void main(String args[]) {
            new IkkunaTesti().setVisible(true);
       
        
    }      
}
