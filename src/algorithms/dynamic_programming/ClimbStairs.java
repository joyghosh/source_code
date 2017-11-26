package algorithms.dynamic_programming;

import java.util.Scanner;

/**
 * You are climbing stairs. You can advance 1 to k steps at a time. Your destination is
 * exactly n steps up. Write a program which takes as inputs n and k and returns the number of ways in which you can get to your
 * destination.
 * 
 * @author joyghosh
 *
 */
public class ClimbStairs {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int k = s.nextInt();
//		System.out.println(countWaysRecursive(n, k));
		System.out.println(countWaysDynamicProgramming(n, k));
		s.close();
	}
	
	//Time-complexity: O(n^k)
	//Space-complexity: O(n^k)
	public static int countWaysRecursive(int n, int k){
		if(n==0 || n==1) return 1;
		
		int tmpWaysCount = 0;
		for(int i=1; i<=k; i++){
			tmpWaysCount += countWaysRecursive(n-i, k);
		}
		
		return tmpWaysCount;
	}
	
	public static int countWaysDynamicProgramming(int n, int k){
		int[] result = new int[n+1];
		result[0] = 1; result[1] = 1;
		
		for(int i=2; i<=n; i++){
			result[i] = 0;
			for(int j=1; j<=k && j<=i; j++){
				result[i] += result[i-j];
			}
		}
		
		return result[n];
	}
}
