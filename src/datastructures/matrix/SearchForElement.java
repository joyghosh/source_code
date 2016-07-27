package datastructures.matrix;

/**
 * Search in a row wise and column wise sorted matrix.
 * Given an n x n matrix, where every row and column is sorted in increasing order. 
 * Given a number x, how to decide whether this x is in the matrix. 
 * The designed algorithm should have linear time complexity. 
 * 
 * @author Joy Ghosh
 *
 */
public class SearchForElement {

	public static void main(String[] args) {
		int mat[][] = {{10, 20, 30, 40},
                		{15, 25, 35, 45},
                		{27, 29, 37, 48},
                		{32, 33, 39, 50}};
		int key = 55;
		if(findElement(mat, key)){
			System.out.printf("%d is present.\n",key);
		}else{
			System.out.printf("%d is not present.\n",key);
		}
	}
	
	/**
	 * Time-complexity: O(N)
	 * @param arr
	 * @param key
	 * @return
	 */
	public static boolean findElement(int[][] arr, int key){
		
		for(int i=0; i<arr.length; i++){
			for(int j=arr[0].length-1;j>=0;j--){
				if(arr[i][j] == key)
					return true;
				if(arr[i][j] < key){
					break;   //continue to the below row.
				}
				//else scan for in left elements.
			}
		}
		return false;
	}
}
