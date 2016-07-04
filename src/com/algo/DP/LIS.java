package com.algo.DP;

/**
 * Longest increasing subsequence.
 * @author Joy Ghosh
 * @version 1.0
 */
public class LIS {

	static int max_ref;
	
	public static void main(String[] args) {
		
		int[] arr = {10, 22, 9, 33, 21, 50, 41, 60};
		int n = arr.length;
		System.out.println("Length of lis is: "+lisNaive(arr, n));
		System.out.println("Length of lis using DP: "+lisDynamicProgramming(arr, n));
	}
	
	/**
	 * Time-complexity: O(n!)
	 * Space-complexity: O(1)
	 * @param arr
	 * @param len
	 * @return
	 */
	public static int lisNaive(int[] arr, int len){
		
		max_ref = 1;
		_lisNaive(arr, len);
		return max_ref;
	}
	
	public static int _lisNaive(int[] arr, int len){
		
		if(len==1)		//base case.
			return 1;
		
		int res, max_ending_here = 1;
		for(int i=1; i<len; i++){
			res = _lisNaive(arr, i);
			if(arr[i-1] < arr[len-1] && (res+1) > max_ending_here){
				max_ending_here = res + 1;
			}
		}
		
		if(max_ref < max_ending_here){
			max_ref = max_ending_here;
		}
		
		return max_ending_here;
	}
	
	/**
	 * Time-complexity: O(n^2).
	 * Space-complexity: O(n).
	 * @param arr
	 * @param n
	 * @return
	 */
	private static int lisDynamicProgramming(int[] arr, int n){
		
		int[] lis = new int[n];
		int max = 0;
		
		//initialize the lis values for all indices.
		for(int i=0; i<n; i++){
			lis[i] = 1;
		}
		
		//compute optimized lis values in a bottom-up manner.
		for(int i=1; i<n; i++){
			for(int j=0; j<i;j++){
				if(arr[j] < arr[i] && lis[i] < (lis[j]+1)){
					lis[i] = lis[j] + 1;
				}
			}
		}
		
		//return the max lis.
		for(int i=0;i<n;i++){
			if(lis[i]>max){
				max = lis[i];
			}
		}
		
		return max;
	}
}
