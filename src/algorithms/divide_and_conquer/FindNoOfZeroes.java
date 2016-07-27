package algorithms.divide_and_conquer;

public class FindNoOfZeroes {

	public static void main(String[] args) {
		int[] arr = {1, 1, 1, 1, 0, 0};
		System.out.println("Number of zeroes: "+numberOfZeroes(arr));
	}
	
	public static int numberOfZeroes(int[] arr){
		
		int first_idx = firstIndexOfZero(arr, 0, arr.length - 1);
		
		if(first_idx!=Integer.MIN_VALUE){
			return arr.length - first_idx;
		}
		
		return 0;
	}
	
	/**
	 * Time-complexity: O(log n)
	 * Space-complexity: O(log n)
	 * @param arr
	 * @param low
	 * @param high
	 * @return
	 */
	public static int firstIndexOfZero(int[] arr, int low, int high){
		
		if(low <= high){
			int mid = low + (high - low)/2; 
			if((mid == 0 || arr[mid-1] == 1) && arr[mid] == 0)
				return mid;
			if(arr[mid] == 0){
				return firstIndexOfZero(arr, low, mid-1);
			}else{
				return firstIndexOfZero(arr, mid+1, high);
			}
		}
		return Integer.MIN_VALUE;
	}
}
