public class Adressbuch
{
    //Attribute
    private List<Kontakt> addressbuch;


    //Konstruktor(en)
    public Adressbuch() {
    this.addressbuch = new List<Kontakt>();
    }
    
    public static void main(String[] args) {
        Adressbuch a = new Adressbuch();
        a.kontaktHinzufügen("A", 1231142);
        a.kontaktHinzufügen("B", 1231143);
        a.alleNummernAnzeigen();
        a.nummerAnzeigen("B");
    }
    
    //Methoden
    public void kontaktHinzufügen(String pName, int pNummer) {
        Kontakt neuerKontakt = new Kontakt(pNummer, pName);
        this.addressbuch.append(neuerKontakt);
    }
    public void letztenKontaktLoeschen() {
        this.addressbuch.toLast();
        if(this.addressbuch.hasAccess()) {
            this.addressbuch.remove();
        }
    }
    public void alleNummernAnzeigen() {
        this.addressbuch.toFirst();
        
        while (this.addressbuch.hasAccess()) {
            System.out.println(this.addressbuch.getContent().getTelefonnummer());
            this.addressbuch.next();
        }
    }
    public String alleNummern() {
        this.addressbuch.toFirst();
        String result = "";
        while (this.addressbuch.hasAccess()) {
            result += this.addressbuch.getContent().getTelefonnummer();
            result += " \n";
            this.addressbuch.next();
        }
        return result;
    }
    public int nummerAnzeigen(String pName) {
        this.addressbuch.toFirst();
        boolean fertig = false;
        while (this.addressbuch.hasAccess()) {
            if (this.addressbuch.getContent().getName() == pName) {
                System.out.println(this.addressbuch.getContent().getTelefonnummer());
                fertig = true;
                return this.addressbuch.getContent().getTelefonnummer();
                
            }
            else {
                this.addressbuch.next();
                continue;
            }
        }
        return 0;

    }
    public int nummerFinden(String name) {
        this.addressbuch.toFirst();
        int nummer = 0;
        while (this.addressbuch.hasAccess()) {
            if (this.addressbuch.getContent().getName() == name) {
                nummer = this.addressbuch.getContent().getTelefonnummer();
            }
            else {
                this.addressbuch.next();
            }
        }
        return nummer;

    }
    public void kontaktSortiertHinzufügen(String pName, int pNummer) {
        Kontakt k = new Kontakt(pNummer, pName);
        this.addressbuch.toFirst();
        boolean fertig = false;
        while (!fertig && this.addressbuch.hasAccess()) {
            String aktuellerName = this.addressbuch.getContent().getName();
            if(aktuellerName.compareTo(k.getName()) > 0) {
                this.addressbuch.insert(k);
                fertig = true;
            }
        }
        // Falls der Kontakt nirgendwo einsortiert werden konnte, wird er angehängt
        if (!fertig) {
            this.addressbuch.append(k);
        }

    }
    
    
}
