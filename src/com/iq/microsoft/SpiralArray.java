package com.iq.microsoft;

public class SpiralArray {
	
//	static int arr[][] = {{1,2,3,4},
//						  {5,6,7,8},
//						  {9,10,11,12},
//						  {13,14,15,16}};
	
	static int arr[][] = {{1,2,3,4},
						  {5,6,7,8},
		                  {9,10,11,12}};
	
	public static void main(String []args){
		
		printInSpiralOrder(arr);
	}
	
	private static void printInSpiralOrder(int arr[][]){
		
		//maintain the indices. Top, Bottom, Left and Right.
		int top = 0;
		int bottom = arr.length-1;
		int left = 0;
		int right = arr[0].length-1;
		
		//Continue until top > bottom or left > right.
		while(true){
			
			//print the top row.
			for(int i=left;i<=right;++i)
				System.out.print(arr[top][i]);
			top++;
			
			//check if limits are reached.
			if(isLimitsCrossed(left, right, top, bottom))
				break;
			
			//print the rightmost column.
			for(int j=top;j<=bottom;++j)
				System.out.print(arr[j][right]);
			right--;
			
			//check if limits are reached.
			if(isLimitsCrossed(left, right, top, bottom))
				break;
			
			//print the bottom row.
			for(int i=right;i>=left;--i)
				System.out.print(arr[bottom][i]);
			bottom--;
			
			//check if limits are reached.
			if(isLimitsCrossed(left, right, top, bottom))
				break;
			
			//print the leftmost column.
			for(int j=bottom;j>=top;--j)
				System.out.print(arr[j][left]);
			left++;
			
			//check if limits are reached.
			if(isLimitsCrossed(left, right, top, bottom))
				break;
		}
	}
	
	private static boolean isLimitsCrossed(int left,int right, int top, int bottom){
		
		return ((left > right) || (top > bottom));
	}
}
