package datastructures.graph;

public class KruskalMST {

	public static void main(String[] args) {
		
	}
	
	class Edge implements Comparable<Edge>{
		int src, dest;
		int weight;

		@Override
		public int compareTo(Edge o) {
			return this.weight - o.weight;
		}
	}
	
	public static int find(int[] parent, int i){
		if(parent[i] == -1)
			return i;
		return find(parent, parent[i]);
	}
	
	public static void union(int[] parent, int x, int y){
		int xset = find(parent, x);
		int yset = find(parent, y);
		parent[xset] = yset;
	}
}
