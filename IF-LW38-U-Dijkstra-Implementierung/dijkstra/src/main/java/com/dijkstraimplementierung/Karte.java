package com.dijkstraimplementierung;

import java.net.http.WebSocket;

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

  private boolean tiefenSuche(Vertex current, String suchId) {
    if (current.getID().equals(suchId)) {
      return true;
    }
    current.setMark(true);
    List<Vertex> nachbarn  = karte.getNeighbours(current);
    nachbarn.toFirst();
    while (nachbarn.hasAccess()) {
      if (!nachbarn.getContent().isMarked()) {
        tiefenSuche(nachbarn.getContent(), suchId);
        System.out.println(nachbarn.getContent().getID());
      }
      nachbarn.next();
    }
    return false;
  }

  private boolean tiefenSucheUnterricht(Vertex k, String nachId) {
    k.setMark(true);
    // Rekursionsbedingung
    if (k.getID().equals(nachId)) {
      return true;
    }
    // Durch die Nachbarn durch gehen
    List<Vertex> nachbarn = karte.getNeighbours(k);
    for(nachbarn.toFirst(); nachbarn.hasAccess(); nachbarn.next()) {
      if (!nachbarn.getContent().isMarked()) {
        // Ergebnis der Rekursion nach oben durch geben
        if(tiefenSucheUnterricht(nachbarn.getContent(), nachId)) {
          return true;}
      }
    }
    return false;

  }

  public void tiefenSuche(String startId, String nachId) {
    karte.setAllEdgeMarks(false);
    boolean result =  tiefenSucheUnterricht(karte.getVertex(startId), nachId);
    System.out.println(result);
  }

  public boolean breitenSuche(String startId, String nachId) {
    // Teste, dass der Startknoten existiert
    if (karte.getVertex(startId) == null) {
      System.out.println("Startknoten existiert nicht");
      return false;
    }
    // Markiere alle Knoten als nicht besucht
    karte.setAllVertexMarks(false);
    // Markiere den Startknoten als besucht
    karte.getVertex(startId).setMark(true);
    // Initialisiere die leere Schlange
    Queue<Vertex> queue = new Queue<>();
    // Füge den Startknoten in die Schlange ein
    queue.enqueue(karte.getVertex(startId));
    // Solange die Schlange nicht leer ist
    while (!queue.isEmpty()) {
      // Entnehme den ersten Knoten aus der Schlange
      Vertex k = queue.front();
      queue.dequeue();
      // Abbruchbedingung der Iteration
      if (k.getID().equals(nachId)) {
        System.out.println("Gefunden");
        return true;
      }
      // Durchlaufe die Nachbarn des aktuellen Knotens
      List<Vertex> nachbarn = karte.getNeighbours(k);
      for (nachbarn.toFirst(); nachbarn.hasAccess(); nachbarn.next()) {
        // Fall der aktuelle Nachbar noch nicht besucht wurde
        if (!nachbarn.getContent().isMarked()) {
          // Markiere den Nachbarn als besucht
          nachbarn.getContent().setMark(true);
          // Füge den Nachbarn in die Schlange ein
          queue.enqueue(nachbarn.getContent());
        }
      }
    }
    System.out.println("Nicht gefunden");
    return false;
  }

}
