public class Kunde {
    private String vorname;
    private String nachname;
    private String addresse;
    private int gebDatum;
    private int kundenNr;
    private Girokonto gk;
    private Sparkonto sk;

    public Girokonto getGk() {
        return gk;
    }

    public Sparkonto getSk() {
        return sk;
    }

    public String getVorname() {
        return vorname;
    }

    public void setVorname(String vorname) {
        this.vorname = vorname;
    }

    public String getNachname() {
        return nachname;
    }

    public void setNachname(String nachname) {
        this.nachname = nachname;
    }

    public String getAddresse() {
        return addresse;
    }

    public void setAddresse(String addresse) {
        this.addresse = addresse;
    }

    public int getGebDatum() {
        return gebDatum;
    }

    public void setGebDatum(int gebDatum) {
        this.gebDatum = gebDatum;
    }

    public Kunde(String vorname, String nachname, String addresse, int gebDatum, int kundneNr) {
        this.vorname = vorname;
        this.nachname = nachname;
        this.addresse = addresse;
        this.gebDatum = gebDatum;
        this.kundenNr = kundenNr;
        this.gk = null;
        this.sk = null;
    }

    public int getKundenNr() {
        return this.kundenNr;
    }

    public void einzahlen(char kontoTyp, int menge) {

    }

    public void auszahlen(char kontoTyp, int menge, int pin) {

    }

    public void abheben(char kontoTyp, int menge, int pin) {

    }

    public void ueberweise(Konto sender, Konto empfaender, int menge) {

    }
    public void setGirokonto(Girokonto gk) {
        this.gk = gk;
    }
    public void setSparkonto(Sparkonto sk) {
        this.sk = sk;
    }
}
