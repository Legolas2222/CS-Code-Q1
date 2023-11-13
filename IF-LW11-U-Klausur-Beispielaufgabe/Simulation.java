public class Simulation{
    private Kursarbeit kursarbeit;
    private Notentabelle notentabelle;
    
    public Simulation(){
        kursarbeit = new Kursarbeit(Notentabelle.GenerischeTabelle());
        notentabelle = Notentabelle.GenerischeTabelle();
    }
    
    public void neueKlausur(String pName, int nrArbeit){
        kursarbeit.neueKlausur(pName);
    }
    
    public void bewerteKlausur(int nrArbeit, int pPunkte){
        kursarbeit.legeVonLinksAufAP();
        kursarbeit.bewerteAP(pPunkte);
        kursarbeit.legeVonAPNachRechts();
    }
    
    public void bestimmeDurchschnittsnote(){
        //EIGENER CODE
    }
}
