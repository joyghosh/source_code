package com.algo.DP;

/**
 * Finding value of Binomial co-efficient given values for
 * n & k in C(n,k).
 * Points to remember:
 * (1) C(n, k) = C(n-1, k-1) + C(n-1, k).
 * (2) C(n,0) = C(n,n) = 1.
 * @author Joy Ghosh
 * @version 1.0
 */
public class BinomialCoefficient {

	public static void main(String[] args) {
		int n = 5, k = 2;
		System.out.println("Binomial co-efficient value: "+findCoefficientValueRecursive(n, k));
	}
	
	/**
	 * 
	 * @param n
	 * @param k
	 * @return
	 */
	private static int findCoefficientValueRecursive(int n, int k){
		//base cases.
		if(k == 0 || n == k){
			return 1;
		}
		
		return (findCoefficientValueRecursive(n-1, k-1) 
						+ findCoefficientValueRecursive(n-1, k));
	} 
}
