import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.io.*;

/**
  *
  * Oberfläche für das Irrgartenprojekt
  *
  * @version 1.0 vom 22.09.2008
  * @author Daniel Garmann
  */

public class Gui extends JFrame {
  // Anfang Attribute
  private Irrgarten irrgarten = new Irrgarten();
  private JFileChooser jfco = new JFileChooser();
  private JButton jButton1 = new JButton();
  private JButton jButton2 = new JButton();
  private JTextArea jTextArea1 = new JTextArea("");
    private JScrollPane jTextArea1ScrollPane = new JScrollPane(jTextArea1);
  // Ende Attribute

  public Gui(String title) {
    // Frame-Initialisierung
    super (title);
    setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    int frameWidth = 318; 
    int frameHeight = 328;
    setSize(frameWidth, frameHeight);
    Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
    int x = (d.width - getSize().width) / 2;
    int y = (d.height - getSize().height) / 2;
    setLocation(x, y);
    Container cp = getContentPane();
    cp.setLayout(null);
    // Anfang Komponenten

    jButton1.setBounds(72, 8, 75, 25);
    jButton1.setText("Laden");
    jButton1.setMargin(new Insets(2, 2, 2, 2));
    jButton1.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        jButton1_ActionPerformed(evt);
      }
    });
    cp.add(jButton1);
    jButton2.setBounds(160, 8, 75, 25);
    jButton2.setText("Lösen");
    jButton2.setMargin(new Insets(2, 2, 2, 2));
    jButton2.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        jButton2_ActionPerformed(evt);
      }
    });
    cp.add(jButton2);
    jTextArea1ScrollPane.setBounds(16, 48, 281, 225);
    jTextArea1.setFont(new Font("Courier", Font.PLAIN, 12));
    cp.add(jTextArea1ScrollPane);
    // Ende Komponenten

    setResizable(false);
    setVisible(true);
  }

  // Anfang Methoden
  
  public void paint(Graphics g) {
    super.paint(g);
    irrgarten.ausgeben(jTextArea1);
  }
  
  private String jfcoOpenFilename() {
    jfco.setDialogTitle("Öffne Datei");                                 // neuer Öffnen-Dialog
    jfco.setCurrentDirectory(new File(System.getProperty("user.dir"))); // Verzeichnis auf aktuelles Projektverzeichnis setzen
    if (jfco.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {     // Wenn ok gedrückt wurde
      return jfco.getSelectedFile().getPath();                          // dann Dateinamen zurückgeben
    } else {
      return null;
    }
  }

  public void jButton1_ActionPerformed(ActionEvent evt) {
    String dateiname = jfcoOpenFilename();            // Öffnen-Dialog starten
    if (dateiname != null) {
      irrgarten = new Irrgarten(dateiname);
    } else {
      irrgarten = new Irrgarten();
    }
    repaint();
  }

  public void jButton2_ActionPerformed(ActionEvent evt) {
    irrgarten.loesen();                               // Irrgarten lösen
    repaint();
  }

  // Ende Methoden

  public static void main(String[] args) {
    new Gui("Gui");
  }
}
