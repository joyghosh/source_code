package datastructures.matrix;

import java.util.Scanner;

/**
 * source and destination of matrix is given no of way to reach destination .
 * @author joyghosh
 *
 */
public class NoOfWays {
	
	private static int Rows = 0;
	private static int Cols = 0;
	
	public static void main(String[] args) {
		int[][] arr = { {10, 20, 30, 40},
                		{15, 25, 35, 45},
                		{27, 29, 37, 48},
                		{32, 33, 39, 50}};
		Rows = arr.length;
		Cols = arr[0].length;
		System.out.println("Rows: "+Rows);
		System.out.println("Cols: "+Cols);
		
		Scanner s = new Scanner(System.in);
		
		System.out.println("Enter the source co-ordinates.");
		int srci = s.nextInt();
		int srcj = s.nextInt();
		
		System.out.println("Enter the destination co-ordinates.");
		int desti = s.nextInt();
		int destj = s.nextInt();
		
		if(!isSafe(srci, srcj) && 
				!isSafe(desti, destj)){
			System.out.println("Co-ordinates not within range.");
		}else{
			System.out.println("No. of ways to reach the destination is: "+noOfWays(arr, srci, srcj, desti, destj));
		}
		
		s.close();
	}
	
	private static int noOfWays(int[][] arr, int srci, int srcj, int desti, int destj){
		
		if(srci == desti && srcj == destj) return 1;
		
		int leftWays = 0, rightWays = 0, upWays = 0, downWays = 0;
		
		if(isSafe(srci, srcj-1)){
			leftWays = noOfWays(arr, srci, srcj-1, desti, destj);
		}
		
		if(isSafe(srci, srcj+1)){
			rightWays = noOfWays(arr, srci, srcj+1, desti, destj);
		}
		
		if(isSafe(srci+1, srcj)){
			downWays = noOfWays(arr, srci+1, srcj, desti, destj);
		}
	
		if(isSafe(srci-1, srcj)){
			upWays = noOfWays(arr, srci-1, srcj, desti, destj);
		}
		
		return leftWays + rightWays + downWays + upWays;
	}
	
	private static boolean isSafe(int i, int j){
		if(i>=0 && i<Rows && j>=0 && j<Cols) return true;
		return false;
	}
}
