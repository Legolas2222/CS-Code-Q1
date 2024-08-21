package com.projekt.karte;

import com.abiklassegraph.Edge;
import com.abiklassegraph.Graph;
import com.abiklassegraph.List;
import com.abiklassegraph.Vertex;

public class Landkarte {
    private Graph graph;

    public Landkarte() {
        this.graph = new Graph();
        this.neuerOrt("Mülldorf");
        this.neuerOrt("Menden");
        this.neuerOrt("St. Augustin");
        this.neuerOrt("Niederpleis");
        this.neuerOrt("Hangelar");
        this.neuerOrt("Holzlar");

        this.neueStrasse("Mülldorf", "Menden", 2.0);
        this.neueStrasse("Mülldorf", "Niederpleis", 3.0);
        this.neueStrasse("Mülldorf", "St. Augustin", 2.0);

        this.neueStrasse("Menden", "St. Augustin", 3.0);
        this.neueStrasse("St. Augustin", "Niederpleis", 3.0);
        this.neueStrasse("St. Augustin", "Hangelar", 2.0);

        this.neueStrasse("Hangelar", "Niederpleis", 5.0);
        this.neueStrasse("Niederpleis", "Holzlar", 8.0);
        this.neueStrasse("Hangelar", "Holzlar", 4.0);
    }

    public void neuerOrt(String id) {
        this.graph.addVertex(new Vertex(id));
    }

    public void neueStrasse(String vonId, String nachId, double gewicht) {
        this.graph.addEdge(new Edge(this.graph.getVertex(vonId), this.graph.getVertex(nachId), gewicht));
    }

    public void findeOrt(String id) {
        Vertex v = this.graph.getVertex(id);
        if (v == null) {
            System.out.println("Ort nicht gefunden");
        } else {
            System.out.println("Ort gefunden");
        }
    }

    public void findeWeg(String vonId, String nachId) {
        Vertex von = this.graph.getVertex(vonId);
        Vertex nach = this.graph.getVertex(nachId);
        List<Vertex> pfad = findeWegPrivate(new List<Vertex>(), von, nach);
        pfad.toFirst();
        while (pfad.hasAccess()) {
            System.out.print(pfad.getContent().getID());
            System.out.print(" --> ");
            pfad.next();
        }
    }
    

    private List<Vertex> findeWegPrivate(List<Vertex> bisherigerWeg, Vertex von, Vertex nach) {
        bisherigerWeg.toLast();
        List<Vertex> nachbarn = this.graph.getNeighbours(bisherigerWeg.getContent());
        while (nachbarn.hasAccess()) {
            if (nachbarn.getContent().equals(nach)) {
                nachbarn.getContent().setMark(true);
                bisherigerWeg.append(nachbarn.getContent());
                return bisherigerWeg;
            }
            nachbarn.next();
        }
        nachbarn.toFirst();
        while (nachbarn.hasAccess()) {
            if (nachbarn.getContent().isMarked()) {
                continue;
            }
            if (!nachbarn.getContent().isMarked()) {
                nachbarn.getContent().setMark(true);
                bisherigerWeg.append(nachbarn.getContent());
                return findeWegPrivate(bisherigerWeg, von, nach);
            }
            nachbarn.next();
        }
        return null;
    }
}
