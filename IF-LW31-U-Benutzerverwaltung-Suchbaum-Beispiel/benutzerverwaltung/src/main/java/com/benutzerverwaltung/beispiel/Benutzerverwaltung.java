package com.benutzerverwaltung.beispiel;

public class Benutzerverwaltung {
    // Attribute
    private BinarySearchTree<Benutzerprofil> Userbaum;

    public Benutzerverwaltung() {
        this.Userbaum = new BinarySearchTree<Benutzerprofil>();
    }

    public void BenutzerEinfuegen(String username, int passwort) {
        Benutzerprofil pUser = new Benutzerprofil(username, passwort);  
        if (Userbaum.search(pUser) == null) {
            Userbaum.insert(pUser);
        } else {
            System.out.println("Benutzer bereits vorhanden");
        }
    }

    public void BenutzerLoeschen(Benutzerprofil pUser) {
        if (Userbaum.search(pUser) != null) {
            Userbaum.remove(pUser);
        }
        else {
            System.out.println("Benutzer nicht vorhanden");
        }
    }

    public Benutzerprofil BenutzerFinden(String userName) {
        Benutzerprofil UserToFind = new Benutzerprofil(userName, -1);
        return Userbaum.search(UserToFind);
    }

    public boolean PasswortPruefen(String Username, int passwort) {
        Benutzerprofil User = BenutzerFinden(Username);
        if (User != null) {
            return User.getPass() == passwort;
        }
        return false;
    }

}

