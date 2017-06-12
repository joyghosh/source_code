package problem_solving;

/**
 * Given n non-negative integers representing an elevation map where the width of each bar is 1, 
 * compute how much water it is able to trap after raining.
 * Input: arr[]   = {2, 0, 2}
 * Output: 2
 * Structure is like below
 * | |
 * |_|
 * We can trap 2 units of water in the middle gap.
 * 
 * @author joyghosh
 */
public class TrapRainWater {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr1 = {2, 0, 2};
		int[] arr2 = {3, 0, 0, 2, 0, 4};
		int[] arr3 = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
		
		System.out.println("Water trapped between bars: "+simple(arr1));
		System.out.println("Water trapped between bars: "+simple(arr2));
		System.out.println("Water trapped between bars: "+simple(arr3));
		
		System.out.println("Water trapped between bars: "+precomputed(arr1));
		System.out.println("Water trapped between bars: "+precomputed(arr2));
		System.out.println("Water trapped between bars: "+precomputed(arr3));
	}
	
	//Time complexity O(n^2)
	//Space complexity O(1)
	//For every element, find the highest bars to the left and right.
	//Calculate the difference between the smaller and the current bar.
	//This is the water collected at this element.
	private static int simple(int[] arr){
		if(arr.length == 0) return 0;
		
		int n = arr.length;
		int totalWaterTrapped = 0;
		
		for(int i=1; i<n-1; i++){
			
			//Find highest bar on the left.
			int maxLeft = Integer.MIN_VALUE;
			for(int left=i-1; left>=0; --left){
				if(arr[left] > arr[i] && arr[left] > maxLeft){
					maxLeft = arr[left];
				}
			}
			
			//if no max left value found, continue.
			if(maxLeft == Integer.MIN_VALUE) continue;
			
			//Find the highest bar to the right.
			int maxRight = Integer.MIN_VALUE;
			
			for(int right=i+1; right<n; ++right){
				if(arr[right] > arr[i] && arr[right] > maxRight){
					maxRight = arr[right];
				}
			}
			
			//if no max right value found, continue.
			if(maxRight == Integer.MIN_VALUE) continue;
			
			totalWaterTrapped += (maxRight > maxLeft)? maxLeft-arr[i]: maxRight-arr[i];
		}
		
		return totalWaterTrapped;
	}
	
	//Pre-compute the heights first.
	//Time complexity O(n)
	//Space complexity O(n)
	private static int precomputed(int[] arr){
		int n = arr.length;
		if(n==0) return 0;
		int totalWaterTrapped = 0;
		
		//Pre-computed left array.
		int[] left = new int[n];
		left[0] = arr[0];
		for(int i=1; i<n; i++){
			left[i] = Math.max(left[i-1], arr[i]);
		}
		
		//Pre-computed right array.
		int[] right = new int[n];
		right[n-1] = arr[n-1];
		for(int i=n-2; i>=0; --i){
			right[i] = Math.max(right[i+1], arr[i]); 
		}
		
		//Calculate the total water trapped.
		for(int i=0; i<n; i++){
			totalWaterTrapped += Math.min(left[i], right[i]) - arr[i];
		}
		
		return totalWaterTrapped;
	} 
}
