public class Video extends Medium {
    private String regisseur;
    
    public Video(String titel,int spielzeit, String regisseur) {
        super(titel, spielzeit);
        this.regisseur = regisseur;
    }
    
    public String gibRegisseur() {
        return this.regisseur;
    }
    public void ausgeben() {
        System.out.println("Medium Ausgegeben!");
        System.out.println("Titel: " + this.gibTitel());
        System.out.println("Spielzeit: " + this.gibSpielzeit());
        System.out.println("Habe ich?: " + this.gibVorhanden());
        System.out.println("Kommentar: " + this.gibKommentar());
        System.out.println("Künstler: " + this.gibRegisseur());
    }
}