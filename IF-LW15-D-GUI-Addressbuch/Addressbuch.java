import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

/**
 *
 * Beschreibung
 *
 * @version 1.0 vom 08.12.2023
 * @author 
 */

public class Addressbuch extends JFrame {
  // Anfang Attribute
  private JButton jButton1 = new JButton();
  private JTextField jTextField1 = new JTextField();
  private JTextField jTextField2 = new JTextField();
  // Ende Attribute
  
  public Addressbuch() { 
    // Frame-Initialisierung
    super();
    setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    int frameWidth = 305; 
    int frameHeight = 232;
    setSize(frameWidth, frameHeight);
    Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
    int x = (d.width - getSize().width) / 2;
    int y = (d.height - getSize().height) / 2;
    setLocation(x, y);
    setTitle("Addressbuch");
    setResizable(false);
    Container cp = getContentPane();
    cp.setLayout(null);
    // Anfang Komponenten
    
    jButton1.setBounds(40, 72, 209, 41);
    jButton1.setText("Testen");
    jButton1.setMargin(new Insets(2, 2, 2, 2));
    jButton1.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        jButton1_ActionPerformed(evt);
      }
    });
    cp.add(jButton1);
    jTextField1.setBounds(32, 16, 225, 33);
    cp.add(jTextField1);
    jTextField2.setBounds(32, 136, 225, 33);
    cp.add(jTextField2);
    // Ende Komponenten
    
    setVisible(true);
  } // end of public Addressbuch
  
  // Anfang Methoden
  
  public static void main(String[] args) {
    new Addressbuch();
  } // end of main
  
  public void jButton1_ActionPerformed(ActionEvent evt) {
    String input = this.jTextField1.getText();
    this.jTextField2.setText(input);

  } // end of jButton1_ActionPerformed

  // Ende Methoden
} // end of class Addressbuch
