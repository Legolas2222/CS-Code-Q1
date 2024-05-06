package com.zeichenverwaltung;

public class Zeichenverwaltung {

    public static BinarySearchTree<Zeichen> leseText(String zeichenkette) {
        BinarySearchTree<Zeichen> tree = new BinarySearchTree<Zeichen>();
        for (int i = 0; i < zeichenkette.length(); i++) {
            Zeichen z = new Zeichen(zeichenkette.charAt(i), 1);
            Zeichen gefunden = tree.search(z);
            if (gefunden != null) {
                gefunden.incrementAnzahl();
            } else {
                tree.insert(z);
            }
        }
        return tree;
    }
}
