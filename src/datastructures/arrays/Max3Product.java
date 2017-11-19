package datastructures.arrays;

/**
 * Given an array of size n consisting of positive integers, choose three integers(not necessarily contiguous) such that they are in 
 * ascending order and their product is maximum. Input was given in this format.
 * 
 * array = {5, 3, 6, 8, 9, 10}
 * Output: array = {8, 9, 10}
 * 
 * @author joyghosh
 *
 */
public class Max3Product {

	public static void main(String[] args) {
		int[] arr = {5, 3, 6, 8, 9, 10};
		maxProductSimple(arr);
	}
	
	public static void maxProductSimple(int[] arr){
		int n = arr.length;
		if(n == 0 || n<3) return;
		
		int maxProdCurr = Integer.MIN_VALUE;
		int a = 0, b = 0, c = 0;
		for(int i=0; i<n-2; i++){
			for(int j=i+1; j<n-1; j++){
				for(int k=j+1; k<n; k++){
					if(arr[i] < arr[j] && arr[j] < arr[k]){
						maxProdCurr = Math.max(maxProdCurr, arr[i]*arr[j]*arr[k]);
						a = i; b = j; c = k;
					}
				}
			}
		}
		
		System.out.printf("{%d, %d, %d}", arr[a], arr[b], arr[c]);
	}
	
	public static void maxProductOptimized(int[] arr){
		
	}
}
