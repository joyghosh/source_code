package datastructures.matrix;

public class MaxSumSquareSubMatrix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] arr = {{1, 1, 1, 1, 1},
		        	  {2, 2, 2, 2, 2},
		        	  {3, 8, 6, 7, 3},
		        	  {4, 4, 4, 4, 4},
		        	  {5, 5, 5, 5, 5}};
		System.out.println(maxSumSubMatrixSimple(arr, 3));
	}
	
	public static int maxSumSubMatrixSimple(int[][] arr, int k){
		
		int max_sum = Integer.MIN_VALUE;
		int row_idx = 0; int col_idx = 0;
		
		for(int i=0; i+k<arr.length; i++){
			for(int j=0; j+k<arr[0].length; j++){
				int sum = 0;
				for(int r=0; r<k; r++){
					for(int c=0; c<k; c++){
						sum += arr[i+r][j+c];
					}
				}
				if(sum > max_sum){
					max_sum = sum;
					row_idx = i;
					col_idx = j;
				}
			}
		}
		
		System.out.println(row_idx);
		System.out.println(col_idx);
		return max_sum;
	} 
}
