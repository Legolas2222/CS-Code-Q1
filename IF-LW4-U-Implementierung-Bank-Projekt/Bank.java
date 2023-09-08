public class Bank {
    private int anzahlKunden = 0;
    private Kunde[] kunden = new Kunde[1000];
    private int anzahlKonten = 0;
    private Konto[] konten = new Konto[2000];
    private int globalSaldo;
    private int globalDispo;
    private int globalZinssatz;

    private Bank(int anzahlKunden, Kunde[] kunden, int globalSaldo, int globalDispo, int globalZinssatz) {
        this.anzahlKunden = anzahlKunden;
        this.kunden = kunden;
        this.globalSaldo = globalSaldo;
        this.globalDispo = globalDispo;
        this.globalZinssatz = globalZinssatz;
    }


    private static Bank bank;
    

    public Kunde neuerKunde(String vorname, String nachname, String addresse, int gebDatum) {
        this.anzahlKunden++;
        int kundenNr = anzahlKunden+1000;

        Kunde k = new Kunde(vorname, nachname, addresse, gebDatum, kundenNr);
        this.kunden[anzahlKunden] = k;
        return k;
    }
    public Konto neuesKonto(char art, int kundenNr) {
        this.anzahlKonten++;
        Konto k;
        Kunde kunde;
        int kontoNr;
        if (existiertKunde(kundenNr)) {
            kunde = findByKundenNr(kundenNr);
            if (art == 'g') {
                kontoNr = kundenNr*100+1;
                k = new Girokonto(kontoNr, globalSaldo, globalDispo);
                this.konten[anzahlKonten] = k;
                kunde.setGirokonto(k);
            }
            else if (art == 's') {
                kontoNr = kundenNr*100+2;
                k = new Sparkonto(kontoNr, globalSaldo, globalZinssatz)
                this.konten[anzahlKonten] = k;
                kunde.setSparkonto(k);
            }
            else {
                throw new Error("Nicht erkannte Art des Kontos");
            }
        }
        return k;
    }

    public void einzahlen(char kontoTyp, int menge) {

    }

    public void auszahlen(char kontoTyp, int menge, int pin) {

    }

    public void abheben(char kontoTyp, int menge, int pin) {

    }

    public void ueberweise(Konto sender, Konto empfaender, int menge, int tan) {

    }

    public static Bank bank() {
        if (Bank.bank != null) {
            return Bank.bank;
        }
        else {
            Bank.bank = new Bank(0, new Kunde[1000], 45, 34, 12);
            return Bank.bank;
        }
    }

    public Kunde findByKundenNr(int kundenNr) {
        for (int i = 0; i < anzahlKunden.length; i++) {
            if (this.kunden[i].getKundenNr() == kundenNr) {
                return this.kunden[i];
            }
        }
        throw new Error("Kein Kunde mit dieser Kunden nummer")
    }

    public void kontoAnlegen(char art, int kundenNr) {
        Kunde kunde;
        if (existiertKunde(kundenNr)) {
            kunde = findByKundenNr(kundenNr)
        }
        Konto konto = neuesKonto(art, kundenNr);
        if (art == 's')  {
            kunde.setGirokonto(konto);
        }
        if (art == 'g')  {
            kunde.setSparkonto(konto);
        }
    }
    public boolean existiertKunde(int kundenNr) {
        try {
            findByKundenNr(kundenNr);
        }
        catch(Exception e) {
            return false
        }
        return true;
    }
}
