import java.util.Random;


public class Skispringer {
  private String name;
  private double[] punkte;
  private static Random zufall = new Random();
  
  public Skispringer() {
    name = this.zufallsgriff("BDFGHJKLMNPRSTVWZ") + this.zufallsgriff("aeiou") + this.zufallsgriff("dfghklmnprstxz") + this.zufallsendung();
    punkte = new double[2];
  }
  
  public String gibName() {
    return name;
  }
  
  public double gibPunktzahl(int pDurchgang) {
    if (pDurchgang == 1) {
      return punkte[0];
    } else {
      return punkte[1];
    }
  }
  
  public double gibGesamtpunktzahl() {
    return this.zahlMit1Nachkommastelle(punkte[0] + punkte[1]);
  }
  
  public void setzePunktzahl(int pDurchgang, double pMinimum, double pMaximum) {
    double lPunktzahl = this.zahlMit1Nachkommastelle((pMinimum + ((pMaximum - pMinimum) * Math.random())));
    
    if (pDurchgang == 1) {
      punkte[0] = lPunktzahl;
    } else {
      punkte[1] = lPunktzahl;
    }
  }
  
  private String zufallsgriff(String moeglicheZeichen) {
    return "" + moeglicheZeichen.charAt(this.ganzeZufallszahl(0, moeglicheZeichen.length() - 1));
  }
  
  private String zufallsendung() {
    switch (this.ganzeZufallszahl(1, 5)) {
      case 1:
      return "meier";
      
      case 2:
      return "müller";
      
      case 3:
      return "schulze";
      
      case 4:
      return "mann";
      
      case 5:
      return "hausen";
    }
    
    return "";
  }
  
  private int ganzeZufallszahl(int pMinimum, int pMaximum) {
    return pMinimum + zufall.nextInt(pMaximum - pMinimum + 1);
  }
  
  private double zahlMit1Nachkommastelle(double pZahl) {
    String lString = String.valueOf(pZahl);
    
    return Double.parseDouble(lString.substring(0, lString.lastIndexOf('.') + 2));
  }
}
