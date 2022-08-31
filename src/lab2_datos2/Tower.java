package lab2_datos2;

import java.util.ArrayList;

public class Tower {

    private int x; //Posicion x
    private int y; // Posicion y
    private int name;
    private final int d = 30; // Diametro del circulo que representa las torres
    ArrayList<Edge> edges;

    public Tower(int x, int y, int name) {
        this.x = x;
        this.y = y;
        this.name = name;
        this.edges = new ArrayList();
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getName() {
        return name;
    }

    public int getD() {
        return d;
    }

    void addEdge(Tower destination, int distance) {
        edges.add(new Edge(destination, distance));
    }

    void deleteEdges(Tower t) {
        ArrayList<Edge> tempEdges = new ArrayList();
        for (Edge edge : edges) {
            if (edge.getDestination() == t) {
                tempEdges.add(edge);
            }
        }
        for (Edge edge : tempEdges) {
            edges.remove(edge);
        }
    }

    public Edge getEdge(int i) {

        return edges.get(i);

    }

    public ArrayList<Edge> getEdges() {
        return edges;
    }

}
