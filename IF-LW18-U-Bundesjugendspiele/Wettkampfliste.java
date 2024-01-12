import java.io.Serializable;

public class Wettkampfliste implements Serializable {
  static final long serialVersionUID = 42L;
  private List<Wettkampfkarte> liste;

  public Wettkampfliste() {
    liste = new List<Wettkampfkarte>();
  }

  private Wettkampfkarte aktuelleWettkampfkarte() {
    return aktuelleWettkampfkarte(liste);
  }

  private Wettkampfkarte aktuelleWettkampfkarte(List<Wettkampfkarte> pList) {
    return pList.getContent();
  }

  public void ergaenzeKarte(Wettkampfkarte pWettkampfkarte) {
    liste.append(pWettkampfkarte);
  }

  public Wettkampfkarte besteKarte(String pDisziplin) {
    this.liste.toFirst();
    Wettkampfkarte bester = this.liste.getContent();
    while (this.liste.hasAccess()) {
      int aktuelleDisziplin = this.liste.getContent().gibPunkte(pDisziplin);
      if (aktuelleDisziplin > bester.gibPunkte(pDisziplin)) {
        bester = this.liste.getContent();
      }
      this.liste.next();
    }
    return bester;
  }

  public void sortiereNach(String pDisziplin, String pVerfahren) {
    if (pVerfahren.equals("Sortieren durch Auswahl")) {
      sortiereAuswahl(pDisziplin);
    } else if (pVerfahren.equals("Sortieren durch Einf�gen")) {
      sortiereEinfuegen(pDisziplin);
    } else if (pVerfahren.equals("Sortieren durch Vertauschen")) {
      bubblesort(pDisziplin);
    }
  }

  private void sortiereAuswahl(String pDisziplin) {
    // to do: Hier eigenen Code einfuegen
  }

  private void sortiereEinfuegen(String pDisziplin) {
    // to do: Hier eigenen Code einfuegen
  }

  private void bubblesort(String pDisziplin) {
    // to do: Hier eigenen Code einfuegen
  }

  /**
   * Diese Anfrage liefert das Ergebnis in Textform.
   */
  public String toString() {
    String lText = "";
    Wettkampfkarte lAktuelleKarte = aktuelleWettkampfkarte();

    liste.toFirst();

    while (liste.hasAccess()) {
      lText = lText + aktuelleWettkampfkarte().toString() + "\n";
      liste.next();
    }

    // Zur alten Position
    if (lAktuelleKarte != null) {
      liste.toFirst();

      while (lAktuelleKarte != aktuelleWettkampfkarte()) {
        liste.next();
      }
    }

    return lText;
  }
}
