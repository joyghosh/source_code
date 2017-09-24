package algorithms.dynamic_programming;

import java.util.Scanner;

public class CoinChange {

	public static void main(String[] args) {
		 Scanner in = new Scanner(System.in);
	        long n = in.nextLong();
	        int m = in.nextInt();
	        long[] c = new long[m];
	        for(int c_i=0; c_i < m; c_i++){
	            c[c_i] = in.nextLong();
	        }
	        // Print the number of ways of making change for 'n' units using coins having the values given by 'c'
	        long ways = getWays(n, m, c);
	        
	}

	static long getWays(long n, int m, long[] c){
        // Complete this function
        if(n==0) return 1;  //1 solution exists.
        if(n<0) return 0;   //If n becomes negative.
        if(m<=0 && n>0) return 0;   //If we run out of coins and n is still greater than 0.
        
        return getWays(n, m-1, c) + getWays(n-c[m-1], m, c);
    }
}
