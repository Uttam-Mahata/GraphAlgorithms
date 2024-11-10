package uttam.graphalgo.trees.mst;
import java.util.PriorityQueue;
import java.util.ArrayList;
import java.util.List;

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

public class PrimsAlgorithm {
    private static final int V = 5;

    public void primMST(List<Edge>[] graph) {
        boolean[] visited = new boolean[V];
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        List<Edge> mstEdges = new ArrayList<>();
        int minCost = 0;

        visited[0] = true;
        pq.addAll(graph[0]);

        while (!pq.isEmpty() && mstEdges.size() < V - 1) {
            Edge edge = pq.poll();
            if (visited[edge.dest]) continue;

            visited[edge.dest] = true;
            mstEdges.add(edge);
            minCost += edge.weight;

            for (Edge nextEdge : graph[edge.dest]) {
                if (!visited[nextEdge.dest]) {
                    pq.add(nextEdge);
                }
            }
        }

        System.out.println("Minimum Spanning Tree Edges:");
        for (Edge e : mstEdges) {
            System.out.println("(" + (char)('a' + e.src) + "," + (char)('a' + e.dest) + "," + e.weight + ")");
        }
        System.out.println("Minimum Cost: " + minCost);
    }

    public static void main(String[] args) {
        List<Edge>[] graph = new ArrayList[V];
        for (int i = 0; i < V; i++) {
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0, 1, 1)); graph[1].add(new Edge(1, 0, 1));
        graph[0].add(new Edge(0, 4, 2)); graph[4].add(new Edge(4, 0, 2));
        graph[1].add(new Edge(1, 2, 3)); graph[2].add(new Edge(2, 1, 3));
        graph[0].add(new Edge(0, 2, 4)); graph[2].add(new Edge(2, 0, 4));
        graph[1].add(new Edge(1, 3, 3)); graph[3].add(new Edge(3, 1, 3));
        graph[2].add(new Edge(2, 4, 3)); graph[4].add(new Edge(4, 2, 3));
        graph[2].add(new Edge(2, 3, 1)); graph[3].add(new Edge(3, 2, 1));
        graph[3].add(new Edge(3, 4, 2)); graph[4].add(new Edge(4, 3, 2));

        PrimsAlgorithm pa = new PrimsAlgorithm();
        pa.primMST(graph);
    }
}
