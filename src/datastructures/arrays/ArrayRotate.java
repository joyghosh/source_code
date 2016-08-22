package datastructures.arrays;

/**
 * Program for array rotation
 * Write a function rotate(ar[], d, n) that rotates arr[] of size n by d elements.
 * @author Joy Ghosh
 *
 */
public class ArrayRotate {

	public static void main(String[] args) {
		int[] arr = {1,2,3,4,5,6,7};
		printArray(arr);
		rotateUsingJuggle(arr, 1);
		printArray(arr);
	}
	
	/**
	 * [Using temp array]
	 * T.C. = O(n)
	 * S.C. = O(d) 
	 *
	 * @param arr
	 * @param d
	 */
	public static void rotate(int[] arr, int d){
		int n = arr.length;
		int[] temp = new int[d];
		
		//Copy the first d array elements.
		for(int i=0;i<d;i++){
			temp[i] = arr[i];
		}
		
		//Shift the rest of the array elements left by d places.
		for(int i=d;i<n;i++){
			arr[i-d] = arr[i];
		}
		
		//Store the first d elements back in the original array.
		for(int i=n-d, j=0; i<n && j<d; i++, j++){
			arr[i] = temp[j];
		}
	}
	
	/**
	 * [Rotate one by one]
	 * T.C. = O(d*n)
	 * S.C. = O(1)
	 * 
	 * @param arr
	 */
	public static void rotateOneByOne(int[] arr, int d){
		for(int i=0; i<d; i++){
			rotate(arr, 1);
		}
	}
	
	/**
	 * [Rotate by d using juggling method.]
	 * T.C. = O(n)
	 * S.C. = O(1)
	 * 
	 * @param arr
	 * @param d
	 */
	public static void rotateUsingJuggle(int[] arr, int d){
		//reverse the first sub-array from 0-d-1.
		reverse(arr, 0, d-1);
		
		//reverse the second sub-array from d to length-1.
		reverse(arr, d, arr.length-1);
		
		//reverse the whole array.
		reverse(arr, 0, arr.length-1);
	}
	
	public static void swap(int[] arr, int a, int b){
		int temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}
	
	public static void reverse(int[] arr, int start, int end){
		for(int i=start; i<=(start+end)/2; i++){
			swap(arr, i, (start+end)-i);
		}
	}
	
	/**
	 * Utility function.
	 * @param arr
	 */
	public static void printArray(int[] arr){
		for(int i=0; i<arr.length; i++){
			System.out.printf("%d ", arr[i]);
		}
		System.out.println();
	}
	
	public static int gcd(int p, int q){
		if(q == 0)
			return p;

		return gcd(q, p%q);
	}
}
