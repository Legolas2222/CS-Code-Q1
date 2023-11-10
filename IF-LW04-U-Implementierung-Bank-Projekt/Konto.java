public class Konto {
    private int KontoNr;
    private int Saldo;

    public int getKontoNr() {
        return KontoNr;
    }

    public void setKontoNr(int kontoNr) {
        KontoNr = kontoNr;
    }

    public int getSaldo() {
        return Saldo;
    }

    public void setSaldo(int saldo) {
        Saldo = saldo;
    }

    public Konto(int pKontoNr, int pSaldo) {
        this.KontoNr = pKontoNr;
        this.Saldo = pSaldo;
    }

}
