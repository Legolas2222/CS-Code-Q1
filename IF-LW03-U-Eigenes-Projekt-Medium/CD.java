public class CD extends Medium {
    private String kuenstler;
    private int titelanzahl;
    
    public CD(String titel, String kuenstler, int stuecke, int spielzeit) {
        super(titel, spielzeit);
        this.kuenstler = kuenstler;
        this.titelanzahl = stuecke;
    }
    
    public String gibKuenstler() {
        return this.kuenstler;
    }
    public int gibTitelanzahl() {
        return this.titelanzahl;
    }
    public void ausgeben() {
        System.out.println("Medium Ausgegeben!");
        System.out.println("Titel: " + this.gibTitel());
        System.out.println("Spielzeit: " + this.gibSpielzeit());
        System.out.println("Habe ich?: " + this.gibVorhanden());
        System.out.println("Kommentar: " + this.gibKommentar());
        System.out.println("Künstler: " + this.gibKuenstler());
        System.out.println("Anzahl der Titel: " + this.gibTitelanzahl());
    }
}