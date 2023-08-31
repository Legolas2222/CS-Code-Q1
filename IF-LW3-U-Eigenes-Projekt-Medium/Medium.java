public class Medium {
    private String titel;
    private int spielzeit;
    private boolean habIch;
    private String kommentar;
    
    public Medium(
        String titel,
        int spielzeit
    ) {
        this.titel = titel;
        this.spielzeit = spielzeit;
        this.habIch = false;
        this.kommentar = "";
    }
    
    public void seteKommentar(String neuerKommentar) {
        this.kommentar = kommentar;
    }
    public String gibKommentar() {
        return this.kommentar;
    }
    public void setzeVorhande(boolean neuerWert) {
        this.habIch = neuerWert;
    }
    public boolean gibVorhanden() {
        return this.habIch;
    }
    public String gibTitel() {
        return this.titel;
    }
    public int gibSpielzeit() {
        return this.spielzeit;
    }
    public void ausgeben() {
        System.out.println("Medium Ausgegeben!");
        System.out.println("Titel: " + this.titel);
        System.out.println("Spielzeit: " + this.spielzeit);
        System.out.println("Habe ich?: " + this.habIch);
        System.out.println("Kommentar: " + this.kommentar);
    }
}