package com.benutzerverwaltung.beispiel;

public class Benutzerprofil implements ComparableContent<Benutzerprofil>{

    private String name;
    private int pass;
    
    public void setPass(int pass) {
        this.pass = pass;
    }

    public Benutzerprofil (String pName, int pPass){
        name = pName;
        pass = pPass;
    }
    
    public String getName(){
        return name;
    }
    
    public int getPass(){
        return pass;
    }
    
    public boolean isGreater(Benutzerprofil pBenutzerprofil){
        return this.getName().compareTo(pBenutzerprofil.getName()) > 0;
    }
    
    public boolean isLess(Benutzerprofil pBenutzerprofil){
        return this.getName().compareTo(pBenutzerprofil.getName()) < 0;
    }
    
    public boolean isEqual(Benutzerprofil pBenutzerprofil){
        return this.getName().compareTo(pBenutzerprofil.getName()) == 0;
    } 
    
}
