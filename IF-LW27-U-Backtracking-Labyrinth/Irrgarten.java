import java.io.*;
import java.awt.*;
import javax.swing.*;
/**
  *
  * Klasse zur Realisierung eines Irrgarten-Lösers
  *
  * @version 1
  * @author Daniel Garmann
  */

public class Irrgarten {

  // Anfang Attribute
  private char[][] feld;       // Irrgartenfeld
  private int startx;          // Startpunkt-x
  private int starty;          // Startpunkt y
  private int breite, hoehe;   // Breite und Höhe des Irrgartens

  private char[][] feldMitKuerzestemWeg; // für Suche nach kürzestem Weg nötig.
  // Ende Attribute

  /**
   *  parameterloser Konstruktor mit leerem Irrgarten
   */
  public Irrgarten() {
    breite = 0;
    hoehe = 0;
  }

  /**
   *  Konstruktor mit Übergabe eines Dateinamens einer Textdatei
   *  @param dateiname Das Irrgartenfeld als Textdatei
   */
  public Irrgarten(String dateiname) {
    File datei = new File(dateiname);
    String dateiString = "";
    try {
      FileReader reader = new FileReader(datei);
      BufferedReader puffer = new BufferedReader(reader);
      String s = puffer.readLine();
      while (s != null) {
        dateiString = dateiString + s+",";               // erst mal alles Komma-getrennt in einen String
        s = puffer.readLine();
      }
      reader.close();

      String[] zeilen = dateiString.split(",");          // dann in einzelne Zeilen aufteilen
      hoehe = zeilen.length;                             // Höhe = Anzahl der Zeilen
      breite = zeilen[0].length();                       // Breite = Länge einer Zeile
      feld = new char[breite][hoehe];                    // und dann alle Felder setzen
      for (int x = 0; x < breite; x++) {
        for (int y = 0; y < hoehe; y++) {
          char c = zeilen[y].charAt(x);
          feld[x][y] = c;
          if (c == 'S') {                                // evtl. Startposition merken
            startx = x; starty = y;
          }
        }
      }

    } catch (FileNotFoundException e) {
      System.out.println("Datei nicht vorhanden");
    } catch (IOException e) {
      System.err.println(e.toString());
    }
  }
  
  /**
   * Methode ausgeben des Irrgartens auf einer TextArea
   * @param cp Container, auf dem ausgegeben werden soll
   */
  public void ausgeben(JTextArea jta) {
    String ausgabe = "";
    for (int y = 0; y < hoehe; y++) {
      for (int x = 0; x < breite; x++) {
        ausgabe += feld[x][y];
      }
      ausgabe += "\n";
    }
    jta.setText(ausgabe);
  }


  /**
   * Methode zum suchen und markieren eines Weges
   * @param x aktuelle x-Position bei der Suche
   * @param y aktuelle y-Position bei der Suche
   */
  private boolean suche(int x, int y) {
    // Außerhalb?
    if (x > feld.length - 1 || y > feld[0].length - 1 || x < 0 || y < 0) {
      return false;
    } 
    // Schon am Ziel?
    if (feld[x][y] == 'Z') {
      return true;
    } else {
      // Sonst: Auf Wand oder schon besucht?
      if (feld[x][y] == '#' || feld[x][y] == 'O') {
        return false;
      } 
      else {
        feld[x][y] = 'O';
        if (suche(x+1, y)) {return true;} 
        if (suche(x-1, y)) {return true;}
        if (suche(x, y+1)) {return true;}
        if (suche(x, y-1)) {return true;}
      } 
    }
    feld[x][y] = ' ';
    return false;
  }

  /**
   * Methode zum lösen des Irrgartens. Der richtige Weg wird durch * markiert.
   */
  public void loesen() {
    if (breite != 0 && hoehe != 0) {
      // Anstoß der Rekursion
      suche(startx, starty);
    }
  }


  /**
   * Methode zum suchen und markieren des kürzesten Weges
   * @param x aktuelle x-Position bei der Suche
   * @param y aktuelle y-Position bei der Suche
   * @param laenge aktuelle Weglänge vom Startpunkt aus
   * @param minimaleLaenge bisherige kürzeste Weglänge vom Startpunkt zum Zielpunkt (anfangs MAX_VALUE)
   * @return minimale Weglänge
   */
  private int suche(int x, int y, int laenge, int minimaleLaenge) {
    if (feld[x][y] == 'Z') {
      if (laenge < minimaleLaenge) {
        // dann Feld klonen
        feldMitKuerzestemWeg = new char[breite][hoehe];
        for (int i = 0; i < breite; i++) for (int j = 0; j < hoehe; j++) feldMitKuerzestemWeg[i][j] = feld[i][j];
        return laenge;
      } else {
        return minimaleLaenge;
      }
    } else {
      if (feld[x][y] == 'S' || feld[x][y] == ' ') {
        feld[x][y] = 'O';
        if (x < breite - 1) minimaleLaenge = suche(x+1, y, laenge+1, minimaleLaenge);
        if (x > 0) minimaleLaenge = suche(x-1, y, laenge+1, minimaleLaenge);
        if (y < hoehe - 1) minimaleLaenge = suche(x, y+1, laenge+1, minimaleLaenge);
        if (y > 0) minimaleLaenge = suche(x, y-1, laenge+1, minimaleLaenge);
        feld[x][y] = ' ';
      }
      return minimaleLaenge;
    }
  }

  /**
   * Methode zum lösen des Irrgartens. Der kürzeste Weg wird durch O markiert.
   */
  public void kuerzesterWeg() {
    if (breite != 0 && hoehe != 0) {
      if (suche(startx, starty, 0, Integer.MAX_VALUE) < Integer.MAX_VALUE) {
        feld = feldMitKuerzestemWeg;
      }
    }
  }

  // Ende Methoden
}


