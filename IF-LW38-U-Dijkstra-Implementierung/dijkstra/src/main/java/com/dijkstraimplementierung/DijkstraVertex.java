package com.dijkstraimplementierung;

public class DijkstraVertex extends Vertex {

    private double distance;


    public double getDistance() {
        return distance;
    }

    public void setDistance(double gewichtung) {
        distance = gewichtung;
    }
    
    private DijkstraVertex Vorgaenger;

    public DijkstraVertex getVorgaenger() {
        return Vorgaenger;
    }

    public void setVorgaenger(DijkstraVertex vorgaenger) {
        Vorgaenger = vorgaenger;
    }

    
    public DijkstraVertex(String pID) {
        super(pID);
        //TODO Auto-generated constructor stub
    }

}
