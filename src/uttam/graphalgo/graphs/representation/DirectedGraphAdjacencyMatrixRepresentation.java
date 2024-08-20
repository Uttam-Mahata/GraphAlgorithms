package uttam.graphalgo.graphs.representation;

public class DirectedGraphAdjacencyMatrixRepresentation {
    private int V;
    private int E;
    private int[][] adjMatrix;

    public DirectedGraphAdjacencyMatrixRepresentation(int nodes) {
        this.V = nodes;
        this.E = 0;
        
        this.adjMatrix = new int[nodes][nodes];
    }

    // Add edge
    public void addEdge(int from, int to) {
        if (from >= 0 && from < V && to >= 0 && to < V) {
            adjMatrix[from][to] = 1;
            E++;
        } else {
            System.out.println("Invalid vertex");
        }
    }

    // Remove edge
    public void removeEdge(int from, int to) {
        if (from >= 0 && from < V && to >= 0 && to < V) {
            adjMatrix[from][to] = 0;
            E--;
        } else {
            System.out.println("Invalid vertex");
        }
    }

    // Print the adjacency matrix
    public void printGraph() {
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                System.out.print(adjMatrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int numVertices = 5;
        DirectedGraphAdjacencyMatrixRepresentation graph = new DirectedGraphAdjacencyMatrixRepresentation(numVertices);

        // Adding edges
        graph.addEdge(0, 1);
        graph.addEdge(0, 4);
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(1, 4);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);

        // Printing the adjacency matrix
        System.out.println("Adjacency Matrix:");
        graph.printGraph();
    }
}
