package com.projekt.karte;
 public class Karte{
    //Attribute
    private Graph karte;    
    
    //Konstruktor(en)
    public Karte(){
        karte = new Graph();
        neuerOrt("Mülldorf");
        neuerOrt("Menden");
        neuerOrt("St. Augustin");
        neuerOrt("Niederpleis");
        neuerOrt("Hangelar");
        neuerOrt("Holzlar");
        neueStrasse("Mülldorf", "Menden", 2.0);
        neueStrasse("Mülldorf", "St. Augustin", 2.0);
        neueStrasse("Mülldorf", "Niederpleis", 3.0);
        neueStrasse("Menden", "St. Augustin", 3.0);
        neueStrasse("Niederpleis", "St. Augustin", 3.0);
        neueStrasse("Hangelar", "St. Augustin", 2.0);
        neueStrasse("Niederpleis", "Hangelar", 5.0);
        neueStrasse("Niederpleis", "Holzlar", 8.0);
        neueStrasse("Hangelar", "Holzlar", 4.0);          
    }
    
    //Methode(n)
    public void neuerOrt(String pId){
        Vertex neuerKnoten = new Vertex(pId);
        karte.addVertex(neuerKnoten);
    }
    
    public void neueStrasse(String pVonId, String pNachId, double laenge){
        Vertex v1 = karte.getVertex(pVonId);
        Vertex v2 = karte.getVertex(pNachId);
        Edge e = new Edge(v1, v2, laenge);
        karte.addEdge(e);
    }

    
    public void findeOrt(String pOrt){
        List<Vertex> liste = karte.getVertices();
        liste.toFirst();
        while(liste.hasAccess()){
            if(liste.getContent().getID().equals(pOrt))
                System.out.println(pOrt + " ist im Graphen enthalten");
            liste.next();
        }
    }    
    
    public void findeOrt2(String pOrt){
        if(karte.getVertex(pOrt) != null)
            System.out.println(pOrt + " ist im Graphen enthalten");        
        else
            System.out.println(pOrt + " ist nicht im Graphen enthalten");
    }
    
    public void starteWegesuche(String pVon, String pNach){
        karte.setAllVertexMarks(false);
        wegesuche(pVon, pNach, pVon, 0, 0);    
    }
    
    private void wegesuche(String akt, String pNach,String bishWeg, double lang, int anz){
        
        //markiere aktuellen Knoten
        Vertex current = karte.getVertex(akt);
        current.setMark(true);
        Vertex target = karte.getVertex(pNach);
    
        if(current == target) {
            System.out.println(bishWeg);
            System.out.println(lang);
            System.out.println(anz);
        }
        else {
            List<Vertex> neighbors = karte.getNeighbours(current);
            neighbors.toFirst();
            while (neighbors.hasAccess()) {
                if (!neighbors.getContent().isMarked()) {
                    wegesuche(neighbors.getContent().getID(), pNach, bishWeg+" - "+neighbors.getContent().getID(), lang + karte.getEdge(current, neighbors.getContent()).getWeight(), anz++);
                }
                neighbors.next();
            }
        }
        //Rekursionsanker: akt-Knoten = pNach-Knoten
            //gib bisherigen Weg aus
        //rekursiver Fall
            //hole alle Nachbarn von akt-Knoten
            //alle Nachbarn durchlaufen
                //wenn nicht Nachbar nicht markiert:
                    //wegesuche rekursiv aufrufen mit:
                            //Nachbar als akt, pNach, bishWeg+" - "+Nachbar
    }
}
