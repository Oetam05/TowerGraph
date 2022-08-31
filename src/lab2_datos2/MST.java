package lab2_datos2;

import java.util.ArrayList;

public class MST {

    int M[][];
    int nVertices;
    City city;
    ArrayList<int[]> MstEdges;
    int initial;

    public MST(City city, int initial) {
        this.city = city;
        this.M = city.getAdjacencyMatrix();
        nVertices = M.length;
        MstEdges = new ArrayList();
        this.initial = initial;
    }

    // Function to find the vertex with minimum edge value,
    // from the set of vertices not yet included in out tree
    int min_edge(int edges[], boolean seen[]) {
        int min = Integer.MAX_VALUE, min_index = -1;
        for (int v = 0; v < nVertices; v++) {
            if (seen[v] == false && edges[v] < min) {
                min = edges[v];
                min_index = v;
            }
        }
        return min_index;
    }

    // Print MST
    void printMST_Prim(int[] mst_result) {
        for (int v = 1; v < nVertices; v++) {            
            MstEdges.add(new int[]{city.getiTower(mst_result[v]), city.getiTower(v)});
        }
    }

    // Function to construct MST for a graph represented using adjancecy matrix
    void Algorithm_Prim() {
        //mst -> Minimum Spanning Tree
        // Array to store tree
        int mst_result[] = new int[nVertices];
        // Edge values used to pick minimum weighted edge
        int values[] = new int[nVertices];
        // Seen vertex
        boolean mst_set[] = new boolean[nVertices];

        for (int v = 0; v < nVertices; v++) {
            values[v] = Integer.MAX_VALUE;
            mst_set[v] = false;
        }

        // This can be replaced with randomizer
        values[0] = initial;
        mst_result[0] = -1;

        for (int i = 0; i < nVertices - 1; i++) {
            // Pick minimum vertex from the set of vertices
            // given their edge not yet included in MST
            int min_edge = min_edge(values, mst_set);
            // Add picked vertex to the MST seen set
            mst_set[min_edge] = true;

            // Update values and mst_result index of the adjacent
            // vertices of the picked vertex (min_edge). Should only
            // consider those vertices which are not yet included to 
            // MST seen set
            for (int v = 0; v < nVertices; v++) {
                if (M[min_edge][v] != 0 && mst_set[v] == false && M[min_edge][v] < values[v]) {
                    mst_result[v] = min_edge;
                    values[v] = M[min_edge][v];
                }
            }
        }
        printMST_Prim(mst_result);
    }

    public ArrayList<int[]> getMstEdges() {
        return MstEdges;
    }

}
