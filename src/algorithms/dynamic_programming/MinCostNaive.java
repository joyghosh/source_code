package algorithms.dynamic_programming;

public class MinCostNaive {

	private static int[][] cost = {{1,2,3},
									{4,8,2},
								   {1,5,3}};
	
	//find the minimum cost to reach from (0,0) to (m,n).
	private static int minCost(int m, int n){
		
		if(m<0 || n<0){
			return Integer.MAX_VALUE;
		
		//base case (0,0)
		}else if(m==0 && n==0){
			return cost[m][n];
		
		}else{
		//others.
			int min1 = minCost(m-1, n-1);
			int min2 = minCost(m-1, n);
			int min3 = minCost(m, n-1);
			return (cost[m][n] + min(min1, min2, min3));
		}
	}
	
	//find the minimum of 3 integer values.
	private static int min(int a, int b, int c){
		return Math.min(Math.min(a,b), c);
	}
	
	public static void main(String[] args) {
		
		int x = 2, y = 2;
		System.out.println("minimum cost to reach ("+x+","+y+") from (0,0) is: "+minCost(x, y));
	}
}
