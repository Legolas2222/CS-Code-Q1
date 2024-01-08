import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Vokabelheft extends JFrame {

  private JButton btVokabelAnhaengen = new JButton();
  private JButton btVokabelEinfuegen = new JButton();
  private JButton btVokabelLoeschen = new JButton();
  private JButton btAnfangListe = new JButton();
  private JButton btVorherigeVokabel = new JButton();
  private JButton btNaechsteVokabel = new JButton();
  private JButton btEndeListe = new JButton();
  private Label englisch = new Label();
  private Label deutsch = new Label();
  private TextField edDeutsch = new TextField();
  private TextField edVokabel = new TextField();
  private java.awt.List lBoxVokabeln = new java.awt.List();
  private List<Vokabel> vokabelliste;

  public Vokabelheft(String title) {
    // Frame-Initialisierung
    super(title);
    addWindowListener(new WindowAdapter() {
      @Override
      public void windowClosing(WindowEvent evt) {
        System.exit(0);
      }
    });
    
    int frameWidth = 491; 
    int frameHeight = 409;
    setSize(frameWidth, frameHeight);
    
    Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
    int x = (d.width - getSize().width) / 2;
    int y = (d.height - getSize().height) / 2;
    setLocation(x, y);
    
    Panel cp = new Panel(null);
    add(cp);
    // Anfang Komponenten
    btVokabelAnhaengen.setBounds(8, 16, 195, 25);
    btVokabelAnhaengen.setFont(new Font("Dialog", Font.BOLD, 13));
    btVokabelAnhaengen.setText("Vokabel anh�ngen");
    cp.add(btVokabelAnhaengen);
    btVokabelAnhaengen.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent evt) {
        btVokabelAnhaengen_ActionPerformed(evt);
      }
    });
    
    btVokabelEinfuegen.setBounds(8, 48, 195, 25);
    btVokabelEinfuegen.setFont(new Font("Dialog", Font.BOLD, 13));
    btVokabelEinfuegen.setText("Vokabel einf�gen");
    cp.add(btVokabelEinfuegen);
    btVokabelEinfuegen.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent evt) {
        btVokabelEinfuegen_ActionPerformed(evt);
      }
    });
    
    btVokabelLoeschen.setBounds(8, 80, 195, 25);
    btVokabelLoeschen.setFont(new Font("Dialog", Font.BOLD, 13));
    btVokabelLoeschen.setText("Vokabel l�schen");
    cp.add(btVokabelLoeschen);
    btVokabelLoeschen.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent evt) {
        btVokabelLoeschen_ActionPerformed(evt);
      }
    });
    
    englisch.setBounds(176, 16, 60, 20);
    englisch.setText("Englisch");
    englisch.setFont(new Font("Dialog", Font.BOLD, 13));
    cp.add(englisch);
    edDeutsch.setBounds(216, 104, 249, 24);
    edDeutsch.setEditable(false);
    edDeutsch.setText("");
    cp.add(edDeutsch);
    deutsch.setBounds(176, 80, 57, 20);
    deutsch.setText("Deutsch");
    deutsch.setFont(new Font("Dialog", Font.BOLD, 13));
    cp.add(deutsch);
    btAnfangListe.setBounds(216, 136, 59, 33);
    btAnfangListe.setFont(new Font("Dialog", Font.BOLD, 13));
    btAnfangListe.setText("|<<");
    cp.add(btAnfangListe);
    btAnfangListe.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent evt) {
        btAnfangListe_ActionPerformed(evt);
      }
    });
    
    btVorherigeVokabel.setBounds(280, 136, 59, 33);
    btVorherigeVokabel.setFont(new Font("Dialog", Font.BOLD, 13));
    btVorherigeVokabel.setText("<");
    cp.add(btVorherigeVokabel);
    btVorherigeVokabel.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent evt) {
        btVorherigeVokabel_ActionPerformed(evt);
      }
    });
    
    btNaechsteVokabel.setBounds(344, 136, 59, 33);
    btNaechsteVokabel.setFont(new Font("Dialog", Font.BOLD, 13));
    btNaechsteVokabel.setText(">");
    cp.add(btNaechsteVokabel);
    btNaechsteVokabel.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent evt) {
        btNaechsteVokabel_ActionPerformed(evt);
      }
    });
    
    btEndeListe.setBounds(408, 136, 59, 33);
    btEndeListe.setFont(new Font("Dialog", Font.BOLD, 13));
    btEndeListe.setText(">>|");
    cp.add(btEndeListe);
    btEndeListe.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent evt) {
        btEndeListe_ActionPerformed(evt);
      }
    });
    
    edVokabel.setBounds(216, 40, 249, 24);
    edVokabel.setEditable(false);
    edVokabel.setText("");
    edVokabel.setFont(new Font("Dialog", Font.PLAIN, 13));
    cp.add(edVokabel);
    lBoxVokabeln.setBounds(8, 200, 457, 161);
    lBoxVokabeln.setFont(new Font("Dialog", Font.PLAIN, 13));
    cp.add(lBoxVokabeln);
    edDeutsch.setFont(new Font("Dialog", Font.PLAIN, 13));
    edDeutsch.setBounds(216, 104, 209, 24);
    edVokabel.setBounds(216, 40, 209, 24);
    deutsch.setBounds(216, 80, 57, 20);
    englisch.setBounds(216, 16, 60, 20);
    lBoxVokabeln.setBounds(8, 184, 417, 161);
    // Ende Komponenten
    setResizable(false);
    setVisible(true);
    
    // Eigener Teil
    vokabelliste = new List<Vokabel>();
    grundwortschatzErzeugen();
    anzeigen();
  }

  //////////////////////////////////////////////////////////////////////////////
  // Die Pfeiltasten
  //////////////////////////////////////////////////////////////////////////////
  public void btAnfangListe_ActionPerformed(ActionEvent evt) {
    this.vokabelliste.toFirst();
    anzeigen();
  }

  public void btVorherigeVokabel_ActionPerformed(ActionEvent evt) {
    Vokabel referenz = this.vokabelliste.getContent();
    this.vokabelliste.toFirst();
    Vokabel hilfe = this.vokabelliste.getContent();
    boolean vorherigenGefunden = false;
    while (!vorherigenGefunden && this.vokabelliste.hasAccess()) {
      if (vokabelliste.getContent() != referenz) {
        hilfe = vokabelliste.getContent();
        vokabelliste.next();
      }
      else {
        vorherigenGefunden = true;
      }
    }
    this.vokabelliste.toFirst();
    // Jetzt mit linear Suche current auf das Hilfs-Element hilfe setzen
    while (this.vokabelliste.hasAccess()) {
      if (!hilfe.istGleich(this.vokabelliste.getContent())) {
        this.vokabelliste.next();
      }
      else {
        break;
      }
    }
    
    // 
  }

  public void btNaechsteVokabel_ActionPerformed(ActionEvent evt) {
    this.vokabelliste.next();
    anzeigen();
  }

  public void btEndeListe_ActionPerformed(ActionEvent evt) {
    this.vokabelliste.toLast();
    anzeigen();
  }

  //////////////////////////////////////////////////////////////////////////////
  //////////////////////////////////////////////////////////////////////////////
  // Die Kn�pfe
  //////////////////////////////////////////////////////////////////////////////
  public void btVokabelAnhaengen_ActionPerformed(ActionEvent evt) {
    // Erzeuge Dialog
    VokabelDialog dialog;
    Vokabel vok;
    dialog = new VokabelDialog(this, "Vokabel anh�ngen", true);
    vok = new Vokabel(dialog.getEnglisch(), dialog.getDeutsch());
    
    // ToDo: Quelltext einf�gen
    
    this.vokabelliste.append(vok);
    System.out.println("Test" + vok.getEnglisch());
    anzeigen();
  }

  public void btVokabelEinfuegen_ActionPerformed(ActionEvent evt) {
    // Erzeuge Dialog
    VokabelDialog dialog;
    Vokabel vok;
    dialog = new VokabelDialog(this, "Vokabel einf�gen", true);
    vok = new Vokabel(dialog.getEnglisch(), dialog.getDeutsch());
    
    // ToDo: Quelltext einf�gen
    if (this.vokabelliste.hasAccess()) {
      this.vokabelliste.insert(vok);
    }
    else {
      this.vokabelliste.append(vok);
    }
    anzeigen();
  }

  public void btVokabelLoeschen_ActionPerformed(ActionEvent evt) {
    // Erzeuge Dialog
    VokabelDialog dialog;
    Vokabel vok;
    dialog = new VokabelDialog(this, "Vokabel l�schen", true);
    vok = new Vokabel(dialog.getEnglisch(), dialog.getDeutsch());
    
    // Vokabel vok suchen mit linearer Suche
    boolean vorhanden;
    vorhanden = false;
    // ToDo: Quelltext einf�gen
    this.vokabelliste.toFirst();
    while (!vorhanden && this.vokabelliste.hasAccess()) {
      if (vok.istGleich(vokabelliste.getContent())) {
        vokabelliste.remove();
        vorhanden = true;
      }
    }
    anzeigen();
  }

  //////////////////////////////////////////////////////////////////////////////
  //////////////////////////////////////////////////////////////////////////////
  // Sonstiges
  //////////////////////////////////////////////////////////////////////////////
  private void grundwortschatzErzeugen() {
    Vokabel vok;
    
    vok = new Vokabel("father", "Vater");
    vokabelliste.append(vok);
    
    vok = new Vokabel("mother", "Mutter");
    vokabelliste.append(vok);
    
    vok = new Vokabel("child", "Kind");
    vokabelliste.append(vok);
    
    vok = new Vokabel("teacher", "Lehrer");
    vokabelliste.append(vok);
    
    vok = new Vokabel("brother", "Bruder");
    vokabelliste.append(vok);
    
    vok = new Vokabel("sister", "Schwester");
    vokabelliste.append(vok);
    
    vok = new Vokabel("computer science", "Informatik");
    vokabelliste.append(vok);
    
    vok = new Vokabel("school", "Schule");
    vokabelliste.append(vok);
    
    vokabelliste.toFirst();  // Damit es ein aktuelles Element in der Liste gibt.
  }

  private void anzeigen() {
    Vokabel aktVok;
    Vokabel vokabel;
    
    lBoxVokabeln.removeAll();
    edVokabel.setText("");
    edDeutsch.setText("");
    
    if (!vokabelliste.isEmpty()) {
      /*
      // Auskommentiert, damit die Sch�ler etwas zu tun haben.
      if(!vokabelliste.hasAccess()){
      vokabelliste.toFirst();        
      }
      */
      // Aktuelle Vokabel merken
      aktVok = vokabelliste.getContent();
      
      // Aktualisieren der Editkompoenten
      edVokabel.setText(aktVok.getEnglisch());
      edDeutsch.setText(aktVok.getDeutsch());
      
      // Die Liste durchlaufen
      vokabelliste.toFirst();
      int index = 0;
      
      while (vokabelliste.hasAccess()) {
        vokabel = vokabelliste.getContent();
        lBoxVokabeln.add(vokabel.getEnglisch() + "   " + vokabel.getDeutsch());
        vokabelliste.next();
      }
      
      // Zur�cksetzen der aktuellen Vokabel
      vokabelliste.toFirst();
      // Problem: Bei identischem englischem Inhalt wird immer die erste Vokabel genommen :-(
      while ((vokabelliste.getContent()).getEnglisch().compareTo(aktVok.getEnglisch()) != 0 ||(vokabelliste.getContent()).getDeutsch().compareTo(aktVok.getDeutsch()) != 0) {
        vokabelliste.next();
        index++;
      }
      lBoxVokabeln.select(index);
    }
  }

  //////////////////////////////////////////////////////////////////////////////
  public static void main(String[] args) {
    new Vokabelheft("Vokabelheft");
  }
}
