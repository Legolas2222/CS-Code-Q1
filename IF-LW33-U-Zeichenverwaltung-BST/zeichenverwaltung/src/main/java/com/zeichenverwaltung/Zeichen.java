package com.zeichenverwaltung;

public class Zeichen implements ComparableContent<Zeichen>{

    private char zeichen;
    private int anzahl;
    
    public Zeichen(char pZeichen, int pAnzahl){
        zeichen = pZeichen;
        anzahl = pAnzahl;
    }

    public void setAnzahl (int pAnzahl) {
        this.anzahl = pAnzahl;
    }
    
    public int getAnzahl(){
        return anzahl;
    }

    public int incrementAnzahl(){
        this.anzahl++;
        return this.getAnzahl();
    }

    public char getZeichen(){
        return this.zeichen;
    }
    
    
    public boolean isGreater(Zeichen pAnderesZeichen){
        return this.getZeichen() > pAnderesZeichen.getZeichen();
    }
    
    public boolean isLess(Zeichen pAnderesZeichen){
        return this.getZeichen() > pAnderesZeichen.getZeichen();
    }
    
    public boolean isEqual(Zeichen pAnderesZeichen){
        return this.getZeichen() > pAnderesZeichen.getZeichen();
    } 
    
}
