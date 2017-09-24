package datastructures.matrix;

import java.util.Scanner;

/**
 * Count all possible paths to traverse from top left of a matrix to the bottom right of a matrix with the only constraints:
 * you can move left from a cell.
 * you can move right from a cell.
 * 
 * @Dynamic Programming
 * @Recursion
 * @Matrix
 * @author joyghosh
 *
 */
public class CountPaths {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("M: ");
		int M = sc.nextInt();
		System.out.print("N: ");
		int N = sc.nextInt();
		System.out.println("Possible paths from top left to bottom right: "+countPaths(M, N));
		System.out.println("Possible paths from top left to bottom right: "+countPathsDp(M, N));
		sc.close();
	}

	//Simple recursive solution.
	public static int countPaths(int m, int n){	
		//Base case where we are at first row or column.
		if(m==1 || n==1) return 1;
		
		//Summation for rest of the cases.
		return countPaths(m-1, n) + countPaths(m, n-1);
	}
	
	//Dynamic Programming solution.
	public static int countPathsDp(int M, int N){
		int[][] count = new int[M][N];
		
		//First row cells have all possible counts as 1.
		for(int i=0; i<N; i++){
			count[0][i] = 1;
		}
		
		//First col cells have all possible counts as 1.
		for(int i=0; i<M; i++){
			count[i][0] = 1;
		}
		
		//For the rest we build up the solutions using bottom up approach.
		for(int i=1; i<M; i++){
			for(int j=1; j<N; j++){
				count[i][j] = count[i-1][j] + count[i][j-1];
			}
		}
		
		return count[M-1][N-1];
	}
}
