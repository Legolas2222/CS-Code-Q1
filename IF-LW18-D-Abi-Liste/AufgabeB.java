public class AufgabeB {
    // Soll innerhalb der Klasse Verwaltung sein
    public List<Grundstueck> ermittleGrundstueckeMitEinbruechen(Zeitstempel pTatzeit, int pMaxMinutenDifferenz) {
        // In dieser Liste werden die aktuellen Grundstuecke zwischengespeichert
        List<Grundstueck> hilfe = this.gibKopieAllerGrundstuecke();
        // Repräsentiert die Grundstücke, deren Einbrüche ermittelt werden sollen
        List<Grundstueck> erg = new List<Grundstueck>();
        hilfe.toFirst();
        // Über alle Grundstuecke laufen
        while (hilfe.hasAccess()) {
            // Boolean falls irgendein Einbruch des Grundstücks innerhalb der gesuchten Tatzeit liegt
            boolean hatEinbrch = false;
            // Liste in der alle Einbrüche des aktuellen Grundstücks zwischengespeichert werden
            List<Einbruch> einbrueche = hilfe.getContent().gibEinbrueche();   
            einbrueche.toFirst();
            /*  Alle Einbrüche werden auf die passende Differenz zur Tatzeit überprüft, 
                sobals ein Einbruch passt, wird die Boolean Variable auf true gesetzt
            */
            while (einbrueche.hasAccess()) {
                if(einbrueche.getContent.gibTatzeit().gibZeitdifferenz(pTatzeit) >= pMaxMinutenDifferenz) {
                    hatEinbrch = true;
                    // Sobald nur ein Einbruch passt, ist die Bedingung erfüllt
                    break;
                }
                // Ansonsten weitere Einbrüche überprüfen
                einbrueche.next();
            }
            // Falls das Grundstück einen passenden Einbruch verzeichnet hat, wird es zur Ergebnisliste
            // hinzugefügt
            if (hatEinbrch) {
                erg.append(hilfe.getContent);
            }
            // Das nächste Grundstück überprüfen
            hilfe.next();
        }
        // Die Liste mit den passenden Grundstücken zurückgeben
        return erg;
    }
    
}