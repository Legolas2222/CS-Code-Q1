package com.benutzerverwaltung;

public class Benutzerprofil implements ComparableContent<Benutzerprofil>{

    private String name;

    public String getName() {
        return name;
    }
    private int pass;
        
    public boolean isLess(Benutzerprofil pContent) {
        return this.name.compareToIgnoreCase(pContent.getName()) < 0;
    }
    public boolean isGreater(Benutzerprofil pContent) {
        return this.name.compareToIgnoreCase(pContent.getName()) > 0;
    }

    public boolean isEqual(Benutzerprofil pContent) {
        return this.name.equals(pContent.getName());
    }
    
}
