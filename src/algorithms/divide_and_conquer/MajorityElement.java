package algorithms.divide_and_conquer;

public class MajorityElement {

	public static void main(String[] args) {
		int[] arr = {1, 2, 3, 3, 3, 3, 10};
		int x = 3;
		System.out.println(isMajorityElementBS(arr, x));
	}
	
	/**
	 * Simple soln.
	 * TC: O(n)
	 * ASC: O(1);
	 * @param arr
	 * @param x
	 * @return
	 */
	public static boolean isMajorityElement(int[] arr, int x){
		
		int last_index = (arr.length%2 == 0) ? arr.length/2 : (arr.length/2)+1;
		for(int i=0; i<last_index; i++){
			if(arr[i] == x && (arr[i+arr.length/2] == x)){
				return true;
			}
		}
		return false;
	}
	
	/**
	 * TC: O(log n)
	 * ASC: O(1)
	 * @param arr
	 * @param x
	 * @return
	 */
	public static boolean isMajorityElementBS(int[] arr, int x){
		int i = firstIndex(arr, 0, arr.length, x); 
		if(i==-1)
			return false;
		
		if((i+arr.length/2 <= arr.length-1) && arr[i+arr.length/2] == x)
			return true;
		else
			return false;
	}
	
	public static int firstIndex(int[] arr, int low, int high, int x){
		
		if(high>=low){
			int mid = (low + high)/2;
			
			if((mid==0 || x>arr[mid-1]) && (arr[mid]==x)){
				return mid;
			}else if(arr[mid] < x ){
				return firstIndex(arr, mid+1, high, x);
			}else{
				return firstIndex(arr, low, mid-1, x);
			}
		}
		return -1;
	}
}
