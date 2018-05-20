package algorithms.dynamic_programming;

public class EggDropProblem {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	/**
	 * Recursive implementation.
	 * 
	 * @param n Number of eggs.
	 * @param k Number of floors.
	 * @return min. no. of trials needed.
	 */
	public static int eggDropRecur(int n, int k){
		//base cases: no floors or just one floor.
		if(k == 1 || k == 0) return k;
		
		//just one egg and k floors, k trials are needed.
		if(n == 1) return k;
		
		int minTrials = Integer.MAX_VALUE;
		int result = 0;
		for(int x = 1; x<=k; x++){
			result = Math.max(eggDropRecur(n-1, x-1), eggDropRecur(n, k-x));
			minTrials = Math.min(minTrials, result);
		}
		
		return minTrials + 1;
	}
	
//	public st
}
