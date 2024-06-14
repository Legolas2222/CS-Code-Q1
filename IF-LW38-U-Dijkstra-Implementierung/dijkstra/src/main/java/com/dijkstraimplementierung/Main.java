package com.dijkstraimplementierung;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        Karte k = new Karte();
        k.dijkstra("München", "Hamburg");
    }
}