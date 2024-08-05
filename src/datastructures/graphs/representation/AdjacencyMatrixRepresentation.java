/**
 * 
 */
package datastructures.graphs.representation;

/**
 * 
 */
public class AdjacencyMatrixRepresentation {
	private int V;
	private int E;
	
	private int[][] adjMatrix;
	
	

	
	public AdjacencyMatrixRepresentation(int nodes) {
		this.V = nodes;
		this.E = 0;
		
		this.adjMatrix = new int[nodes][nodes];
	}
	
	public void addEdge(int u, int v) {
		this.adjMatrix[u][v] = 1;
		this.adjMatrix[v][u] = 1;
		E++;
		

		
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(V + " vertices, " + E + " edges " + "\n");
		for (int v = 0; v < V; v++) {
			sb.append(v + ": ");
			for (int w : adjMatrix[v]) {
				sb.append(w + " ");
			}
			sb.append("\n");
		}
		return sb.toString();
		
	}

	


	public static void main(String[] args) {
		
		AdjacencyMatrixRepresentation g = new AdjacencyMatrixRepresentation(4);
		
		g.addEdge(0, 1);
		g.addEdge(1, 2);
		g.addEdge(2, 3);
		g.addEdge(3, 0);
		
		System.out.println(g);
		

	}

}
