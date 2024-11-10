package uttam.graphalgo.trees.mst;
import java.util.*;

class Edge implements Comparable<Edge> {
    int src, dest, weight;
    
    Edge(int src, int dest, int weight) {
        this.src = src;
        this.dest = dest;
        this.weight = weight;
    }
    
    public int compareTo(Edge compareEdge) {
        return this.weight - compareEdge.weight;
    }
}

class Subset {
    int parent, rank;
}

public class Kruskal {
    int vertices, edges;
    Edge[] edge;

    Kruskal(int vertices, int edges) {
        this.vertices = vertices;
        this.edges = edges;
        edge = new Edge[edges];
        for (int i = 0; i < edges; i++) {
            edge[i] = new Edge(0, 0, 0);
        }
    }

    int find(Subset[] subsets, int i) {
        if (subsets[i].parent != i) {
            subsets[i].parent = find(subsets, subsets[i].parent);
        }
        return subsets[i].parent;
    }

    void union(Subset[] subsets, int x, int y) {
        int rootX = find(subsets, x);
        int rootY = find(subsets, y);
        if (subsets[rootX].rank < subsets[rootY].rank) {
            subsets[rootX].parent = rootY;
        } else if (subsets[rootX].rank > subsets[rootY].rank) {
            subsets[rootY].parent = rootX;
        } else {
            subsets[rootY].parent = rootX;
            subsets[rootX].rank++;
        }
    }

    void kruskalMST() {
        Edge[] result = new Edge[vertices];
        int e = 0;
        int i = 0;
        for (i = 0; i < vertices; i++) {
            result[i] = new Edge(0, 0, 0);
        }
        Arrays.sort(edge);
        Subset[] subsets = new Subset[vertices];
        for (i = 0; i < vertices; i++) {
            subsets[i] = new Subset();
            subsets[i].parent = i;
            subsets[i].rank = 0;
        }
        i = 0;
        while (e < vertices - 1) {
            Edge nextEdge = edge[i++];
            int x = find(subsets, nextEdge.src);
            int y = find(subsets, nextEdge.dest);
            if (x != y) {
                result[e++] = nextEdge;
                union(subsets, x, y);
            }
        }
        int minCost = 0;
        for (i = 0; i < e; i++) {
            System.out.println((char) (result[i].src + 'a') + " - " + (char) (result[i].dest + 'a') + " : " + result[i].weight);
            minCost += result[i].weight;
        }
        System.out.println("Minimum Cost: " + minCost);
    }

    public static void main(String[] args) {
        int vertices = 16;
        int edges = 27;
        Kruskal graph = new Kruskal(vertices, edges);

        int[][] inputEdges = {
            {0, 1, 1}, {0, 4, 1}, {0, 3, 2}, {0, 12, 2},
            {1, 2, 2}, {1, 5, 3},
            {2, 3, 1}, {2, 6, 3},
            {3, 7, 1}, {3, 15, 2},
            {4, 5, 2}, {4, 8, 2},
            {5, 6, 3}, {5, 9, 3},
            {6, 7, 2}, {6, 10, 4},
            {7, 11, 3},
            {8, 9, 3}, {8, 12, 3},
            {9, 10, 4}, {9, 13, 4},
            {10, 11, 3}, {10, 14, 3},
            {11, 15, 2},
            {12, 13, 2}, {12, 15, 2},
            {13, 14, 2}, {14, 15, 3}
        };

        for (int i = 0; i < edges; i++) {
            graph.edge[i] = new Edge(inputEdges[i][0], inputEdges[i][1], inputEdges[i][2]);
        }

        graph.kruskalMST();
    }
}

