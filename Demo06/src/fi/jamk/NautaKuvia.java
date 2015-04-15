package fi.jamk;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.MediaTracker;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;


public class NautaKuvia extends JFrame implements ActionListener {
    private Image image1, image2, image3;
    private MediaTracker mt;
    
    private JButton button1, button2, button3;
    private JPanel up, center;
    
    // Konstruktori
    public NautaKuvia() {
        // Otsikko
        super("NaytaKuvia Appis");
        // Ladataan kuvat
        lataaKuvat();
        // Luodaan Buttonit
        button1 = new JButton("eka");
        button1.addActionListener(this);
        button2 = new JButton("toka");
        button2.addActionListener(this);
        button3 = new JButton("kolmas");
        button3.addActionListener(this);
        // luodaan up Paneeli
        up = new JPanel();
        up.setLayout(new FlowLayout());
        up.add(button1);
        up.add(button2);
        up.add(button3);
        // Luodaan center paneeli
        center = new JPanel();
        // Lisätään paneelit ikkunaan eli JFrameen
        getContentPane().add(up, BorderLayout.NORTH);
        getContentPane().add(center, BorderLayout.CENTER);
        // Ikkunan koko
        setSize(400, 400);
        // Ikkunan sulkeminen
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
    }
    
    // Metodi lataa kuvat levyltä
    private void lataaKuvat() {
        image1 = getToolkit().createImage("kuva1.jpg");
        image2 = getToolkit().createImage("kuva2.jpg");
        image3 = getToolkit().createImage("kuva3.jpg");
        // Odotellaan kuvien latautuminen
        mt = new MediaTracker(this);
        mt.addImage(image1, 0);
        mt.addImage(image2, 1);
        mt.addImage(image3, 2);
        try {
            mt.waitForAll();
        } catch (Exception e) {
            // nothing...
        }
    }
    
    // Main
    public static void main(String args[]) {
        try {
        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            System.out.println("Haluttua tuntumaa ei saada käyttöön");
        }
        new NautaKuvia().setVisible(true);
        
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // center paneelin piirtopinta
        Graphics g = center.getGraphics();
        // Mitä buttonia on painettu
        JButton pressed = (JButton) e.getSource();
        if (pressed == button1) {
            g.drawImage(image1, 10, 10, this);
        } else if (pressed == button2) {
            g.drawImage(image2, 10, 10, this);
        } else if (pressed == button3) {
            g.drawImage(image3, 10, 10, this);
        }
    }
    
}

​

