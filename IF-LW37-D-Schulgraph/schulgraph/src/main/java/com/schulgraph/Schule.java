package com.schulgraph;

public class Schule {
    private Graph wegenetz;

    public Schule() {
        this.wegenetz = new Graph();
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

        wegenetz.addVertex(sani);
        wegenetz.addVertex(verwaltung);
        wegenetz.addVertex(sekri);
        wegenetz.addVertex(TrepA);
        wegenetz.addVertex(hausi);
        wegenetz.addVertex(TrepB);
        wegenetz.addVertex(pausi);
        wegenetz.addVertex(bibi);
        wegenetz.addVertex(musik);
        wegenetz.addVertex(aula);
        wegenetz.addVertex(fahri);
        wegenetz.addVertex(TrepC);

        wegenetz.addEdge(new Edge(sani, verwaltung, 5));
        wegenetz.addEdge(new Edge(sekri, verwaltung, 15));
        wegenetz.addEdge(new Edge(TrepA, verwaltung, 15));
        wegenetz.addEdge(new Edge(TrepA, hausi, 20));
        wegenetz.addEdge(new Edge(TrepA, pausi, 40));
        wegenetz.addEdge(new Edge(aula, pausi, 20));
        wegenetz.addEdge(new Edge(bibi, pausi, 15));
        wegenetz.addEdge(new Edge(musik, pausi, 35));
        wegenetz.addEdge(new Edge(musik, pausi, 35));
        wegenetz.addEdge(new Edge(fahri, pausi, 45));
        wegenetz.addEdge(new Edge(fahri, TrepB, 5));
        wegenetz.addEdge(new Edge(TrepA, TrepB, 50));
        wegenetz.addEdge(new Edge(TrepC, TrepB, 50));
        wegenetz.addEdge(new Edge(TrepC, fahri, 10));
    }

    public void ausgabeAllerWegpunkte() {
        List<Vertex> punkte = wegenetz.getVertices();
        punkte.toFirst();
        System.out.println("Gespeicherte Wegpunkte:");
        while (punkte.hasAccess()) {
            System.out.print(punkte.getContent().getID() + ", ");
            punkte.next();
        }
    }
    public void ausgabeAllerWege() {
        List<Edge> wege = wegenetz.getEdges();
        wege.toFirst();
        System.out.println("Gespeicherte Wegpunkte:");
        while (wege.hasAccess()) {
            Vertex[] knoten = wege.getContent().getVertices();
            System.out.print(knoten[0].getID() + "-" + knoten[1].getID() + ", ");
            wege.next();
        }
    }
}
