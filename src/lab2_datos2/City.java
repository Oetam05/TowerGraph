package lab2_datos2;

import java.util.ArrayList;

public class City {

    ArrayList<Tower> towers;
    ArrayList<Edge> edges;
    int adjacencyMatrix[][];

    public City() {
        towers = new ArrayList();
        edges = new ArrayList();
    }

    public ArrayList<Tower> getTowers() {
        return towers;
    }

    public void addTower(Tower t) {
        towers.add(t);
    }

    public Tower getTower(int name) {
        for (Tower tower : towers) {
            if (tower.getName() == name) {
                return tower;
            }
        }
        return null;
    }

    public void addEdge(Edge edge) {
        edges.add(edge);
    }

    public ArrayList<Edge> getEdges() {
        return edges;
    }

    public int[][] getAdjacencyMatrix() {
        this.adjacencyMatrix = generateAdjacencyMatrix();
        return adjacencyMatrix;
    }

    public Tower checkSpace(int x, int y) {
        for (Tower tower : towers) {
            if (x < tower.getX() + 90 && x > tower.getX() - 90 && y < tower.getY() + 90 && y > tower.getY() - 90) {
                return tower;
            }
        }
        return null;
    }

    public void deleteTower(Tower t) {
        towers.remove(t);
        ArrayList<Edge> tempEdges = new ArrayList();
        for (Edge edge : edges) {
            if (edge.getOrigin() == t || edge.getDestination() == t) {
                tempEdges.add(edge);
            }
        }
        for (Edge edge : tempEdges) {
            edges.remove(edge);
        }
        for (Tower tower : towers) {
            tower.deleteEdges(t);
        }
    }

    public int[][] generateAdjacencyMatrix() {
        int M[][] = new int[towers.size()][towers.size()];
        for (int i = 0; i < towers.size(); i++) {
            for (int j = 0; j < towers.size(); j++) {
                M[i][j] = 0;
            }
        }
        int Names[] = new int[towers.size()];
        int i = 0;
        for (Tower tower : towers) {
            Names[i++] = tower.getName();
        }
        i = 0;
        for (Tower tower : towers) {
            for (Edge edge : tower.getEdges()) {
                M[i][FindName(edge.getDestination().getName(), Names)] = edge.getDistance();
            }
            i++;
        }
        return M;
    }

    private int FindName(int name, int[] Names) {
        for (int i = 0; i < Names.length; i++) {
            if (Names[i] == name) {
                return i;
            }
        }
        return -1;
    }

    // Prim Algorythm 
    int getiTower(int i) {
        return towers.get(i).getName();
    }

    int getPosition(int t) {
        int i = 0;
        for (Tower tower : towers) {
            if (tower.getName() == t) {
                return i;
            }
            i++;
        }
        return -1;
    }

    boolean checkEdge(int a, int b) {
        for (Edge edge : edges) {

            if ((a == edge.getOrigin().getName() && b == edge.getDestination().getName()) || (a == edge.getDestination().getName() && b == edge.getOrigin().getName())) {
                return false;
            }
        }
        return true;
    }
}
