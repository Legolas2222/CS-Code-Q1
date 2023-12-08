public class Kursarbeit {
    // Attribute

    private CustomStack<Klausur> linkerStapel;
    private CustomStack<Klausur> rechterStapel;
    private CustomStack<Klausur> arbeitsplatz;

    private Notentabelle tabelle;
    // Konstruktoren
    public Kursarbeit(Notentabelle pNotentabelle){
        this.linkerStapel = new CustomStack<Klausur>();
        this.rechterStapel = new CustomStack<Klausur>();
        this.arbeitsplatz = new CustomStack<Klausur>();

        this.tabelle = pNotentabelle;
        //EIGENER CODE 
   
    }
    // Methoden
    public void neueKlausur(String pName){

        Klausur k = new Klausur(pName);
        this.linkerStapel.push(k);
    }

    public void bewerteAP(int pPunkte){
        if (!this.arbeitsplatz.isEmpty()) {
            Klausur k = this.arbeitsplatz.top();
            k.setPunkte(pPunkte);
            k.setNote(this.tabelle.bestimmeNote(pPunkte));
            this.arbeitsplatz.push(k);
        }  
    }
    
    public /*int*/void gibNote(String pName){
        //EIGENER CODE
    }    

    public boolean istLinksLeer(){
        return this.linkerStapel.isEmpty();
    }

    public boolean istRechtsLeer(){
        return this.rechterStapel.isEmpty();
    }

    public boolean istAPLeer(){
        return this.arbeitsplatz.isEmpty();
    }
    
    public void legeVonLinksAufAP(){
        this.arbeitsplatz.push(this.linkerStapel.top());
        this.linkerStapel.pop();
    }
    
    public void legeVonAPNachRechts(){
        this.rechterStapel.push(this.arbeitsplatz.top());
        this.arbeitsplatz.pop();
    }
    
    public void legeVonRechtsNachLinks(){
        this.linkerStapel.push(this.rechterStapel.top());
        this.rechterStapel.pop();
    }    
    
    public void legeAlleVonRechtsNachLinks(){
        while (!this.rechterStapel.isEmpty()) {
            this.linkerStapel.push(this.rechterStapel.top());
            this.rechterStapel.pop();
        }
        //EIGENER CODE
    }
}


















