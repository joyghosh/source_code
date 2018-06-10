package algorithms.dynamic_programming;

/**
 * 0-1 knapsack problem.
 * (1) Naive or recursive solution.
 * (2) Dynamic programming solution.
 * 
 * @author joyghosh
 *
 */
public class KnapSack01 {

	public static void main(String[] args) {
		int[] weights = new int[]{10, 20, 30};
		int[] values = new int[]{60, 100, 120};
		int W = 50;
		int n = values.length;
		
//		int resultRecursive = knapSackRecursive(W, weights, values, n);
		int resultDp = knapSackDp(W, weights, values, n);
//		System.out.println("Max. value: "+resultRecursive);
		System.out.println("Max. value: "+resultDp);

	}
	
	public static int knapSackRecursive(int W, int[] weights, 
										int[] values, int n){
		//Base cases.
		//(1) No more items left to process.
		//(2) Total weight limit is reduced to zero or the Knapsack is filled. 
		if(n == 0 || W == 0) return 0;
		
		//Check if the weight of the nth item exceeds that of the W.
		//If yes, then this item cannot be included in the optimal solution.
		if(weights[n-1] > W){
			return knapSackRecursive(W, weights, values, n-1);
		}
		
		//Else return the max of the following values.
		//(1) One where the nth item is included in the optimal solution.
		//(2) Another situation where the nth item is left out of the solution.
		return Math.max(values[n-1] + knapSackRecursive(W-weights[n-1], weights, values, n-1), 
				knapSackRecursive(W, weights, values, n-1));
	}
	
	/**
	 * Dynamic Programming solution.
	 * @param W
	 * @param weights
	 * @param values
	 * @param n
	 * @return
	 */
	public static int knapSackDp(int W, int[] weights, int[] values, int n){
		int[][] K = new int[n+1][W+1];
		
		for(int i=0; i<=n; i++){
			for(int w=0; w<=W; w++){
				if(i == 0 || w == 0){
					K[i][w] = 0;
				}else if(weights[i-1] <= w){
					K[i][w] = Math.max(values[i-1] + K[i-1][w-weights[i-1]], K[i-1][w]);
				}else{
					K[i][w] = K[i-1][w];
				}
			}
		}
		
		return K[n][W];
	}
}
