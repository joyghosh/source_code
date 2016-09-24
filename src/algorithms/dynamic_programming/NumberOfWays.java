package algorithms.dynamic_programming;

/**
 * Number of ways to reach a destination cell from the source cell.
 * 
 * @author Joy Ghosh
 */
public class NumberOfWays {

	public static void main(String[] args) {
		int M = 3;
		int N = 4;
		System.out.println(noOfWays(M-1, N-1));
		System.out.println(noOfWaysDP(M,N));
	}

	/**
	 * [Recursive approach]
	 * Time complexity: O(2^N) where N = m*n
	 * Space complexity:O(2^N)
	 * Aux. space complexity: O(1)  
	 * 
	 * @param i
	 * @param j
	 * @return
	 */
	public static int noOfWays(int i, int j){
		if(i==0 || j==0)
			return 1;
		return noOfWays(i-1, j) + noOfWays(i, j-1);
	}
	
	/**
	 * [Dynamic programming approach]
	 * Time complexity: O(m*n)
	 * Aux. Space complexity:O(m*n)
	 *   
	 * @param m
	 * @param n
	 * @return
	 */
	public static int noOfWaysDP(int m, int n){
		int[][] ways = new int[m][n];
		
		//For the rest of the cells.
		for(int r=0; r<m; r++){
			for(int c=0; c<n; c++){
				if(r==0 || c==0){
					//For topmost row or leftmost column.
					ways[r][c] = 1;
				}else{
					//for the rest of the cells
					ways[r][c] = ways[r-1][c] + ways[r][c-1];
				}
			}
		}
		
		return ways[m-1][n-1];
	}
}
