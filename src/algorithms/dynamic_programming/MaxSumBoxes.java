package algorithms.dynamic_programming;

/**
 * Given sequentially placed boxes, each representing a number( which may be positive or negative), 
 * we need to select the numbers in order to have the maximum sum, having the constraint that if we 
 * select a given box, we cannot select adjacent box to it, but can select any other.
 * @author Joy Ghosh
 * @category Amazon
 * 
 */
public class MaxSumBoxes {

	public static void main(String[] args) {
		int[] arr = {-1,2,-4,5,6};
		//System.out.println("max sum is: "+maxSumOfBoxes(arr, 1));
		System.out.println("max sum is: "+maxSumOfBoxesDiff(arr, arr.length-1));
	}
	
	/**
	 * Simple Recursive approach.
	 * @param arr
	 * @param index
	 * @return
	 */
	private static int maxSumOfBoxes(int[] arr, int index){
		
		if(index < arr.length){
			return arr[index] + Math.max(maxSumOfBoxes(arr, index+2), maxSumOfBoxes(arr, index+3)); 
		}
		
		return 0;
	}
	
	/**
	 * A different approach.
	 * @param arr
	 * @param index
	 * @return
	 */
	private static int maxSumOfBoxesDiff(int[] arr, int index){
		if(index > 2){
			return arr[index] + Math.max(maxSumOfBoxesDiff(arr, index-2), maxSumOfBoxesDiff(arr, index-3));
		}
		
		return arr[index];
	}
	
	private static int maxSumOfBoxesDP(int[] arr){
		int[] cache = new int[arr.length+1];
		cache[0] = Integer.MIN_VALUE;
		cache[1] = arr[0];
		cache[2] = arr[1];
		
//		for(int i=3;i<=arr.length;i++){
//			cache[i] = Math.max(arr[i] + cache, b)
//		}
		
		return arr[0];
	}
}
