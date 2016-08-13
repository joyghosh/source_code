package algorithms.dynamic_programming;

/**
 * Max. value contiguous subsequence.
 * 
 * @author Joy Ghosh
 *
 */
public class MaxValueContiguousSubsequence {

	public static void main(String[] args) {
//		int a[] = {-2, -3, 4, -1, -2, 1, 5, -3};
		int a[] = {-2, -3, 4, -1, -2, 1, 5, -3};
		System.out.println("max. value contiguous subsequence: "+maxValueContiguousSubsequence(a));
	}
	
	/**
	 * TC: O(n)
	 * SC: O(n)
	 * 
	 * @param arr
	 * @return
	 */
	public static int maxValueContiguousSubsequence(int[] arr){
		int n = arr.length;
		
		if(n==0) return 0;
		if(n == 1) return arr[0];
		
		int[] max_value = new int[n];
		max_value[0] = arr[0];
		
		for(int i=1;i<n;i++){
			max_value[i] = Math.max(max_value[i-1]+arr[i], arr[i]);
		}
		
		int max = Integer.MIN_VALUE;
		for(int i=0; i<n; i++){
			if(max_value[i] > max){
				max = max_value[i];
			}
		}
		
		return max;
	}
}
