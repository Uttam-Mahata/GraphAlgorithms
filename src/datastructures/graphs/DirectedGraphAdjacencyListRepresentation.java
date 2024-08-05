package datastructures.graphs;

import java.util.LinkedList;

public class DirectedGraphAdjacencyListRepresentation {
    private int V;
    private int E;
    private LinkedList<Integer>[] adjList;

    public DirectedGraphAdjacencyListRepresentation(int nodes) {
        this.V = nodes;
        this.E = 0;
        
        this.adjList = new LinkedList[nodes];
        for (int v = 0; v < V; v++) {
            adjList[v] = new LinkedList<>();
        }
    }

    // Add edge
    public void addEdge(int from, int to) {
        if (from >= 0 && from < V && to >= 0 && to < V) {
            adjList[from].add(to);
            E++;
        } else {
            System.out.println("Invalid vertex");
        }
    }

    // Remove edge
    public void removeEdge(int from, int to) {
        if (from >= 0 && from < V && to >= 0 && to < V) {
            adjList[from].remove((Integer) to);
            E--;
        } else {
            System.out.println("Invalid vertex");
        }
    }

    // Print the adjacency list
    public void printGraph() {
        for (int v = 0; v < V; v++) {
            System.out.print("Vertex " + v + ":");
            for (Integer w : adjList[v]) {
                System.out.print(" -> " + w);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int numVertices = 5;
        DirectedGraphAdjacencyListRepresentation graph = new DirectedGraphAdjacencyListRepresentation(numVertices);

        // Adding edges
        graph.addEdge(0, 1);
        graph.addEdge(0, 4);
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(1, 4);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);

        // Printing the adjacency list
        System.out.println("Adjacency List:");
        graph.printGraph();
    }
}
