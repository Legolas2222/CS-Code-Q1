package com.ahnenbaum;

public class Ahne {
    private String vorname;
    private String nachname;
    private char geschlecht;

    public void setVorname(String vorname) {
        this.vorname = vorname;
    }

    public void setNachname(String nachname) {
        this.nachname = nachname;
    }

    public void setGeschlecht(char geschlecht) {
        this.geschlecht = geschlecht;
    }

    public String getVorname() {
        return vorname;
    }

    public String getNachname() {
        return nachname;
    }

    public char getGeschlecht() {
        return geschlecht;
    }

    public Ahne(String vorname, String nachname, char geschlecht) {
        this.vorname = vorname;
        this.nachname = nachname;
        this.geschlecht = geschlecht;
    }
}