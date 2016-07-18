package algorithms.dynamic_programming;

/**
 * Given an array of n positive integers. Write a program to find the 
 * sum of maximum sum subsequence of the given array such that the integers 
 * in the subsequence are sorted in increasing order. For example, if input 
 * is {1, 101, 2, 3, 100, 4, 5}, then output should be 106 (1 + 2 + 3 + 100), 
 * if the input array is {3, 4, 5, 10}, then output should be 22 (3 + 4 + 5 + 10) 
 * and if the input array is {10, 5, 4, 3}, then output should be 10.
 * 
 * @author Joy Ghosh
 * @category Dynamic Programming, Amazon, Morgan Stanley.
 */
public class MaximumSumIncreasingSubsequence {

	public static void main(String[] args) {
		
		int[] arr = {10, 5, 4, 3};
		int size = arr.length;
		assert maxSumIncreasingSubsequence(arr, size) == 10;
		//System.out.println("sum of max. sum subsequence array: "+maxSumIncreasingSubsequence(arr, size));
	}
	
	/**
	 * Max. sum of an increasing subsequence of an array.
	 * Time-complexity: O(n^2)
	 * Space-complexity: O(n)
	 * @param arr
	 * @param n
	 * @return
	 */
	private static int maxSumIncreasingSubsequence(int[] arr, int n){
		int msis[] = new int[n];
		int max = Integer.MIN_VALUE;
		
		//initialize the msis array.
		for(int i=0;i<n;i++){
			msis[i] = arr[i];
		}
		
		//Bottom up computation.
		for(int i=1;i<n;i++){
			for(int j=0;j<i;j++){
				//if constraints are satisfied.
				if(arr[j] <= arr[i] && (msis[i] < (msis[j]+arr[i]))){
					msis[i] = msis[j] + arr[i];
				}
			}
		}
		
		//Find the max. sum.
		for(int i=0;i<n;i++){
			if(msis[i] > max){
				max = msis[i];
			}
		}
		
		//return max sum of an increasing subsequence.
		return max;
	}
}
