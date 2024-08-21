package com.projekt.karte;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        Landkarte karte = new Landkarte();
        karte.findeWeg("St. Augustin", "Holzlar");
    }
}