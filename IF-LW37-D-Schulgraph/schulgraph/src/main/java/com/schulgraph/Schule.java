package com.schulgraph;

public class Schule {
    private Graph netz;
    public Schule() {
        this.netz = new Graph();
        Vertex sani = new Vertex("Sani-Raum");
        Vertex verwaltung = new Vertex("Verwaltungstrakt");
        Vertex sekri = new Vertex("Sekretariat");
        Vertex TrepA = new Vertex("Treppenhaus-A");
        Vertex hausi = new Vertex("Hausmeister");
        Vertex TrepB = new Vertex("Treppenhaus-B");
        Vertex pausi = new Vertex("Pausenhalle");
        Vertex bibi = new Vertex("Bibi");
        Vertex musik = new Vertex("Musikräume");
        Vertex aula = new Vertex("Aula");
        Vertex fahri = new Vertex("Fahrradkäfig");
        Vertex TrepC = new Vertex("Treppenhaus-C");


        netz.addVertex(sani);
        netz.addVertex(verwaltung);
        netz.addVertex(sekri);
        netz.addVertex(TrepA);
        netz.addVertex(hausi);
        netz.addVertex(TrepB);
        netz.addVertex(pausi);
        netz.addVertex(bibi);
        netz.addVertex(musik);
        netz.addVertex(aula);
        netz.addVertex(fahri);
        netz.addVertex(TrepC);

        netz.addEdge(new Edge(sani, verwaltung, 5));
        netz.addEdge(new Edge(sekri, verwaltung, 15));
        netz.addEdge(new Edge(TrepA, verwaltung, 15));
        netz.addEdge(new Edge(TrepA, hausi, 20));
        netz.addEdge(new Edge(TrepA, pausi, 40));
        netz.addEdge(new Edge(aula, pausi, 20));
        netz.addEdge(new Edge(bibi, pausi, 15));
        netz.addEdge(new Edge(musik, pausi, 35));
        netz.addEdge(new Edge(musik, pausi, 35));
        netz.addEdge(new Edge(fahri, pausi, 45));
        netz.addEdge(new Edge(fahri,TrepB, 5));
        netz.addEdge(new Edge(TrepA,TrepB, 50));
        netz.addEdge(new Edge(TrepC,TrepB, 50));
        netz.addEdge(new Edge(TrepC,fahri, 10));

    }
}
