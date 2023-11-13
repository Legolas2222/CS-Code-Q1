// Aufgabe 1a von Seite 75 im Informatikbuch

public void listeAusgeben() {
    einkaufsliste.reset();
    while(einkaufsliste.hasAccess) {
        System.out.println(einkaufsliste.current.getArtikelname());
    }
}
// Ende listeAusgeben()