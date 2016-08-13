package algorithms.greedy;

public class KruskalsMST {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static void mst(){
		
	}
	
	class Edge implements Comparable<Edge>{
		int src, dest, weight;
		
		public int compareTo(Edge edge){
			return this.weight - edge.weight;
		}
	}
	
	class Subset{
		int parent, rank;
	}
	
	class Graph{
		int V, E;
		Edge[] edges;
		
		public Graph(int v, int e){
			V = v;
			E = e;
			edges = new Edge[E];
			for(int i=0; i<e; i++){
				edges[i] = new Edge();
			}
		}
		
		
	}
}
