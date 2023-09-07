public class Bank {
    private int anzahlKunden = 0;
    private Kunde[] kunde = new Kunde[1000];
    private int globalSaldo;
    private int globalDispo;

    private Bank(int anzahlKunden, Kunde[] kunde, int globalSaldo, int globalDispo, int globalZinssatz) {
        this.anzahlKunden = anzahlKunden;
        this.kunde = kunde;
        this.globalSaldo = globalSaldo;
        this.globalDispo = globalDispo;
        this.globalZinssatz = globalZinssatz;
    }

    private int globalZinssatz;

    private static Bank bank;
    

    public Kunde neuerKunde(String vorname, String nachname, String addresse, int gebDatum) {
        this.anzahlKunden++;
        Girokonto gk = new Girokonto(1000+anzahlKunden, globalSaldo, globalDispo);
        Sparkonto sk = new Sparkonto(2000+anzahlKunden, globalSaldo, globalZinssatz);
        Kunde k = new Kunde(vorname, nachname, addresse, gebDatum, sk , gk);
        this.kunde[anzahlKunden] = k;
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
}
