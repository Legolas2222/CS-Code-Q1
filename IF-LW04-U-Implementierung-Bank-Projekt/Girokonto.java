public class Girokonto extends Konto {
    private int dispo;

    public Girokonto(int pKontoNr, int pSaldo, int pDispo) {
        super(pKontoNr, pSaldo);
        this.dispo = pDispo;
    }

    public int getDispo() {
        return dispo;
    }

    public void setDispo(int dispo) {
        this.dispo = dispo;
    }

}
