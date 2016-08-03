package algorithms.searching;

/**
 * Search an element in a sorted and rotated array.
 * An element in a sorted array can be found in O(log n) time via binary search. 
 * But suppose we rotate an ascending order sorted array at some pivot unknown to you beforehand. 
 * So for instance, 1 2 3 4 5 might become 3 4 5 1 2. Devise a way to find an element in the rotated 
 * array in O(log n) time.
 * 
 * @author Joy Ghosh
 *
 */
public class SearchRotatedArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

//	public static int findInRotated(int[] arr, int i){
//		
//	}
	
	public static int searchPivot(int[] arr, int l, int r){
		if(l<r){
			int mid = l + (r-l)/2;
			if(arr[mid] > arr[mid+1]){
				return mid;
			}else if(arr[mid] < arr[mid-1]){
				return mid-1;
			}
		}
		return -1;
	}
}
