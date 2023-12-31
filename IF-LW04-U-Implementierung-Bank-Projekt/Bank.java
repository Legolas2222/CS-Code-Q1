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
        int kundenNr = anzahlKunden + 1000;

        Kunde k = new Kunde(vorname, nachname, addresse, gebDatum, kundenNr);
        this.kunden[anzahlKunden] = k;
        return k;
    }

    public Konto neuesKonto(char art, int kundenNr) {
        this.anzahlKonten++;
        Kunde kunde;
        int kontoNr;
        if (existiertKunde(kundenNr)) {
            kunde = findByKundenNr(kundenNr);
            if (art == 'g') {
                kontoNr = kundenNr * 100 + 1;
                Girokonto k = new Girokonto(kontoNr, globalSaldo, globalDispo);
                this.konten[anzahlKonten] = k;
                kunde.setGirokonto(k);
                return k;
            } else if (art == 's') {
                kontoNr = kundenNr * 100 + 2;
                Sparkonto k = new Sparkonto(kontoNr, globalSaldo, globalZinssatz);
                this.konten[anzahlKonten] = k;
                kunde.setSparkonto(k);
                return k;
            }
        }
        throw new Error("Nicht erkannte Art des Kontos");
    }

    public void einzahlen(int menge, int kontoNr) {
        // 1. Kontotyp und Menge ueberpruefen
        // Konto ueber die KontoNr heraussuchen
        if (existiertKonto(kontoNr)) {
            Konto k = findByKontoNr(kontoNr);
            // Menge des Kontos veraendern
            k.setSaldo(k.getSaldo() + menge);
        }
    }

    public void auszahlen(char kontoTyp, int menge, int pin) {

    }

    public void abheben(char kontoTyp, int menge, int pin) {

    }

    public void ueberweise(int kontoNrEmpfaenger, int kontoNrSender, int menge) {
        // Existieren beide Konten?
        if (existiertKonto(kontoNrEmpfaenger) && existiertKonto(kontoNrSender) && kontoNrEmpfaenger != kontoNrSender) {
            Konto sender = findByKontoNr(kontoNrSender);
            Konto emfaenger = findByKontoNr(kontoNrEmpfaenger);
            // Geld abziehen
            sender.setSaldo(sender.getSaldo() - menge);
            emfaenger.setSaldo(emfaenger.getSaldo() + menge);
        }
    }

    public static Bank bank() {
        if (Bank.bank != null) {
            return Bank.bank;
        } else {
            Bank.bank = new Bank(0, new Kunde[1000], 45, 34, 12);
            return Bank.bank;
        }
    }

    public Konto findByKontoNr(int kontoNr) {
        for (int i = 0; i < this.konten.length; i++) {
            if (this.konten[i].getKontoNr() == kontoNr) {
                return this.konten[i];
            }
        }
        throw new Error("Kein Konto mit dieser Kontonummer");
    }

    public boolean existiertKonto(int kontoNr) {
        try {
            findByKontoNr(kontoNr);
        } catch (Exception e) {
            return false;
        }
            return true;
    }

    public Kunde findByKundenNr(int kundenNr) {
        for (int i = 0; i < this.kunden.length; i++) {
            if (this.kunden[i].getKundenNr() == kundenNr) {
                return this.kunden[i];
            }
        }
        throw new Error("Kein Kunde mit dieser Kunden nummer");
    }

    public boolean existiertKunde(int kundenNr) {
        try {
            findByKundenNr(kundenNr);
        } catch (Exception e) {
            return false;
        }
        return true;
    }   

}
