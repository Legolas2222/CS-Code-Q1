import java.io.*;


public class Wettkampfkarte implements Serializable {
  static final long serialVersionUID = 43L;
  public static final int LAUF = 1;
  public static final int SPRUNG = 2;
  public static final int WURF = 3;
  public static final int GESAMT = 4;
  private String name;
  private String vorname;
  private String klasse;
  private int alter;
  private int lauf;
  private int sprung;
  private int wurf;
  
  /**
  * Die Wettkampfkarte wurde mit den angegebenen Daten initialisiert. Alle Punktzahlen sind 0.
  */
  public Wettkampfkarte(String pName, String pVorname, String pKlasse, int pAlter) {
    name = pName;
    vorname = pVorname;
    klasse = pKlasse;
    alter = pAlter;
    lauf = 0;
    sprung = 0;
    wurf = 0;
  }
  
  /**
  * Die der Disziplin entsprechende Punktzahl wurde gesetzt.
  */
  public void setzePunkte(String pDisziplin, int pPunkte) {
    if (pDisziplin.equals("Lauf")) {
      lauf = pPunkte;
    } else if (pDisziplin.equals("Wurf")) {
      wurf = pPunkte;
    } else if (pDisziplin.equals("Sprung")) {
      sprung = pPunkte;
    }
  }
  
  public String gibName() {
    return name;
  }
  
  public String gibVorname() {
    return vorname;
  }
  
  public String gibKlasse() {
    return klasse;
  }
  
  public int gibAlter() {
    return alter;
  }
  
  public int gibPunkte(String pDisziplin) {
    int erg = -1;
    if (pDisziplin.equals("Lauf")) {
      erg = lauf;
    } else if (pDisziplin.equals("Wurf")) {
      erg = wurf;
    } else if (pDisziplin.equals("Sprung")) {
      erg = sprung;
    } else {
      erg = lauf + sprung + wurf;
    }
    return erg;
  }
  
  /**
  * Eine Textform der Daten der Wettkampfkarte wurde geliefert.
  */
  public String toString() {
    return name + ", " + vorname + ", " + klasse + ", " + alter + "\t" + lauf + "\t" + wurf + "\t" + sprung + "\t" + this.gibPunkte("Gesamtwertung");
  }
}
