public class Sparkonto extends Konto {
    private int zinssatz;

    public int getZinssatz() {
        return zinssatz;
    }

    public void setZinssatz(int zinssatz) {
        this.zinssatz = zinssatz;
    }

    public Sparkonto(int pKontoNr, int pSaldo, int pZinssatz) {
        super(pKontoNr, pSaldo);
        this.zinssatz = pZinssatz;
    }
}
