/**
 * 
 */
package uttam.graphalgo.graphs.representation;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 
 */
public class AdjacencyListRepresentation {
	private int V;
	private int E;
	
	private LinkedList<Integer>[] adjList;
	
	public AdjacencyListRepresentation(int nodes) {
		this.V = nodes;
        this.E = 0;
        
        this.adjList = new LinkedList[nodes];
        for (int v = 0; v < V; v++) {
            adjList[v] = new LinkedList<>();
        }
        
		
	}
	
	public void addEdge(int u, int v) {
		adjList[u].add(v);
		adjList[v].add(u);
		E++;

	}
	
	public void addEdge(int u) {
		adjList[u] = new LinkedList<>();
		E++;
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(V + " vertices, " + E + " edges " + "\n");
		for (int v = 0; v < V; v++) {
			sb.append(v + ": ");
			for (int w : adjList[v]) {
				sb.append(w + " ");
			}
			sb.append("\n");
		}
		return sb.toString();
	}
	
	public void bfs(int s) {
		boolean[] visited = new boolean[V];
		Queue<Integer> q = new LinkedList<>();
		visited[s] = true;
		q.offer(s);
		
		while (!q.isEmpty()) {
			int u = q.poll();
			System.out.print(u + " ");
			for (int v : adjList[u]) {
				if (!visited[v]) {
					visited[v] = true;
					q.offer(v);
				}
			}
		}
		
	}
	
	public AdjacencyListRepresentation(int v, int e, LinkedList<Integer>[] adjList) {
		super();
		V = v;
		E = e;
		this.adjList = adjList;
	}

	public void iterativeDFS(int s) {
		boolean[] visited = new boolean[V];
		Stack<Integer> stack = new Stack<>();
		
		stack.push(s);
		while (!stack.isEmpty()) {
			int u = stack.pop();
			if (!visited[u]) {
				visited[u] = true;
				System.out.print(u + " ");
				for (int v : adjList[u]) {
					if (!visited[v]) {
						stack.push(v);
					}
				}
			}
		}
	}
	
	public void recursiveDFS() {
		boolean[] visited = new boolean[V];
		for (int v = 0; v < V; v++) {
			if (!visited[v]) {
				dfs(v, visited);
			}
		}
	}
	
	private void dfs(int u, boolean[] visited) {
		visited[u] = true;
		System.out.print(u + " ");
		for (int v : adjList[u]) {
			if (!visited[v]) {
				dfs(v, visited);
			}
		}
	}
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		AdjacencyListRepresentation g = new AdjacencyListRepresentation(6);
		
		g.addEdge(0, 1);
		g.addEdge(1, 2);
		g.addEdge(2, 3);
		g.addEdge(3, 0);
		g.addEdge(2, 4);
		
		g.addEdge(5);
		
		System.out.println(g);
		
		g.bfs(0);
		System.out.println();
		g.iterativeDFS(0);
		System.out.println();
		g.recursiveDFS();

	}

}
