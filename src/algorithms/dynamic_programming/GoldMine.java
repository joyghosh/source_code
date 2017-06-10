package algorithms.dynamic_programming;

import java.util.Scanner;

public class GoldMine {

	public static void main(String[] args) {
		int M,N;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the dimensions of the goldmine.");
		System.out.print("Rows (M):");
		M = sc.nextInt();
		
		System.out.print("Columns (N):");
		N = sc.nextInt();
		
		int[][] goldMine = new int[M][N];
		for(int i=0; i<M; i++){
			for(int j=0; j<N; j++){
				System.out.printf("Value[%d][%d]:", i, j);
				goldMine[i][j] = sc.nextInt();
			}
		}
		
		System.out.println("Max. value after gold mining is: "+maxGoldValue(goldMine));
		
		sc.close();
	}
	
	
	private static int maxGoldValue(int[][] goldMine){
		
		int m = goldMine.length;
		int n = goldMine[0].length;
		int[][] goldValue = new int[m][n];
		
		for(int col=n-1; col>=0; col--){
			for(int row=0; row<m; row++){
				int right = (col==n-1)?0:goldValue[row][col+1];
				int right_up = (col==n-1 || row==0)?0:goldValue[row-1][col+1];
				int right_down = (col==n-1 || row==m-1)?0:goldValue[row+1][col+1];
				
				goldValue[row][col] = goldMine[row][col] + max(right, right_up, right_down);
			}
		}
		
		//Find the max from the first column as the results is aggregated in the first column.
		int res = goldValue[0][0];
		for(int i=1; i<m; i++){
			res = Math.max(res, goldValue[i][0]);
		}
		
		return res;
	}
	
	private static int max(int a, int b, int c){
		return Math.max(Math.max(a, b), c);
	}
}
