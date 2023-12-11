public class Kontakt
{
    //Attribute
    private int telefonnummer;
    private String name;
    
    //Konstruktor(en)
    public Kontakt() {
        
    }
    public Kontakt(int pNummer, String pName) {
        this.telefonnummer = pNummer;
        this.name = pName;
    }
    
    
    //Methoden
    public int getTelefonnummer() {
        return telefonnummer;
    }
    public String getName() {
        return name;
    }
    
    
    
}
