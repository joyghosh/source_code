package datastructures.arrays;

/**
 * Maximum sum such that no two elements are adjacent.
 * 
 * @author joyghosh
 *
 */
public class MaxSumNoAdjacent {

	public static void main(String[] args) {
		int[] arr1 = {5, 5, 10, 100, 10, 5};
		System.out.println("Max. sum: "+maxSum(arr1));
		
		int[] arr2 = {1, 2, 3};
		System.out.println("Max. sum: "+maxSum(arr2));
		
		int[] arr3 = {1, 20, 3};
		System.out.println("Max. sum: "+maxSum(arr3));
	}
	
	//Time-complexity: O(n^2).
	//Space-complexity: O(1).
	public static int maxSum(int[] arr){
		if(arr.length==0) return Integer.MIN_VALUE;
		
		int n = arr.length;
		int maxSum = Integer.MIN_VALUE;
		for(int i=0;i<n;i++){
			int tmpSum = arr[i];
			for(int j=2;i+j<n;j+=2){
				tmpSum += arr[i+j];
			}
			if(tmpSum>maxSum){
				maxSum = tmpSum;
			}
		}
		
		return maxSum;
	}
}
