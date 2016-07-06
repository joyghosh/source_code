package datastructures.graph;


public class DetectCycleUnionFind {

	public static void main(String[] args) {
	      /**
	       *  Let us create following graph
		   *    0
		   *   |  \
		   *   |    \
		   *   1-----2 
		   */
		int V = 3; int E = 3;
		Graph g = new Graph(V, E);
		
		//add an edge 0-1
        g.edges[0].src = 0;
        g.edges[0].dest = 1;
 
        //add an edge 1-2
        g.edges[1].src = 1;
        g.edges[1].dest = 2;
 
        //add an edge 0-2
//        g.edges[2].src = 0;
//        g.edges[2].dest = 2;
        
        if(g.isCycle()){
        	System.out.println("Graph contains a cycle.");
        }else{
        	System.out.println("Graph doesn't contain a cycle.");
        }
	}
}

/**
 * Represents edge of a graph.
 *
 */
class Edge{
	int src, dest;
}

/**
 * Represents the graph itself.
 */
class Graph{
	
	int V, E;
	Edge[] edges;
	int[] parent;
	
	public Graph(int V, int E) {
		this.V = V;
		this.E = E;
		
		//init.
		this.parent = new int[V];
		edges = new Edge[E];
		for(int i=0;i<edges.length;i++)
			edges[i] = new Edge();
	}
	
	/**
	 * MakeSet() operation.
	 * Time-complexity: O(1)
	 * Space-complexity: O(1)
	 * @param n Nod n
	 */
	public void makeSet(int n){
		this.parent[n] = -1;
	}
	
	/**
	 * Find operation.
	 * Time-complexity: O(n)
	 * Space-complexity: O(n)
	 * @param n
	 * @return
	 */
	public int find(int n){
		
		if(this.parent[n] == -1){
			return n;
		}
		return find(this.parent[n]);
	}
	
	/**
	 * Union operation.
	 * Time-complexity: O(1)
	 * Space-complexity: O(1)	
	 * @param x
	 * @param y
	 */
	public void union(int x, int y){
		int rootX = find(x);
		int rootY = find(y);
		this.parent[rootX] = rootY;
	}
	
	/**
	 * Detects if a graph contains a cycle or not.
	 * @param g
	 * @return
	 */
	public boolean isCycle(){
		
		//Initialize parent array.		
		for(int i=0;i<this.V;i++)
			this.makeSet(i);
		
		//Iterate through all the vertices of the graph.
		//Find subset of both the vertices of every edge, if both are same,
		//then there is a cycle in the graph.
		for(int i=0;i<this.E;i++){
			int x = this.find(this.edges[i].src);
			int y = this.find(this.edges[i].dest);
			
			if(x == y)
				return true;
			
			this.union(x, y);
		}
		
		return false;
	}
}