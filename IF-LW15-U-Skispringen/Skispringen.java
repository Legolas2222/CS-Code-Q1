import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.event.*;


public class Skispringen extends JFrame {
  // Anfang Attribute
  private JLabel jLabel1 = new JLabel();
  private JLabel jLabel2 = new JLabel();
  private JLabel jLabel3 = new JLabel();
  private JLabel jLabel4 = new JLabel();
  private JTextArea jTextAreaStart1 = new JTextArea("");
  private JScrollPane jTextAreaStart1ScrollPane = new JScrollPane(jTextAreaStart1);
  private JTextArea jTextAreaErgebnis1 = new JTextArea("");
  private JScrollPane jTextAreaErgebnis1ScrollPane = new JScrollPane(jTextAreaErgebnis1);
  private JTextArea jTextAreaStart2 = new JTextArea("");
  private JScrollPane jTextAreaStart2ScrollPane = new JScrollPane(jTextAreaStart2);
  private JTextArea jTextAreaErgebnis2 = new JTextArea("");
  private JScrollPane jTextAreaErgebnis2ScrollPane = new JScrollPane(jTextAreaErgebnis2);
  private JButton jButtonStartlisteErzeugen = new JButton();
  private JButton jButtonDruchgang1 = new JButton();
  private JButton jButtonDurchgang2 = new JButton();
  private Skispringerliste startliste1;
  private Skispringerliste ergebnisliste1;
  private Skispringerliste startliste2;
  private Skispringerliste ergebnisliste2;

  // Ende Attribute
  public Skispringen(String title) {
    // Frame-Initialisierung
    super(title);
    setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    
    int frameWidth = 759; 
    int frameHeight = 648;
    setSize(frameWidth, frameHeight);
    
    Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
    int x = (d.width - getSize().width) / 2;
    int y = (d.height - getSize().height) / 2;
    setLocation(x, y);
    setResizable(false);
    
    Container cp = getContentPane();
    cp.setLayout(null);
    // Anfang Komponenten
    jLabel1.setBounds(8, 8, 110, 20);
    jLabel1.setText("Startliste");
    cp.add(jLabel1);
    jLabel2.setBounds(192, 8, 132, 20);
    jLabel2.setText("Ergebnis 1. Durchgang");
    cp.add(jLabel2);
    jLabel3.setBounds(376, 8, 134, 20);
    jLabel3.setText("Startliste 2. Durchgang");
    cp.add(jLabel3);
    jLabel4.setBounds(560, 8, 110, 20);
    jLabel4.setText("Endergebnis");
    cp.add(jLabel4);
    jTextAreaStart1ScrollPane.setBounds(8, 32, 168, 524);
    cp.add(jTextAreaStart1ScrollPane);
    jTextAreaErgebnis1ScrollPane.setBounds(192, 32, 168, 524);
    cp.add(jTextAreaErgebnis1ScrollPane);
    jTextAreaStart2ScrollPane.setBounds(376, 32, 168, 524);
    cp.add(jTextAreaStart2ScrollPane);
    jTextAreaErgebnis2ScrollPane.setBounds(560, 32, 168, 524);
    cp.add(jTextAreaErgebnis2ScrollPane);
    jButtonStartlisteErzeugen.setBounds(8, 568, 171, 25);
    jButtonStartlisteErzeugen.setText("Startliste erzeugen");
    jButtonStartlisteErzeugen.setMargin(new Insets(2, 2, 2, 2));
    jButtonStartlisteErzeugen.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent evt) {
        jButtonStartlisteErzeugen_ActionPerformed(evt);
      }
    });
    cp.add(jButtonStartlisteErzeugen);
    jButtonDruchgang1.setBounds(192, 568, 171, 25);
    jButtonDruchgang1.setText("1. Durchgang");
    jButtonDruchgang1.setMargin(new Insets(2, 2, 2, 2));
    jButtonDruchgang1.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent evt) {
        jButtonDruchgang1_ActionPerformed(evt);
      }
    });
    cp.add(jButtonDruchgang1);
    jButtonDurchgang2.setBounds(472, 568, 155, 25);
    jButtonDurchgang2.setText("2. Durchgang");
    jButtonDurchgang2.setMargin(new Insets(2, 2, 2, 2));
    jButtonDurchgang2.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent evt) {
        jButtonDurchgang2_ActionPerformed(evt);
      }
    });
    cp.add(jButtonDurchgang2);
    // Ende Komponenten
    startliste1 = new Skispringerliste();
    ergebnisliste1 = new Skispringerliste();
    startliste2 = new Skispringerliste();
    ergebnisliste2 = new Skispringerliste();
    jTextAreaStart1.setEditable(false);
    jTextAreaStart2.setEditable(false);
    jTextAreaErgebnis1.setEditable(false);
    jTextAreaErgebnis2.setEditable(false);
    
    setVisible(true);
  }

  // Anfang Methoden
  public void jButtonStartlisteErzeugen_ActionPerformed(ActionEvent evt) {
    for (int lNr = 1; lNr <= 50; lNr++) {
      startliste1.anhaengen(new Skispringer());
    }
    
    jTextAreaStart1.setText(startliste1.alsText());
  }

  public void jButtonDruchgang1_ActionPerformed(ActionEvent evt) {
    durchgang1();
    jTextAreaErgebnis1.setText(ergebnisliste1.alsText());
    
    bestimmeStartliste2();
    jTextAreaStart2.setText(startliste2.alsText());
  }

  public void jButtonDurchgang2_ActionPerformed(ActionEvent evt) {
    durchgang2();
    jTextAreaErgebnis2.setText(ergebnisliste2.alsText());
  }

  /**
  * Der erste Durchgang wird durchgef�hrt.
  * Jeder Skispringer erh�lt eine zuf�llige Punktzahl zwischen 80 und 120 und
  * wird passend in der Ergebnisliste eingeordnet.
  */
  public void durchgang1() {
    startliste1.zumAnfang();
    while (startliste1.hatZugriff()) {
      startliste1.aktuellerSkispringer().setzePunktzahl(1,80,120);
      startliste1.weiter();
    }
    startliste1.zumAnfang();
    ergebnisliste1.zumAnfang();
    while (startliste1.hatZugriff()) {
      sortiertEinfügenGroesste(ergebnisliste1, startliste1.aktuellerSkispringer(), 1);
      startliste1.weiter();
    }
  }

  /**
  * Die Startliste f�r den zweiten Durchgang wird erzeugt. Sie besteht aus
  * den besten 30 Springern des ersten Durchgangs in umgekehrter Reihenfolge.
  * Dabei kann der 30. Platz mehrfach vergeben sein.
  */
  public void bestimmeStartliste2() {
    this.ergebnisliste1.zumAnfang();
    for (int i = 0; i < 50; i++) {
      //sortiertEinfügenKleinste(startliste2, ergebnisliste1.aktuellerSkispringer(), 1);
      ergebnisliste1.weiter();
    }
  }

  public void sortiertEinfügenGroesste(Skispringerliste liste, Skispringer elem, int durchgang) {
    liste.zumAnfang();
    if (liste.istLeer()) {
      liste.einfuegen(elem);
      return;
    }
    
    while (liste.hatZugriff() && liste.aktuellerSkispringer().gibPunktzahl(durchgang) > elem.gibPunktzahl(durchgang)) {
        liste.weiter();
        if (liste.hatZugriff()) {
          liste.einfuegen(elem);
        }
        else {
          liste.anhaengen(elem);
        }
      }
    }
  
  

  /**
  * Der zweite Durchgang wird durchgef�hrt. Jeder Skispringer erh�lt eine
  * zuf�llige Punktzahl zwischen 80 % und 120 % des ersten Durchgangs und wird
  * nach der Gesamtpunktzahl in der Ergebnisliste eingeordnet.
  */
  public void durchgang2() {
    // ToDo: Quelltext einf�gen
  }

  public static void main(String[] args) {
    new Skispringen("Skispringen");
  }
}
