/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.jamk;

/**
 *
 * @author lauri
 */
import javax.swing.*;
import java.awt.*; 
import java.awt.event.ActionListener;
import java.awt.event.*;

public class tehtava1b {
  public tehtava1b(){
    JFrame frm = new JFrame("Muunnin");
    frm.setBounds(300,300,840,800);
    frm.setLayout(null);
    frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    Container content = frm.getContentPane();
    content.setBackground(Color.black);
    JTextField text = new JTextField();
    text.setBounds(70,25,100,30);
    JButton button1, button2; 
    JTextField syote, tulos;
    button1 = new JButton("Euroiksi");
    button2 = new JButton("Markoiksi");
    syote = new JTextField("Anna luku");
    tulos = new JTextField("Vastaus");
    button1.setBounds(270,25,120,50);
    button2.setBounds(270,90,120,50);
    button1.addActionListener(new ButtonHandler());
    button2.addActionListener(new ButtonHandler());
    syote.setBounds(270,25,120,50);
    tulos.setBounds(270,25,120,50);
    syote.addActionListener(new ButtonHandler());
    tulos.addActionListener(new ButtonHandler());
    frm.add(button1);
    frm.add(button2);
    frm.add(syote);
    frm.add(tulos);
    frm.add(text);
    frm.setVisible(true);
    frm.setResizable(false);
  }

   public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {

            private final JTabbedPane jtp = new JTabbedPane();

            @Override
            public void run() {
                tehtava1b tehtava = new tehtava1b();
            }
        });
    }
  
  class ButtonHandler implements ActionListener {    
  }
    public void actionPerformed(ActionEvent e) {     
      Float syote = new Float();     
      Float = e.getActionCommand();    
      System.out.println(" " + str);
    }
  }  
