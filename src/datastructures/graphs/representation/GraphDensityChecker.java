package datastructures.graphs.representation;
import java.util.ArrayList;
import java.util.List;

public class GraphDensityChecker {

    static class Graph {
        int vertices;
        List<Integer>[] adjacencyList;

        public Graph(int vertices) {
            this.vertices = vertices;
            adjacencyList = new ArrayList[vertices];
            for (int i = 0; i < vertices; i++) {
                adjacencyList[i] = new ArrayList<>();
            }
        }

        public void addEdge(int source, int destination) {
            adjacencyList[source].add(destination);
            adjacencyList[destination].add(source);
        }

        public int countEdges() {
            int count = 0;
            for (int i = 0; i < vertices; i++) {
                count += adjacencyList[i].size();
            }
            return count / 2; // Since the graph is undirected, each edge is counted twice
        }

        public boolean isDense() {
            int maxEdges = vertices * (vertices - 1) / 2;
            int actualEdges = countEdges();
            double density = (double) actualEdges / maxEdges;
            return density >= (2.0 / 3.0);
        }
    }

    public static void main(String[] args) {
        int vertices = 5; // Number of vertices
        Graph graph = new Graph(vertices);

        // Add edges to the graph
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(2, 4);

        if (graph.isDense()) {
            System.out.println("The graph is dense.");
        } else {
            System.out.println("The graph is sparse.");
        }
    }
}
