package datastructures.matrix;

public class SumOfElements {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] arr = { {1, 1, 2},
        				{3, 4, 6},
        				{5, 3, 2} };
		System.out.println("sum of all elements except given row and col : "+findSum(0, 1, arr));
	}
	
	private static int findSum(int row, int col, int[][] arr){
	    
	    int rows = arr.length;
	    int cols = arr[0].length;
	    int sum = 0;
	    
	    for(int i=0;i<rows;i++){
	        if(i!=row){
	            for(int j=0;j<cols;j++){
	                if(j!=col){
	                    sum += arr[i][j];
	                }
	            }
	        }
	    }
	    
	    return sum;
	}
}
