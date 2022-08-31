/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab2_datos2;

/**
 *
 * @author Mateo
 */
class ShortestPath {

    // A utility function to find the vertex with minimum distance value,
    // from the set of vertices not yet included in shortest path tree
    int M[][];
    int nVertices;
    City city;
    int initial;

    public ShortestPath(City city, int initial) {
        this.city = city;
        this.M = city.getAdjacencyMatrix();
        this.nVertices = this.M.length;
        this.initial = initial;
    }

    int minDistance(int dist[], Boolean sptSet[]) {
        // Initialize min value
        int min = Integer.MAX_VALUE, min_index = -1;

        for (int v = 0; v < nVertices; v++) {
            if (sptSet[v] == false && dist[v] <= min) {
                min = dist[v];
                min_index = v;
            }
        }

        return min_index;
    }

    // Function that implements Dijkstra's single source shortest path
    // algorithm for a graph represented using adjacency matrix
    // representation
    int[] dijkstra() {
        int dist[] = new int[nVertices]; // The output array. dist[i] will hold
        // the shortest distance from src to i

        // sptSet[i] will true if vertex i is included in shortest
        // path tree or shortest distance from src to i is finalized
        Boolean sptSet[] = new Boolean[nVertices];

        // Initialize all distances as INFINITE and stpSet[] as false
        for (int i = 0; i < nVertices; i++) {
            dist[i] = Integer.MAX_VALUE;
            sptSet[i] = false;
        }

        // Distance of source vertex from itself is always 0
        dist[initial] = 0;

        // Find shortest path for all vertices
        for (int count = 0; count < nVertices - 1; count++) {
            // Pick the minimum distance vertex from the set of vertices
            // not yet processed. u is always equal to src in first
            // iteration.
            int u = minDistance(dist, sptSet);

            // Mark the picked vertex as processed
            sptSet[u] = true;

            // Update dist value of the adjacent vertices of the
            // picked vertex.
            for (int v = 0; v < nVertices; v++) // Update dist[v] only if is not in sptSet, there is an
            // edge from u to v, and total weight of path from src to
            // v through u is smaller than current value of dist[v]
            {
                if (!sptSet[v] && M[u][v] != 0
                        && dist[u] != Integer.MAX_VALUE && dist[u] + M[u][v] < dist[v]) {
                    dist[v] = dist[u] + M[u][v];
                }
            }
        }
        return dist;        
    }
}
