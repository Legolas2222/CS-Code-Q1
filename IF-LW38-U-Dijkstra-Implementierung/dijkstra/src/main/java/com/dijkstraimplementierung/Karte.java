package com.dijkstraimplementierung;

public class Karte {

  private Graph karte;

  public Karte() {
    karte = new Graph();
    neuerOrt("Berlin");
    neuerOrt("Bremen");
    neuerOrt("Dortmund");
    neuerOrt("Dresden");
    neuerOrt("Düsseldorf");
    neuerOrt("Frankfurt");
    neuerOrt("Hamburg");
    neuerOrt("Hannover");
    neuerOrt("Köln");
    neuerOrt("Leipzig");
    neuerOrt("München");
    neuerOrt("Stuttgart");
    neueStrasse("Berlin", "Dresden", 205.0);
    neueStrasse("Berlin", "Hamburg", 284.0);
    neueStrasse("Berlin", "Hannover", 282.0);
    neueStrasse("Berlin", "Leipzig", 179.0);
    neueStrasse("Bremen", "Dortmund", 233.0);
    neueStrasse("Bremen", "Hamburg", 119.0);
    neueStrasse("Bremen", "Hannover", 125.0);
    neueStrasse("Dortmund", "Düsseldorf", 63.0);
    neueStrasse("Dortmund", "Hannover", 208.0);
    neueStrasse("Dortmund", "Frankfurt", 264.0);
    neueStrasse("Dresden", "Leipzig", 108.0);
    neueStrasse("Düsseldorf", "Köln", 47.0);
    neueStrasse("Frankfurt", "Hannover", 352.0);
    neueStrasse("Frankfurt", "Köln", 189.0);
    neueStrasse("Frankfurt", "Leipzig", 395.0);
    neueStrasse("Frankfurt", "München", 400.0);
    neueStrasse("Frankfurt", "Stuttgart", 217.0);
    neueStrasse("Hamburg", "Hannover", 154.0);
    neueStrasse("Hannover", "Leipzig", 256.0);
    neueStrasse("Leipzig", "München", 425.0);
    neueStrasse("München", "Stuttgart", 220.0);
  }

  public void dijkstra(String vonId, String nachId) {
    // setze alle Markierungen auf false
    karte.setAllVertexMarks(false);
    // setze alle Entfernungen auf max und alle Vorgänger auf null
    List<Vertex> init = karte.getVertices();
    while (init.hasAccess()) {
      DijkstraVertex v = (DijkstraVertex) init.getContent();
      v.setDistance(Double.MAX_VALUE);
      v.setVorgaenger(null);
      init.next();
    }
    // setze Entfernung beim Startknoten auf 0
    DijkstraVertex start = (DijkstraVertex) karte.getVertex(vonId);
    start.setDistance(0);

    // solange ziel nicht erreicht
    while (!karte.getVertex(nachId).isMarked()) {
      // suche aus allen unmarkierten Knoten den mit dem geringsten Abstand zum Start
      // und speichere ihn in unter dem Namen "min"
      List<Vertex> knoten = karte.getVertices();
      // Raussuchen des ersten Vertex, das nicht markiert ist um danach ein Vergleich zu haben
      DijkstraVertex min = null;
      
      while (knoten.hasAccess()) {
        // Raussuchen des Knotens mit dem 
        DijkstraVertex current = (DijkstraVertex)knoten.getContent();
        if (min == null || (current.getDistance() < min.getDistance()) && !current.isMarked()) {
          min = current;
        }
        knoten.next();
      }
      // markiere min
      min.setMark(true);

      List<DijkstraVertex> nachbarn = new List<DijkstraVertex>();
      List<Vertex> ursprünglicheNachbarn = karte.getNeighbours(karte.getVertex(min.getID()));
      // hole alle Nachbarn und speichere die unmarkierten in einer Liste "nachbarn"
      while (ursprünglicheNachbarn.hasAccess()) {
        DijkstraVertex currentNeighbor = (DijkstraVertex)ursprünglicheNachbarn.getContent();
        if (!currentNeighbor.isMarked()) {
          nachbarn.append(currentNeighbor);
        }
      }
      // gehe an den Anfang von nachbarn
      nachbarn.toFirst();

      // solange Zugriff auf nachbarn
      while (nachbarn.hasAccess()) {
        double neueEntfernung = min.getDistance() + karte.getEdge((Vertex)nachbarn.getContent(), (Vertex)min).getWeight();
        // wenn gespeicherte Entfernung > neue Entfernung
        if (nachbarn.getContent().getDistance() > neueEntfernung) {
          // setze neue Entfernung und neuen Vorgänger
          nachbarn.getContent().setDistance(neueEntfernung);
          nachbarn.getContent().setVorgaenger(min);
        }
        // gehe zum nächsten nachbarn
        nachbarn.next();
      }

      
    }
    DijkstraVertex endpunkt = (DijkstraVertex)karte.getVertex(nachId);
    System.out.println("Test");
    System.out.println("Beste Distanz: " + endpunkt.getDistance());
  }


  public void dijkstraUnterricht(String vonId, String nachId) {
    karte.setAllVertexMarks(false);
    List<Vertex> vertices = karte.getVertices();
    vertices.toFirst();
    while (!vertices.hasAccess()) {
      DijkstraVertex v = (DijkstraVertex)vertices.getContent();
      v.setDistance(Double.MAX_VALUE);
      v.setVorgaenger(null);
    }

    DijkstraVertex v = (DijkstraVertex)karte.getVertex(nachId);
    v.setDistance(0);
    v.setMark(true);
  }

  private void neuerOrt(String pId) {
    karte.addVertex(new DijkstraVertex(pId));
  }

  private void neueStrasse(String vonId, String nachId, double laenge) {
    DijkstraVertex v1 = (DijkstraVertex) karte.getVertex(vonId);
    DijkstraVertex v2 = (DijkstraVertex) karte.getVertex(nachId);
    karte.addEdge(new Edge(v1, v2, laenge));
  }

}
