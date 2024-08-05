package datastructures.graphs;

import java.util.LinkedList;
import java.util.List;

public class WeightedDirectedGraphAdjacencyListRepresentation {
    private int V;
    private int E;
    private List<Edge>[] adjList;

    // Edge class to represent a weighted edge
    private static class Edge {
        int to;
        int weight;

        Edge(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }

        @Override
        public String toString() {
            return "(" + to + ", " + weight + ")";
        }
    }

    public WeightedDirectedGraphAdjacencyListRepresentation(int nodes) {
        this.V = nodes;
        this.E = 0;
        
        this.adjList = new LinkedList[nodes];
        for (int v = 0; v < V; v++) {
            adjList[v] = new LinkedList<>();
        }
    }

    // Add edge
    public void addEdge(int from, int to, int weight) {
        if (from >= 0 && from < V && to >= 0 && to < V) {
            adjList[from].add(new Edge(to, weight));
            E++;
        } else {
            System.out.println("Invalid vertex");
        }
    }

    // Remove edge
    public void removeEdge(int from, int to) {
        if (from >= 0 && from < V && to >= 0 && to < V) {
            adjList[from].removeIf(edge -> edge.to == to);
            E--;
        } else {
            System.out.println("Invalid vertex");
        }
    }

    // Print the adjacency list
    public void printGraph() {
        for (int v = 0; v < V; v++) {
            System.out.print("Vertex " + v + ":");
            for (Edge edge : adjList[v]) {
                System.out.print(" -> " + edge);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int numVertices = 5;
        WeightedDirectedGraphAdjacencyListRepresentation graph = new WeightedDirectedGraphAdjacencyListRepresentation(numVertices);

        // Adding edges
        graph.addEdge(0, 1, 2);
        graph.addEdge(0, 4, 5);
        graph.addEdge(1, 2, 3);
        graph.addEdge(1, 3, 1);
        graph.addEdge(1, 4, 7);
        graph.addEdge(2, 3, 2);
        graph.addEdge(3, 4, 3);

        // Printing the adjacency list
        System.out.println("Weighted Adjacency List:");
        graph.printGraph();
    }
}
