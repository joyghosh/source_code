package algorithms.divide_and_conquer;


public class FixedPoint {

	public static void main(String[] args) {
		int arr[] = {-10, -5, 0, 3, 7};
		System.out.println("Fixed point in array: "+fixedPointBinSearch(arr, 0, arr.length-1));
	}
	
	/**
	 * Find fixed point using binary search.
	 * Time complexity: O(log n)
	 * @param arr
	 * @param start
	 * @param end
	 * @return
	 */
	private static int fixedPointBinSearch(int[] arr, int start, int end){
		
		if(start < end){
			int mid = start + (end-start)/2;
			if(arr[mid] == mid)
					return arr[mid];
			if(mid > arr[mid])
					return fixedPointBinSearch(arr, mid+1, end);
			else
				return fixedPointBinSearch(arr, start, mid-1);
		}
		
		return Integer.MIN_VALUE;
	}
}
