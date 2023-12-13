public class Skispringerliste {
  List<Skispringer> springerliste;

  public Skispringerliste(){
    springerliste = new List<Skispringer>();
  }
 
  public Skispringer aktuellerSkispringer() {
    return springerliste.getContent();
  }
  
  public void anhaengen(Skispringer pSkispringer) {
    springerliste.append(pSkispringer);
  }

  public void einfuegen(Skispringer pSkispringer) {
    springerliste.insert(pSkispringer);
  }

  public boolean hatZugriff() {
    return springerliste.hasAccess();
  }

  public void zumAnfang() {
    springerliste.toFirst();
  }

  public void weiter() {
    springerliste.next();
  }

  /**
   * Die Liste wird als Zeichenkette geliefert.
   * Dabei enthält jede Zeile die Daten eines Springers in der Form: Nr: Name (Gesamtpunkte, falls vorhanden).
   */
  public String alsText() {
    String lText = "";
    int lNr = 1;
    
    springerliste.toFirst();
    
    while (springerliste.hasAccess()) {
      Skispringer lSpringer = aktuellerSkispringer();
      lText = lText + lNr + ": " + lSpringer.gibName();
      
      if (lSpringer.gibGesamtpunktzahl() > 0) {
        lText = lText + " (" + lSpringer.gibGesamtpunktzahl() + ")";
      }
      
      lNr++;
      springerliste.next();
      
      if (springerliste.hasAccess()) {
        lText = lText + "\n"; // Zeilenvorschub
      }
    }
    
    return lText;
  }
}
