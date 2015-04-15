/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.jamk;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import javafx.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JFrame;

/**
 *
 * @author lauri
 */
public class TapahtumaPainikkeissa extends JFrame implements ActionListener {
  private JFrame kehys;    
  private JButton p1,p2;
    
  public TapahtumaPainikkeissa() {
    kehys = new JFrame("Tapahtumankäsittely");
    alustaKomponentit();
    kehys.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    kehys.setSize(400,300);
    kehys.setVisible(true);
  }
    
  public void alustaKomponentit() {
    Container contentPane = kehys.getContentPane();
    contentPane.setLayout(new GridLayout(2, 1));
    p1 = new JButton("Painike1");
    // rekisteröidään painikkeen tapahtumankäsittely luokan sisälle (ei sisäistä luokkaa)
    p1.addActionListener(this);
    p2 = new JButton("Painike2");
    // rekisteröidään painikkeen tapahtumankäsittely luokan sisälle (ei sisäistä luokkaa)
    p2.addActionListener(this);
    contentPane.add(p1);
    contentPane.add(p2);
  }

  public static void main(String args[]){
    new TapahtumaPainikkeissa();
  }
    
  // tapahtumankäsittelyn toteuttava metodi
  public void actionPerformed(ActionEvent e){
    // mitä painiketta painettiin
    if (e.getSource() == p1) System.out.println("Painike1");
    if (e.getSource() == p2) System.out.println("Painike2");
  }
    
}eHops 6s:llä ohjelmistosuunnittelun moduulit 5k:lle
Mikkolo Heidi yrittäjyys kuviot. heidi.mikkola@jamk.fi
D421 klo alkaa 14.15 ja 14.50 embedded systems paketti. Esittely, mitä sisältää.
Matilta kysyä, voiko kesällä embedded systems projektia.
