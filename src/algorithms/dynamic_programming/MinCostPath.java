package algorithms.dynamic_programming;

/**
 * Min Cost Path
 * Given a cost matrix cost[][] and a position (m, n) in cost[][], 
 * write a function that returns cost of minimum cost path to reach (m, n) from (0, 0). 
 * Each cell of the matrix represents a cost to traverse through that cell. 
 * Total cost of a path to reach (m, n) is sum of all the costs on that path 
 * (including both source and destination). You can only traverse down, right and diagonally 
 * lower cells from a given cell, i.e., from a given cell (i, j), cells (i+1, j), (i, j+1) 
 * and (i+1, j+1) can be traversed. You may assume that all costs are positive integers.
 * 
 * @author Joy Ghosh
 *
 */
public class MinCostPath {
	
	//find the minimum cost to reach from (0,0) to (m,n).
	public static int minCost(int[][] cost, int m, int n){
		if(m<0 || n <0){
			return Integer.MAX_VALUE;
		}else if(m == 0 || n == 0){
			return cost[m][n];
		}
		return (min(minCost(cost, m-1, n-1), minCost(cost, m-1, n), minCost(cost, m, n-1)) + cost[m][n]);
	}
	
	//find the minimum of 3 integer values.
	private static int min(int a, int b, int c){
		if(a<b && a<c) return a;
		else if(b<a && b<c) return b;
		return c;
	}
	
	public static void main(String[] args) {
		
		int[][] cost = {{1,2,3},
						{4,8,2},
						{1,5,3}};
		int x = 2, y = 2;
		System.out.println("minimum cost to reach ("+x+","+y+") from (0,0) is: "+minCost(cost, x, y));
	}
}
