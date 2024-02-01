import java.awt.*;
import java.awt.event.*;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javax.swing.*;
import javax.swing.event.*;


/**
  *
  * Beschreibung
  *
  * @version 1.0 vom 25.07.2014
  * @author Markus Minklai
  */
public class Bundesjugendspiele extends JFrame {
  
  private JPanel jPanelKarte = new JPanel(null, true);
  private JLabel jLabel1 = new JLabel();
  private JLabel jLabel2 = new JLabel();
  private JLabel jLabel3 = new JLabel();
  private JLabel jLabel4 = new JLabel();
  private JLabel jLabel5 = new JLabel();
  private JLabel jLabel6 = new JLabel();
  private JLabel jLabel7 = new JLabel();
  private JTextField jTextFieldName = new JTextField();
  private JTextField jTextFieldVorname = new JTextField();
  private JTextField jTextFieldKlasse = new JTextField();
  private JTextField jTextFieldAlter = new JTextField();
  private JTextField jTextFieldLauf = new JTextField();
  private JTextField jTextFieldWurf = new JTextField();
  private JTextField jTextFieldSprung = new JTextField();
  private JButton jButtonNeueKarteHinzufuegen = new JButton();
  private JButton jButtonLaden = new JButton();
  private JButton jButtonSpeichern = new JButton();
  private JPanel jPanelListe = new JPanel(null, true);
  private JTextArea jTextAreaAusgabe = new JTextArea("");
  private JScrollPane jTextAreaAusgabeScrollPane = new JScrollPane(jTextAreaAusgabe);
  private JLabel jLabel8 = new JLabel();
  private JLabel jLabel9 = new JLabel();
  private JComboBox jComboBoxDisziplin = new JComboBox();
  private JComboBox jComboBoxSortierverfahren = new JComboBox();
  private JButton jButtonBestimmeBesten = new JButton();
  private JButton jButtonSortieren = new JButton();
  private Wettkampfliste wettkampfliste;
  
  
  public Bundesjugendspiele(String title) {
    // Frame-Initialisierung
    super(title);
    setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    
    int frameWidth = 888;
    int frameHeight = 399;
    setSize(frameWidth, frameHeight);
    
    Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
    int x = (d.width - getSize().width) / 2;
    int y = (d.height - getSize().height) / 2;
    setLocation(x, y);
    setResizable(false);
    
    Container cp = getContentPane();
    cp.setLayout(null);
    // Anfang Komponenten
    jPanelKarte.setBounds(8, 8, 260, 348);
    jPanelKarte.setOpaque(false);
    jPanelKarte.setBorder(BorderFactory.createTitledBorder("Wettkampfkarte"));
    cp.add(jPanelKarte);
    jLabel1.setBounds(16, 32, 78, 20);
    jLabel1.setText("Name");
    jPanelKarte.add(jLabel1);
    jLabel2.setBounds(16, 64, 78, 20);
    jLabel2.setText("Vorname");
    jPanelKarte.add(jLabel2);
    jLabel3.setBounds(16, 96, 78, 20);
    jLabel3.setText("Klasse");
    jPanelKarte.add(jLabel3);
    jLabel4.setBounds(16, 128, 78, 20);
    jLabel4.setText("Alter");
    jPanelKarte.add(jLabel4);
    jLabel5.setBounds(16, 160, 78, 20);
    jLabel5.setText("Lauf");
    jPanelKarte.add(jLabel5);
    jLabel6.setBounds(16, 192, 78, 20);
    jLabel6.setText("Wurf");
    jPanelKarte.add(jLabel6);
    jLabel7.setBounds(16, 224, 78, 20);
    jLabel7.setText("Sprung");
    jPanelKarte.add(jLabel7);
    jTextFieldName.setBounds(96, 32, 150, 20);
    jPanelKarte.add(jTextFieldName);
    jTextFieldVorname.setBounds(96, 64, 150, 20);
    jPanelKarte.add(jTextFieldVorname);
    jTextFieldKlasse.setBounds(96, 96, 150, 20);
    jPanelKarte.add(jTextFieldKlasse);
    jTextFieldAlter.setBounds(96, 128, 150, 20);
    jPanelKarte.add(jTextFieldAlter);
    jTextFieldLauf.setBounds(96, 160, 150, 20);
    jPanelKarte.add(jTextFieldLauf);
    jTextFieldWurf.setBounds(96, 192, 150, 20);
    jPanelKarte.add(jTextFieldWurf);
    jTextFieldSprung.setBounds(96, 224, 150, 20);
    jPanelKarte.add(jTextFieldSprung);
    jButtonNeueKarteHinzufuegen.setBounds(88, 264, 155, 25);
    jButtonNeueKarteHinzufuegen.setText("Neue Karte hinzufügen");
    jButtonNeueKarteHinzufuegen.setMargin(new Insets(2, 2, 2, 2));
    jButtonNeueKarteHinzufuegen.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent evt) {
        jButtonNeueKarteHinzufuegen_ActionPerformed(evt);
      }
    });
    jPanelKarte.add(jButtonNeueKarteHinzufuegen);
    jPanelListe.setBounds(280, 8, 588, 348);
    jPanelListe.setOpaque(false);
    jPanelListe.setBorder(BorderFactory.createTitledBorder("Wettkampfliste"));
    cp.add(jPanelListe);
    jTextAreaAusgabeScrollPane.setBounds(16, 24, 560, 196);
    jTextAreaAusgabe.setEditable(false);
    jPanelListe.add(jTextAreaAusgabeScrollPane);
    jLabel8.setBounds(16, 232, 110, 20);
    jLabel8.setText("Diszilpin");
    jPanelListe.add(jLabel8);
    jLabel9.setBounds(16, 264, 110, 20);
    jLabel9.setText("Sortierverfahren");
    jPanelListe.add(jLabel9);
    jComboBoxDisziplin.setBounds(128, 232, 190, 20);
    jComboBoxDisziplin.setModel(new DefaultComboBoxModel(new String[] { "Lauf", "Wurf", "Sprung", "Gesamtwertung" }));
    jPanelListe.add(jComboBoxDisziplin);
    jComboBoxSortierverfahren.setBounds(128, 264, 190, 20);
    jComboBoxSortierverfahren.setModel(new DefaultComboBoxModel(new String[] { "Sortieren durch Auswahl", "Sortieren durch Einfügen", "Sortieren durch Vertauschen" }));
    jPanelListe.add(jComboBoxSortierverfahren);
    jButtonBestimmeBesten.setBounds(16, 304, 195, 25);
    jButtonBestimmeBesten.setText("Bestimme Besten");
    jButtonBestimmeBesten.setMargin(new Insets(2, 2, 2, 2));
    jButtonBestimmeBesten.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent evt) {
        jButtonBestimmeBesten_ActionPerformed(evt);
      }
    });
    jPanelListe.add(jButtonBestimmeBesten);
    jButtonSortieren.setBounds(232, 304, 195, 25);
    jButtonSortieren.setText("Sortieren");
    jButtonSortieren.setMargin(new Insets(2, 2, 2, 2));
    jButtonSortieren.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent evt) {
        jButtonSortieren_ActionPerformed(evt);
      }
    });
    jPanelListe.add(jButtonSortieren);
    jButtonLaden.setBounds(88, 304, 75, 25);
    jButtonLaden.setText("Laden");
    jButtonLaden.setMargin(new Insets(2, 2, 2, 2));
    jButtonLaden.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent evt) {
        jButtonLaden_ActionPerformed(evt);
      }
    });
    jPanelKarte.add(jButtonLaden);
    jButtonSpeichern.setBounds(168, 304, 75, 25);
    jButtonSpeichern.setText("Speichern");
    jButtonSpeichern.setMargin(new Insets(2, 2, 2, 2));
    jButtonSpeichern.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent evt) {
        jButtonSpeichern_ActionPerformed(evt);
      }
    });
    jPanelKarte.add(jButtonSpeichern);
    // Ende Komponenten
    setVisible(true);
    
    wettkampfliste = new Wettkampfliste();
  }
  
  public void jButtonNeueKarteHinzufuegen_ActionPerformed(ActionEvent evt) {
    ergaenzeKarte();
    leeren();
    zeigeListeAn();
  }
  
  public void jButtonBestimmeBesten_ActionPerformed(ActionEvent evt) {
    String lDisziplin;
    lDisziplin = (String) jComboBoxDisziplin.getSelectedItem();
    
    Wettkampfkarte lKarte;
    lKarte = wettkampfliste.besteKarte(lDisziplin);
    EinAusgabe.nachricht(this, "Der beste Teilnehmer ist " + lKarte.gibVorname() + " " + lKarte.gibName() + " mit " + lKarte.gibPunkte(lDisziplin) + " Punkten.", "Bester Teilnehmer in der Disziplin '" + lDisziplin + "'", "Information");
  }
  
  public void jButtonSortieren_ActionPerformed(ActionEvent evt) {
    String lDisziplin;
    lDisziplin = (String) jComboBoxDisziplin.getSelectedItem();
    String lVerfahren;
    lVerfahren = (String) jComboBoxSortierverfahren.getSelectedItem();
    
    wettkampfliste.sortiereNach(lDisziplin, lVerfahren);
    zeigeListeAn();
  }
  
  public void jButtonLaden_ActionPerformed(ActionEvent evt) {
    wettkampfliste = (Wettkampfliste) EinAusgabe.liesDatei("Wettkampfergebnis.dat");
    zeigeListeAn();
  }
  
  public void jButtonSpeichern_ActionPerformed(ActionEvent evt) {
    EinAusgabe.schreibeDatei(wettkampfliste, "Wettkampfergebnis.dat");
  }
  
  private void ergaenzeKarte() {
    Wettkampfkarte lKarte = new Wettkampfkarte(jTextFieldName.getText(), jTextFieldVorname.getText(), jTextFieldKlasse.getText(), Integer.parseInt(jTextFieldAlter.getText()));
    lKarte.setzePunkte("Lauf", Integer.parseInt(jTextFieldLauf.getText()));
    lKarte.setzePunkte("Wurf", Integer.parseInt(jTextFieldWurf.getText()));
    lKarte.setzePunkte("Sprung", Integer.parseInt(jTextFieldSprung.getText()));
    wettkampfliste.ergaenzeKarte(lKarte);
  }
  
  private void leeren() {
    jTextFieldName.setText("");
    jTextFieldVorname.setText("");
    jTextFieldKlasse.setText("");
    jTextFieldAlter.setText("");
    jTextFieldLauf.setText("");
    jTextFieldWurf.setText("");
    jTextFieldSprung.setText("");
  }
  
  private void zeigeListeAn() {
    jTextAreaAusgabe.setText(wettkampfliste.toString());
  }
  
  public static void main(String[] args) {
    new Bundesjugendspiele("Bundesjugendspiele");
  }
}
