public class Karte{

    private Graph karte;
    
    public Karte(){
        karte = new Graph();        
        neuerOrt("L");
        neuerOrt("A");
        neuerOrt("B");
        neuerOrt("C");
        neuerOrt("D");
        neuerOrt("E");
        neuerOrt("F");
        neueStrasse("L", "A", 14.0);
        neueStrasse("L", "B", 69.0);
        neueStrasse("L", "C", 26.0);
        neueStrasse("L", "D", 31.0);
        neueStrasse("L", "E", 16.0);
        neueStrasse("A", "B", 47.0);
        neueStrasse("A", "C", 66.0);
        neueStrasse("A", "D", 33.0);
        neueStrasse("A", "E", 52.0);        
        neueStrasse("B", "C", 58.0);
        neueStrasse("B", "D", 52.0);
        neueStrasse("B", "E", 23.0);
        neueStrasse("C", "D", 45.0);
        neueStrasse("C", "E", 27.0);
        neueStrasse("D", "E", 59.0);
    }

    
    public void starteRundreise(String startId){
        karte.setAllVertexMarks(false);
        Vertex k = karte.getVertex(startId); 
        System.out.print(k.getID() + " - ");
        rundreise(k, k);        
    }
    
    private void rundreise(Vertex k, Vertex ziel){
        List<Vertex> nachbarn = karte.getNeighbours(k);
        nachbarn.toFirst();
        k.setMark(true);
        double min = karte.getEdge(k, nachbarn.getContent()).getWeight();
        while(nachbarn.hasAccess()){
            
        }
    }   
    public void rundreise(Vertex start) {
        start.setMark(true);
        Vertex current = start;
        List<Vertex> nachbarn = karte.getNeighbours(current);
        // Suche die jeweils nächste billigste Kante heraus
        Edge min = karte.getEdge(current, nachbarn.getContent());
        while (nachbarn.hasAccess()) {
            if (karte.getEdge(current, nachbarn.getContent()).getWeight() < min.getWeight()) {
                min = karte.getEdge(current, nachbarn.getContent());
            }
        }


    }
    
    
    private void neuerOrt(String pId){
        karte.addVertex(new Vertex(pId));
    }
    
    private void neueStrasse(String vonId, String nachId, double laenge){
        Vertex v1 = karte.getVertex(vonId);
        Vertex v2 = karte.getVertex(nachId);
        karte.addEdge(new Edge(v1, v2, laenge));
    }
    

}





























