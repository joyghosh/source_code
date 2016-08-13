package datastructures.graph;

public class PrimsMST {
	
	private static final int V = 5;
	
	public static void main(String[] args) {
		int[][] graph = {{0, 2, 0, 6, 0},
                		{2, 0, 3, 8, 5},
                		{0, 3, 0, 0, 7},
                		{6, 8, 0, 0, 9},
                		{0, 5, 7, 9, 0}};
		
		primMst(graph);
	}
	
	public static void primMst(int[][] graph){
		
		//Set of vertices not yet included in mst.
		boolean[] mstSet = new boolean[V];
		
		//Array to store constructed mst.
		int[] parent = new int[V];
		
		// Key values used to pick minimum weight edge in cut
		int key[] = new int [V];
		
        // Initialize all keys as INFINITE.
		for(int i=0; i<V; i++){
			key[i] = Integer.MAX_VALUE;
		}
		
		// Always include first 1st vertex in MST.
		key[0] = 0; 		// Make key 0 so that this vertex is picked as first vertex.
		parent[0] = -1; 	// First node is always root of MST
		
		// The MST will have V vertices.
		for(int c=0; c<V; c++){
			// Pick thd minimum key vertex from the set of vertices
            // not yet included in MST
			int u = minKey(key, mstSet);
			
			// Add the picked vertex to the MST Set
			mstSet[u] = true;
			
			// Update key value and parent index of the adjacent
            // vertices of the picked vertex. Consider only those
            // vertices which are not yet included in MST.
			for(int v=0; v<V; v++){
				
				if(graph[u][v]!=0 && mstSet[v] == false && graph[u][v] < key[v]){
					parent[v] = u;
					key[v] = graph[u][v];
				}
			}
		}
		printMST(parent, graph);
	}
	
	/**
	 * Return the minimum key valued index.
	 * 
	 * @param key
	 * @param mstSet
	 * @return
	 */
	public static int minKey(int[] key, boolean[] mstSet){
		int min = Integer.MAX_VALUE;
		int min_index = -1;
		
		for(int v=0; v<V; v++){
			if(mstSet[v] == false && key[v] < min){
				min = key[v];
				min_index = v;
			}
		}
		return min_index;
	}
	
	public static void printMST(int[] parent, int[][] graph){
        System.out.println("Edge   Weight");
        for (int i = 1; i < V; i++){
            System.out.println(parent[i]+" - "+ i+"    "+
                    graph[i][parent[i]]);
        }
	}
}
